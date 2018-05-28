package edu.ncwu.osums.service;

import java.util.List;

import edu.ncwu.osums.entity.Minutes;

public interface MinutesService {
    public abstract int create(Minutes minutes);

    public abstract int removeById(int id);

    public abstract int changeById(Minutes minutes);

    public abstract Minutes findById(int id);

    public abstract List<Minutes> findByDepartmentName(String departmentName, String search, int currentPage);

    public abstract int findCountByDepartmentName(String departmentName, String search);
}
