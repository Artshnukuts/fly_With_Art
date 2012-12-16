package lv.javaguru.dao;

import lv.javaguru.app.Country;
import lv.javaguru.app.Ticket;

import java.util.Collection;
import java.sql.SQLException;

public interface TicketDao {
  public void addTicket(Ticket ticket) throws SQLException;
  public void updateTicket(Integer t_id, Ticket ticket) throws SQLException;
  public Ticket getTicketById(Integer t_id) throws SQLException;
  @SuppressWarnings("rawtypes")
public Collection getAllTickets() throws SQLException;
  public void deleteTicket(Ticket ticket) throws SQLException;
  @SuppressWarnings("rawtypes")
public Collection getTicketByCountry(Country country) throws SQLException;
}
