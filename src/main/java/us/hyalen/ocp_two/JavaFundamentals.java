package us.hyalen.ocp_two;

import lombok.Getter;
import lombok.NoArgsConstructor;
import us.hyalen.ocp_two.enums.Season;

@NoArgsConstructor
public class JavaFundamentals {
    Season season;

    JavaFundamentals(Season season) {
        this.season = season;
    }
}
