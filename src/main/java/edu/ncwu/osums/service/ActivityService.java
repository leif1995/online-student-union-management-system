package edu.ncwu.osums.service;

import java.util.List;

import edu.ncwu.osums.entity.Activity;

public interface ActivityService {
    public abstract int create(Activity activity);

    public abstract int removeByIds(String ids);

    public abstract int changeStatusForRemoveByIds(String ids, String updatedTime, String updatedBy);

    public abstract int changeAutomaticallyById(int id);

    public abstract int changeById(Activity activity);

    public abstract List<Activity> findActiveForChangeAutomaticallyById();

    public abstract List<Activity> findActive(String search, int currentPage);

    public abstract int findActiveCount(String search);

    public abstract List<Activity> findCompleted(String search, int currentPage);

    public abstract int findCompletedCount(String search);

    public abstract List<Activity> findOverdue(String search, int currentPage);

    public abstract int findOverdueCount(String search);
}
