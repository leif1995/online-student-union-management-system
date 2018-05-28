package edu.ncwu.osums.service;

import java.util.List;

import edu.ncwu.osums.entity.User;
import edu.ncwu.osums.exception.ParameterException;
import edu.ncwu.osums.exception.ServiceException;

public interface UserService {
    public abstract int removeByUsername(String username);

    public abstract int changeByUsername(User user);

    public abstract int changePasswordForResetByUsername(User user);

    public abstract int changeBasicByUsername(User user);

    public abstract int changePasswordByUsername(User user, String oldPassword, String newPassword) throws ServiceException;

    public abstract List<User> findTopEight();

    public abstract List<User> findTopOneByDepartmentName();

    public abstract List<User> findAllByDepartmentName(String departmentName);

    public abstract User findByUsername(String username);

    public abstract int findCountByDepartmentName(String departmentName);

    public abstract User login(String username, String password) throws ParameterException, ServiceException;
}
