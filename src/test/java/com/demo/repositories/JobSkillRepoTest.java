package com.demo.repositories;

import com.demo.entities.Candidate;
import com.demo.entities.Job;
import com.demo.entities.Skill;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class JobSkillRepoTest {

    @Autowired
    private JobSkillRepo jobSkillRepo;

    @Autowired
    private JobRepo jobRepo;

    @Autowired
    private SkillRepo skillRepo;

    @Test
    @Order(1)
    @Rollback
    void addJobSkill() {
        jobSkillRepo.addJobSkill(jobRepo.getJobById(4), skillRepo.getSkillById(5), 1);
        assertNotNull(jobSkillRepo.getJobSkillsByJobId(4).get(1));
    }

    @Test
    @Rollback(false)
    void updateJobSkill() {
        Job job = jobRepo.getJobById(5);
        Skill skill = skillRepo.getSkillById(6);

        assertNotNull(job, "Job not found");
        assertNotNull(skill, "Skill not found");

        jobSkillRepo.updateJobSkill(job, skill, 3);
        assertEquals(3, jobSkillRepo.getJobSkillsByJobId(5).get(0).getLevel());
    }

    @Test
    @Rollback(false)
    void deleteJobSkill() {
        jobSkillRepo.addJobSkill(jobRepo.getJobById(6), skillRepo.getSkillById(7), 1);
        jobSkillRepo.deleteJobSkill(jobRepo.getJobById(6), skillRepo.getSkillById(7));
        assertTrue(jobSkillRepo.getJobSkillsByJobId(6).isEmpty());
    }

    @Test
    @Rollback(false)
    void getCandidateSuitable() {
        List<Candidate> ls = jobSkillRepo.getCandidatesSutable("SE");
        assertEquals(2, ls.size());
        assertEquals(1, ls.get(0).getId());
        assertEquals(2, ls.get(1).getId());
    }

}