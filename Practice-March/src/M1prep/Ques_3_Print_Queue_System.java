package M1prep;

import java.util.*;

class PrintJob {
    String jobId;
    int pages;
    boolean delayed;

    PrintJob(String jobId, int pages, boolean delayed) {
        this.jobId = jobId;
        this.pages = pages;
        this.delayed = delayed;
    }
}

public class Ques_3_Print_Queue_System {
    public static void processPrintQueue(Queue<PrintJob> queue) {
        Queue<PrintJob> assess = new LinkedList<>();

        for(PrintJob job : queue) {
            if(job.pages <= 10) {
                System.out.println("Printing "+job.jobId+" (Pages: "+job.pages+")");
                continue;
            }
            else {
                job.delayed = true;
                assess.offer(job);
            }
        }
        for(PrintJob job : assess) {
            System.out.println("Printing "+job.jobId+" (Pages: "+job.pages+")");
        }
    }

    public static void main(String[] args) {
        Queue<PrintJob> jobs = new LinkedList<>(List.of(
                new PrintJob("j1",5,false),
                new PrintJob("j2",12,false),
                new PrintJob("j3",7,false),
                new PrintJob("j4",15,false)
        ));

        Ques_3_Print_Queue_System.processPrintQueue(jobs);
    }
}
