package edu.ncwu.osums.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.ncwu.osums.entity.Activity;
import edu.ncwu.osums.entity.Plan;

@Mapper
public interface ActivityDao {
    @Insert("INSERT INTO activity(activity_name, activity_date, activity_place, status, created_time, created_by, updated_time, updated_by) VALUES (#{activity_name}, #{activity_date}, #{activity_place}, #{status}, #{created_time}, #{created_by}, #{updated_time}, #{updated_by})")
    public abstract int insert(Activity activity);

    @Insert("INSERT INTO activity(activity_name, activity_date, activity_place, status, created_time, created_by, updated_time, updated_by) VALUES (#{plan_name}, #{activity_date}, #{activity_place}, 1, #{created_time}, #{created_by}, #{updated_time}, #{updated_by})")
    public abstract int insertAutomaticallyFromPlan(Plan plan);

    @Delete("DELETE FROM activity WHERE id IN ${ids}")
    public abstract int deleteByIds(@Param("ids") String ids);

    @Update("UPDATE activity SET status = '0', updated_time = #{updatedTime}, updated_by = #{updatedBy} WHERE id IN ${ids}")
    public abstract int updateStatusForDeleteByIds(@Param("ids") String ids, @Param("updatedTime") String updatedTime, @Param("updatedBy") String updatedBy);

    @Update("UPDATE activity SET status = '2' WHERE id = #{id}")
    public abstract int updateAutomaticallyById(int id);

    @Update("UPDATE activity SET activity_name = #{activity_name}, activity_date = #{activity_date}, activity_place = #{activity_place}, updated_time = #{updated_time}, updated_by = #{updated_by} WHERE id = #{id}")
    public abstract int updateById(Activity activity);

    @Select("SELECT * FROM activity WHERE status = '1'")
    public abstract List<Activity> selectActiveForUpdateAutomaticallyById();

    @Select("SELECT * FROM activity WHERE status = '1' AND activity_name LIKE #{search} ORDER BY activity_date ASC, activity_name ASC LIMIT #{currentPage}, 7")
    public abstract List<Activity> selectActive(@Param("search") String search, @Param("currentPage") int currentPage);

    @Select("SELECT count(*) FROM activity WHERE status = '1' AND activity_name LIKE #{search}")
    public abstract int selectActiveCount(String search);

    @Select("SELECT * FROM activity WHERE status = '2' AND activity_name LIKE #{search} ORDER BY activity_date DESC, activity_name ASC LIMIT #{currentPage}, 7")
    public abstract List<Activity> selectCompleted(@Param("search") String search, @Param("currentPage") int currentPage);

    @Select("SELECT count(*) FROM activity WHERE status = '2' AND activity_name LIKE #{search}")
    public abstract int selectCompletedCount(String search);

    @Select("SELECT * FROM activity WHERE status = '0' AND activity_name LIKE #{search} ORDER BY activity_date DESC, activity_name ASC LIMIT #{currentPage}, 7")
    public abstract List<Activity> selectOverdue(@Param("search") String search, @Param("currentPage") int currentPage);

    @Select("SELECT count(*) FROM activity WHERE status = '0' AND activity_name LIKE #{search}")
    public abstract int selectOverdueCount(String search);
}
