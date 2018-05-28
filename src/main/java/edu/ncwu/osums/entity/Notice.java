package edu.ncwu.osums.entity;

public class Notice {
    private int id;
    private String content;
    private String created_time;
    private String created_by;

    public Notice() {}

    public Notice(String content, String created_time, String created_by) {
        this.content = content;
        this.created_time = created_time;
        this.created_by = created_by;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    @Override
    public String toString() {
        return "Notice [id=" + id + ", content=" + content + ", created_time=" + created_time + ", created_by=" + created_by + "]";
    }
}
