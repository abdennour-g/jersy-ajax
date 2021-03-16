package com.example.demo.jpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.example.demo.ent.User;


public class Manager {
	  private static EntityManagerFactory emf = Persistence.createEntityManagerFactory( "bouaicha" );
	    // @PersistenceContext
	    private static EntityManager        em  = emf.createEntityManager();

	    public static List<User> showList() {
	        Query q1 = em.createQuery( "SELECT c FROM User c" );
	        return q1.getResultList();
	    }


	    // @Transactional
	    public static void insert( User user ) {
	    	if(user!=null) {
	    	em.getTransaction().begin();
	        em.persist( user );
	        em.getTransaction().commit();
	    	}
	   }
	    

	    public static void update( User userUpdate,Long id ) {
	    	if(userUpdate!=null&&id>0) {
	    	User user=     em.find(User.class,id);   	
	     	user.setUsername(userUpdate.getUsername());
	     	user.setEmail(userUpdate.getEmail());
	     	user.setPassword(userUpdate.getPassword());
	     	em.getTransaction().begin();
	        em.persist( user );
	        em.getTransaction().commit();
	    	}
	    }
	    public static void delete(Long id) {
	    	if(id>0) {
	    	User user=     em.find(User.class,id);   
	    	em.getTransaction().begin();
	    	em.remove(user);
	    	em.getTransaction().commit();
	    	}
	    }
	    
}
