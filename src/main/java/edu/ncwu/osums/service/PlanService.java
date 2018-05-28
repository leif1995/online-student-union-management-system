package edu.ncwu.osums.service;

import java.util.List;

import edu.ncwu.osums.entity.Plan;
import edu.ncwu.osums.entity.Position;

public interface PlanService {
    public abstract int create(Position position, Plan plan);

    public abstract int removeByIds(String ids);

    public abstract int changeAttachmentById(int id, String attachment, String suffix);

    public abstract int changeStatusForRemoveByIds(String ids, String updatedTime, String updatedBy);

    public abstract int changeStatusForPassByIds(String departmentName, String ids, String updatedTime, String updatedBy);

    public abstract int changeById(Plan plan);

    public abstract int findForDiagramByDepartmentName(String departmentName);

    public abstract Plan findLastId();

    public abstract Plan findById(int id);

    public abstract List<Plan> findActive(String departmentName, String search, int currentPage);

    public abstract int findActiveCount(String departmentName, String search);

    public abstract List<Plan> findCompleted(String departmentName, String search, int currentPage);

    public abstract int findCompletedCount(String departmentName, String search);

    public abstract List<Plan> findOverdue(String departmentName, String search, int currentPage);

    public abstract int findOverdueCount(String departmentName, String search);

    public abstract int findCountByPlanType(String planType);
}
