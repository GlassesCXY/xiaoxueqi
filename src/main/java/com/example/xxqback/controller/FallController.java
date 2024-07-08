package com.example.xxqback.controller;

import com.example.xxqback.entity.Fall;
import com.example.xxqback.service.impl.FallServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/fall")
public class FallController {

    @Autowired
    private FallServiceImpl fallService;

    @GetMapping("/list")
    public Map<String, Object> listFalls(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<Fall> falls = fallService.findFalls(page, size);
        int total = fallService.countFalls();
        Map<String, Object> response = new HashMap<>();
        response.put("falls", falls);
        response.put("total", total);
        response.put("page", page);
        response.put("size", size);
        return response;
    }

    @DeleteMapping("/{fid}")
    public String deleteFall(@PathVariable int fid) {
        fallService.deleteFall(fid);
        return "Record deleted successfully";
    }

    @GetMapping("/image/{fid}")
    public Map<String, String> getFallImage(@PathVariable int fid) {
        String url = fallService.getFallImageUrl(fid);
        Map<String, String> response = new HashMap<>();
        response.put("url", url);
        return response;
    }
}
