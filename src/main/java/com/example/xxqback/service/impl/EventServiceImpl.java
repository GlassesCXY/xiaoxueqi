package com.example.xxqback.service.impl;

import com.example.xxqback.Util.MinioUtil;
import com.example.xxqback.entity.Event;
import com.example.xxqback.mapper.EventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl {

    @Autowired
    private EventMapper eventMapper;

    @Autowired
    private MinioUtil minioUtil;


    public List<Event> findEvents(int page, int size) {
        int offset = (page - 1) * size;
        return eventMapper.findEvents(offset, size);
    }


    public void deleteEvent(int eventId) {
        eventMapper.deleteEvent(eventId);
    }

    public int countEvents() {
        return eventMapper.countEvents();
    }


    public String getEventImageUrl(int eventId) {
        return minioUtil.getFileUrl("event", eventId + ".jpg");
    }
}
