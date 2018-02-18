package cz.tkacikt.test.sapho.piggyfier.tokenholder.token;

public class DefaultStringToken implements StringToken {

    private final String initialValue;
    private volatile String value;

    public DefaultStringToken(String value) {
        if(value == null) {
            value = "";
        }
        this.initialValue = value;
        this.value = value;
    }

    @Override
    public String getInitialValue() {
        return initialValue;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String newValue) {
        this.value = newValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DefaultStringToken)) return false;

        DefaultStringToken that = (DefaultStringToken) o;

        if (!getInitialValue().equals(that.getInitialValue())) return false;
        return getValue().equals(that.getValue());
    }

    @Override
    public int hashCode() {
        int result = getInitialValue().hashCode();
        result = 31 * result + getValue().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "StringToken{" +
                "initialValue='" + initialValue + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
