package cz.tkacikt.test.sapho.piggyfier.processor.updater;

import cz.tkacikt.test.sapho.piggyfier.tokenholder.token.StringToken;

public class ToLowerCaseUpdater implements Updater {

    @Override
    public void update(StringToken token) {
        token.update(token.getValue().toLowerCase());
    }

    @Override
    public boolean isTerminating(StringToken token) {
        return false;
    }
}
