import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        try {
            manager.loadFromFile();
        } catch (Exception e) {
            System.out.println("Error loading tasks.");
        }

        while (true) {
            System.out.println("\n--- Student Task Manager ---");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task Completed");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter deadline: ");
                    String deadline = sc.nextLine();

                    System.out.print("Enter priority: ");
                    String priority = sc.nextLine();

                    manager.addTask(title, deadline, priority);
                }
                case 2 -> manager.viewTasks();
                case 3 -> {
                    System.out.print("Enter task number: ");
                    int index = sc.nextInt() - 1;
                    manager.markTaskCompleted(index);
                }
                case 4 -> {
                    System.out.print("Enter task number: ");
                    int del = sc.nextInt() - 1;
                    manager.deleteTask(del);
                }
                case 5 -> {
                    try {
                        manager.saveToFile();
                    } catch (Exception e) {
                        System.out.println("Error saving tasks.");
                    }
                    System.out.println("Tasks saved successfully.");
                    System.out.println("Exiting program...");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice!");

            }
        }
    }
}