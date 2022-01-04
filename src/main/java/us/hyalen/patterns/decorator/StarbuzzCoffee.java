package us.hyalen.patterns.decorator;

public class StarbuzzCoffee {
    public static void main(String... args) {
        Beverage espresso = new Espresso();
        System.out.println(espresso.getDescription() + ", $" + espresso.cost());

        Beverage houseBlend = new HouseBlend();
        houseBlend = new MochaCondimentDecorator(houseBlend);
        houseBlend = new MochaCondimentDecorator(houseBlend);
        houseBlend = new WhipCondimentDecorator(houseBlend);
        System.out.println(houseBlend.getDescription() + ", $" + houseBlend.cost());
    }
}
