package edu.ncwu.osums.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.ncwu.osums.entity.Recruitment;

@Mapper
public interface RecruitmentDao {
    @Insert("INSERT INTO recruitment(nickname, gender, birthday, major, classs, native_place, username, department_name, swap, phone, email, qq, hobby, self_appraisal, department_understanding, awards_and_achievements, status, created_time, created_by, updated_time, updated_by) VALUES (#{nickname}, #{gender}, #{birthday}, #{major}, #{classs}, #{native_place}, #{username}, #{department_name}, #{swap}, #{phone}, #{email}, #{qq}, #{hobby}, #{self_appraisal}, #{department_understanding}, #{awards_and_achievements}, #{status}, #{created_time}, #{created_by}, #{updated_time}, #{updated_by})")
    public abstract int insert(Recruitment recruitment);

    @Delete("DELETE FROM recruitment")
    public abstract int deleteAll();

    @Delete("DELETE FROM recruitment WHERE (username = #{username} && id != #{id})")
    public abstract int deleteAutomaticallyByUsername(@Param("id") int id, @Param("username") String username);

    @Update("UPDATE recruitment SET department_name = '秘书处', updated_time = #{updatedTime}, updated_by = #{updatedBy} WHERE department_name = #{departmentName}")
    public abstract int updateAutomaticallyForDepartment(@Param("departmentName") String departmentName, @Param("updatedTime") String updatedTime, @Param("updatedBy") String updatedBy);

    @Update("UPDATE recruitment SET department_name = #{departmentName} WHERE id = ${id}")
    public abstract int updateForDepartmentById(@Param("id") int id, @Param("departmentName") String departmentName);

    @Update("UPDATE recruitment SET status = '淘汰', updated_time = #{updatedTime}, updated_by = #{updatedBy} WHERE id = ${id}")
    public abstract int updateStatusForDeleteById(@Param("id") int id, @Param("updatedTime") String updatedTime, @Param("updatedBy") String updatedBy);

    @Update("UPDATE recruitment SET status = '通过', updated_time = #{updatedTime}, updated_by = #{updatedBy} WHERE id = ${id}")
    public abstract int updateStatusForPassById(@Param("id") int id, @Param("updatedTime") String updatedTime, @Param("updatedBy") String updatedBy);

    @Select("SELECT * FROM recruitment")
    public abstract List<Recruitment> selectAll();

    @Select("SELECT * FROM recruitment WHERE id = #{id}")
    public abstract Recruitment selectAutomaticallyById(int id);

    @Select("SELECT * FROM recruitment ORDER BY status ASC, department_name ASC, username ASC LIMIT #{currentPage}, 7")
    public abstract List<Recruitment> selectApplication(int currentPage);

    @Select("SELECT count(*) FROM recruitment WHERE status = '申请' AND department_name LIKE #{departmentName}")
    public abstract int selectApplicationCount(String departmentName);

    @Select("SELECT count(*) FROM recruitment")
    public abstract int selectCount();
}
