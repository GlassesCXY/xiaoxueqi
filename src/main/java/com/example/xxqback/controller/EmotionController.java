package com.example.xxqback.controller;

import com.example.xxqback.entity.Emotion;
import com.example.xxqback.service.impl.EmotionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/emotion")
public class EmotionController {

    @Autowired
    private EmotionServiceImpl emotionService;

    @GetMapping("/list")
    public Map<String, Object> listEmotions(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<Emotion> emotions = emotionService.findEmotions(page, size);
        int total = emotionService.countEmotions();
        Map<String, Object> response = new HashMap<>();
        response.put("emotions", emotions);
        System.out.println(emotions.get(0).getEmotionDate());
        response.put("total", total);
        response.put("page", page);
        response.put("size", size);
        return response;
    }

    @DeleteMapping("/{eid}")
    public String deleteEmotion(@PathVariable int eid) {
        emotionService.deleteEmotion(eid);
        return "Record deleted successfully";
    }
}
