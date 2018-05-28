package edu.ncwu.osums.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ncwu.osums.dao.ActivityDao;
import edu.ncwu.osums.entity.Activity;
import edu.ncwu.osums.service.ActivityService;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityDao activityDao;

    @Override
    public int create(Activity activity) {
        return activityDao.insert(activity);
    }

    @Override
    public int removeByIds(String ids) {
        return activityDao.deleteByIds(ids);
    }

    @Override
    public int changeStatusForRemoveByIds(String ids, String updatedTime, String updatedBy) {
        return activityDao.updateStatusForDeleteByIds(ids, updatedTime, updatedBy);
    }

    @Override
    public int changeAutomaticallyById(int id) {
        return activityDao.updateAutomaticallyById(id);
    }

    @Override
    public int changeById(Activity activity) {
        return activityDao.updateById(activity);
    }

    @Override
    public List<Activity> findActiveForChangeAutomaticallyById() {
        return activityDao.selectActiveForUpdateAutomaticallyById();
    }

    @Override
    public List<Activity> findActive(String search, int currentPage) {
        return activityDao.selectActive(search, currentPage);
    }

    @Override
    public int findActiveCount(String search) {
        return activityDao.selectActiveCount(search);
    }

    @Override
    public List<Activity> findCompleted(String search, int currentPage) {
        return activityDao.selectCompleted(search, currentPage);
    }

    @Override
    public int findCompletedCount(String search) {
        return activityDao.selectCompletedCount(search);
    }

    @Override
    public List<Activity> findOverdue(String search, int currentPage) {
        return activityDao.selectOverdue(search, currentPage);
    }

    @Override
    public int findOverdueCount(String search) {
        return activityDao.selectOverdueCount(search);
    }
}
