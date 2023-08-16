package system;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import system.Task.Priority;
import system.Task.TaskStatus;
import java.text.ParseException;
import java.time.LocalDate;


public class TaskUI {
    private TaskManager taskManager;
    private Scanner scanner;
    private List<Notification> notis;

    public TaskUI() {
        taskManager = new TaskManager();
        scanner = new Scanner(System.in);
        notis = new ArrayList<>();
    }

    public void displayMenu() throws ParseException {
        System.out.println("==== Task Management System ====");
        System.out.println("1. View Tasks");
        System.out.println("2. Create Task");
        System.out.println("3. Update Task");
        System.out.println("4. Delete Task");
        System.out.println("5. View Notifications");
        System.out.println("6. Exit");
        
        

        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                displayTasks();
                break;
            case 2:
                createTask();
                break;
            case 3:
                updateTask();
                break;
            case 4:
                deleteTask();
                break;
            case 5:
            	displayNotifications();
            	break;
            case 6:
                System.out.println("Exiting Task Management System. Goodbye!");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
        }

        // Display the menu again
        displayMenu();
    }

    public void displayTasks() {
        System.out.println("==== Tasks ====");
        for (Task task : taskManager.getAllTasks()) {
            System.out.println("Task Name: " + task.getName());
            System.out.println("Description: " + task.getDescription());
            System.out.println("Due Date: " + task.getDueDate());
            System.out.println("Status: " + task.getStatus());
            System.out.println("Assigned User: " + task.getAssignedUser());
            System.out.println("Priority: " + task.getPriority());
            System.out.println();
        }
    }
    
    public void displayNotifications() throws ParseException {
        System.out.println("==== Notifications ====");
        for (Notification notification : notis) {
        	
        	LocalDate dueDateTime = notification.getAssociatedTask().getDueDate();
        	
        	
        	if (notification.getTimestamp().isAfter(dueDateTime)) {
                System.out.println("Message: " + notification.getMessage());
                System.out.println("Timestamp: " + notification.getTimestamp());
                System.out.println("Associated Task: " + notification.getAssociatedTask().getName());
                System.out.println();        		
        	}
        	

        }
    }

    public void createTask() {
        System.out.println("==== Create Task ====");
        System.out.print("Enter task name: ");
        String name = scanner.nextLine();

        System.out.print("Enter task description: ");
        String description = scanner.nextLine();

        System.out.print("Enter task due date (YYYY-MM-DD): ");
        String dueDateStr = scanner.nextLine();
        LocalDate dueDate = LocalDate.parse(dueDateStr);

        System.out.print("Enter task status: ");
        String statusStr = scanner.nextLine();
        TaskStatus status = TaskStatus.valueOf(statusStr.toUpperCase());

        System.out.print("Enter assigned user: ");
        String assignedUser = scanner.nextLine();

        System.out.print("Enter task priority: ");
        String priorityStr = scanner.nextLine();
        Priority priority = Priority.valueOf(priorityStr.toUpperCase());
        
        System.out.println("Enter notification message: ");
        String message = scanner.nextLine();

        // Create a new task
        Task newTask = new Task(name, description, dueDate, status, priority, assignedUser);

        // Add the task to the task manager
        taskManager.addTask(newTask);
        
        Notification notification = new Notification(message, LocalDate.now(), newTask);
        
        notis.add(notification);
        
        System.out.println("Task created successfully!");
        System.out.println();
        
       
    }

    public void updateTask() {
        System.out.println("==== Update Task ====");
        // Prompt the user to enter task details to update
        // Update the task using taskManager.updateTask() method
        // Display success message or error message
    }

    public void deleteTask() {
        System.out.println("==== Delete Task ====");
        // Prompt the user to enter task details to delete
        // Delete the task using taskManager.deleteTask() method
        // Display success message or error message
    }

    public static void main(String[] args) throws ParseException {
        TaskUI taskUI = new TaskUI();
        taskUI.displayMenu();
    }
}

