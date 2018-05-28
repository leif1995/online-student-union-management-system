package edu.ncwu.osums.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import edu.ncwu.osums.entity.Feedback;

@Mapper
public interface FeedbackDao {
    @Insert("INSERT INTO feedback(feedback_content, type, created_time) VALUES (#{feedback_content}, #{type}, #{created_time})")
    public abstract int insert(Feedback feedback);

    @Delete("DELETE FROM feedback WHERE id = #{id}")
    public abstract int deleteById(int id);

    @Select("SELECT * FROM feedback ORDER BY type DESC, created_time DESC")
    public abstract List<Feedback> selectAll();

    @Select("SELECT count(*) FROM feedback")
    public abstract int selectCount();

    @Select("SELECT count(*) FROM feedback WHERE type = #{type}")
    public abstract int selectCountByType(String type);
}
