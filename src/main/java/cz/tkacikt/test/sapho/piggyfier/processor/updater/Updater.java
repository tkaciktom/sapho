package cz.tkacikt.test.sapho.piggyfier.processor.updater;

import cz.tkacikt.test.sapho.piggyfier.tokenholder.token.StringToken;

public interface Updater {
    void update(StringToken token);
    boolean isTerminating(StringToken token);
}
