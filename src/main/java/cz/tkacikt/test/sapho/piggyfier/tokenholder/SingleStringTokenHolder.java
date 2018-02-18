package cz.tkacikt.test.sapho.piggyfier.tokenholder;

import cz.tkacikt.test.sapho.piggyfier.tokenholder.token.DefaultStringToken;
import cz.tkacikt.test.sapho.piggyfier.tokenholder.token.StringToken;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;

public class SingleStringTokenHolder implements StringTokenHolder {

    private final StringToken token;

    public SingleStringTokenHolder(String tokenString) {
        Assert.notNull(tokenString, "Token string cannot be null!");
        this.token = new DefaultStringToken(tokenString);
    }

    @Override
    public List<StringToken> getTokens() {
        return Arrays.asList(token);
    }

    @Override
    public String getValue() {
        return token.getValue();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SingleStringTokenHolder)) return false;

        SingleStringTokenHolder that = (SingleStringTokenHolder) o;

        return token.equals(that.token);
    }

    @Override
    public int hashCode() {
        return token.hashCode();
    }

    @Override
    public String toString() {
        return "SingleTokeHolder{" +
                "token=" + token +
                '}';
    }
}
