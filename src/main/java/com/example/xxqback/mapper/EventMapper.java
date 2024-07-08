package com.example.xxqback.mapper;

import com.example.xxqback.entity.Event;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EventMapper {

    @Select("SELECT event_id AS eventId, type, date FROM events LIMIT #{offset}, #{limit}")
    List<Event> findEvents(@Param("offset") int offset, @Param("limit") int limit);

    @Delete("DELETE FROM events WHERE event_id = #{eventId}")
    void deleteEvent(@Param("eventId") int eventId);

    @Select("SELECT COUNT(*) FROM events")
    int countEvents();
}