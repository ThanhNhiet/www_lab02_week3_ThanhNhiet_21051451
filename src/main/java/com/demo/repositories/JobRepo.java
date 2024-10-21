package com.demo.repositories;

import com.demo.entities.Job;
import com.demo.mapper.JobMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class JobRepo {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    // Create
    public void addJob(Job job) {
        String sql = "INSERT INTO job (id, description) VALUES (?, ?)";
        jdbcTemplate.update(sql, job.getId(), job.getDescription());
    }

    // find by id
    public Job getJobById(int id) {
        String sql = "SELECT * FROM job WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                    new Job(rs.getInt("id"), rs.getString("description")), id);
        } catch (EmptyResultDataAccessException e) {
            return null;  // Trả về null nếu không có kết quả
        }
    }

    //find by description
    public Job getJobByDes(String des){
        String sql = "SELECT * FROM job WHERE description = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new Job(rs.getInt("id"), rs.getString("description")), des);
    }

    // Update
    public void updateJob(Job job) {
        String sql = "UPDATE job SET description = ? WHERE id = ?";
        jdbcTemplate.update(sql, job.getDescription(), job.getId());
    }

    // Delete
    public void deleteJob(int id) {
        String sql = "DELETE FROM job WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    // List all jobs
    public List<Job> getAllJobs() {
        String sql = "select * from job";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Job>(Job.class));
    }
}
