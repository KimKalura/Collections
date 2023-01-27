package IMDb_simulation;

public enum Review {
    ONE_STAR (1),
    TWO_STARS(2),
    THREE_STARS(3),
    FOUR_STARS(4),
    FIVE_STARS(5);

    Integer reviewValue;

    Review(Integer reviewValue) {
        this.reviewValue = reviewValue;
    }
}
