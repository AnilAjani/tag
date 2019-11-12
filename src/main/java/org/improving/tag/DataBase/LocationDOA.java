package org.improving.tag.DataBase;

import org.improving.tag.Adversary;
import org.improving.tag.Location;
import org.improving.tag.items.UniqueItems;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.Id;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

//@Component
//public class LocationDOA {
//    private final JdbcTemplate jdbcTemplate;
//
//    public LocationDOA(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//
//    }

//    public List<Location> findAll() {
//        try {
//            EntityManager em = JPAutility.getEntityManager();
//            List<Location> locations = em.createQuery("SELECT location FROM org.improving.tag.Location location").getResultList();
//            return locations;
//        } catch (DataAccessException e) {
//            e.printStackTrace();
//            System.out.println("Exception in JDBC: " + e.getMessage());
//            return null;
//        }
//    }
//}