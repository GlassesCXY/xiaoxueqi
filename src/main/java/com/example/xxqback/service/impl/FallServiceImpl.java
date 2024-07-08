package com.example.xxqback.service.impl;

import com.example.xxqback.Util.MinioUtil;
import com.example.xxqback.entity.Fall;
import com.example.xxqback.mapper.FallMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FallServiceImpl  {

    @Autowired
    private FallMapper fallMapper;

    @Autowired
    private MinioUtil minioUtil;

    public List<Fall> findFalls(int page, int size) {
        int offset = (page - 1) * size;
        return fallMapper.findFalls(offset, size);
    }

    public void deleteFall(int fid) {
        fallMapper.deleteFall(fid);
    }

    public int countFalls() {
        return fallMapper.countFalls();
    }

    public String getFallImageUrl(int fid) {
        return minioUtil.getFileUrl("fall", fid + ".jpg");
    }
}
