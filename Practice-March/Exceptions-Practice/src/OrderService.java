import OrdersExceptions.*;

public class OrderService {
    public void placeOrder(User user, double amount) throws OrderException {

        if(amount > 200000) throw new OrderAmountExceededException("Order amount must be < 2000");

        if(amount < 0) throw new InvalidOrderAmountException("Invalid amount");

        if(!user.getIsActive()) throw new UserInactiveException("User inactive");

        if(user.getBalance() < amount) throw new InsufficientBalanceException("Insufficient Balance");

        user.deductBalance(amount);
        System.out.println("Order placed successfully for "+user.getName());
    }
}
