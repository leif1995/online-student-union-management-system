package edu.ncwu.osums.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ncwu.osums.dao.DepartmentDao;
import edu.ncwu.osums.dao.PlanDao;
import edu.ncwu.osums.dao.RecruitmentDao;
import edu.ncwu.osums.dao.UserDao;
import edu.ncwu.osums.entity.Department;
import edu.ncwu.osums.exception.ServiceException;
import edu.ncwu.osums.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private RecruitmentDao recruitmentDao;

    @Autowired
    private PlanDao planDao;

    @Override
    public int create(Department department) throws ServiceException {
        if (departmentDao.selectByDepartmentName(department.getDepartment_name()) != null) {
            throw new ServiceException("该部门已存在！");
        }

        return departmentDao.insert(department);
    }

    @Override
    public int removeById(Department department) {
        if (!"主席团".equals(department.getDepartment_name()) && !"秘书处".equals(department.getDepartment_name()) && !"办公室".equals(department.getDepartment_name()) && !"提案调研部".equals(department.getDepartment_name()) && !"组织部".equals(department.getDepartment_name()) && !"新媒体宣传部".equals(department.getDepartment_name())) {
            userDao.updateAutomaticallyForDepartment(department.getDepartment_name(), department.getUpdated_time(), department.getUpdated_by());
            recruitmentDao.updateAutomaticallyForDepartment(department.getDepartment_name(), department.getUpdated_time(), department.getUpdated_by());
            planDao.updateAutomaticallyForDepartment(department.getDepartment_name(), department.getUpdated_time(), department.getUpdated_by());
            return departmentDao.deleteById(department.getId());
        }

        return 0;
    }

    @Override
    public int changeById(Department department) {
        return departmentDao.updateById(department);
    }

    @Override
    public Department findById(int id) {
        return departmentDao.selectById(id);
    }

    @Override
    public List<Department> findAll() {
        return departmentDao.selectAll();
    }

    @Override
    public List<Department> findForRecruitment() {
        return departmentDao.selectForRecruitment();
    }
}
