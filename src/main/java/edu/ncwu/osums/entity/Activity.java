package edu.ncwu.osums.entity;

public class Activity {
    private int id;
    private String activity_name;
    private String activity_date;
    private String activity_place;
    private int status;
    private String created_time;
    private String created_by;
    private String updated_time;
    private String updated_by;

    public Activity() {}

    public Activity(String activity_name, String activity_date, String activity_place, int status, String created_time, String created_by, String updated_time, String updated_by) {
        this.activity_name = activity_name;
        this.activity_date = activity_date;
        this.activity_place = activity_place;
        this.status = status;
        this.created_time = created_time;
        this.created_by = created_by;
        this.updated_time = updated_time;
        this.updated_by = updated_by;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActivity_name() {
        return activity_name;
    }

    public void setActivity_name(String activity_name) {
        this.activity_name = activity_name;
    }

    public String getActivity_date() {
        return activity_date;
    }

    public void setActivity_date(String activity_date) {
        this.activity_date = activity_date;
    }

    public String getActivity_place() {
        return activity_place;
    }

    public void setActivity_place(String activity_place) {
        this.activity_place = activity_place;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    public String getUpdated_time() {
        return updated_time;
    }

    public void setUpdated_time(String updated_time) {
        this.updated_time = updated_time;
    }

    public String getUpdated_by() {
        return updated_by;
    }

    public void setUpdated_by(String updated_by) {
        this.updated_by = updated_by;
    }

    @Override
    public String toString() {
        return "Activity [id=" + id + ", activity_name=" + activity_name + ", activity_date=" + activity_date + ", activity_place=" + activity_place + ", status=" + status + ", created_time=" + created_time + ", created_by=" + created_by + ", updated_time=" + updated_time + ", updated_by=" + updated_by + "]";
    }
}
