package cz.tkacikt.test.sapho.piggyfier.tokenholder.factory;

import cz.tkacikt.test.sapho.piggyfier.tokenholder.StringTokenHolder;

public interface StringTokenHolderFactory {
    StringTokenHolder createTokenHolder(String value);
}
