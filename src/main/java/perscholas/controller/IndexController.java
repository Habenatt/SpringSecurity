package perscholas.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import static javax.servlet.jsp.PageContext.SESSION;

@RestController
public class IndexController {

    private static  String SESSION_KEY = "trythis";

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public ModelAndView index(HttpSession session) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("index");
        return response;
    }


    @RequestMapping(value =  "/indexSubmit" , method = RequestMethod.GET)
    public ModelAndView indexSubmit(HttpServletRequest request) throws Exception {
        System.out.println("Full Name =" + request.getParameter("name"));
        System.out.println("Email =" + request.getParameter("email"));
        System.out.println("Telephone Number =" + request.getParameter("phone"));
        System.out.println("Date of Birth =" + request.getParameter("dateOfBirth"));
        System.out.println("License Number =" + request.getParameter("lic"));
        System.out.println("Expires Date =" + request.getParameter("date1"));
        System.out.println("Experience in Years =" + request.getParameter("quantity"));
       String name = request.getParameter("name");
       String DOB = request.getParameter("dateOfBirth");
        ModelAndView response = new ModelAndView();
        response.addObject("name", name);
        response.addObject("DOB", DOB);
        response.setViewName("indexSubmit");

        return response;
    }


    /* Object userSession= session.getAttribute("username");
    //// System.out.println("Trying to get : " + userSession);
        /*Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            String name = cookies[i].getName();
            String value = cookies[i].getValue();
            System.out.println(name);
            System.out.println(value);
        }*/



}
