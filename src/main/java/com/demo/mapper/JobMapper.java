package com.demo.mapper;

import com.demo.entities.Job;

import java.sql.ResultSet;

public class JobMapper {
    public Job mapRow(ResultSet rs, int rowNum) throws Exception {
        Job job = new Job();
        job.setId(rs.getInt("id"));
        job.setDescription(rs.getString("description"));
        return job;
    }
}
