package edu.ncwu.osums.entity;

public class Feedback {
    private int id;
    private String feedback_content;
    private String type;
    private String created_time;

    public Feedback() {}

    public Feedback(String feedback_content, String type, String created_time) {
        this.feedback_content = feedback_content;
        this.type = type;
        this.created_time = created_time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFeedback_content() {
        return feedback_content;
    }

    public void setFeedback_content(String feedback_content) {
        this.feedback_content = feedback_content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    @Override
    public String toString() {
        return "Feedback [id=" + id + ", feedback_content=" + feedback_content + ", type=" + type + ", created_time=" + created_time + "]";
    }
}
