package com.emsa.models;

import com.emsa.util.Mysql;
import org.hibernate.Session;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
// import com.emsa.models.Client;

import static org.junit.Assert.*;

public class ClientTest {
    @Before
    public void setUp() throws Exception {
        Session session = Mysql.getSession();
        session.beginTransaction();
        session.createNativeQuery("truncate table clients").executeUpdate();
        session.getTransaction().commit();
        session.close();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test(expected = org.hibernate.exception.DataException.class)
    public void shouldNotSaveDueToNameTooLong() throws Exception {
        Session session = Mysql.getSession();
        session.beginTransaction();
        Client c = new Client("01234567890123456789012345678901234567890123456789");
        session.save(c);
        session.getTransaction().commit();
        session.close();
        assertEquals(1, c.getId());
    }

    @Test
    public void shouldCreateNewClientAndSave() throws Exception {
        Session session = Mysql.getSession();
        session.beginTransaction();
        Client c = new Client("jennifer");
        session.save(c);
        session.getTransaction().commit();
        session.close();
    }
}