package com.demo.repositories;

import com.demo.entities.Job;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@Transactional// Data will be rolled back after each test
class JobRepoTest {

    @Autowired
    private JobRepo jobRepo;

    @BeforeEach
    void setUp() {
    }

    @Test
    void addJob() {
        jobRepo.addJob(new Job(7, "ccc"));
        assertNotNull(jobRepo.getJobById(7));
        assertEquals("ccc", jobRepo.getJobById(7).getDescription());
    }

    @Test
    void updateJob() {
        Job j = jobRepo.getJobById(2);
        j.setDescription("IT");
        jobRepo.updateJob(j);
        assertEquals("IT", jobRepo.getJobById(2).getDescription());
    }

    @Test
    void deleteJob() {
        jobRepo.deleteJob(7);
        assertNull(jobRepo.getJobById(7));
    }



}
