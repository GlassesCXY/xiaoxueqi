package com.example.xxqback.service.impl;

import com.example.xxqback.entity.Stranger;
import com.example.xxqback.mapper.StrangerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StrangerServiceImpl {

    @Autowired
    private StrangerMapper strangerMapper;

    public List<Stranger> findStrangers(int page, int size) {
        int offset = (page - 1) * size;
        return strangerMapper.findStrangers(offset, size);
    }

    public void deleteStranger(int sid) {
        strangerMapper.deleteStranger(sid);
    }

    public int countStrangers() {
        return strangerMapper.countStrangers();
    }
}