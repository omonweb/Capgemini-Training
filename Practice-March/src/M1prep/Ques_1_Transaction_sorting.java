package M1prep;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Transaction {
    String transactionId;
    int amount;
    int timestamp;

    Transaction(String transactionId, int amount, int timestamp) {
        this.amount = amount;
        this.transactionId = transactionId;
        this.timestamp = timestamp;
    }
}

public class Ques_1_Transaction_sorting {
    public static void trans_sorting(List<Transaction> transactions) {
        Collections.sort(transactions, (a,b) -> {
            int amt1 = a.amount;
            int amt2 = b.amount;

            int res = amt2 - amt1;

            if(res != 0) return res;
            else return Integer.compare(a.timestamp,b.timestamp);
        });
    }

    public static void main(String[] args) {

        List<Transaction> transactions = new ArrayList<>(List.of(
                new Transaction("T1", 5000, 120),
                new Transaction("T2", 7000, 180),
                new Transaction("T3", 5000, 190),
                new Transaction("T4", 7000, 210)
        ));

        Ques_1_Transaction_sorting.trans_sorting(transactions);

        for (Transaction t : transactions) {
            System.out.println(t.transactionId+" -- "+t.amount+" -- "+t.timestamp);
        }
    }
}
