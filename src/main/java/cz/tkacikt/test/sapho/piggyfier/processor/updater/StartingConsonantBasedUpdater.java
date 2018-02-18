package cz.tkacikt.test.sapho.piggyfier.processor.updater;

import cz.tkacikt.test.sapho.piggyfier.tokenholder.token.StringToken;

public class StartingConsonantBasedUpdater extends SubstringBasedUpdater {

    @Override
    public void update(StringToken token) {
        String initialValue = token.getInitialValue();
        if(initialValue.length() == 0) {
            return;
        }
        String firstCharacter = initialValue.substring(0, 1).toLowerCase();
        if(getSubstrings().contains(firstCharacter)) {
            StringBuilder newValue = new StringBuilder(token.getValue().substring(1))
                    .append(firstCharacter)
                    .append("ay");
            token.setValue(newValue.toString());
        }
    }

}
