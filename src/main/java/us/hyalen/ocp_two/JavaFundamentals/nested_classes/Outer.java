package us.hyalen.ocp_two.JavaFundamentals.nested_classes;

public class Outer {
    private String greeting = "Hi";

    // Could also be public, private or package
    protected class Inner {
        private int repeat;
        private StringBuilder sb;

        Inner() {
            this.repeat = 3;
            this.sb = new StringBuilder();
        }

        public String go() {
            for (int i = 0; i < repeat; i++)
                sb.append(greeting);

            return sb.toString();
        }
    }

    public String callInner() {
        Inner inner = new Inner();
        String result = inner.go();

        return result;
    }
}
