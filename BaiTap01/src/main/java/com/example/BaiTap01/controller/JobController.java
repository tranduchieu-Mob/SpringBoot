package com.example.BaiTap01.controller;
import com.example.BaiTap01.Service.JobService;
import com.example.BaiTap01.model.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("api/v1/")
public class JobController {
    @Autowired //inject bean
    private JobService jobService;

    @GetMapping("jobs")
    public List<Job> getAllJob(){
        return jobService.getAllJob();
    }

    @GetMapping("jobs/random")
    public Job getJobByRandom(){
        return jobService.getJobByRandom();
    }
    @GetMapping("/sort")
    public List<Job> sortJobBySalary(@RequestParam(value = "field",defaultValue = "maxSalary") String field,
                                     @RequestParam(value = "direction", defaultValue = "DESC") String direction){
        return jobService.sortJobBySalary(field,direction);
    }
}
