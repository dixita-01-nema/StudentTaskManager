import java.io.*;
import java.util.ArrayList;

class TaskManager {
    ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(String title, String deadline, String priority) {
        tasks.add(new Task(title, deadline, priority));
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }

        for (int i = 0; i < tasks.size(); i++) {
            Task t = tasks.get(i);
            System.out.println((i + 1) + ". " + t.title +
                    " | Deadline: " + t.deadline +
                    " | Priority: " + t.priority +
                    " | Completed: " + t.isCompleted);
        }
    }

    public void markTaskCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).markCompleted();
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task deleted successfully.");
        } else {
            System.out.println("Invalid task number.");
        }
    }

    public void loadFromFile() throws Exception {
        File file = new File("tasks.txt");

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                tasks.add(Task.fromString(line));
            }
        }
    }

    public void saveToFile() throws Exception {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("tasks.txt"))) {
            for (Task t : tasks) {
                bw.write(t.toString());
                bw.newLine();
            }
        }
    }
}