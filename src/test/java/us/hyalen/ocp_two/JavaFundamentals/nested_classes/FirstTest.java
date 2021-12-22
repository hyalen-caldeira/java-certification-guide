package us.hyalen.ocp_two.JavaFundamentals.nested_classes;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import us.hyalen.ocp_two.JavaFundamentals.nested_classes.enums.InnerOrder;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstTest {
    @BeforeEach
    void setUp() {
    }

    @Test
    void whenInnerClassIsCalled_then_ScopeIsTreatedCorrectly() {
        First first = new First();
        First.Second second = first.new Second();
        First.Second.Third third = second.new Third();

        assertEquals(10, third.allTheNums(InnerOrder.FIRST));
        assertEquals(20, third.allTheNums(InnerOrder.SECOND));
        assertEquals(30, third.allTheNums(InnerOrder.THIRD));
    }
}
