package org.endorodrigo.repository;

import java.sql.SQLException;
import java.util.List;

public interface Repo<T> {
    List<T> getList() throws SQLException;
    T forID(Long id) throws SQLException;
    void save(T t) throws SQLException;
    void delite(Long id) throws SQLException;
}
