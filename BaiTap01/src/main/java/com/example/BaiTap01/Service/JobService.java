package com.example.BaiTap01.Service;

import com.example.BaiTap01.model.Job;
import com.example.BaiTap01.request.UpSertJobRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.*;
@Service
public class JobService {
    private List<Job> jobs;

    public JobService(){
        jobs = new ArrayList<>();
        jobs.add(new Job("1","Công việc dễ dàng","Không yêu cầu bằng cấp","13 Dịch vọng hậu",100,1200,"123@gmail.com"));
        jobs.add(new Job("2","Công việc nhẹ nhàng","Không yêu cầu bằng cấp","48 Tố hữu",50,500,"1234@gmail.com"));
        jobs.add(new Job("3","Công việc chân tay","Không yêu cầu bằng cấp","17 Dịch vọng hậu",70,1000,"12345@gmail.com"));
    }
    public List<Job> getAllJob() {
        return jobs;
    }
    public Job createJob(UpSertJobRequest request) {
        String id = UUID.randomUUID().toString();
        Job job = new Job(id,
                request.getTitle()
                , request.getDescription()
                , request.getLocation()
                , request.getMinSalary()
                , request.getMaxSalary()
                , request.getEmailTo());
        jobs.add(job);
        return job;
    }

    public Job updateJobById(String id, UpSertJobRequest request) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                job.setDescription(request.getDescription());
                job.setLocation(request.getLocation());
                job.setMinSalary(request.getMinSalary());
                job.setMaxSalary(request.getMaxSalary());
                job.setEmailTo(request.getEmailTo());
                return job;
            }
        }
        return null;
    }

    public Job getJobById(String id, UpSertJobRequest request) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                return job;
            }
        }
        return null;
    }

    public void deleteJob(String id) {
        for (Job job : jobs) {
            if (job.getId().equals(id)) {
                jobs.remove(job);
            }
        }
    }

    public Job getJobByRandom(){
        int id = new Random().nextInt(jobs.size());
        return jobs.get(id);
    }
    public List<Job> sortJobBySalary(String field, String direction){
        if(field.equalsIgnoreCase("maxSalary")){
            if(direction.equalsIgnoreCase("ADSC")){
                return jobs.stream().sorted(Comparator.comparing(Job::getMaxSalary)).toList();
            }else {
                return jobs.stream().sorted(Comparator.comparing(Job::getMaxSalary).reversed()).toList();
            }
        }else return null;
    }
}
