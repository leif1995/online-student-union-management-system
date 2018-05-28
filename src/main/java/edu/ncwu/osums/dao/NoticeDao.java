package edu.ncwu.osums.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.ncwu.osums.entity.Notice;

@Mapper
public interface NoticeDao {
    @Insert("INSERT INTO notice(content, created_time, created_by) VALUES (#{content}, #{created_time}, #{created_by})")
    public abstract int insert(Notice notice);

    @Update("UPDATE notice SET content = #{content}, created_time = #{created_time}, created_by = #{created_by} WHERE id = '0'")
    public abstract int updateContent(Notice notice);

    @Select("SELECT * FROM notice WHERE id = '0'")
    public abstract Notice selectContent();
}
