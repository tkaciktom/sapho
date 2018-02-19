package cz.tkacikt.test.sapho.piggyfier.tokenholder;

import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DelimiterBasedMultipleStringTokenHolder extends MultipleStringTokenHolder {

    private final String delimiter;

    public DelimiterBasedMultipleStringTokenHolder(String delimiter, String delimitedValues) {
        super(split(delimitedValues, delimiter));

        this.delimiter = delimiter;
    }

    private static List<String> split(String delimitedValues, String delimiter) {
        Assert.hasLength(delimiter, "Delimiter cannot be null!");

        int expectedTokensCount = StringUtils.countOccurrencesOf(delimitedValues, delimiter);
        Assert.isTrue(expectedTokensCount > 0, "Delimiter cannot be found in input string!");

        return Arrays.asList(delimitedValues.split(delimiter, -1));
    }

    @Override
    public String getValue() {
        List<String> values = getTokens().stream().map(token -> token.getValue()).collect(Collectors.toList());
        return StringUtils.collectionToDelimitedString(values, delimiter);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DelimiterBasedMultipleStringTokenHolder)) return false;
        if (!super.equals(o)) return false;

        DelimiterBasedMultipleStringTokenHolder that = (DelimiterBasedMultipleStringTokenHolder) o;

        return delimiter.equals(that.delimiter);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + delimiter.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "DelimiterBasedMultipleTokenHolder{" +
                "delimiter='" + delimiter + '\'' +
                ", tokens=" + getTokens() +
                '}';
    }
}
