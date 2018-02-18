package cz.tkacikt.test.sapho.piggyfier.tokenizer;

import cz.tkacikt.test.sapho.piggyfier.tokenholder.StringTokenHolder;

import java.util.stream.Stream;

/**
 * Command line arguments tokenizer. Tranforms array of input strings to a {@link Stream} of {@link StringTokenHolder}'s.
 */
public interface CmdLineTokenizer {

    /**
     * Returns a sequential {@code Stream} with particular input as its source.
     *
     * <p>
     *     Descendants can parse the command line arguments to allow various sources of resulting stream (file based,
     *     collection based etc).
     * </p>
     *
     * @return a sequential {@code Stream} over the input created using given args.
     */
    Stream<StringTokenHolder> tokenize(String... args);
}
