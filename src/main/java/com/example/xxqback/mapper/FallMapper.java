package com.example.xxqback.mapper;

import com.example.xxqback.entity.Fall;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FallMapper {

    @Select("SELECT fid, fall_date AS fallDate FROM fall LIMIT #{offset}, #{limit}")
    List<Fall> findFalls(@Param("offset") int offset, @Param("limit") int limit);

    @Delete("DELETE FROM fall WHERE fid = #{fid}")
    void deleteFall(@Param("fid") int fid);

    @Select("SELECT COUNT(*) FROM fall")
    int countFalls();
}
