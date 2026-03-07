package M1prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ques_2_Activity_Tracker {
    public static void processLogs(List<String> logs){
        HashMap<String,Integer> actions = new HashMap<>();
        HashMap<String,Integer> sessions = new HashMap<>();

        for(String log : logs) {
            String user = log.substring(log.indexOf(":")+1);
            String activity = log.substring(0,log.indexOf(":"));

            if(activity.equalsIgnoreCase("action")){
                actions.put(user,actions.getOrDefault(user,0)+1);
            }
            if(activity.equalsIgnoreCase("login")){
                sessions.put(user,sessions.getOrDefault(user,0)+1);
            }
        }
        sessions.forEach((key,value1) -> {
            int value2 = actions.getOrDefault(key,0);

            System.out.print("User "+ key+" ->");
            System.out.print("Sessions: "+value1);
            System.out.println(" Actions: "+ value2);

        });
    }

    public static void main(String[] args) {
        List<String> logs = new ArrayList<>(List.of(
                "LOGIN:101",
                "ACTION:101",
                "ACTION:101",
                "LOGOUT:101",
                "LOGIN:101",
                "LOGIN:102",
                "ACTION:101",
                "LOGOUT:101",
                "ACTION:102",
                "ACTION:101"
        ));
        Ques_2_Activity_Tracker.processLogs(logs);
    }
}
