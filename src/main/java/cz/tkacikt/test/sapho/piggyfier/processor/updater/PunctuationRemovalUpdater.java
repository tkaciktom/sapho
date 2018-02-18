package cz.tkacikt.test.sapho.piggyfier.processor.updater;

import cz.tkacikt.test.sapho.piggyfier.tokenholder.token.StringToken;

public class PunctuationRemovalUpdater implements Updater {

    @Override
    public void update(StringToken token) {
        String newValue = token.getValue().replaceAll("\\p{Punct}", "");

        token.update(newValue);
    }

    @Override
    public boolean isTerminating(StringToken token) {
        return false;
    }
}
