package edu.ncwu.osums.entity;

public class Indexs {
    private int id;
    private String indexs_name;
    private String content;
    private String type;
    private String attachment;
    private String suffix;
    private int status;
    private String created_time;
    private String created_by;
    private String updated_time;
    private String updated_by;

    public Indexs() {}

    public Indexs(String indexs_name, String content, String type, int status, String created_time, String created_by, String updated_time, String updated_by) {
        this.indexs_name = indexs_name;
        this.content = content;
        this.type = type;
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

    public String getIndexs_name() {
        return indexs_name;
    }

    public void setIndexs_name(String indexs_name) {
        this.indexs_name = indexs_name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
        return "Indexs [id=" + id + ", indexs_name=" + indexs_name + ", content=" + content + ", type=" + type + ", attachment=" + attachment + ", status=" + status + ", suffix=" + suffix + ", created_time=" + created_time + ", created_by=" + created_by + ", updated_time=" + updated_time + ", updated_by=" + updated_by + "]";
    }
}
