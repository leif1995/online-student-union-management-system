package edu.ncwu.osums.service;

import java.util.List;

import edu.ncwu.osums.entity.Department;
import edu.ncwu.osums.exception.ServiceException;

public interface DepartmentService {
    public abstract int create(Department department) throws ServiceException;

    public abstract int removeById(Department department);

    public abstract int changeById(Department department);

    public abstract Department findById(int id);

    public abstract List<Department> findAll();

    public abstract List<Department> findForRecruitment();
}
