package cz.tkacikt.test.sapho.piggyfier;

import cz.tkacikt.test.sapho.piggyfier.collector.StringTokenHolderCollector;
import cz.tkacikt.test.sapho.piggyfier.processor.TokenHolderProcessor;
import cz.tkacikt.test.sapho.piggyfier.tokenizer.CmdLineTokenizer;

public class AppRunner {

    private CmdLineTokenizer cmdLineTokenizer;
    private TokenHolderProcessor tokenHolderProcessor;
    private StringTokenHolderCollector tokenHolderCollector;

    public void run(String... args) {
        if(args == null) {
            args = new String[]{};
        }
        cmdLineTokenizer
                .tokenize(args)
                .map(tokenHolderProcessor::process)
                .forEach(tokenHolderCollector::collect);
    }

    public void setCmdLineTokenizer(CmdLineTokenizer cmdLineTokenizer) {
        this.cmdLineTokenizer = cmdLineTokenizer;
    }

    public void setTokenHolderProcessor(TokenHolderProcessor tokenHolderProcessor) {
        this.tokenHolderProcessor = tokenHolderProcessor;
    }

    public void setTokenHolderCollector(StringTokenHolderCollector tokenHolderCollector) {
        this.tokenHolderCollector = tokenHolderCollector;
    }
}
