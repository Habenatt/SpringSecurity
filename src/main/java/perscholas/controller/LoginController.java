package perscholas.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import perscholas.form.LoginFormBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Scope("session")
// @RequestMapping( "/login")
public class LoginController {
    private static  String SESSION_KEY = "trythis";
    @RequestMapping(value =  "/login" , method = RequestMethod.GET)
    public ModelAndView index(HttpSession session) throws Exception {
        System.out.println("===============at the first login page========================================");
        ModelAndView response = new ModelAndView();
        response.setViewName("login/login");
        return response;
    }


    @RequestMapping(value = "/loginSubmit" , method = RequestMethod.GET)
    public Object index(HttpServletRequest request, HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();
        //response.setViewName("login/loginSubmit");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("====================== at the  loginSubmit main page  =================================");
        System.out.println("username of client  =" + username);
        System.out.println("password of client  =" + password);


        if (username.equals("tom")) {
            System.out.println("===============if statement1 ========================================");
            session.setAttribute("username", username);
            System.out.println("session:   " + session.getAttributeNames());
        }

        if ("tom".equals(username)&& "jerry".equals(password)) {
            System.out.println("===============if statement2 ========================================");
            System.out.println("username of client is correct =" + username);
            System.out.println("password of client is correct  =" + password);
            System.out.println("at the success page");
            response.setViewName("login/success");

        }
        else{
            System.out.println("=============== else statement ========================================");
            System.out.println("at the second login page");
            response.setViewName("login/login");
            session.setAttribute("username", null);
        }
        return response;
    }


    @RequestMapping(value = "/logout" , method = RequestMethod.GET)
    public Object logout(HttpServletRequest request, HttpSession session) throws Exception {
        System.out.println("=============== at the logout method page ========================================");
        ModelAndView response = new ModelAndView();
        // response.setViewName("login/login");
        response.setViewName("redirect:/login");
        return response;
    }

}
