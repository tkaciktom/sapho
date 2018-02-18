package cz.tkacikt.test.sapho.piggyfier.processor.updater;

import cz.tkacikt.test.sapho.piggyfier.tokenholder.token.StringToken;

public class EndStringBasedTerminatingUpdater extends SubstringBasedUpdater {

    @Override
    public void update(StringToken token) {}

    @Override
    public boolean isTerminating(StringToken token) {
        for(String string : getSubstrings()) {
            if(token.getValue().endsWith(string)) {
                return true;
            }
        }
        return false;
    }

}
