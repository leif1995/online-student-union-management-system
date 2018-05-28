package edu.ncwu.osums.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ncwu.osums.dao.DepartmentDao;
import edu.ncwu.osums.dao.PositionDao;
import edu.ncwu.osums.dao.UserDao;
import edu.ncwu.osums.entity.Department;
import edu.ncwu.osums.entity.User;
import edu.ncwu.osums.exception.ParameterException;
import edu.ncwu.osums.exception.ServiceException;
import edu.ncwu.osums.service.UserService;
import edu.ncwu.osums.util.StringUtil;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private DepartmentDao departmentDao;

    @Autowired
    private PositionDao positionDao;

    @Override
    public int removeByUsername(String username) {
        User user = userDao.selectByUsername(username);
        userDao.deleteByUsername(username);
        departmentDao.updatePeopleNumberByDepartmentName(userDao.selectCountByDepartmentName(user.getDepartment_name()), user.getDepartment_name());
        positionDao.updatePeopleNumberByPositionName(userDao.selectCountByPositionName(user.getPosition_name()), user.getPosition_name());
        return 1;
    }

    @Override
    public int changePasswordForResetByUsername(User user) {
        return userDao.updatePasswordForResetByUsername(user);
    }

    @Override
    public int changeByUsername(User user) {
        User oldUser = userDao.selectByUsername(user.getUsername());
        userDao.updateByUsername(user);
        departmentDao.updatePeopleNumberByDepartmentName(userDao.selectCountByDepartmentName(oldUser.getDepartment_name()), oldUser.getDepartment_name());
        departmentDao.updatePeopleNumberByDepartmentName(userDao.selectCountByDepartmentName(user.getDepartment_name()), user.getDepartment_name());
        positionDao.updatePeopleNumberByPositionName(userDao.selectCountByPositionName(oldUser.getPosition_name()), oldUser.getPosition_name());
        positionDao.updatePeopleNumberByPositionName(userDao.selectCountByPositionName(user.getPosition_name()), user.getPosition_name());
        return 1;
    }

    @Override
    public int changeBasicByUsername(User user) {
        return userDao.updateBasicByUsername(user);
    }

    @Override
    public int changePasswordByUsername(User user, String oldPassword, String newPassword) throws ServiceException {
        if (!oldPassword.equals(userDao.selectByUsername(user.getUsername()).getPassword())) {
            throw new ServiceException("旧密码错误!");
        }

        if (!user.getPassword().equals(newPassword)) {
            throw new ServiceException("两次输入的新密码不一致!");
        }

        return userDao.updatePasswordByUsername(user);
    }

    @Override
    public List<User> findTopEight() {
        return userDao.selectTopEight();
    }

    @Override
    public List<User> findTopOneByDepartmentName() {
        List<User> userList = new ArrayList<User>();

        for (Department department : departmentDao.selectAll()) {
            User user = userDao.selectTopOneByDepartmentName(department.getDepartment_name());

            if (user != null) {
                userList.add(user);
            }
        }

        return userList;
    }

    @Override
    public List<User> findAllByDepartmentName(String departmentName) {
        return userDao.selectAllByDepartmentName(departmentName);
    }

    @Override
    public User findByUsername(String username) {
        return userDao.selectByUsername(username);
    }

    @Override
    public int findCountByDepartmentName(String departmentName) {
        return userDao.selectCountByDepartmentName(departmentName);
    }

    @Override
    public User login(String username, String password) throws ParameterException, ServiceException {
        ParameterException parameterException = new ParameterException();

        if (StringUtil.isEmpty(username)) {
            parameterException.addToParameterErrorField("usernameIsEmpty", "用户名不能为空！");
        }

        if (StringUtil.isEmpty(password)) {
            parameterException.addToParameterErrorField("passwordIsEmpty", "密码不能为空！");
        }

        if (parameterException.hasParameterError()) {
            throw parameterException;
        }

        User user = userDao.selectByUsername(username);

        if (user == null || !password.equals(user.getPassword())) {
            throw new ServiceException("用户名或密码错误!");
        }

        return user;
    }
}
