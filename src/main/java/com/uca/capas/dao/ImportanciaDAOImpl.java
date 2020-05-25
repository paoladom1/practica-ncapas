package com.uca.capas.dao;

import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ImportanciaDAOImpl implements ImportanciaDAO{
    @PersistenceContext(unitName = "capas")
    private EntityManager entityManager;

    @Override
    public List<Importancia> findAll() throws DataAccessException {
        StringBuffer sb = new StringBuffer();
        sb.append("select * from public.importancia");
        Query query = entityManager.createNativeQuery(sb.toString(), Importancia.class);
        List<Importancia> resultset = query.getResultList();

        return resultset;
    }

    @Override
    public Importancia findOne(Integer code) throws DataAccessException {
        Importancia importancia = entityManager.find(Importancia.class, code);
        return importancia;
    }
}
