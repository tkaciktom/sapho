package cz.tkacikt.test.sapho.piggyfier.processor;

import cz.tkacikt.test.sapho.piggyfier.processor.updater.Updater;
import cz.tkacikt.test.sapho.piggyfier.tokenholder.StringTokenHolder;
import cz.tkacikt.test.sapho.piggyfier.tokenholder.token.StringToken;

import java.util.List;

public class UpdaterBasedTokenHolderProcessor implements TokenHolderProcessor {

    private volatile List<Updater> updaters;

    @Override
    public StringTokenHolder process(StringTokenHolder inputTokenHolder) {
        if(inputTokenHolder == null) {
            return null;
        }

        StringTokenHolder tokenHolder = inputTokenHolder;
        for(StringToken token : tokenHolder.getTokens()) {
            for (Updater updater : updaters) {
                updater.update(token);
                if (updater.isTerminating(token)) {
                    break;
                }
            }
        }
        return tokenHolder;
    }

    public void setUpdaters(List<Updater> updaters) {
        this.updaters = updaters;
    }
}
