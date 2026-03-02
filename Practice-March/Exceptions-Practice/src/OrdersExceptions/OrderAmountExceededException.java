package OrdersExceptions;

public class OrderAmountExceededException extends OrderException{
    public OrderAmountExceededException(String message) {
        super(message);
    }
}
