package io.github.lab3.db;

import io.github.lab3.model.CheckAreaBean;

import java.sql.SQLException;
import java.util.List;

public interface CheckAreaDAO {
    void create(CheckAreaBean result) throws SQLException;
    List<CheckAreaBean> getAll() throws SQLException;
    void clear() throws SQLException;
}
