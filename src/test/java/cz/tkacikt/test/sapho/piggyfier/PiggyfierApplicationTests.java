package cz.tkacikt.test.sapho.piggyfier;

import cz.tkacikt.test.sapho.piggyfier.collector.StringTokenHolderCollector;
import cz.tkacikt.test.sapho.piggyfier.collector.printer.Printer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PiggyfierApplicationTests {

	public static final String DELIMITER = "-";

	@Autowired
	private AppRunner appRunner;

	@Autowired
	@InjectMocks
	private StringTokenHolderCollector tokenHolderCollector;

	@Mock
	private Printer collectorPrinter;

	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		appRunner.setTokenHolderCollector(tokenHolderCollector);
	}

	@Test
	public void testNullInput() {
		appRunner.run(null);

		Mockito.verify(collectorPrinter, Mockito.times(0)).print((String)Mockito.any());
	}

	@Test
	public void testEmptyInput() {
		testUpdater("", "");
	}

	@Test
	public void testBlankInput() {
		testUpdater("  ", "  ");
	}

	@Test
	public void testEmptyHyphenDelimitedInput() {
		testHyphenUpdater("", "", "", "");
	}

	@Test
	public void testBlankHyphenDelimitedInput() {
		testHyphenUpdater(" ", " ", " ", " ");
	}

	@Test
	public void testEndStringBasedTerminatingUpdater() {
		testUpdater("stairway", "stairway");
	}

	@Test
	public void testStartingConsonantBasedUpdater() {
		testUpdater("Hello", "Ellohay");
	}

	@Test
	public void testStartingVowelBasedUpdater() {
		testUpdater("apple", "appleway");
	}

	@Test
	public void testPunctuationAdditionUpdater_1() {
		testUpdater("can't.", "antca'y.");
	}

	@Test
	public void testPunctuationAdditionUpdater_2() {
		testUpdater("e'nd.", "endw'ay.");
	}

	@Test
	public void testCapitalizationUpdater_1() {
		testUpdater("Can'T.", "AntcA'y.");
	}

	@Test
	public void testEndStringBasedTerminatingHyphenUpdater() {
		testHyphenUpdater("stairway", "stairway", "stairway", "stairway");
	}

	@Test
	public void testStartingConsonantBasedHyphenUpdater() {
		testHyphenUpdater("Hello", "Ellohay", "Hello", "Ellohay");
	}

	@Test
	public void testStartingVowelBasedHyphenUpdater() {
		testHyphenUpdater("apple", "appleway", "apple", "appleway");
	}

	@Test
	public void testPunctuationAdditionHyphenUpdater_1() {
		testHyphenUpdater("can't.", "antca'y.", "can't.", "antca'y.");
	}

	@Test
	public void testPunctuationAdditionHyphenUpdater_2() {
		testHyphenUpdater("e'nd.", "endw'ay.", "e'nd.", "endw'ay.");
	}

	@Test
	public void testCapitalizationHyphenUpdater_1() {
		testHyphenUpdater("Can'T.", "AntcA'y.", "Can'T.", "AntcA'y.");
	}

	@Test
	public void testMixedHyphenUpdater_1() {
		testHyphenUpdater("Can'T.", "AntcA'y.", "e'nd.", "endw'ay.");
	}

	@Test
	public void testMixedHyphenUpdater_2() {
		testHyphenUpdater("Hello", "Ellohay", "stairway", "stairway");
	}

	@Test
	public void testMixedHyphenUpdater_3() {
		testHyphenUpdater("'", "'", "a'", "away'");
	}

	@Test
	public void testMultiHyphenUpdater() {
		testHyphenUpdater("Can'T.", "AntcA'y.", "Hello", "Ellohay", "apple", "appleway");
	}

	private String concatenateUsingHyphen(String... values) {
		return StringUtils.arrayToDelimitedString(values, DELIMITER);
	}

	private void testUpdater(String input, String output) {
		appRunner.run(input);

		Mockito.verify(collectorPrinter, Mockito.times(1)).print(output);
	}

	private void testHyphenUpdater(String... inputOutputArray) {
		String input = concatenateUsingHyphen(getInputs(inputOutputArray));
		appRunner.run(input);

		String expectedOutput = concatenateUsingHyphen(getOutputs(inputOutputArray));
		Mockito.verify(collectorPrinter, Mockito.times(1)).print(expectedOutput);
	}

	private String[] getInputs(String... vals) {
		return getValues(true, vals);
	}

	private String[] getOutputs(String... vals) {
		return getValues(false, vals);
	}

	private String[] getValues(boolean input, String... testValues) {
		List<String> testValuesList = Arrays.asList(testValues);
		return IntStream.range(0, testValuesList.size())
				.filter(i -> i%2==(input?0:1))
				.mapToObj(testValuesList::get)
				.collect(Collectors.toList())
				.toArray(new String[testValues.length/2]);
	}

}
