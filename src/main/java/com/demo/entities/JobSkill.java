package com.demo.entities;

public class JobSkill {
    private Job job;
    private Skill skill;
    private int level;

    public JobSkill() {
    }

    public JobSkill(Job job, Skill skill, int level) {
        this.job = job;
        this.skill = skill;
        this.level = level;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if(level < 0 || level > 5) {
            throw new IllegalArgumentException("Level must be between 0 and 5");
        }
        this.level = level;
    }

    @Override
    public String toString() {
        return "JobSkill{" +
                "job=" + job +
                ", skill=" + skill +
                ", level=" + level +
                '}';
    }
}
