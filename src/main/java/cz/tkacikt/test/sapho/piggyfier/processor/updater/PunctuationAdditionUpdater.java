package cz.tkacikt.test.sapho.piggyfier.processor.updater;

import cz.tkacikt.test.sapho.piggyfier.tokenholder.token.StringToken;

import java.util.regex.Pattern;

public class PunctuationAdditionUpdater implements Updater {

    @Override
    public void update(StringToken token) {
        StringBuilder initialValueReversed = new StringBuilder(token.getInitialValue()).reverse();
        StringBuilder valueReversed = new StringBuilder(token.getValue()).reverse();

        for(int i=0; i<initialValueReversed.length(); i++) {
            String symbol = initialValueReversed.substring(i, i+1);
            if(Pattern.matches("\\p{Punct}", symbol)) {
                valueReversed.insert(i, symbol);
            }
        }

        token.setValue(valueReversed.reverse().toString());
    }

    @Override
    public boolean isTerminating(StringToken token) {
        return false;
    }

}
