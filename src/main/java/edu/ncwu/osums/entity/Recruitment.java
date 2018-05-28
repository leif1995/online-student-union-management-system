package edu.ncwu.osums.entity;

public class Recruitment {
    private int id;
    private String nickname;
    private String gender;
    private String birthday;
    private String major;
    private String classs;
    private String native_place;
    private String username;
    private String department_name;
    private String swap;
    private String phone;
    private String email;
    private String qq;
    private String hobby;
    private String self_appraisal;
    private String department_understanding;
    private String awards_and_achievements;
    private String status;
    private String created_time;
    private String created_by;
    private String updated_time;
    private String updated_by;

    public Recruitment() {}


    public Recruitment(String nickname, String gender, String birthday, String major, String classs, String native_place, String username, String department_name, String swap, String phone, String email, String qq, String hobby, String self_appraisal, String department_understanding, String awards_and_achievements, String status, String created_time, String created_by, String updated_time, String updated_by) {
        this.nickname = nickname;
        this.gender = gender;
        this.birthday = birthday;
        this.major = major;
        this.classs = classs;
        this.native_place = native_place;
        this.username = username;
        this.department_name = department_name;
        this.swap = swap;
        this.phone = phone;
        this.email = email;
        this.qq = qq;
        this.hobby = hobby;
        this.self_appraisal = self_appraisal;
        this.department_understanding = department_understanding;
        this.awards_and_achievements = awards_and_achievements;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public String getSwap() {
        return swap;
    }

    public void setSwap(String swap) {
        this.swap = swap;
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

    public String getDepartment_understanding() {
        return department_understanding;
    }

    public void setDepartment_understanding(String department_understanding) {
        this.department_understanding = department_understanding;
    }

    public String getAwards_and_achievements() {
        return awards_and_achievements;
    }

    public void setAwards_and_achievements(String awards_and_achievements) {
        this.awards_and_achievements = awards_and_achievements;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
        return "Recruitment [id=" + id + ", nickname=" + nickname + ", gender=" + gender + ", birthday=" + birthday + ", major=" + major + ", classs=" + classs + ", native_place=" + native_place + ", username=" + username + ", department_name=" + department_name + ", swap=" + swap + ", phone=" + phone + ", email=" + email + ", qq=" + qq + ", hobby=" + hobby + ", self_appraisal=" + self_appraisal + ", department_understanding=" + department_understanding + ", awards_and_achievements=" + awards_and_achievements + ", status=" + status + ", created_time=" + created_time + ", created_by=" + created_by + ", updated_time=" + updated_time + ", updated_by=" + updated_by + "]";
    }

}
