package edu.ncwu.osums.entity;

public class Minutes {
    private int id;
    private String minutes_name;
    private String department_name;
    private String start_time;
    private String end_time;
    private String place;
    private String host;
    private String attendees;
    private String leaver;
    private String later;
    private String absenteeismer;
    private String content;
    private String created_time;
    private String created_by;
    private String updated_time;
    private String updated_by;

    public Minutes() {}

    public Minutes(String minutes_name, String department_name, String start_time, String end_time, String place, String host, String attendees, String leaver, String later, String absenteeismer, String content, String created_time, String created_by, String updated_time, String updated_by) {
        this.minutes_name = minutes_name;
        this.department_name = department_name;
        this.start_time = start_time;
        this.end_time = end_time;
        this.place = place;
        this.host = host;
        this.attendees = attendees;
        this.leaver = leaver;
        this.later = later;
        this.absenteeismer = absenteeismer;
        this.content = content;
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

    public String getMinutes_name() {
        return minutes_name;
    }

    public void setMinutes_name(String minutes_name) {
        this.minutes_name = minutes_name;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getAttendees() {
        return attendees;
    }

    public void setAttendees(String attendees) {
        this.attendees = attendees;
    }

    public String getLeaver() {
        return leaver;
    }

    public void setLeaver(String leaver) {
        this.leaver = leaver;
    }

    public String getLater() {
        return later;
    }

    public void setLater(String later) {
        this.later = later;
    }

    public String getAbsenteeismer() {
        return absenteeismer;
    }

    public void setAbsenteeismer(String absenteeismer) {
        this.absenteeismer = absenteeismer;
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
        return "Minutes [id=" + id + ", minutes_name=" + minutes_name + ", department_name=" + department_name + ", start_time=" + start_time + ", end_time=" + end_time + ", place=" + place + ", host=" + host + ", attendees=" + attendees + ", leaver=" + leaver + ", later=" + later + ", absenteeismer=" + absenteeismer + ", content=" + content + ", created_time=" + created_time + ", created_by=" + created_by + ", updated_time=" + updated_time + ", updated_by=" + updated_by + "]";
    }
}
