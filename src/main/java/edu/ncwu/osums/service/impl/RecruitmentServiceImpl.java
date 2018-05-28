package edu.ncwu.osums.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ncwu.osums.dao.DepartmentDao;
import edu.ncwu.osums.dao.PositionDao;
import edu.ncwu.osums.dao.RecruitmentDao;
import edu.ncwu.osums.dao.UserDao;
import edu.ncwu.osums.entity.Recruitment;
import edu.ncwu.osums.service.RecruitmentService;

@Service
public class RecruitmentServiceImpl implements RecruitmentService {
    @Autowired
    private RecruitmentDao recruitmentDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private PositionDao positionDao;

    @Override
    public int create(Recruitment recruitment) {
        if (userDao.selectByUsername(recruitment.getUsername()) == null) {
            return recruitmentDao.insert(recruitment);
        }

        return -1;
    }

    @Override
    public int removeAll() {
        return recruitmentDao.deleteAll();
    }

    @Override
    public int changeForDepartmentById(int id, String departmentName) {
        return recruitmentDao.updateForDepartmentById(id, departmentName);
    }

    @Override
    public int changeStatusForRemoveById(int id, String updatedTime, String updatedBy) {
        return recruitmentDao.updateStatusForDeleteById(id, updatedTime, updatedBy);
    }

    @Override
    public int changeStatusForPassById(int id, String updatedTime, String updatedBy) {
        recruitmentDao.updateStatusForPassById(id, updatedTime, updatedBy);
        Recruitment recruitment = recruitmentDao.selectAutomaticallyById(id);
        userDao.insertAutomaticallyFromRecruitment(recruitment);
        departmentDao.updatePeopleNumberByDepartmentName(userDao.selectCountByDepartmentName(recruitment.getDepartment_name()), recruitment.getDepartment_name());
        positionDao.updatePeopleNumberByPositionName(userDao.selectCountByPositionName("干事"), "干事");
        return recruitmentDao.deleteAutomaticallyByUsername(recruitment.getId(), recruitment.getUsername());
    }

    @Override
    public Recruitment findById(int id) {
        return recruitmentDao.selectAutomaticallyById(id);
    }

    @Override
    public List<Recruitment> findAll() {
        return recruitmentDao.selectAll();
    }

    @Override
    public List<Recruitment> findApplication(int currentPage) {
        return recruitmentDao.selectApplication(currentPage);
    }

    @Override
    public int findApplicationCount(String departmentName) {
        if ("软件学院".equals(departmentName) || "主席团".equals(departmentName)) {
            return recruitmentDao.selectApplicationCount("%%");
        } else {
            return recruitmentDao.selectApplicationCount(departmentName);
        }
    }

    @Override
    public int findCount() {
        return recruitmentDao.selectCount();
    }
}
