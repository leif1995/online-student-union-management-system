package edu.ncwu.osums.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.ncwu.osums.entity.Indexs;

@Mapper
public interface IndexsDao {
    @Insert("INSERT INTO indexs(indexs_name, content, type, attachment, suffix, status, created_time, created_by, updated_time, updated_by) VALUES (#{indexs_name}, #{content}, #{type}, #{attachment}, #{suffix}, #{status}, #{created_time}, #{created_by}, #{updated_time}, #{updated_by})")
    public abstract int insert(Indexs indexs);

    @Delete("DELETE FROM indexs WHERE id = #{id}")
    public abstract int deleteById(int id);

    @Update("UPDATE indexs SET status = '2', updated_time = #{updatedTime}, updated_by = #{updatedBy} WHERE id = #{id}")
    public abstract int updateStatusForPassById(@Param("id") int id, @Param("updatedTime") String updatedTime, @Param("updatedBy") String updatedBy);

    @Update("UPDATE indexs SET attachment = #{attachment}, suffix = #{suffix} WHERE id = #{id}")
    public abstract int updateAttachmentById(@Param("id") int id, @Param("attachment") String attachment, @Param("suffix") String suffix);

    @Select("SELECT * FROM indexs ORDER BY id DESC LIMIT 0, 1")
    public abstract Indexs selectLastId();

    @Select("SELECT * FROM indexs WHERE id = #{id}")
    public abstract Indexs selectById(int id);

    @Select("SELECT * FROM indexs WHERE type = '新闻中心' AND status = '2' ORDER BY suffix DESC, updated_time DESC, indexs_name ASC LIMIT 0, 3")
    public abstract List<Indexs> selectNewsCenterTopThree();

    @Select("SELECT * FROM indexs WHERE indexs_name LIKE #{newsCenterSearch} AND type = '新闻中心' AND status = '2' ORDER BY updated_time DESC, indexs_name ASC")
    public abstract List<Indexs> selectNewsCenter(String newsCenterSearch);

    @Select("SELECT * FROM indexs WHERE indexs_name LIKE #{organizationStructureSearch} AND type = '组织结构' AND status = '2' ORDER BY updated_time DESC, indexs_name ASC")
    public abstract List<Indexs> selectOrganizationStructure(String organizationStructureSearch);

    @Select("SELECT * FROM indexs WHERE indexs_name LIKE #{noticeBoardSearch} AND type = '通知公告' AND status = '2' ORDER BY updated_time DESC, indexs_name ASC")
    public abstract List<Indexs> selectNoticeBoard(String noticeBoardSearch);

    @Select("SELECT * FROM indexs WHERE indexs_name LIKE #{search} ORDER BY type ASC, updated_time DESC, indexs_name ASC LIMIT #{currentPage}, 7")
    public abstract List<Indexs> selectAll(@Param("search") String search, @Param("currentPage") int currentPage);

    @Select("SELECT count(*) FROM indexs WHERE indexs_name LIKE #{search}")
    public abstract int selectAllCount(String search);
}
