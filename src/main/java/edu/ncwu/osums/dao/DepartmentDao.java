package edu.ncwu.osums.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.ncwu.osums.entity.Department;

@Mapper
public interface DepartmentDao {
    @Insert("INSERT INTO department(department_name, people_number, created_time, created_by, updated_time, updated_by) VALUES (#{department_name}, 0, #{created_time}, #{created_by}, #{updated_time}, #{updated_by})")
    public abstract int insert(Department department);

    @Delete("DELETE FROM department WHERE id = #{id}")
    public abstract int deleteById(int id);

    @Update("UPDATE department SET introduction = #{introduction}, updated_time = #{updated_time}, updated_by = #{updated_by} WHERE id = #{id}")
    public abstract int updateById(Department department);

    @Update("UPDATE department SET people_number = #{peopleNumber} WHERE department_name = #{departmentName}")
    public abstract int updatePeopleNumberByDepartmentName(@Param("peopleNumber") int peopleNumber, @Param("departmentName") String departmentName);

    @Select("SELECT * FROM department WHERE department_name = #{departmentName}")
    public abstract Department selectByDepartmentName(String departmentName);

    @Select("SELECT * FROM department WHERE id = #{id}")
    public abstract Department selectById(int id);

    @Select("SELECT * FROM department WHERE id != '0'")
    public abstract List<Department> selectAll();

    @Select("SELECT * FROM department WHERE department_name NOT IN ('学生会', '主席团', '秘书处')")
    public abstract List<Department> selectForRecruitment();
}
