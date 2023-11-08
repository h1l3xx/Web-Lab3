package io.github.lab3.db;

import io.github.lab3.model.CheckAreaBean;
import javax.persistence.*;

import java.sql.SQLException;
import java.util.List;

public class CheckAreaDAOImpl implements CheckAreaDAO {
    private final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Result");
    private final EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public void create(CheckAreaBean bean) throws SQLException {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(bean);
            transaction.commit();
        }catch (Exception e){
            transaction.rollback();
            System.err.println("Something went wrong in DAO: " + e);
            throw new SQLException(e);
        }
    }
    @Override
    public List<CheckAreaBean> getAll() throws SQLException {
        List<CheckAreaBean> results;
        try {
            results = entityManager.createQuery("select result from CheckAreaBean result ORDER BY result.id" , CheckAreaBean.class).getResultList();
            System.out.println("Твоя мать шикраная женщина");
        } catch (Throwable e) {
            System.err.println("Something went wrong in DAO: " + e);
            throw new SQLException(e);
        }
        return results;
    }

    @Override
    public void clear() throws SQLException {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.createQuery("delete from CheckAreaBean").executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            System.err.println("Something went wrong in DAO: " + e);
            throw new SQLException(e);
        }
    }
}
