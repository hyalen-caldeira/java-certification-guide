package us.hyalen.ocp_two.JavaFundamentals.interface_members;

// When the class implements 2 or more interfaces with the same default method, it must implement the method
public class Cat implements Walkable, Runnable {
    @Override
    public int getSpeed() {
        return 25;
    }

    private int getWalkSpeed() {
        return Walkable.super.getSpeed();
    }

    private int getRunSpeed() {
        return Runnable.super.getSpeed();
    }

    public static void main(String[] args) {
        Cat cat = new Cat();

        System.out.println("Speed --> " + cat.getSpeed());
        System.out.println("Walk Speed --> " + cat.getWalkSpeed());
        System.out.println("Run Speed --> " + cat.getRunSpeed());
    }
}
