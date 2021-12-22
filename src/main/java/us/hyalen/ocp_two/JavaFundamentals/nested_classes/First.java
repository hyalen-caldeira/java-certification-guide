package us.hyalen.ocp_two.JavaFundamentals.nested_classes;

import us.hyalen.ocp_two.JavaFundamentals.nested_classes.enums.InnerOrder;

public class First {
    private int num = 10;

    public class Second {
        private int num = 20;

        public class Third {
            private int num = 30;

            public int allTheNums(InnerOrder order) {
                int result = 0;

                switch (order) {
                    case FIRST:
                        result = First.this.num;
                        break;
                    case SECOND:
                        result = Second.this.num;
                        break;
                    case THIRD:
                        result = this.num; // Or just "num"
                        break;
                }

                return result;
            }
        }
    }
}
