package com.dao.impl;

import com.dao.RootDao;
import com.dao.session_factory.SessionManager;
import com.domain.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

@Repository
public class RootImplDao implements RootDao {

    @Override
    public void create(Root root) {

        Session session = SessionManager.getFactory().openSession();

        Transaction transactionManager = session.beginTransaction();

        session.persist(root);

        transactionManager.commit();

        System.out.println();

        session.close();
    }
}
