package system;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public List<Task> getTasksByUser(String username) {
        List<Task> userTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getAssignedUser().equals(username)) {
                userTasks.add(task);
            }
        }
        return userTasks;
    }
    
    // Add other methods for task management operations like updateTask, getTasksByStatus, etc.
}