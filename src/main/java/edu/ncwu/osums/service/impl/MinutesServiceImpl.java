package edu.ncwu.osums.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ncwu.osums.dao.MinutesDao;
import edu.ncwu.osums.dao.UserDao;
import edu.ncwu.osums.entity.Minutes;
import edu.ncwu.osums.service.MinutesService;
import edu.ncwu.osums.util.StringUtil;

@Service
public class MinutesServiceImpl implements MinutesService {
    @Autowired
    private MinutesDao minutesDao;

    @Autowired
    private UserDao userDao;

    @Override
    public int create(Minutes minutes) {
        minutesDao.insert(minutes);

        if (!StringUtil.isEmpty(minutes.getLeaver())) {
            for (String leaver : minutes.getLeaver().split(";")) {
                if (!StringUtil.isEmpty(leaver)) {
                    userDao.updatePersonalCountByUsername("leave_number", userDao.selectByUsername(leaver.substring(0, leaver.indexOf("-"))).getLeave_number() + 1, leaver.substring(0, leaver.indexOf("-")));
                }
            }
        }

        if (!StringUtil.isEmpty(minutes.getLater())) {
            for (String later : minutes.getLater().split(";")) {
                if (!StringUtil.isEmpty(later)) {
                    userDao.updatePersonalCountByUsername("late_number", userDao.selectByUsername(later.substring(0, later.indexOf("-"))).getLate_number() + 1, later.substring(0, later.indexOf("-")));
                }
            }
        }

        if (!StringUtil.isEmpty(minutes.getAbsenteeismer())) {
            for (String absenteeismer : minutes.getAbsenteeismer().split(";")) {
                if (!StringUtil.isEmpty(absenteeismer)) {
                    userDao.updatePersonalCountByUsername("absenteeism_number", userDao.selectByUsername(absenteeismer.substring(0, absenteeismer.indexOf("-"))).getAbsenteeism_number() + 1, absenteeismer.substring(0, absenteeismer.indexOf("-")));
                }
            }
        }

        return 1;
    }

    @Override
    public int removeById(int id) {
        Minutes minutes = minutesDao.selectById(id);
        minutesDao.deleteById(id);

        if (!StringUtil.isEmpty(minutes.getLeaver())) {
            for (String leaver : minutes.getLeaver().split(";")) {
                if (!StringUtil.isEmpty(leaver)) {
                    userDao.updatePersonalCountByUsername("leave_number", userDao.selectByUsername(leaver.substring(0, leaver.indexOf("-"))).getLeave_number() - 1, leaver.substring(0, leaver.indexOf("-")));
                }
            }
        }

        if (!StringUtil.isEmpty(minutes.getLater())) {
            for (String later : minutes.getLater().split(";")) {
                if (!StringUtil.isEmpty(later)) {
                    userDao.updatePersonalCountByUsername("late_number", userDao.selectByUsername(later.substring(0, later.indexOf("-"))).getLate_number() - 1, later.substring(0, later.indexOf("-")));
                }
            }
        }

        if (!StringUtil.isEmpty(minutes.getAbsenteeismer())) {
            for (String absenteeismer : minutes.getAbsenteeismer().split(";")) {
                if (!StringUtil.isEmpty(absenteeismer)) {
                    userDao.updatePersonalCountByUsername("absenteeism_number", userDao.selectByUsername(absenteeismer.substring(0, absenteeismer.indexOf("-"))).getAbsenteeism_number() - 1, absenteeismer.substring(0, absenteeismer.indexOf("-")));
                }
            }
        }

        return 1;
    }

    @Override
    public int changeById(Minutes minutes) {
        Minutes oldMinutes = minutesDao.selectById(minutes.getId());
        minutesDao.updateById(minutes);

        if (!StringUtil.isEmpty(oldMinutes.getLeaver())) {
            for (String leaver : oldMinutes.getLeaver().split(";")) {
                if (!StringUtil.isEmpty(leaver)) {
                    userDao.updatePersonalCountByUsername("leave_number", userDao.selectByUsername(leaver.substring(0, leaver.indexOf("-"))).getLeave_number() - 1, leaver.substring(0, leaver.indexOf("-")));
                }
            }
        }

        if (!StringUtil.isEmpty(oldMinutes.getLater())) {
            for (String later : oldMinutes.getLater().split(";")) {
                if (!StringUtil.isEmpty(later)) {
                    userDao.updatePersonalCountByUsername("late_number", userDao.selectByUsername(later.substring(0, later.indexOf("-"))).getLate_number() - 1, later.substring(0, later.indexOf("-")));
                }
            }
        }

        if (!StringUtil.isEmpty(oldMinutes.getAbsenteeismer())) {
            for (String absenteeismer : oldMinutes.getAbsenteeismer().split(";")) {
                if (!StringUtil.isEmpty(absenteeismer)) {
                    userDao.updatePersonalCountByUsername("absenteeism_number", userDao.selectByUsername(absenteeismer.substring(0, absenteeismer.indexOf("-"))).getAbsenteeism_number() - 1, absenteeismer.substring(0, absenteeismer.indexOf("-")));
                }
            }
        }

        if (!StringUtil.isEmpty(minutes.getLeaver())) {
            for (String leaver : minutes.getLeaver().split(";")) {
                if (!StringUtil.isEmpty(leaver)) {
                    userDao.updatePersonalCountByUsername("leave_number", userDao.selectByUsername(leaver.substring(0, leaver.indexOf("-"))).getLeave_number() + 1, leaver.substring(0, leaver.indexOf("-")));
                }
            }
        }

        if (!StringUtil.isEmpty(minutes.getLater())) {
            for (String later : minutes.getLater().split(";")) {
                if (!StringUtil.isEmpty(later)) {
                    userDao.updatePersonalCountByUsername("late_number", userDao.selectByUsername(later.substring(0, later.indexOf("-"))).getLate_number() + 1, later.substring(0, later.indexOf("-")));
                }
            }
        }

        if (!StringUtil.isEmpty(minutes.getAbsenteeismer())) {
            for (String absenteeismer : minutes.getAbsenteeismer().split(";")) {
                if (!StringUtil.isEmpty(absenteeismer)) {
                    userDao.updatePersonalCountByUsername("absenteeism_number", userDao.selectByUsername(absenteeismer.substring(0, absenteeismer.indexOf("-"))).getAbsenteeism_number() + 1, absenteeismer.substring(0, absenteeismer.indexOf("-")));
                }
            }
        }

        return 1;
    }

    @Override
    public Minutes findById(int id) {
        return minutesDao.selectById(id);
    }

    @Override
    public List<Minutes> findByDepartmentName(String departmentName, String search, int currentPage) {
        return minutesDao.selectByDepartmentName(departmentName, search, currentPage);
    }

    @Override
    public int findCountByDepartmentName(String departmentName, String search) {
        return minutesDao.selectCountByDepartmentName(departmentName, search);
    }
}
