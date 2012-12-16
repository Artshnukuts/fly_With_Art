package lv.javaguru.app;

import org.hsqldb.lib.HashSet;
import org.hsqldb.lib.Set;

public class Firm {

	private Integer f_id;
	private String firmName;
	private String firmAdres;
	
	private Set tickets = new HashSet();
	
	public Firm() {
	}
	
	public void setF_id(Integer f_id) {
	  this.f_id = f_id;
	}
	
	public void setFirmName(String firmName) {
	  this.firmName = firmName;
	}
	
	public void setFirmAdres(String firmAdres) {
		  this.firmAdres = firmAdres;
	}
	
	public void setTickets(Set tickets) {
		this.tickets = tickets;
	}
	
	public Integer getF_id() {
	    return f_id;
	  }
	
	public String getFirmName() {
	  return firmName;
	}
	
	public String getFirmAdres() {
		  return firmAdres;
	}
	
	public Set getTickets() {
		return tickets;
	}
	
}
