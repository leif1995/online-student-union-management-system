package edu.ncwu.osums.service;

import java.util.List;

import edu.ncwu.osums.entity.Recruitment;

public interface RecruitmentService {
    public abstract int create(Recruitment recruitment);

    public abstract int removeAll();

    public abstract int changeForDepartmentById(int id, String departmentName);

    public abstract int changeStatusForRemoveById(int id, String updatedTime, String updatedBy);

    public abstract int changeStatusForPassById(int id, String updatedTime, String updatedBy);

    public abstract Recruitment findById(int id);

    public abstract List<Recruitment> findAll();

    public abstract List<Recruitment> findApplication(int currentPage);

    public abstract int findApplicationCount(String departmentName);

    public abstract int findCount();
}
