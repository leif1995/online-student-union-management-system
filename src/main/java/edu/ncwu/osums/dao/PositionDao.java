package edu.ncwu.osums.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import edu.ncwu.osums.entity.Position;

@Mapper
public interface PositionDao {
    @Update("UPDATE position SET people_number = #{peopleNumber} WHERE position_name = #{positionName}")
    public abstract int updatePeopleNumberByPositionName(@Param("peopleNumber") int peopleNumber, @Param("positionName") String positionName);

    @Select("SELECT * FROM position WHERE id != '0'")
    public abstract List<Position> selectAll();

    @Select("SELECT * FROM position WHERE position_name = #{positionName}")
    public abstract Position selectByPositionName(String positionName);
}
