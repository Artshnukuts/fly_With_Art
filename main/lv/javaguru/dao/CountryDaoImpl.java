package lv.javaguru.dao;

import lv.javaguru.dao.CountryDao;

import lv.javaguru.app.Country;
import lv.javaguru.app.Ticket;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import lv.javaguru.app.HibernateUtil;
import javax.swing.*;
import org.hibernate.Session;
import org.hibernate.Query;

public class CountryDaoImpl implements CountryDao{

	  public void addCountry(Country country) throws SQLException {
		    Session session = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      session.save(country);
		      session.getTransaction().commit();
		    } catch (Exception e) {
		      JOptionPane.showMessageDialog(null, e.getMessage(), "Error on paste of Country", JOptionPane.OK_OPTION);
		    } finally {
		      if (session != null && session.isOpen()) {

		        session.close();
		      }
		    }
		  }
	  
	  public void updateCountry(Integer c_id, Country country) throws SQLException {
		    Session session = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      session.update(country);
		      session.getTransaction().commit();
		    } catch (Exception e) {
		      JOptionPane.showMessageDialog(null, e.getMessage(), "Error on update of Country", JOptionPane.OK_OPTION);
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		  }
	  

	  
	  @SuppressWarnings("rawtypes")
	public Collection getAllCountries() throws SQLException {
		    Session session = null;
		    List countries = new ArrayList<Country>();
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      countries = session.createCriteria(Country.class).list();
		    } catch (Exception e) {
		      JOptionPane.showMessageDialog(null, e.getMessage(), "Error on getAllCountries", JOptionPane.OK_OPTION);
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return countries;
		  }
	  
	  public void deleteCountry(Country country) throws SQLException {
		    Session session = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      session.delete(country);
		      session.getTransaction().commit();
		    } catch (Exception e) {
		      JOptionPane.showMessageDialog(null, e.getMessage(), "Error on deleteCountry", JOptionPane.OK_OPTION);
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		  }
	  
	  @SuppressWarnings({ "unchecked", "rawtypes" })
	public Collection getCountryByTicket(Ticket ticket) throws SQLException {
		    Session session = null;
		    List countries = new ArrayList<Country>();
		    try {
		      session = HibernateUtil.getSessionFactory().getCurrentSession();
		      session.beginTransaction();
		      Integer ticket_id = ticket.getT_id();
		      Query query = session.createQuery(
		          " select c "
		              + " from Country c INNER JOIN c.TICKETS ticket"
		              + " where ticket.t_id = :ticketsId "
		      )
		          .setInteger("ticketsId", ticket_id);
		      countries = (List<Country>) query.list();
		      session.getTransaction().commit();

		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return countries;
		  }

}
