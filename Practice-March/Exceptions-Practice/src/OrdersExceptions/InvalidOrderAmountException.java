package OrdersExceptions;

public class InvalidOrderAmountException extends OrderException {
    public InvalidOrderAmountException(String message) {
        super(message);
    }
}
