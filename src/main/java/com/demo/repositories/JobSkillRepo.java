package com.demo.repositories;

import com.demo.entities.Candidate;
import com.demo.entities.Job;
import com.demo.entities.JobSkill;
import com.demo.entities.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JobSkillRepo {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Autowired
    private JobRepo jobRepo;

    @Autowired
    private SkillRepo skillRepo;

    // Create
    public void addJobSkill(Job job, Skill skill, int level) {
        String sql = "INSERT INTO jobskill (job_id, skill_id, required_level) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, job.getId(), skill.getId(), level);
    }

    // Update
    public void updateJobSkill(Job job, Skill skill, int level) {
        String sql = "UPDATE jobskill SET required_level = ? WHERE job_id = ? AND skill_id = ?";
        jdbcTemplate.update(sql, level, job.getId(), skill.getId());
    }

    // Delete
    public void deleteJobSkill(Job job, Skill skill) {
        String sql = "DELETE FROM jobskill WHERE job_id = ? AND skill_id = ?";
        jdbcTemplate.update(sql, job.getId(), skill.getId());
    }

    // Read
    public List<JobSkill> getJobSkillsByJobId(int jobId) {
        String sql = "SELECT * FROM jobskill WHERE job_id = ?";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new JobSkill(jobRepo.getJobById(rs.getInt("job_id")),
                        skillRepo.getSkillById(rs.getInt("skill_id")),
                        rs.getInt("required_level")), jobId
        );
    }


    //Enter job description, return list candidates suitable for job. the candidates must have all the skills required for the job and the level of the skill must be equal or greater (job require level - 1)
    public List<Candidate> getCandidatesSutable(String des){
        String sql = "SELECT c.* " +
                "FROM candidate c " +
                "JOIN candidateskill cs ON c.id = cs.candidate_id " +
                "JOIN jobskill js ON cs.skill_id = js.skill_id " +
                "JOIN job j ON js.job_id = j.id " +
                "WHERE j.description = ? " +
                "AND cs.level >= js.required_level " +
                "GROUP BY c.id " +
                "HAVING COUNT(DISTINCT js.skill_id) = (" +
                "    SELECT COUNT(DISTINCT skill_id) " +
                "    FROM jobskill " +
                "    WHERE job_id IN ( " +
                "        SELECT id " +
                "        FROM job " +
                "        WHERE description = ? " +
                "    )" +
                ")";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Candidate>(Candidate.class), des, des);
    }
}
