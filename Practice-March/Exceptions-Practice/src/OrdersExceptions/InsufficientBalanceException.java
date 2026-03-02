package OrdersExceptions;

public class InsufficientBalanceException extends OrderException{

    public InsufficientBalanceException(String message){
        super(message);
    }
}
