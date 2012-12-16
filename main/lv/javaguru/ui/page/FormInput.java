package lv.javaguru.ui.page;
import lv.javaguru.model.FormSearchInput;
import java.util.Arrays;
import java.util.List;

import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.WebPage;

import org.apache.wicket.model.CompoundPropertyModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.markup.html.form.TextField;

public class FormInput extends WebPage {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("serial")
	public FormInput(final PageParameters parameters) {

	}
	
	@SuppressWarnings("serial")
	private class InputForm extends Form<FormSearchInput>
	{
		
		@SuppressWarnings("serial")
		public InputForm(String id) {
			super(id, new CompoundPropertyModel<FormSearchInput>(new FormSearchInput()));
			
			add(new DropDownChoice("DropDownTicket", TICKETCOUNT));

            add(new TextField<String>("FromTextProperty").setRequired(true).setLabel(
                    new Model<String>("")));
            
            add(new TextField<String>("ToTextProperty").setRequired(true).setLabel(
                    new Model<String>("")));
            
            add(new TextField<String>("AtDateTextProperty").setRequired(true).setLabel(
                    new Model<String>("")));
            
            add(new TextField<String>("ToDateTextProperty").setRequired(true).setLabel(
                    new Model<String>("")));
   
            
            RadioChoice<String> rc = new RadioChoice<String>("TripChoice", NUMBERS).setSuffix("");
            rc.setLabel(new Model<String>("number"));
            rc.setRequired(true);
            add(rc);
            
            add(new Button("SearchButton"));

		}
		
        @Override
        public void onSubmit()
        {
            // Form validation successful. Display message showing edited model.
            info("Saved model " + getDefaultModelObject());
        }
		
	}
	
	public static final List<String> NUMBERS = Arrays.asList("Round-Trip", "One-Way");
	
	@SuppressWarnings("rawtypes")
	public static final List TICKETCOUNT = Arrays.asList(new Integer[] { new Integer(1), new Integer(2), new Integer(3), new Integer(4), new Integer(5), new Integer(6) });
	
    public FormInput()
    {
        // Construct form and feedback panel and hook them up
        final FeedbackPanel feedback = new FeedbackPanel("feedback");
        add(feedback);
        add(new InputForm("inputForm"));
    }
    

}
