package us.hyalen.ocp_two.JavaFundamentals.interface_members;

public interface Runnable {
    // Implicit public
    default int getSpeed() {
        return 15;
    }
}
