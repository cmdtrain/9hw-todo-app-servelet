package todo.storage;

import java.util.ArrayList;
import java.util.List;
import todo.model.Task;
import todo.model.Priority;

public class TaskStorage {
    private static final List<Task> tasks = new ArrayList<>();
    private static int nextId = 1;

    public static List<Task> getAll() {
        return tasks;
    }

    public static Task findById(int id) {
        return tasks.stream()
                .filter(t -> t.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public static boolean exists(String name, Integer excludeId) {
        return tasks.stream().anyMatch(t ->
                t.getName().equalsIgnoreCase(name)
                        && (excludeId == null || t.getId() != excludeId));
    }

    public static Task add(String name, Priority priority) {
        if (exists(name, null)) {
            return null;
        }
        Task t = new Task(nextId++, name, priority);
        tasks.add(t);
        return t;
    }

    public static boolean update(int id, String name, Priority priority) {
        if (exists(name, id)) {
            return false;
        }
        Task t = findById(id);
        if (t == null) {
            return false;
        }
        t.setName(name);
        t.setPriority(priority);
        return true;
    }

    public static void delete(int id) {
        tasks.removeIf(t -> t.getId() == id);
    }
}