package edu.ncwu.osums.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.ncwu.osums.entity.Minutes;

@Mapper
public interface MinutesDao {
    @Insert("INSERT INTO minutes(minutes_name, department_name, start_time, end_time, place, host, attendees, leaver, later, absenteeismer, content, created_time, created_by, updated_time, updated_by) VALUES (#{minutes_name}, #{department_name}, #{start_time}, #{end_time}, #{place}, #{host}, #{attendees}, #{leaver},  #{later}, #{absenteeismer}, #{content}, #{created_time}, #{created_by}, #{updated_time}, #{updated_by})")
    public abstract int insert(Minutes minutes);

    @Delete("DELETE FROM minutes WHERE id = #{id}")
    public abstract int deleteById(int id);

    @Update("UPDATE minutes SET minutes_name = #{minutes_name}, start_time = #{start_time}, end_time = #{end_time}, place = #{place}, host = #{host}, attendees = #{attendees}, leaver = #{leaver}, later = #{later}, absenteeismer = #{absenteeismer}, content = #{content}, updated_time = #{updated_time}, updated_by = #{updated_by} WHERE id = #{id}")
    public abstract int updateById(Minutes minutes);

    @Select("SELECT * FROM minutes WHERE id = #{id}")
    public abstract Minutes selectById(int id);

    @Select("SELECT * FROM minutes WHERE department_name = #{departmentName} AND minutes_name LIKE #{search} ORDER BY start_time DESC, minutes_name ASC LIMIT #{currentPage}, 7")
    public abstract List<Minutes> selectByDepartmentName(@Param("departmentName") String departmentName, @Param("search") String search, @Param("currentPage") int currentPage);

    @Select("SELECT count(*) FROM minutes WHERE department_name = #{departmentName} AND minutes_name LIKE #{search}")
    public abstract int selectCountByDepartmentName(@Param("departmentName") String departmentName, @Param("search") String search);
}
