package lv.javaguru.dao;


import lv.javaguru.app.Country;
import lv.javaguru.app.Ticket;

import java.util.Collection;
import java.sql.SQLException;

public interface CountryDao {
  public void addCountry(Country country) throws SQLException;
  public void updateCountry(Integer c_id, Country country) throws SQLException;
  /*public Country getCountryById(Integer c_id) throws SQLException;*/
  @SuppressWarnings("rawtypes")
public Collection getAllCountries() throws SQLException;
  public void deleteCountry(Country country) throws SQLException;
  @SuppressWarnings("rawtypes")
public Collection getCountryByTicket(Ticket ticket) throws SQLException;
}
