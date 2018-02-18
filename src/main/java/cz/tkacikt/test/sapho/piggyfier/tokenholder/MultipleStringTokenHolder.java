package cz.tkacikt.test.sapho.piggyfier.tokenholder;

import cz.tkacikt.test.sapho.piggyfier.tokenholder.token.DefaultStringToken;
import cz.tkacikt.test.sapho.piggyfier.tokenholder.token.StringToken;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

public abstract class MultipleStringTokenHolder implements StringTokenHolder {

    private List<StringToken> tokens;

    public MultipleStringTokenHolder(List<String> tokensString) {
        Assert.notNull(tokensString, "Tokens list cannot be null!");
        Assert.isTrue(tokensString.size() > 1, "At least 2 tokens are expected");
        this.tokens = tokensString.stream()
                .map(DefaultStringToken::new)
                .collect(Collectors.toList());;
    }

    @Override
    public List<StringToken> getTokens() {
        return tokens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MultipleStringTokenHolder)) return false;

        MultipleStringTokenHolder that = (MultipleStringTokenHolder) o;

        return getTokens().equals(that.getTokens());
    }

    @Override
    public int hashCode() {
        return getTokens().hashCode();
    }

    @Override
    public String toString() {
        return "MultipleTokenHolder{" +
                "tokens=" + tokens +
                '}';
    }
}
