package com.example.xxqback.mapper;

import com.example.xxqback.entity.Emotion;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmotionMapper {

    @Select("SELECT eid, type, emotion_date AS emotionDate FROM emotion LIMIT #{offset}, #{limit}")
    List<Emotion> findEmotions(@Param("offset") int offset, @Param("limit") int limit);

    @Delete("DELETE FROM emotion WHERE eid = #{eid}")
    void deleteEmotion(@Param("eid") int eid);

    @Select("SELECT COUNT(*) FROM emotion")
    int countEmotions();

    @Select("SELECT DATE(emotion_date) AS date, COUNT(*) AS count FROM emotion WHERE emotion_date >= DATE_SUB(CURDATE(), INTERVAL 5 DAY) GROUP BY DATE(emotion_date)")
    List<Map<String, Object>> countEmotionsByDate();

    @Select("SELECT type, COUNT(*) AS count FROM emotion WHERE emotion_date >= DATE_SUB(CURDATE(), INTERVAL 5 DAY) GROUP BY type")
    List<Map<String, Object>> countEmotionsByType();
}
