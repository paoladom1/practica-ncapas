package com.uca.capas.dao;

import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ContribuyenteDAO {
    public List<Contribuyente> findAll()  throws DataAccessException;

    public void save(Contribuyente contribuyente) throws DataAccessException;

}
