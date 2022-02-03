package perscholas.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import perscholas.database.dao.UserDAO;
import perscholas.database.entity.User;
import perscholas.form.RegisterFormBean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/registration-url-path")
public class RegistrationController {

    @Autowired
    private  UserDAO userDao ;


    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public ModelAndView userList(@RequestParam(required = false) String search, @RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("registration/userList");
        if(!StringUtils.isEmpty(search)){
            List<User> users=userDao.findByFirstNameIgnoreCase(search);
            response.addObject("userListKey", users);
           // response.setViewName("registration/userList");
        }

        if(!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)){
            List<User> users=userDao.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName, lastName);
            response.addObject("userListKey", users);
            // response.setViewName("registration/userList");
        }

        return response;
    }




    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("registration/register");

        RegisterFormBean form = new RegisterFormBean();
        response.addObject("formBeanKey", form);

        return response;
    }



    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView registerEdit(@RequestParam(required=false) Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("registration/register");
        if(id!=null){

        }
else {
            RegisterFormBean form = new RegisterFormBean();
            response.addObject("formBeanKey", form);
        }

        return response;
    }


    @RequestMapping(value = "/registerSubmit", method = RequestMethod.GET)
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult errors) throws Exception {

        ModelAndView response = new ModelAndView();
        response.setViewName("registration/register");

        System.out.println(form);
        if(errors.hasErrors()) {
            for (FieldError error : errors.getFieldErrors()) {
                form.getErrorMessages().add(error.getDefaultMessage());
                System.out.println("error field = " + error.getField() + " message = " + error.getDefaultMessage());
            }
            response.addObject("formBeanKey", form);
            response.setViewName("registration/register");
        }else{

            User user = new User();
            user.setEmail(form.getEmail());
            user.setFirstName(form.getFirstName());
            user.setLastName(form.getLastName());
            user.setUserName(form.getUserName());
            user.setPhone(form.getPhone());
            user.setPassword(form.getPassword());
            userDao.save(user);
            System.out.println(user);



            response.setViewName("redirect:/login");
        }
        return response;
    }





}
