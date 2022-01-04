package us.hyalen.ocp_two.JavaFundamentals.interface_members;

public interface Walkable {
    // Implicit public
    default int getSpeed() {
        return 5;
    }
}
