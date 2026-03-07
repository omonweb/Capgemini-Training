package M1prep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class StepRecord {
    int userId;
    int steps;

    StepRecord(int userId, int steps) {
        this.steps = steps;
        this.userId = userId;
    }
}

public class Ques_5_Activity_Steps {

    // total steps per user, sort descending by steps, lower userid
    public static void generateLeaderboard(List<StepRecord> records) {

        HashMap<Integer, Integer> tot_steps = new HashMap<>();

        for(StepRecord record : records) {
            tot_steps.put(record.userId,
                            tot_steps.getOrDefault(record.userId, 0)
                                                    + record.steps);
        }

        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(tot_steps.entrySet());

        list.sort((a,b) -> {
            int steps1 = a.getValue();
            int steps2 = b.getValue();

            int res = Integer.compare(steps2,steps1);

            if(res != 0) return res;

            return Integer.compare(a.getKey(),b.getKey());
        });

        for (Map.Entry<Integer,Integer> user : list) {
            System.out.println(user.getKey() + " -> "+ user.getValue());
        }
    }

    public static void main(String[] args) {
        List<StepRecord> records = new ArrayList<>(List.of(
                new StepRecord(101,5000),
                new StepRecord(102,7000),
                new StepRecord(101,3000),
                new StepRecord(103,9000),
                new StepRecord(102,2000)
        ));

        Ques_5_Activity_Steps.generateLeaderboard(records);
    }
}
