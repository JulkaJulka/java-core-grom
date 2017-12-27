package lesson36.exception;

/**
 * Created by user on 06.09.2017.
 */
public class LimitExceeded extends BadRequestException {
    public LimitExceeded(String message) {
        super(message);
    }
}
