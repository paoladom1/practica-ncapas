package com.uca.capas.dao;

import com.uca.capas.domain.Contribuyente;
import com.uca.capas.domain.Importancia;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class ContribuyenteDAOImpl implements ContribuyenteDAO {
    @PersistenceContext(unitName = "capas")
    private EntityManager entityManager;

    @Override
    public List<Contribuyente> findAll() throws DataAccessException {
        StringBuffer sb = new StringBuffer();
        sb.append("select * from public.contribuyente");
        Query query = entityManager.createNativeQuery(sb.toString(), Contribuyente.class);
        List<Contribuyente> resultset = query.getResultList();

        return resultset;
    }

    @Override
    @Transactional
    public void save(Contribuyente contribuyente) throws DataAccessException {
        try {
            if(contribuyente.getCodigoContribuyente() == null) {
                entityManager.persist(contribuyente);
            } else {
                entityManager.merge(contribuyente);
                entityManager.flush();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }
}
