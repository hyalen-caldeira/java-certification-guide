package us.hyalen.patterns.decorator;

public class WhipCondimentDecorator extends CondimentDecorator {
    Beverage beverage;

    public WhipCondimentDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public double cost() {
        return beverage.cost() + .40;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }
}
