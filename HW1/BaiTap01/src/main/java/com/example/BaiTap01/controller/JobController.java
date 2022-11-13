package com.example.BaiTap01.controller;
import com.example.BaiTap01.Service.JobService;
import com.example.BaiTap01.model.Job;
import com.example.BaiTap01.request.UpSertJobRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("{id}")
    public  Job getJobById(@PathVariable String id, @RequestBody UpSertJobRequest request){
        return jobService.getJobById(id,request);
    }

    @PostMapping("")
    public Job createJob(@RequestBody UpSertJobRequest request){
        return jobService.createJob(request);
    }

    @PutMapping("{id}")
    public Job updateJob(@PathVariable String id,@RequestBody UpSertJobRequest request){
        return jobService.updateJobById(id,request);
    }

    @DeleteMapping("{id}")
    public void deleteJob(@PathVariable String id){
        jobService.deleteJob(id);
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
