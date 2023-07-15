package system;

import java.util.ArrayList;
import java.util.List;

public class TaskList {
    private String name;
    private String description;
    private List<Task> tasks;

    public TaskList(String name, String description) {
        this.name = name;
        this.description = description;
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

    // Add other methods for task list management operations

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
