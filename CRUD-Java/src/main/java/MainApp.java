import com.capgemini.dao.UserDAO;
import com.capgemini.dao.UserDAOImpl;
import com.capgemini.entity.User;

public class MainApp {
    public static void main(String[] args) {
        UserDAO dao = new UserDAOImpl();

     //    dao.insertUser(new User("Omni", "omni@gmail.com"));

      //  dao.updateUser(new User(1,"Omni Van", "van@gmail.com"));

        System.out.println("All Users:");
        dao.getAllUsers().forEach(u ->
                System.out.println(u.getId() + " " + u.getName() + " " + u.getEmail())
        );

//        dao.deleteUser(4);




    }
}
