package trackie.tasks;

public class Event extends Task {
    private String type = "E";
    private String start;
    private String end;

    public Event(String description, String start, String end) {
        super(description);
        this.start = start;
        this.end = end;
    }

    public Event(String description, String start, String end, int status) {
        super(description, status);
        this.start = start;
        this.end = end;
    }

    public String getTaskInfo() {
        return(String.format("%s, (from: %s to: %s)", super.description, this.start, this.end));
    }

    public String getTaskType() {
        return(this.type);
    }

    public String getStart() { return(this.start); }

    public String getEnd() { return(this.end); }
}
