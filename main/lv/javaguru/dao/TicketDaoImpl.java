package lv.javaguru.dao;

import lv.javaguru.dao.TicketDao;

import lv.javaguru.app.Country;
import lv.javaguru.app.Ticket;
import java.sql.SQLException;
import java.util.Collection;
import java.util.ArrayList;
import java.util.List;
import lv.javaguru.app.HibernateUtil;
import javax.swing.*;


import org.hibernate.Query;
import org.hibernate.classic.Session;


public class TicketDaoImpl implements TicketDao {

	  public void addTicket(Ticket ticket) throws SQLException {
		    Session session = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      session.save(ticket);
		      session.getTransaction().commit();
		    } catch (Exception e) {
		      JOptionPane.showMessageDialog(null, e.getMessage(), "Error on paste of Ticket", JOptionPane.OK_OPTION);
		    } finally {
		      if (session != null && session.isOpen()) {

		        session.close();
		      }
		    }
		  }
	  
	  public void updateTicket(Integer t_id, Ticket ticket) throws SQLException {
		    Session session = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      session.update(ticket);
		      session.getTransaction().commit();
		    } catch (Exception e) {
		      JOptionPane.showMessageDialog(null, e.getMessage(), "Error on update of Ticket", JOptionPane.OK_OPTION);
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		  }
	  
	  public Ticket getTicketById(Integer t_id) throws SQLException {
		    Session session = null;
		    Ticket ticket = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      ticket = (Ticket) session.load(Ticket.class, t_id);
		    } catch (Exception e) {
		      JOptionPane.showMessageDialog(null, e.getMessage(), "Error on getTicketById", JOptionPane.OK_OPTION);
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return ticket;
		  }
	  
	  @SuppressWarnings("rawtypes")
	public Collection getAllTickets() throws SQLException {
		    Session session = null;
		    List tickets = new ArrayList<Ticket>();
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      tickets = session.createCriteria(Country.class).list();
		    } catch (Exception e) {
		      JOptionPane.showMessageDialog(null, e.getMessage(), "Error on getAllTickets", JOptionPane.OK_OPTION);
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return tickets;
		  }
	  
	  public void deleteTicket(Ticket ticket) throws SQLException {
		    Session session = null;
		    try {
		      session = HibernateUtil.getSessionFactory().openSession();
		      session.beginTransaction();
		      session.delete(ticket);
		      session.getTransaction().commit();
		    } catch (Exception e) {
		      JOptionPane.showMessageDialog(null, e.getMessage(), "Error on deleteTicket", JOptionPane.OK_OPTION);
		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		  }
	  
	  @SuppressWarnings({ "unchecked", "rawtypes" })
	public Collection getTicketByCountry(Country country) throws SQLException {
		    Session session = null;
		    List tickets = new ArrayList<Ticket>();
		    try {
		      session = HibernateUtil.getSessionFactory().getCurrentSession();
		      session.beginTransaction();
		      Integer country_id = country.getC_id();
		      Query query = session.createQuery(
		          " select t "
		              + " from Ticket t INNER JOIN t.COUNTRIES country"
		              + " where country.t_id = :countryId "
		      )
		          .setInteger("countryId", country_id);
		      tickets = (List<Ticket>) query.list();
		      session.getTransaction().commit();

		    } finally {
		      if (session != null && session.isOpen()) {
		        session.close();
		      }
		    }
		    return tickets;
		  }

}
