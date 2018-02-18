package cz.tkacikt.test.sapho.piggyfier.processor.updater;

import cz.tkacikt.test.sapho.piggyfier.tokenholder.token.StringToken;

public class CapitalizationUpdater implements Updater {

    @Override
    public void update(StringToken token) {
        String initialValue = token.getInitialValue();
        StringBuffer newValue = new StringBuffer(token.getValue());
        int newValueLength = newValue.length();

        for(int i=0; i<initialValue.length(); i++) {
            if(i >= newValueLength) {
                break;
            }
            if(Character.isUpperCase(initialValue.charAt(i))) {
                int startIndex = i;
                int endIndex = i+1;
                newValue.replace(startIndex, endIndex, newValue.substring(startIndex, endIndex).toUpperCase());
            }
        }

        token.setValue(newValue.toString());
    }

    @Override
    public boolean isTerminating(StringToken token) {
        return false;
    }

}
