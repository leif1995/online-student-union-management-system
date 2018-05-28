package edu.ncwu.osums.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.ncwu.osums.entity.Recruitment;
import edu.ncwu.osums.entity.User;

@Mapper
public interface UserDao {
    @Insert("INSERT INTO user(username, password, nickname, gender, birthday, major, classs, native_place, department_name, position_name, phone, email, qq, hobby, self_appraisal, awards_and_achievements, leave_number, late_number, absenteeism_number, plan_active_number, plan_completed_number, plan_overdue_number, created_time, created_by, updated_time, updated_by) VALUES (#{username}, '123', #{nickname}, #{gender}, #{birthday}, #{major}, #{classs}, #{native_place}, #{department_name}, '干事', #{phone}, #{email}, #{qq}, #{hobby}, #{self_appraisal}, #{awards_and_achievements}, 0, 0, 0, 0, 0, 0, #{updated_time}, #{updated_by}, #{updated_time}, #{updated_by})")
    public abstract int insertAutomaticallyFromRecruitment(Recruitment recruitment);

    @Delete("DELETE FROM user WHERE username = #{username}")
    public abstract int deleteByUsername(String username);

    @Update("UPDATE user SET department_name = '秘书处', updated_time = #{updatedTime}, updated_by = #{updatedBy} WHERE department_name = #{departmentName}")
    public abstract int updateAutomaticallyForDepartment(@Param("departmentName") String departmentName, @Param("updatedTime") String updatedTime, @Param("updatedBy") String updatedBy);

    @Update("UPDATE user SET nickname = #{nickname}, department_name = #{department_name}, position_name = #{position_name}, updated_time = #{updated_time}, updated_by = #{updated_by} WHERE username = #{username}")
    public abstract int updateByUsername(User user);

    @Update("UPDATE user SET password = '123', updated_time = #{updated_time}, updated_by = #{updated_by} WHERE username = #{username}")
    public abstract int updatePasswordForResetByUsername(User user);

    @Update("UPDATE user SET gender = #{gender}, birthday = #{birthday}, major = #{major}, classs = #{classs}, native_place = #{native_place}, phone = #{phone}, email = #{email}, qq = #{qq}, hobby = #{hobby}, self_appraisal = #{self_appraisal}, awards_and_achievements = #{awards_and_achievements}, updated_time = #{updated_time}, updated_by = #{updated_by} WHERE username = #{username}")
    public abstract int updateBasicByUsername(User user);

    @Update("UPDATE user SET password = #{password}, updated_time = #{updated_time}, updated_by = #{updated_by} WHERE username = #{username}")
    public abstract int updatePasswordByUsername(User user);

    @Update("UPDATE user SET ${planStatus} = #{planNumber} WHERE username = #{username}")
    public abstract int updatePlanCountByUsername(@Param("planStatus") String planStatus, @Param("planNumber") int planNumber, @Param("username") String username);

    @Update("UPDATE user SET ${personalFlag} = #{personalNumber} WHERE username = #{username}")
    public abstract int updatePersonalCountByUsername(@Param("personalFlag") String personalFlag, @Param("personalNumber") int personalNumber, @Param("username") String username);

    @Select("SELECT * FROM user WHERE id != '0' ORDER BY plan_completed_number DESC, plan_active_number DESC, plan_overdue_number ASC LIMIT 0, 8")
    public abstract List<User> selectTopEight();

    @Select("SELECT * FROM user WHERE id != '0' AND department_name = #{departmentName} ORDER BY plan_completed_number DESC, plan_active_number DESC, plan_overdue_number ASC LIMIT 0, 1")
    public abstract User selectTopOneByDepartmentName(String departmentName);

    @Select("SELECT * FROM user WHERE id != '0' AND department_name LIKE #{departmentName} ORDER BY nickname DESC")
    public abstract List<User> selectAllByDepartmentName(String departmentName);

    @Select("SELECT * FROM user WHERE username = #{username}")
    public abstract User selectByUsername(String username);

    @Select("SELECT count(*) FROM user WHERE department_name LIKE #{departmentName}")
    public abstract int selectCountByDepartmentName(String departmentName);

    @Select("SELECT count(*) FROM user WHERE position_name LIKE #{positionName}")
    public abstract int selectCountByPositionName(String positionName);
}
