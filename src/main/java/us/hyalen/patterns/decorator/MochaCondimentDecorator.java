package us.hyalen.patterns.decorator;

public class MochaCondimentDecorator extends CondimentDecorator {
    Beverage beverage;

    public MochaCondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + .20;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
}
