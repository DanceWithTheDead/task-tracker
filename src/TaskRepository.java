import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {
    private static final String FILE_NAME = "tasks.json";

    public List<String> load() throws IOException
    {
        if (!Files.exists(Path.of(FILE_NAME))){
            Files.writeString(Path.of(FILE_NAME), "[]");
        }

        String content = Files.readString(Path.of(FILE_NAME)).trim();
        List<String> tasks = new ArrayList<>();

        if (content.length() <= 2){
            return tasks;
        }

        content = content.substring(1, content.length() - 1);
        String[] parts = content.split("//},");

        for (String p: parts) {
            if (!p.endsWith("}")) {
                p = p + "}";
            }
            tasks.add(p);
        }

        return tasks;
    }

    public void save(List<String> tasks) throws IOException
    {
        String json = "[" + String.join(",", tasks) + "]";
        Files.writeString(Path.of(FILE_NAME), json);
    }
}
