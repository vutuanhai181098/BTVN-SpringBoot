package com.btvnSpringBoot.btnvnSpringBoot.controller;

import com.btvnSpringBoot.btnvnSpringBoot.entities.Job;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/job")
public class JobController {
    private List<Job> jobList;

    public JobController(){
        jobList = new ArrayList<>();
    }

    // Get List job.
    @GetMapping("/list")
    public List<Job> getJobList(){
        return jobList;
    }

    // Get job by id.
    @GetMapping("/{id}")
    public Job getJob(@PathVariable String id){
        return jobList.stream().filter(job -> job.getId().equals(id)).findFirst().orElse(null);
    }

    // Create Job.
    @PostMapping("")
    public Job createJob(@RequestBody Job job){
        jobList.add(job);
        return job;
    }

    // Update job.
    @PutMapping("/{id}")
    public Job updateJob(@PathVariable String id, @RequestBody Job job){
        Job curJob = jobList.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
        if(curJob == null) return null;
        curJob.setTitle(job.getTitle());
        curJob.setDescription(job.getDescription());
        curJob.setLocation(job.getLocation());
        curJob.setMinSalary(job.getMinSalary());
        curJob.setMaxSalary(job.getMaxSalary());
        curJob.setEmailTo(job.getEmailTo());
        return curJob;
    }

    // Delete job.
    @DeleteMapping("/{id}")
    public void deleteJob(@PathVariable String id){
        Job curJob = jobList.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
        jobList.remove(curJob);
    }

    // Get random job.
    @GetMapping("/random")
    public Job getRandomJob(){
        Random random = new Random();
        int idx = random.nextInt(jobList.size());
        return jobList.get(idx);
    }

    // Get list job sort desc.
    @GetMapping("/list/sort")
    public List<Job> getListJobSortBySalary(@RequestParam String max_salary){
        if(max_salary.equals("desc")){
            jobList.sort(new Comparator<Job>() {
                @Override
                public int compare(Job o1, Job o2) {
                    return o2.getMaxSalary() - o1.getMaxSalary();
                }
            });
        }
        return jobList;
    }
}
