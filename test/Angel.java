
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */
public class Angel {
    
}
 import javax.swing.JOptionPane;

class Task {
    private String taskName;
    private int taskNumber;
    private String taskDescription;
    private String developerDetails;
    private int taskDuration;
    private String taskID;
    
    public Task(String taskName, int taskNumber, String taskDescription, String developerDetails, int taskDuration) {
        this.taskName = taskName;
        this.taskNumber = taskNumber;
        this.taskDescription = taskDescription;
        this.developerDetails = developerDetails;
        this.taskDuration = taskDuration;
        this.taskID = createTaskID();
    }
    
    public boolean checkTaskDescription() {
        return taskDescription.length() <= 50;
    }
    
    public String createTaskID() {
        String taskID = taskName.substring(0, 2).toUpperCase() + ":" + taskNumber + ":" + developerDetails.substring(developerDetails.lastIndexOf(" ") + 1).toUpperCase();
        return taskID;
    }
    
    public String printTaskDetails() {
        return "Task Status: " + taskID + "\n" +
               "Developer Details: " + developerDetails + "\n" +
               "Task Number: " + taskNumber + "\n" +
               "Task Name: " + taskName + "\n" +
               "Task Description: " + taskDescription + "\n" +
               "Task ID: " + taskID + "\n" +
               "Task Duration: " + taskDuration + " hours";
    }
    
    public int getTaskDuration() {
        return taskDuration;
    }
}

public class EasyKanban {
    private static boolean loggedIn = false; // Initially assume not logged in
    
    public static void main(String[] args) {
        login(); // Perform login
        
        if (loggedIn) {
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");
            int choice;
            do {
                choice = getChoice();
                switch (choice) {
                    case 1:
                        addTasks();
                        break;
                    case 2:
                        showReport();
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(null, "Exiting application");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid choice");
                }
            } while (choice != 3);
        } else {
            JOptionPane.showMessageDialog(null, "Login failed");
        }
    }
    
    private static void login() {
        // Simulated login process, set loggedIn to true if successful
        // Here you can add your actual login logic
        loggedIn = true; // Assuming successful login for demonstration
    }
    
    private static int getChoice() {
        while (true) {
            try {
                return Integer.parseInt(JOptionPane.showInputDialog("Choose an option:\n1) Add tasks\n2) Show report\n3) Quit"));
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
            }
        }
    }
    
    public static void addTasks() {
        int numTasks;
        while (true) {
            try {
                numTasks = Integer.parseInt(JOptionPane.showInputDialog("Enter number of tasks"));
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
            }
        }
        
        Task[] tasks = new Task[numTasks];
        int totalHours = 0;
        
        for (int i = 0; i < numTasks; i++) {
            String taskName = "Add Login Feature"; // Default task name
            int taskNumber = i;
            String taskDescription = JOptionPane.showInputDialog("Enter task description");
            String developerDetails = JOptionPane.showInputDialog("Enter developer details");
            int taskDuration;
            while (true) {
                try {
                    taskDuration = Integer.parseInt(JOptionPane.showInputDialog("Enter task duration in hours"));
                    break;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                }
            }
            
            Task task = new Task(taskName, taskNumber, taskDescription, developerDetails, taskDuration);
            if (task.checkTaskDescription()) {
                tasks[i] = task;
                totalHours += task.getTaskDuration();
                JOptionPane.showMessageDialog(null, "Task successfully captured:\n" + task.printTaskDetails());
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
                i--; // Retry adding the task
            }
        }
        
        JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + totalHours);
    }
    
    public static void showReport() {
        // Implementation of showing report (to be developed)
        JOptionPane.showMessageDialog(null, "Showing report: Coming Soon");
    }
}

