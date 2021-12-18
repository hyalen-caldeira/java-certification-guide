package us.hyalen.ocp_two.JavaFundamentals.working_with_enums;

import lombok.Getter;
import lombok.Setter;
import us.hyalen.ocp_two.JavaFundamentals.working_with_enums.enums.Season;

@Getter
@Setter
public class Example {
    private Season season;

    Example() {
        season = Season.SPRING;
    }

    public String getEnumNameValue() {
        return season.name();
    }

    public int getEnumOrdinalValue() {
        return season.ordinal();
    }

    public String getAvailableHours(Season season) {
        String result;

        switch (season) {
            case WINTER:
                result = Season.WINTER.getHours();
                break;
            case FALL:
                result = Season.FALL.getHours();
                break;
            case SPRING:
                result = Season.SPRING.getHours();
                break;
            case SUMMER:
                result = Season.SUMMER.getHours();
                break;
            default:
                result = "No time for this season ...";
        }

        return result;
    }
}
