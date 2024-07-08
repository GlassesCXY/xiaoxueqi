package com.example.xxqback.controller;

import com.example.xxqback.entity.Event;
import com.example.xxqback.service.impl.EventServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/event")
public class EventController {

    @Autowired
    private EventServiceImpl eventService;

    @GetMapping("/list")
    public Map<String, Object> listEvents(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<Event> events = eventService.findEvents(page, size);
        int total = eventService.countEvents();
        Map<String, Object> response = new HashMap<>();
        response.put("events", events);
        response.put("total", total);
        response.put("page", page);
        response.put("size", size);
        return response;
    }

    @DeleteMapping("/{eventId}")
    public String deleteEvent(@PathVariable int eventId) {
        eventService.deleteEvent(eventId);
        return "Record deleted successfully";
    }

    @GetMapping("/image/{eventId}")
    public Map<String, String> getEventImage(@PathVariable int eventId) {
        String url = eventService.getEventImageUrl(eventId);
        Map<String, String> response = new HashMap<>();
        response.put("url", url);
        return response;
    }
}