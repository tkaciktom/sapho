package cz.tkacikt.test.sapho.piggyfier.processor.updater;

import cz.tkacikt.test.sapho.piggyfier.tokenholder.token.StringToken;

import java.util.Set;

public abstract class SubstringBasedUpdater implements Updater {

    private Set<String> substrings;

    protected Set<String> getSubstrings() {
        return substrings;
    }

    @Override
    public boolean isTerminating(StringToken token) {
        return false;
    }

    public void setSubstrings(Set<String> substrings) {
        this.substrings = substrings;
    }

}
