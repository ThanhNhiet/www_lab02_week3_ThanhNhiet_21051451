package com.demo.repositories;

import com.demo.entities.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class SkillRepo {

    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //find by id
    public Skill getSkillById(int id){
        String sql = "SELECT * FROM skill WHERE id = ?";
        try {
            return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                    new Skill(rs.getInt("id"), rs.getString("skill_name"), rs.getString("description"), rs.getString("field")), id);
        } catch (Exception e) {
            return null;  // Trả về null nếu không có kết quả
        }
    }
}
