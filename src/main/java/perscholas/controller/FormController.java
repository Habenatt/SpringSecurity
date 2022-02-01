package perscholas.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import perscholas.form.LoginFormBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class FormController {

    private static String SESSION_KEY = "usernameSessionKey";
    private static String SESSION_ERROR_MESSAGE = "errorMessageKey";


    @RequestMapping(value =  "/loginFromForm" , method = RequestMethod.GET)
    public Object index(HttpSession session) throws Exception {
        System.out.println("=============== at the loginFromForm page========================================");
        ModelAndView response = new ModelAndView();
        response.setViewName("form/formLogin");
        return response;
    }


    @RequestMapping(value = "/logoutFormSubmit2" , method = RequestMethod.GET)
    public Object loginSubmitWithParam2(LoginFormBean form,  HttpSession session) throws Exception {
        System.out.println("=============== at the Lombok Getter  page ========================================");
        ModelAndView response = new ModelAndView();

        if ("tom".equals(form.getUsernameFromForm())&& "jerry".equals(form.getUsernameFromForm())) {
            System.out.println("===============if statement2 ========================================");
            session.setAttribute(SESSION_KEY,form.getUsernameFromForm());
            System.out.println("username of client is correct =" + form.getUsernameFromForm());
            System.out.println("password of client is correct  =" + form.getUsernameFromForm());
            session.setAttribute(SESSION_ERROR_MESSAGE, null);
        }


        System.out.println(" bringing data from Bean" + form.getUsernameFromForm());
        System.out.println(" bringing data from Bean" + form.getPasswordFromForm());
        session.setAttribute(SESSION_KEY,null);
        response.setViewName("form/formLoginMessage");
        session.setAttribute(SESSION_ERROR_MESSAGE,"Invalid Username " +form.getUsernameFromForm());
        return response;
    }


    @RequestMapping(value = "/success", method = RequestMethod.GET)
    public ModelAndView success(HttpSession session) throws Exception {
        // this method is checking to see if the user is logged in by looking at the session
        // if logged in ( user is in the session ) then show the success page.
        // if not logged in ( user is not in the session ) then show the login page
        ModelAndView response = new ModelAndView();

        String username = (String) session.getAttribute(SESSION_KEY);
        if (StringUtils.equals(username, "tom")) {
            // add the username to the response model so that it can be displayed on the jsp page.
            response.addObject("loggedInUser", username);

            response.setViewName("login/success");
        } else {
            // need to implement here to redirect back to login page
            // because it means the user has requested the /success url
            // but is not in the session
            response.setViewName("redirect:/login");
        }

        return response;
    }




}
