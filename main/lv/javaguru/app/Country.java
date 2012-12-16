package lv.javaguru.app;

import org.hsqldb.lib.HashSet;
import org.hsqldb.lib.Set;

public class Country {

	private Integer c_id;
	private String countryName;
	private String townName;
	
	private Set tickets = new HashSet();
	
	public Country() {
	}
	
	public void setC_id(Integer c_id) {
	  this.c_id = c_id;
	}
	
	public void setCountryName(String countryName) {
	  this.countryName = countryName;
	}
	
	public void setTownName(String townName) {
		  this.townName = townName;
	}
	
	public void setTickets(Set tickets) {
		this.tickets = tickets;
	}
	
	public Integer getC_id() {
	    return c_id;
	  }
	
	public String getCountryName() {
	  return countryName;
	}
	
	public String getTownName() {
		  return townName;
	}
	
	public Set getTickets() {
		return tickets;
	}
	
}
