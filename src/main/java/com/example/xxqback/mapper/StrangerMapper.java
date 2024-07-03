package com.example.xxqback.mapper;

import com.example.xxqback.entity.Stranger;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StrangerMapper {

    @Select("SELECT sid, detect_date AS detectDate FROM stranger LIMIT #{offset}, #{limit}")
    List<Stranger> findStrangers(@Param("offset") int offset, @Param("limit") int limit);

    @Delete("DELETE FROM stranger WHERE sid = #{sid}")
    void deleteStranger(@Param("sid") int sid);

    @Select("SELECT COUNT(*) FROM stranger")
    int countStrangers();
}