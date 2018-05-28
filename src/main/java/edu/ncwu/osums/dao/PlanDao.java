package edu.ncwu.osums.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.ncwu.osums.entity.Plan;

@Mapper
public interface PlanDao {
    @Insert("INSERT INTO plan(plan_name, plan_type, activity_date, activity_place, activity_background, activity_purpose, activity_theme, activity_object, status, department_name, username, created_time, created_by, updated_time, updated_by) VALUES (#{plan_name}, #{plan_type}, #{activity_date}, #{activity_place}, #{activity_background}, #{activity_purpose}, #{activity_theme}, #{activity_object}, #{status}, #{department_name}, #{username}, #{created_time}, #{created_by}, #{updated_time}, #{updated_by})")
    public abstract int insert(Plan plan);

    @Delete("DELETE FROM plan WHERE id IN ${ids}")
    public abstract int deleteByIds(@Param("ids") String ids);

    @Update("UPDATE plan SET attachment = #{attachment}, suffix = #{suffix} WHERE id = #{id}")
    public abstract int updateAttachmentById(@Param("id") int id, @Param("attachment") String attachment, @Param("suffix") String suffix);

    @Update("UPDATE plan SET department_name = '秘书处', updated_time = #{updatedTime}, updated_by = #{updatedBy} WHERE department_name = #{departmentName}")
    public abstract int updateAutomaticallyForDepartment(@Param("departmentName") String departmentName, @Param("updatedTime") String updatedTime, @Param("updatedBy") String updatedBy);

    @Update("UPDATE plan SET status = '0', updated_time = #{updatedTime}, updated_by = #{updatedBy} WHERE id IN ${ids}")
    public abstract int updateStatusForDeleteByIds(@Param("ids") String ids, @Param("updatedTime") String updatedTime, @Param("updatedBy") String updatedBy);

    @Update("UPDATE plan SET status = #{status}, updated_time = #{updatedTime}, updated_by = #{updatedBy} WHERE id IN ${ids}")
    public abstract int updateStatusForPassByIds(@Param("status") String status, @Param("ids") String ids, @Param("updatedTime") String updatedTime, @Param("updatedBy") String updatedBy);

    @Update("UPDATE plan SET plan_name = #{plan_name}, plan_type = #{plan_type}, activity_date = #{activity_date}, activity_place = #{activity_place}, activity_background = #{activity_background}, activity_purpose = #{activity_purpose}, activity_theme = #{activity_theme}, activity_object = #{activity_object}, updated_time = #{updated_time}, updated_by = #{updated_by} WHERE id = #{id}")
    public abstract int updateById(Plan plan);

    @Select("SELECT count(*) FROM plan WHERE status = '3' AND department_name = #{departmentName}")
    public abstract int selectForDiagramByDepartmentName(String departmentName);

    @Select("SELECT * FROM plan WHERE id IN ${ids}")
    public abstract List<Plan> selectAutomaticallyForCreateToActivityByIds(@Param("ids") String ids);

    @Select("SELECT * FROM plan ORDER BY id DESC LIMIT 0, 1")
    public abstract Plan selectLastId();

    @Select("SELECT * FROM plan WHERE id = #{id}")
    public abstract Plan selectById(int id);

    @Select("SELECT * FROM plan WHERE status = #{status} AND department_name LIKE #{departmentName} AND plan_name LIKE #{search} ORDER BY activity_date ASC, plan_name ASC LIMIT #{currentPage}, 7")
    public abstract List<Plan> selectActive(@Param("departmentName") String departmentName, @Param("status") String status, @Param("search") String search, @Param("currentPage") int currentPage);

    @Select("SELECT count(*) FROM plan WHERE status = #{status} AND department_name LIKE #{departmentName} AND plan_name LIKE #{search}")
    public abstract int selectActiveCount(@Param("departmentName") String departmentName, @Param("status") String status, @Param("search") String search);

    @Select("SELECT * FROM plan WHERE status = '3' AND department_name LIKE #{departmentName} AND plan_name LIKE #{search} ORDER BY activity_date DESC, plan_name ASC LIMIT #{currentPage}, 7")
    public abstract List<Plan> selectCompleted(@Param("departmentName") String departmentName, @Param("search") String search, @Param("currentPage") int currentPage);

    @Select("SELECT count(*) FROM plan WHERE status = '3' AND department_name LIKE #{departmentName} AND plan_name LIKE #{search}")
    public abstract int selectCompletedCount(@Param("departmentName") String departmentName, @Param("search") String search);

    @Select("SELECT * FROM plan WHERE status = '0' AND department_name LIKE #{departmentName} AND plan_name LIKE #{search} ORDER BY activity_date DESC, plan_name ASC LIMIT #{currentPage}, 7")
    public abstract List<Plan> selectOverdue(@Param("departmentName") String departmentName, @Param("search") String search, @Param("currentPage") int currentPage);

    @Select("SELECT count(*) FROM plan WHERE status = '0' AND department_name LIKE #{departmentName} AND plan_name LIKE #{search}")
    public abstract int selectOverdueCount(@Param("departmentName") String departmentName, @Param("search") String search);

    @Select("SELECT count(*) FROM plan WHERE status IN ('1', '2') AND username = #{username}")
    public abstract int selectActiveCountByUsername(String username);

    @Select("SELECT count(*) FROM plan WHERE status = '3' AND username = #{username}")
    public abstract int selectCompletedCountByUsername(String username);

    @Select("SELECT count(*) FROM plan WHERE status = '0' AND username = #{username}")
    public abstract int selectOverdueCountByUsername(String username);

    @Select("SELECT count(*) FROM plan WHERE status = '3' AND plan_type = #{planType}")
    public abstract int selectCountByPlanType(String planType);
}
