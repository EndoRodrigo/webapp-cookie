package org.endorodrigo.repository;

import java.sql.SQLException;
import java.util.List;

public interface Repo<T> {
    List<T> getListProduct() throws SQLException;
    T forIDPorudct(Long id) throws SQLException;
    void saveProduct(T t) throws SQLException;
    void deliteProduct(Long id) throws SQLException;
}
