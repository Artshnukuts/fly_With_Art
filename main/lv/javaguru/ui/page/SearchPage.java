package lv.javaguru.ui.page;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

import lv.javaguru.app.Ticket;
import lv.javaguru.dao.FactoryFly;
import lv.javaguru.dao.TicketDao;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;

import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;



public class SearchPage extends WebPage {
	private static final long serialVersionUID = 1L;
	public String message = "[type y56y56yy456e world here]";
    String[] mesArr = {"Mr. ", "Mrs. ", "Ms. " };
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public SearchPage(final PageParameters parameters) throws SQLException {
		
		
	add(new Label("From", new Model("From: ")));
	
    Collection tickets = FactoryFly.getInstance().getTicketDao().getAllTickets();
    Iterator iterator = tickets.iterator();

    while (iterator.hasNext()) {
    	Ticket ticket = (Ticket) iterator.next();
    	message = ticket.getArriveDate();
        System.out.println(ticket.getArriveDate());
      }


			add(new Label("To", new Model("To: ")));

	        PropertyModel<String> messageModel = new PropertyModel<String>(this, "message");

	        add(new Label("msg", messageModel));

	        Form<?> form = new Form("form");
	        form.add(new TextField<String>("msgInput", messageModel));
	        add(form);
	}

    public String getMessage()
    {
        return message;
    }


    public void setMessage(String message)
    {
    	this.message=message;
    }
    
};
