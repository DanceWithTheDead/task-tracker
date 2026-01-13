import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class TaskService {

    private TaskRepository repository = new TaskRepository();

    public void add(String description) throws IOException
    {
        List<String> tasks = repository.load();

        int id  = tasks.size() + 1;
        String now = LocalDateTime.now().toString();

        String task = "{"
                + "\"id\":" + id + ","
                + "\"description\":\"" + description + "\","
                + "\"status\":\"todo\","
                + "\"createdAt\":\"" + now + "\","
                + "\"updatedAt\":\"" + now + "\""
                + "}";

        tasks.add(task);
        repository.save(tasks);

        System.out.println("Task added (ID: " + id + ")");
    }

    public void update(int id, String description) throws IOException
    {
        List<String> tasks = repository.load();

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).contains("\"id\":" + id)) {
                tasks.set(i, replace(tasks.get(i), "description", description));
                tasks.set(i, replace(tasks.get(i), "updated_at", LocalDateTime.now().toString()));
            }
        }

        repository.save(tasks);
    }

    public void delete(int id) throws  IOException
    {
        List<String> tasks = repository.load();
        tasks.removeIf(t -> t.contains("\"id\":" + id));
        repository.save(tasks);
    }

    public void mark(int id, String status) throws IOException
    {
        List<String> tasks = repository.load();

        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).contains("\"id\":" + id)) {
                tasks.set(i, replace(tasks.get(i), "status", status));
                tasks.set(i, replace(tasks.get(i), "updatedAt", LocalDateTime.now().toString()));
            }
        }

        repository.save(tasks);
    }

    public void list(String status) throws IOException
    {
        List<String> tasks = repository.load();

        for(String t : tasks) {
            if (status == null || t.contains("\"status\":\"" + status + "\"")) {
                System.out.println(t);
            }
        }
    }

    private String replace(
            String json,
            String field,
            String value
    ) {
        return json.replaceAll(
                "\"" + field + "\":\".*?\"",
            "\"" + field + "\":\"" + value + "\""
        );
    }
}
