package iotstar.dao.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import vn.iotstar.configs.JPAConfig;
import vn.iotstar.dao.IUserDao;
import vn.iotstar.entity.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    public Connection conn = null;
    public PreparedStatement ps = null;
    public ResultSet rs = null;
    @Override
    public Users findByUsername(String username) {
        EntityManager enma = JPAConfig.getEntityManager();

        Users user = enma.find(Users.class,username);

        return user;
    }

    @Override
    public void insert(Users user) {
// TODO Auto-generated method stub
        EntityManager enma = JPAConfig.getEntityManager();

        EntityTransaction trans = enma.getTransaction();

        try {

            trans.begin();
            // gọi phuong thức để insert, update, delete
            user.getUsername();
            enma.persist(user);
            trans.commit();

        } catch (Exception e) {

            e.printStackTrace();

            trans.rollback();

            throw e;

        } finally {

            enma.close();

        }
    }

    @Override
    public void update(Users user) {
// TODO Auto-generated method stub
        EntityManager enma = JPAConfig.getEntityManager();

        EntityTransaction trans = enma.getTransaction();

        try {

            trans.begin();

            // gọi phuong thức để insert, update, delete

            enma.merge(user);

            trans.commit();

        } catch (Exception e) {

            e.printStackTrace();

            trans.rollback();

            throw e;

        } finally {

            enma.close();

        }
    }

    @Override
    public void delete(String username) throws Exception{
        // TODO Auto-generated method stub
        EntityManager enma = JPAConfig.getEntityManager();

        EntityTransaction trans = enma.getTransaction();

        try {

            trans.begin();

            // gọi phuong thức để insert, update, delete

            Users user = enma.find(Users.class, username);

            if (user != null) {

                enma.remove(user);

            } else {

                throw new Exception("Không tìm thấy");

            }

            trans.commit();

        } catch (Exception e) {
            e.printStackTrace();
            trans.rollback();
            throw e;

        } finally {

            enma.close();

        }
    }

    @Override
    public List<Users> findAll() {
        EntityManager enma = JPAConfig.getEntityManager();


        TypedQuery<Users> query= enma.createNamedQuery("Users.findAll", Users.class);


        return query.getResultList();
    }

    @Override
    public List<Users> findAll(int page, int pagesize) {
        EntityManager enma = JPAConfig.getEntityManager();

        TypedQuery<Users> query= enma.createNamedQuery("Users.findAll", Users.class);

        query.setFirstResult(page*pagesize);

        query.setMaxResults(pagesize);

        return query.getResultList();
    }

    @Override
    public int count() {

            EntityManager enma = JPAConfig.getEntityManager();

            String jpql = "SELECT count(u) FROM Users u";


            Query query = enma.createQuery(jpql);


            return ((Long)query.getSingleResult()).intValue();

    }

}
