package lv.javaguru.app;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.request.Request;

import lv.javaguru.core.Initializable;
import lv.javaguru.dao.CourseDao;
import lv.javaguru.dao.UserDao;
import lv.javaguru.model.Course;

import org.apache.wicket.request.Request;


/**
 * Authenticated session subclass. Note that it is derived from AuthenticatedWebSession which is
 * defined in the auth-role module.
 * 
 * @author Jonathan Locke
 */
public class WebSession extends AuthenticatedWebSession
{
    /**
     * Construct.
     * 
     * @param request
     *            The current request object
     */
    public WebSession(Request request)
    {
        super(request);
    }

    /**
     * @see org.apache.wicket.authentication.AuthenticatedWebSession#authenticate(java.lang.String,
     *      java.lang.String)
     */
    @Override
    public boolean authenticate(final String username, final String password)
    {
        final String WICKET = "wicket";

        // Check username and password
        return WICKET.equals(username) && WICKET.equals(password);
    }

    /**
     * @see org.apache.wicket.authentication.AuthenticatedWebSession#getRoles()
     */
    @Override
    public Roles getRoles()
    {
        if (isSignedIn())
        {
            // If the user is signed in, they have these roles
            return new Roles(Roles.ADMIN);
        }
        return null;
    }
}
