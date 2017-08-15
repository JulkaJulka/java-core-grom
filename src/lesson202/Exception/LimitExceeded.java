package lesson202.Exception;

import lesson20.task2.BadRequestException;

public class LimitExceeded extends BadRequestException {
    public LimitExceeded(String message) {
        super(message);
    }
}
