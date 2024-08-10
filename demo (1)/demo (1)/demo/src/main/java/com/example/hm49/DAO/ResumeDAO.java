package com.example.hm49.DAO;

import com.example.hm49.model.Resumes;

import java.util.List;

public interface ResumeDAO {
    Resumes findById(int id);
    List<Resumes> findByUserId(int userId);
    void create(Resumes resume);
    void update(Resumes resume);
    void delete(int id);
}

