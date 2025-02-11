package org.example;

public class Task {
    private int id;
    private int userId;
    private String title;
    private String description;
    private String status;

    public Task(int userId, String title, String description, String status) {
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{userId=" + userId + ", title='" + title + "', status='" + status + "'}";
    }
}
