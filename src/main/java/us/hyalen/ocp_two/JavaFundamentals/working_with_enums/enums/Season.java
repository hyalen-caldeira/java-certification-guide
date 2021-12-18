package us.hyalen.ocp_two.JavaFundamentals.working_with_enums.enums;

public enum Season {
    // For simple enums, no need to put the character ";" at the end
    // Values (enums) MUST be declared first
    // WINTER, SPRING, SUMMER, FALL

    // Looks like a subclass
    // Values (enums) MUST be declared first
    // Calls default constructor
    WINTER {
        @Override
        public void printExpectedVisitors() {
            // Put your code here
        }

        @Override
        public String getHours() {
            // return super.getHours();
            return "10am-3pm";
        }
    },
    SPRING(1) {
        @Override
        public void printExpectedVisitors() {}
    },
    SUMMER(2) {
        @Override
        public void printExpectedVisitors() {}
    },
    FALL {
        @Override
        public void printExpectedVisitors() {}
    };

    private final int expectedVisitors;

    // Constructors are implicitly private. No need to inform
    private Season() {
        this(0);
    }

    // Constructors are implicitly private. No need to inform
    private Season(int expectedVisitors) {
        this.expectedVisitors = expectedVisitors;
    }

    public abstract void printExpectedVisitors();
    public String getHours() {
        return "9am-5pm";
    }
}
