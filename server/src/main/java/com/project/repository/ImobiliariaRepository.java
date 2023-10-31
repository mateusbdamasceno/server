package com.project.repository;

import com.project.beans.Imovel;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

public interface ImobiliariaRepository {
    public List<Imovel> getImoveis() throws SQLException;
    public List<Object> findAllMongoDB();

}
