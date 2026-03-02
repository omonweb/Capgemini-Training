import OrdersExceptions.OrderException;

public class main {
    public static void main(String[] args) {
        User user = new User("Om",234000,true);

        OrderService ors = new OrderService();

        try {
            ors.placeOrder(user,35000);
        }

        catch (OrderException e) {
            System.out.println("Order failed: "+ e.getMessage());
        }

        System.out.println("Remaining balance: "+user.getBalance());
    }
}
