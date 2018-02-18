package cz.tkacikt.test.sapho.piggyfier.collector.printer;

import java.util.logging.Logger;

public class LoggerBasedPrinter implements Printer {

    private static final Logger LOGGER = Logger.getLogger(LoggerBasedPrinter.class.getName());

    @Override
    public void print(String value) {
        LOGGER.info(value);
    }
}
