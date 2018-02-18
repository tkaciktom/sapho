package cz.tkacikt.test.sapho.piggyfier.tokenholder.factory;

import cz.tkacikt.test.sapho.piggyfier.tokenholder.DelimiterBasedMultipleStringTokenHolder;
import cz.tkacikt.test.sapho.piggyfier.tokenholder.SingleStringTokenHolder;
import cz.tkacikt.test.sapho.piggyfier.tokenholder.StringTokenHolder;

public class DelimiterBasedStringTokenHolderFactory implements StringTokenHolderFactory {

    private volatile String tokensDelimiter;

    @Override
    public StringTokenHolder createTokenHolder(String value) {
        if(value == null) {
            value = "";
        }
        if(value.indexOf(tokensDelimiter) != -1) {
            return new DelimiterBasedMultipleStringTokenHolder(tokensDelimiter, value);
        } else {
            return new SingleStringTokenHolder(value);
        }
    }

    public void setTokensDelimiter(String tokensDelimiter) {
        this.tokensDelimiter = tokensDelimiter;
    }

}
