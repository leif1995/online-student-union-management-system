package edu.ncwu.osums.entity;

public class User {
    private int id;
    private String username;
    private String password;
    private String nickname;
    private String gender;
    private String birthday;
    private String major;
    private String classs;
    private String native_place;
    private String department_name;
    private String position_name;
    private String phone;
    private String email;
    private String qq;
    private String hobby;
    private String self_appraisal;
    private String awards_and_achievements;
    private int leave_number;
    private int late_number;
    private int absenteeism_number;
    private int plan_active_number;
    private int plan_completed_number;
    private int plan_overdue_number;
    private String created_time;
    private String created_by;
    private String updated_time;
    private String updated_by;

    public User() {}

    public User(String username, String password, String nickname, String gender, String birthday, String major, String classs, String native_place, String department_name, String position_name, String phone, String email, String qq, String hobby, String self_appraisal, String awards_and_achievements, int leave_number, int late_number, int absenteeism_number, int plan_active_number, int plan_completed_number, int plan_overdue_number, String created_time, String created_by, String updated_time, String updated_by) {
        this.username = username;
        this.password = password;
        this.nickname = nickname;
        this.gender = gender;
        this.birthday = birthday;
        this.major = major;
        this.classs = classs;
        this.native_place = native_place;
        this.department_name = department_name;
        this.position_name = position_name;
        this.phone = phone;
        this.email = email;
        this.qq = qq;
        this.hobby = hobby;
        this.self_appraisal = self_appraisal;
        this.awards_and_achievements = awards_and_achievements;
        this.leave_number = leave_number;
        this.late_number = late_number;
        this.absenteeism_number = absenteeism_number;
        this.plan_active_number = plan_active_number;
        this.plan_completed_number = plan_completed_number;
        this.plan_overdue_number = plan_overdue_number;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClasss() {
        return classs;
    }

    public void setClasss(String classs) {
        this.classs = classs;
    }

    public String getNative_place() {
        return native_place;
    }

    public void setNative_place(String native_place) {
        this.native_place = native_place;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getPosition_name() {
        return position_name;
    }

    public void setPosition_name(String position_name) {
        this.position_name = position_name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getSelf_appraisal() {
        return self_appraisal;
    }

    public void setSelf_appraisal(String self_appraisal) {
        this.self_appraisal = self_appraisal;
    }

    public String getAwards_and_achievements() {
        return awards_and_achievements;
    }

    public void setAwards_and_achievements(String awards_and_achievements) {
        this.awards_and_achievements = awards_and_achievements;
    }

    public int getLeave_number() {
        return leave_number;
    }

    public void setLeave_number(int leave_number) {
        this.leave_number = leave_number;
    }

    public int getLate_number() {
        return late_number;
    }

    public void setLate_number(int late_number) {
        this.late_number = late_number;
    }

    public int getAbsenteeism_number() {
        return absenteeism_number;
    }

    public void setAbsenteeism_number(int absenteeism_number) {
        this.absenteeism_number = absenteeism_number;
    }

    public int getPlan_active_number() {
        return plan_active_number;
    }

    public void setPlan_active_number(int plan_active_number) {
        this.plan_active_number = plan_active_number;
    }

    public int getPlan_completed_number() {
        return plan_completed_number;
    }

    public void setPlan_completed_number(int plan_completed_number) {
        this.plan_completed_number = plan_completed_number;
    }

    public int getPlan_overdue_number() {
        return plan_overdue_number;
    }

    public void setPlan_overdue_number(int plan_overdue_number) {
        this.plan_overdue_number = plan_overdue_number;
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
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", nickname=" + nickname + ", gender=" + gender + ", birthday=" + birthday + ", major=" + major + ", classs=" + classs + ", native_place=" + native_place + ", department_name=" + department_name + ", position_name=" + position_name + ", phone=" + phone + ", email=" + email + ", qq=" + qq + ", hobby=" + hobby + ", self_appraisal=" + self_appraisal + ", awards_and_achievements=" + awards_and_achievements + ", leave_number=" + leave_number + ", late_number=" + late_number + ", absenteeism_number=" + absenteeism_number + ", plan_active_number=" + plan_active_number + ", plan_completed_number=" + plan_completed_number + ", plan_overdue_number=" + plan_overdue_number + ", created_time=" + created_time + ", created_by=" + created_by + ", updated_time=" + updated_time + ", updated_by=" + updated_by + "]";
    }
}
