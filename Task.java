class Task {
    String title;
    String deadline;
    String priority;
    boolean isCompleted;

    public Task(String title, String deadline, String priority) {
        this.title = title;
        this.deadline = deadline;
        this.priority = priority;
        this.isCompleted = false;
    }

    public void markCompleted() {
        isCompleted = true;
    }

    @Override
    public String toString() {
        return title + "," + deadline + "," + priority + "," + isCompleted;
    }

    public static Task fromString(String data) {
        String[] parts = data.split(",");
        Task task = new Task(parts[0], parts[1], parts[2]);
        task.isCompleted = Boolean.parseBoolean(parts[3]);
        return task;
    }
}