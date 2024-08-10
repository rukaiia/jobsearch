package com.example.hm49.Impl;

import com.example.hm49.DAO.ResumeDAO;
import com.example.hm49.model.Resumes;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResumeDAOImpl implements ResumeDAO {
    private final Connection connection;

    public ResumeDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Resumes findById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM resumes WHERE id = ?");
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                return mapRow(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Resumes> findByUserId(int userId) {
        List<Resumes> resumes = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM resumes WHERE applicant_id = ?");
            statement.setInt(1, userId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                resumes.add(mapRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resumes;
    }

    @Override
    public void create(Resumes resume) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO resumes (applicant_id, name, category_id, salary, is_active, created_date, update_time) VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, resume.getApplicantId());
            statement.setString(2, resume.getName());
            statement.setInt(3, resume.getCategoryId());
            statement.setDouble(4, resume.getSalary());
            statement.setBoolean(5, resume.isActive());
            statement.setTimestamp(6, new Timestamp(resume.getCreatedDate().getTime()));
            statement.setTimestamp(7, new Timestamp(resume.getUpdateTime().getTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Resumes resume) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE resumes SET applicant_id = ?, name = ?, category_id = ?, salary = ?, is_active = ?, created_date = ?, update_time = ? WHERE id = ?");
            statement.setInt(1, resume.getApplicantId());
            statement.setString(2, resume.getName());
            statement.setInt(3, resume.getCategoryId());
            statement.setDouble(4, resume.getSalary());
            statement.setBoolean(5, resume.isActive());
            statement.setTimestamp(6, new Timestamp(resume.getCreatedDate().getTime()));
            statement.setTimestamp(7, new Timestamp(resume.getUpdateTime().getTime()));
            statement.setInt(8, resume.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM resumes WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Resumes mapRow(ResultSet rs) throws SQLException {
        Resumes resume = new Resumes();
        resume.setId(rs.getInt("id"));
        resume.setApplicantId(rs.getInt("applicant_id"));
        resume.setName(rs.getString("name"));
        resume.setCategoryId(rs.getInt("category_id"));
        resume.setSalary(rs.getDouble("salary"));
        resume.setActive(rs.getBoolean("is_active"));
        resume.setCreatedDate(rs.getTimestamp("created_date"));
        resume.setUpdateTime(rs.getTimestamp("update_time"));
        return resume;
    }
}

