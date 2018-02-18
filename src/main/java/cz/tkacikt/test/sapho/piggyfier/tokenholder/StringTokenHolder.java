package cz.tkacikt.test.sapho.piggyfier.tokenholder;

import cz.tkacikt.test.sapho.piggyfier.tokenholder.token.StringToken;

import java.util.List;

public interface StringTokenHolder {
    List<StringToken> getTokens();
    String getValue();
}
