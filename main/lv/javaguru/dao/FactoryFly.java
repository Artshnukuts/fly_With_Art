package lv.javaguru.dao;

public class FactoryFly {
		  
		  private static CountryDao countryDao = null;
		  private static TicketDao ticketDao = null;
		  private static FactoryFly instance = null;

		  public static synchronized FactoryFly getInstance(){
		    if (instance == null){
		      instance = new FactoryFly();
		    }
		    return instance;
		  }

		  public CountryDao getCountryDao(){
		    if (countryDao == null){
		    	countryDao = new CountryDaoImpl();
		    }
		    return countryDao;
		  }

		  public TicketDao getTicketDao(){
		    if (ticketDao == null){
		    	ticketDao = new TicketDaoImpl();
		    }
		    return ticketDao;
		  }

		}
