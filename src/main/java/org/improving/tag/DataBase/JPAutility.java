//package org.improving.tag.DataBase;
//import org.springframework.stereotype.Component;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//
//    public class JPAutility {
//        private static final EntityManagerFactory emFactory;
//
//        static {
//            emFactory = Persistence.createEntityManagerFactory("com.improving");
//        }
//
//        public static EntityManager getEntityManager() {
//            return emFactory.createEntityManager();
//        }
//
//        public static void close() {
//            emFactory.close();
//        }
//    }
//
