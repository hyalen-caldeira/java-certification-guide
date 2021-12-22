package us.hyalen.ocp_two.JavaFundamentals.nested_classes;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class OuterTest {
    private Outer outer;

    @BeforeEach
    void setUp() {
        this.outer = new Outer();
    }

    @Test
    public void whenOuterClassTryToReachPrivateInstanceVariables_then_AValidValueWillBeReturned() {
        assertEquals("HiHiHi", outer.callInner());
    }

    @Test
    public void testingInstantiatingInnerClass() {
        Outer.Inner inner = outer.new Inner();

        assertEquals("HiHiHi", inner.go());
    }

    @AfterEach
    void tearDown() {
    }
}