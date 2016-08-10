package com.emsa.models;

import com.emsa.util.Mysql;
import org.hibernate.Session;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShelterTest {
    @Test
    public void shouldCreateNewShelterAndSave() throws Exception {
        Session session = Mysql.getSession();
        session.beginTransaction();
        Shelter s = new Shelter("Place");
        session.save(s);
        session.getTransaction().commit();
        session.close();
    }

}