package edu.ncwu.osums.entity;

public class Plan {
    private int id;
    private String plan_name;
    private String plan_type;
    private String activity_date;
    private String activity_place;
    private String activity_background;
    private String activity_purpose;
    private String activity_theme;
    private String activity_object;
    private String attachment;
    private String suffix;
    private int status;
    private String department_name;
    private String username;
    private String created_time;
    private String created_by;
    private String updated_time;
    private String updated_by;

    public Plan() {}

    public Plan(String plan_name, String plan_type, String activity_date, String activity_place, String activity_background, String activity_purpose, String activity_theme, String activity_object, String attachment, String suffix, int status, String department_name, String username, String created_time, String created_by, String updated_time, String updated_by) {
        this.plan_name = plan_name;
        this.plan_type = plan_type;
        this.activity_date = activity_date;
        this.activity_place = activity_place;
        this.activity_background = activity_background;
        this.activity_purpose = activity_purpose;
        this.activity_theme = activity_theme;
        this.activity_object = activity_object;
        this.attachment = attachment;
        this.suffix = suffix;
        this.status = status;
        this.department_name = department_name;
        this.username = username;
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

    public String getPlan_name() {
        return plan_name;
    }

    public void setPlan_name(String plan_name) {
        this.plan_name = plan_name;
    }

    public String getPlan_type() {
        return plan_type;
    }

    public void setPlan_type(String plan_type) {
        this.plan_type = plan_type;
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

    public String getActivity_background() {
        return activity_background;
    }

    public void setActivity_background(String activity_background) {
        this.activity_background = activity_background;
    }

    public String getActivity_purpose() {
        return activity_purpose;
    }

    public void setActivity_purpose(String activity_purpose) {
        this.activity_purpose = activity_purpose;
    }

    public String getActivity_theme() {
        return activity_theme;
    }

    public void setActivity_theme(String activity_theme) {
        this.activity_theme = activity_theme;
    }

    public String getActivity_object() {
        return activity_object;
    }

    public void setActivity_object(String activity_object) {
        this.activity_object = activity_object;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        return "Plan [id=" + id + ", plan_name=" + plan_name + ", plan_type=" + plan_type + ", activity_date=" + activity_date + ", activity_place=" + activity_place + ", activity_background=" + activity_background + ", activity_purpose=" + activity_purpose + ", activity_theme=" + activity_theme + ", activity_object=" + activity_object + ", attachment=" + attachment + ", suffix=" + suffix + ", status=" + status + ", department_name=" + department_name + ", username=" + username + ", created_time=" + created_time + ", created_by=" + created_by + ", updated_time=" + updated_time + ", updated_by=" + updated_by + "]";
    }
}
