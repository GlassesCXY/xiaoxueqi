package com.example.xxqback.controller;

import com.example.xxqback.entity.Stranger;
import com.example.xxqback.service.impl.StrangerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/stranger")
public class StrangerController {

    @Autowired
    private StrangerServiceImpl strangerService;

    @GetMapping("/list")
    public Map<String, Object> listStrangers(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        List<Stranger> strangers = strangerService.findStrangers(page, size);
        int total = strangerService.countStrangers();
        Map<String, Object> response = new HashMap<>();
        response.put("strangers", strangers);
        response.put("total", total);
        response.put("page", page);
        response.put("size", size);
        return response;
    }

    @DeleteMapping("/{sid}")
    public String deleteStranger(@PathVariable int sid) {
        strangerService.deleteStranger(sid);
        return "Record deleted successfully";
    }
}