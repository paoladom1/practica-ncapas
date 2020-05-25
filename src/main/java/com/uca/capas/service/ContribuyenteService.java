package com.uca.capas.service;

import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ContribuyenteService {
    public List<Contribuyente> findAll() throws DataAccessException;

    public void save(Contribuyente contribuyente) throws DataAccessException;
}
