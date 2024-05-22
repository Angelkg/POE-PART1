
import javax.swing.JOptionPane;


public class NewClass {
    package angelp2;

import javax.swing.JOptionPane;

public class AngelP2 {

    public static void main(String[] args) {
        
               boolean loggedIn = authenticateUser();

        if (loggedIn) {
            JOptionPane.showMessageDialog(null, "Welcome to EasyKanban");

            boolean running = true;
            while (running) {
                String option = JOptionPane.showInputDialog("Choose an option:\n1. Add tasks\n2. Show report\n3. Quit");
                switch (option) {
                    case "1":
                        addTasks();
                        break;
                    case "2":
                        JOptionPane.showMessageDialog(null, "Coming Soon");
                        break;
                    case "3":
                        running = false;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                }
            }
        }
    }

    static boolean authenticateUser() {
        // Implement your login logic here
        // For now, we assume the user is always successfully logged in
        return true;
    }

    private static void addTasks() {
        String taskCountStr = JOptionPane.showInputDialog("How many tasks would you like to enter?");
        int taskCount = Integer.parseInt(taskCountStr);
        int totalHours = 0;

        for (int i = 0; i < taskCount; i++) {
            String taskName = JOptionPane.showInputDialog("Enter task name:");
            String taskDescription = JOptionPane.showInputDialog("Enter task description (max 50 characters):");
            String developerDetails = JOptionPane.showInputDialog("Enter developer details:");
            String taskDurationStr = JOptionPane.showInputDialog("Enter task duration in hours:");
            int taskDuration = Integer.parseInt(taskDurationStr);
            String status = JOptionPane.showInputDialog("Enter task status (To Do, Done, Doing):");

            Task task = new Task(taskName, taskCount, taskDescription, developerDetails, taskDuration, status);
            if (task.checkTaskDescription()) {
                JOptionPane.showMessageDialog(null, "Task successfully captured");
                tasks.add(task);
                totalHours += task.returnTotalHours();
            } else {
                JOptionPane.showMessageDialog(null, "Please enter a task description of less than 50 characters");
            }

            JOptionPane.showMessageDialog(null, task.printTaskDetails());
        }

        JOptionPane.showMessageDialog(null, "Total hours across all tasks: " + totalHours);
        
        
    }
    
}

    
}
