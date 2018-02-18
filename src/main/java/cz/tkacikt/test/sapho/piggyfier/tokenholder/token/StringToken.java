package cz.tkacikt.test.sapho.piggyfier.tokenholder.token;

public interface StringToken {
    String getInitialValue();
    String getValue();
    void update(String newValue);
}
