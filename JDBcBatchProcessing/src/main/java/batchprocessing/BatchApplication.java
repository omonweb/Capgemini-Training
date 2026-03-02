package batchprocessing;

import batchprocessing.dao.PlayerDao;
import batchprocessing.dao.PlayerDaoImpl;
import batchprocessing.entity.Player;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BatchApplication {
    public static void main(String[] args) throws SQLException {

        List<Player> team = new ArrayList<>();

        team.add(new Player(1,"Abhishek","Paki"));
        team.add(new Player(2,"I.Kishan", "India"));
        team.add(new Player(3,"Raina", "India"));
        team.add(new Player(4,"QDK", "South Africa"));

        PlayerDaoImpl obj = new PlayerDaoImpl();

//        try {
//            obj.insertBatch(team);
//            System.out.println("Batch inserted");
//        }
//        catch (Exception e){
//            System.out.println("Insertion failed; please try again!");
//        }

        try {
            obj.updateBatch(team);
            System.out.println("Batch updated");
        }
        catch (Exception e){
            System.out.println("Updation failed; please try again!");
        }
    }
}
