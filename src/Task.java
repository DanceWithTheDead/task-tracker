import java.time.LocalDateTime;

public class Task {

    public int id;
    public String description;
    public String status;
    public LocalDateTime created_at;
    public LocalDateTime updated_at;

    public Task(
            int id,
            String description
    ) {
     this.id = id;
     this.description = description;
     this.status = "todo";
     this.created_at = LocalDateTime.now();
     this.updated_at = this.created_at;

    }
}