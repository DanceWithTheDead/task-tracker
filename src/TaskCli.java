public class TaskCli {

    public static void main(String[] args)
    {
        TaskService service = new TaskService();

        if (args.length == 0) {
            System.out.println("No command");
            return;
        }

        try {
            switch (args[0]) {
                case "add":
                    service.add(args[1]);
                    break;
                case "update":
                    service.update(Integer.parseInt(args[1]), args[2]);
                    break;
                case "delete":
                    service.delete(Integer.parseInt(args[1]));
                    break;
                case "mark-in-progress":
                    service.mark(Integer.parseInt(args[1]), "in-progress");
                    break;
                case "mark-done":
                    service.mark(Integer.parseInt(args[1]), "done");
                    break;
                case "list":
                    if (args.length == 1){
                        service.list(null);
                    } else {
                        service.list(args[1]);
                    }
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }  catch (Exception e) {
            System.out.println("Error");
        }
    }
}
