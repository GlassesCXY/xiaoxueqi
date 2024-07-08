package com.example.xxqback.service.impl;

import com.example.xxqback.entity.Emotion;
import com.example.xxqback.mapper.EmotionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmotionServiceImpl {

    @Autowired
    private EmotionMapper emotionMapper;

    public List<Emotion> findEmotions(int page, int size) {
        int offset = (page - 1) * size;
        return emotionMapper.findEmotions(offset, size);
    }

    public void deleteEmotion(int eid) {
        emotionMapper.deleteEmotion(eid);
    }

    public int countEmotions() {
        return emotionMapper.countEmotions();
    }

    public List<Map<String, Object>> countEmotionsByDate() {
        return emotionMapper.countEmotionsByDate();
    }

    public List<Map<String, Object>> countEmotionsByType() {
        return emotionMapper.countEmotionsByType();
    }
}
