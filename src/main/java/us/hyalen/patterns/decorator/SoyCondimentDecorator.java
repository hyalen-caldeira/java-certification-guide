package us.hyalen.patterns.decorator;

public class SoyCondimentDecorator extends CondimentDecorator {
    Beverage beverage;

    public SoyCondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + .30;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }
}
