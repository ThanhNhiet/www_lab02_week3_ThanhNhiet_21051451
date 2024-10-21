package com.demo.entities;

import java.util.Objects;

public class Skill {
    private int id;
    private String skill_name;
    private String description;
    private String field;

    public Skill() {
    }

    public Skill(int id, String skill_name, String description, String field) {
        this.id = id;
        this.skill_name = skill_name;
        this.description = description;
        this.field = field;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkill_name() {
        return skill_name;
    }

    public void setSkill_name(String skill_name) {
        this.skill_name = skill_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Skill skill = (Skill) o;
        return id == skill.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", skill_name='" + skill_name + '\'' +
                ", description='" + description + '\'' +
                ", field='" + field + '\'' +
                '}';
    }
}
