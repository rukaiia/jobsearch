package com.example.hm49.Impl;

import com.example.hm49.DAO.VacancyDAO;
import com.example.hm49.model.Vacancies;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VacancyDAOImpl implements VacancyDAO {
    private final Connection connection;

    public VacancyDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Vacancies findById(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM vacancies WHERE id = ?");
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
    public List<Vacancies> findByEmployerId(int employerId) {
        List<Vacancies> vacancies = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM vacancies WHERE employer_id = ?");
            statement.setInt(1, employerId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                vacancies.add(mapRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vacancies;
    }

    @Override
    public void create(Vacancies vacancy) {
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO vacancies (employer_id, title, category_id, salary, description, is_active, created_date) VALUES (?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, vacancy.getEmployerId());
            statement.setString(2, vacancy.getTitle());
            statement.setInt(3, vacancy.getCategoryId());
            statement.setDouble(4, vacancy.getSalary());
            statement.setString(5, vacancy.getDescription());
            statement.setBoolean(6, vacancy.isActive());
            statement.setTimestamp(7, new Timestamp(vacancy.getCreatedDate().getTime()));
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Vacancies vacancy) {
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE vacancies SET employer_id = ?, title = ?, category_id = ?, salary = ?, description = ?, is_active = ?, created_date = ? WHERE id = ?");
            statement.setInt(1, vacancy.getEmployerId());
            statement.setString(2, vacancy.getTitle());
            statement.setInt(3, vacancy.getCategoryId());
            statement.setDouble(4, vacancy.getSalary());
            statement.setString(5, vacancy.getDescription());
            statement.setBoolean(6, vacancy.isActive());
            statement.setTimestamp(7, new Timestamp(vacancy.getCreatedDate().getTime()));
            statement.setInt(8, vacancy.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM vacancies WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Vacancies mapRow(ResultSet rs) throws SQLException {
        Vacancies vacancy = new Vacancies();
        vacancy.setId(rs.getInt("id"));
        vacancy.setEmployerId(rs.getInt("employer_id"));
        vacancy.setTitle(rs.getString("title"));
        vacancy.setCategoryId(rs.getInt("category_id"));
        vacancy.setSalary(rs.getDouble("salary"));
        vacancy.setDescription(rs.getString("description"));
        vacancy.setActive(rs.getBoolean("is_active"));
        vacancy.setCreatedDate(rs.getTimestamp("created_date"));
        return vacancy;
    }
}

