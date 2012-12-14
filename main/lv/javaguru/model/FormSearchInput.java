package lv.javaguru.model;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import lv.javaguru.ui.page.FormInput;

import org.apache.wicket.IClusterable;

public final class FormSearchInput implements IClusterable{

	private static final long serialVersionUID = 1L;
    
    private String FromTextProperty = "From";
    private String ToTextProperty = "To";
    
    private String AtDateTextProperty = "Depart";
    private String ToDateTextProperty = "Return";
    
    private String TripChoice = FormInput.NUMBERS.get(0);
    
	private Integer DropDownTicket = (Integer) FormInput.TICKETCOUNT.get(0);
    
    public String getFromTextProperty()
    {
        return FromTextProperty;
    }
    
    public void setFromTextProperty(String FromTextProperty)
    {
        this.FromTextProperty = FromTextProperty;
    }
    
    public String getToTextProperty()
    {
        return ToTextProperty;
    }
    
    public void setToTextProperty(String ToTextProperty)
    {
        this.ToTextProperty = ToTextProperty;
    }
    
    public String getAtDateTextProperty()
    {
        return AtDateTextProperty;
    }
    
    public void setAtDateTextProperty(String AtDateTextProperty)
    {
        this.AtDateTextProperty = AtDateTextProperty;
    }
    
    public String getToDateTextProperty()
    {
        return ToDateTextProperty;
    }
    
    public void setToDateTextProperty(String ToDateTextProperty)
    {
        this.ToDateTextProperty = ToDateTextProperty;
    }
    
    public void setTripChoice(String Choice)
    {
    	TripChoice = Choice;
    }
    
    public String getTripChoice()
    {
        return TripChoice;
    }
    
    public void DropDownTicket(Integer cTicket)
    {
    	DropDownTicket = cTicket;
    }
    
    public Integer DropDownTicket()
    {
        return DropDownTicket;
    }
    
    public String toString()
    {
     StringBuilder b = new StringBuilder();
        b.append("[TestInputObject stringProperty = '")
            .append(FromTextProperty)
            .append(ToTextProperty)
            .append(AtDateTextProperty)
            .append(ToDateTextProperty)
            .append(", TripChoice = ")
            .append(TripChoice)
        	.append(", DropDownTicket = ")
        	.append(DropDownTicket);
        return b.toString();
    }
    
}
