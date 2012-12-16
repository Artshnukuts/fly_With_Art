package lv.javaguru.app;

public class Ticket {

	private Integer t_id;
	private Integer fromTown;
	private Integer toTown;
	
	private String departDate;
	private String arriveDate;
	
	private String valuta;
	private double prize;

	public Ticket(){
		
	}
	
	public void setT_id(Integer t_id) {
		  this.t_id = t_id;
	}
	
	public void setFromTown(Integer fromTown) {
		  this.fromTown = fromTown;
	}
	
	public void setToTown(Integer toTown) {
		  this.toTown = toTown;
	}
	
	public void setValuta(String valuta) {
		  this.valuta = valuta;
	}
	
	public void setDepartDate(String departDate) {
		  this.departDate = departDate;
	}
	
	public void setArriveDate(String arriveDate) {
		  this.arriveDate = arriveDate;
	}
	
	public void setPrize(double prize) {
		  this.prize = prize;
	}

	public Integer getT_id() {
		return t_id;
	}

	public Integer getFromTown() {
	  return fromTown;
	}
	
	public Integer getToTown() {
		  return toTown;
	} 
	
	public String getDepartDate() {
		  return departDate;
	}
	
	public String getArriveDate() {
		  return arriveDate;
	}
	
	public String getValuta() {
		  return valuta;
	}
	
	public double getPrize() {
		  return prize;
	}
}
