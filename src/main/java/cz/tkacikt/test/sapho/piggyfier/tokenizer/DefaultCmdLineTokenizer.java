package cz.tkacikt.test.sapho.piggyfier.tokenizer;

import cz.tkacikt.test.sapho.piggyfier.tokenholder.StringTokenHolder;
import cz.tkacikt.test.sapho.piggyfier.tokenholder.factory.StringTokenHolderFactory;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * Tokenizer that tranforms an array of input strings directly to a {@link Stream} of {@link StringTokenHolder}'s.
 */
public class DefaultCmdLineTokenizer implements CmdLineTokenizer {

    private volatile StringTokenHolderFactory tokenHolderFactory;

    /**
     * Returns a sequential {@code Stream} with command line arguments as its source.
     *
     * @return a sequential {@code Stream} over the elements in the args array
     */
    @Override
    public Stream<StringTokenHolder> tokenize(String... args) {
        if(args == null) {
            args = new String[]{};
        }
        return Arrays.asList(args)
                .stream()
                .map(tokenHolderFactory::createTokenHolder);
    }

    public void setTokenHolderFactory(StringTokenHolderFactory tokenHolderFactory) {
        this.tokenHolderFactory = tokenHolderFactory;
    }

}
