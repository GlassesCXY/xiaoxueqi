package com.example.xxqback.mapper;

import com.example.xxqback.entity.Emotion;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmotionMapper {

    @Select("SELECT eid, type, emotion_date AS emotionDate FROM emotion LIMIT #{offset}, #{limit}")
    List<Emotion> findEmotions(@Param("offset") int offset, @Param("limit") int limit);

    @Delete("DELETE FROM emotion WHERE eid = #{eid}")
    void deleteEmotion(@Param("eid") int eid);

    @Select("SELECT COUNT(*) FROM emotion")
    int countEmotions();
}
