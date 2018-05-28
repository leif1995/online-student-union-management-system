package edu.ncwu.osums.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ncwu.osums.dao.ActivityDao;
import edu.ncwu.osums.dao.PlanDao;
import edu.ncwu.osums.dao.UserDao;
import edu.ncwu.osums.entity.Plan;
import edu.ncwu.osums.entity.Position;
import edu.ncwu.osums.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    private PlanDao planDao;

    @Autowired
    private ActivityDao activityDao;

    @Autowired
    private UserDao userDao;

    @Override
    public int create(Position position, Plan plan) {
        if (position.getPermission_id() <= 4) {
            plan.setStatus(2);
        }

        planDao.insert(plan);
        return userDao.updatePlanCountByUsername("plan_active_number", planDao.selectActiveCountByUsername(plan.getUsername()), plan.getUsername());
    }

    @Override
    public int removeByIds(String ids) {
        for (String id : ids.substring(1, ids.length() - 1).split(", ")) {
            Plan plan = planDao.selectById(Integer.valueOf(id));
            userDao.updatePlanCountByUsername("plan_overdue_number", planDao.selectOverdueCountByUsername(plan.getUsername()) - 1, plan.getUsername());
        }

        return planDao.deleteByIds(ids);
    }

    @Override
    public int changeAttachmentById(int id, String attachment, String suffix) {
        return planDao.updateAttachmentById(id, attachment, suffix);
    }

    @Override
    public int changeStatusForRemoveByIds(String ids, String updatedTime, String updatedBy) {
        planDao.updateStatusForDeleteByIds(ids, updatedTime, updatedBy);

        for (String id : ids.substring(1, ids.length() - 1).split(", ")) {
            Plan plan = planDao.selectById(Integer.valueOf(id));
            userDao.updatePlanCountByUsername("plan_active_number", planDao.selectActiveCountByUsername(plan.getUsername()), plan.getUsername());
            userDao.updatePlanCountByUsername("plan_completed_number", planDao.selectCompletedCountByUsername(plan.getUsername()), plan.getUsername());
            userDao.updatePlanCountByUsername("plan_overdue_number", planDao.selectOverdueCountByUsername(plan.getUsername()), plan.getUsername());
        }

        return ids.length();
    }

    @Override
    public int changeStatusForPassByIds(String departmentName, String ids, String updatedTime, String updatedBy) {
        if ("软件学院".equals(departmentName) || "主席团".equals(departmentName)) {
            planDao.updateStatusForPassByIds("3", ids, updatedTime, updatedBy);

            for (String id : ids.substring(1, ids.length() - 1).split(", ")) {
                Plan plan = planDao.selectById(Integer.valueOf(id));
                activityDao.insertAutomaticallyFromPlan(plan);
                userDao.updatePlanCountByUsername("plan_active_number", planDao.selectActiveCountByUsername(plan.getUsername()), plan.getUsername());
                userDao.updatePlanCountByUsername("plan_completed_number", planDao.selectCompletedCountByUsername(plan.getUsername()), plan.getUsername());
            }

            return ids.length();
        } else {
            return planDao.updateStatusForPassByIds("2", ids, updatedTime, updatedBy);
        }
    }

    @Override
    public int changeById(Plan plan) {
        return planDao.updateById(plan);
    }

    @Override
    public int findForDiagramByDepartmentName(String departmentName) {
        return planDao.selectForDiagramByDepartmentName(departmentName);
    }

    @Override
    public Plan findLastId() {
        return planDao.selectLastId();
    }

    @Override
    public Plan findById(int id) {
        return planDao.selectById(id);
    }

    @Override
    public List<Plan> findActive(String departmentName, String search, int currentPage) {
        if ("软件学院".equals(departmentName) || "主席团".equals(departmentName)) {
            return planDao.selectActive("%%", "2", search, currentPage);
        } else {
            return planDao.selectActive("%" + departmentName + "%", "1", search, currentPage);
        }
    }

    @Override
    public int findActiveCount(String departmentName, String search) {
        if ("软件学院".equals(departmentName) || "主席团".equals(departmentName)) {
            return planDao.selectActiveCount("%%", "2", search);
        } else {
            return planDao.selectActiveCount("%" + departmentName + "%", "1", search);
        }
    }

    @Override
    public List<Plan> findCompleted(String departmentName, String search, int currentPage) {
        if ("软件学院".equals(departmentName) || "主席团".equals(departmentName)) {
            return planDao.selectCompleted("%%", search, currentPage);
        } else {
            return planDao.selectCompleted("%" + departmentName + "%", search, currentPage);
        }
    }

    @Override
    public int findCompletedCount(String departmentName, String search) {
        if ("软件学院".equals(departmentName) || "主席团".equals(departmentName)) {
            return planDao.selectCompletedCount("%%", search);
        } else {
            return planDao.selectCompletedCount("%" + departmentName + "%", search);
        }
    }

    @Override
    public List<Plan> findOverdue(String departmentName, String search, int currentPage) {
        if ("软件学院".equals(departmentName) || "主席团".equals(departmentName)) {
            return planDao.selectOverdue("%%", search, currentPage);
        } else {
            return planDao.selectOverdue("%" + departmentName + "%", search, currentPage);
        }
    }

    @Override
    public int findOverdueCount(String departmentName, String search) {
        if ("软件学院".equals(departmentName) || "主席团".equals(departmentName)) {
            return planDao.selectOverdueCount("%%", search);
        } else {
            return planDao.selectOverdueCount("%" + departmentName + "%", search);
        }
    }

    @Override
    public int findCountByPlanType(String planType) {
        return planDao.selectCountByPlanType(planType);
    }
}
