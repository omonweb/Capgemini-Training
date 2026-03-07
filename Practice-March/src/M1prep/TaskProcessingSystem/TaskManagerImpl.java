package M1prep.TaskProcessingSystem;

import java.util.*;

interface TaskManager {
    void addTask(String user, String taskName);
    String processTask();
    int getPendingTaskCount(String user);
    List<String> getUsersWithPendingTasks();
}

class Task {
    String user;
    String taskName;

    Task(String user,String taskName) {
        this.user = user;
        this.taskName = taskName;
    }
}

public class TaskManagerImpl implements TaskManager{
    String user;
    String taskName;
    Queue<Task> queue = new LinkedList<>();
    Map<String,Integer> pendingCount = new HashMap<>();
    TreeSet<String> users = new TreeSet<>();

    @Override
    public void addTask(String user, String taskName) {

        queue.offer(new Task(user,taskName));

        pendingCount.put(user, pendingCount.getOrDefault(user,0)+1);

        users.add(user);
    }

    @Override
    public String processTask() {

        if(users.isEmpty()) return "No Task";

        Task task = queue.poll();

        pendingCount.put(task.user,pendingCount.get(task.user) - 1);

        if(pendingCount.get(task.user) == 0) {
            pendingCount.remove(task.user);
            users.remove(task.user);
        }
        return task.taskName;
    }

    @Override
    public int getPendingTaskCount(String user) {
        return pendingCount.getOrDefault(user,0);
    }

    @Override
    public List<String> getUsersWithPendingTasks() {
        return new ArrayList<>(users);
    }
}
