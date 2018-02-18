package cz.tkacikt.test.sapho.piggyfier.collector;

import cz.tkacikt.test.sapho.piggyfier.collector.printer.Printer;
import cz.tkacikt.test.sapho.piggyfier.tokenholder.StringTokenHolder;

public class PrinterBasedStringTokenHolderCollector implements StringTokenHolderCollector {

    private volatile Printer collectorPrinter;

    @Override
    public void collect(StringTokenHolder tokenHolder) {
        if(tokenHolder != null) {
            collectorPrinter.print(tokenHolder.getValue());
        }
    }

    public void setCollectorPrinter(Printer collectorPrinter) {
        this.collectorPrinter = collectorPrinter;
    }

}
