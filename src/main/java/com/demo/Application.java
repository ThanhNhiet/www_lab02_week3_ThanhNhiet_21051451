package com.demo;

import com.demo.entities.Job;
import com.demo.repositories.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {
    @Autowired
    private JobRepo jobRepo;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

//    @Bean
//        public CommandLineRunner run () {
//            return new CommandLineRunner() {
//                @Override
//                public void run(String... args) throws Exception {
//                    //CREATE
//                    jobRepo.addJob(new Job(1,"SE"));
//                    jobRepo.addJob(new Job(2, "IT"));
//                    jobRepo.addJob(new Job(3, "BA"));
//                    jobRepo.addJob(new Job(4, "Tester"));
//
//                    //FIND BY ID
//                    System.out.println("JOB BY ID 2: "+ jobRepo.getJobById(2));
//                    System.out.println("JOB BY ID 4: "+ jobRepo.getJobById(4));
//
//                    //FIND BY JOB
//                    System.out.println("JOB BY DES: "+ jobRepo.getJobByDes("SE"));
//
//                    //UPDATE
//                    jobRepo.updateJob(new Job(2, "IT Manager"));
//                    System.out.println("JOB BY ID 2: "+ jobRepo.getJobById(2));
//
//                    //DELETE
//                    jobRepo.deleteJob(4);
//                    try {
//                        System.out.println("JOB BY ID 4: "+ jobRepo.getJobById(4));
//                    } catch (Exception e) {
//                        System.out.println("JOB BY ID 4: NOT FOUND");
//                    }
//
////                    LIST ALL JOBS
//                    List<Job> jobs = jobRepo.getAllJobs();
//                    System.out.println(jobs);
//                }
//            };
//        }
    }
