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

//searching listing  data from database to the table
    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    public ModelAndView userList(@RequestParam(required = false) String search, @RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) throws Exception {
        ModelAndView response = new ModelAndView();
        RegisterFormBean form= new RegisterFormBean();
        response.setViewName("registration/userList");
        //response.addObject("formBeanKey", form);

        response.addObject("fname", firstName);
        response.addObject("lname", lastName);
        response.addObject("search", search);

        if(!StringUtils.isEmpty(search)){
            List<User> users=userDao.findByFirstNameIgnoreCase(search);
            response.addObject("userListKey", users);

        }

        if(!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)){
            User u= new User();
            u.setFirstName(firstName);
            u.setLastName(lastName);
            List<User> users=userDao.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName, lastName);
            response.addObject("userListKey", users);

        }

        return response;
    }



    @RequestMapping(value = "/userListOR", method = RequestMethod.GET)
    public ModelAndView userListOR( @RequestParam(required = false) String firstName2, @RequestParam(required = false) String lastName2) throws Exception {
        ModelAndView response = new ModelAndView();
        RegisterFormBean form = new RegisterFormBean();
        response.setViewName("registration/userList");
        //response.addObject("formBeanKey", form);
        response.addObject("fname", firstName2);
        response.addObject("lname", lastName2);
        if(!StringUtils.isEmpty(firstName2) || !StringUtils.isEmpty(lastName2)){
            User u= new User();
            u.setFirstName(firstName2);
            u.setLastName(lastName2);
            List<User> users=userDao.findByFirstNameIgnoreCaseOrLastNameIgnoreCase(firstName2, lastName2);
            response.addObject("userListKey", users);

        }

        return response;
    }




//getting data to the form in web
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView registerEdit(@RequestParam(required=false) Integer id) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("registration/register");
        if(id!=null){
            User user =userDao.findById(id);
            RegisterFormBean form= new RegisterFormBean();

            form.setEmail(user.getEmail());
            form.setFirstName(user.getFirstName());
            form.setLastName(user.getLastName());
            form.setUserName(user.getUserName());
            form.setPhone(user.getPhone());
            form.setPassword(user.getPassword());
            form.setId(user.getId());

            response.addObject("formBeanKey", form);

        }
else {
            RegisterFormBean form = new RegisterFormBean();
            response.addObject("formBeanKey", form);
        }

        return response;
    }


//Delleting User
    @RequestMapping(value = "/deleteUser", method = RequestMethod.GET)
    public ModelAndView Delete(@RequestParam(required=true) Integer id) throws Exception {
        ModelAndView response = new ModelAndView();

        User del=userDao.findById(id);
        if(del != null){
            userDao.delete(del);

        }
        response.setViewName("login/success");


        return response;

    }


//List all user from database
    @RequestMapping(value = "/ListAllUsers", method = RequestMethod.GET)
    public ModelAndView listAllUsers() throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("registration/userList");
        List<User> users=userDao.findAllUsers();
        response.addObject("userListKey", users);
        return response;
    }

    //List all user from database
    @RequestMapping(value = "/containsIgnoreCase", method = RequestMethod.GET)
    public ModelAndView containsIgnoreCase( @RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) throws Exception {
        ModelAndView response = new ModelAndView();
        response.setViewName("registration/userList");
        //response.addObject("formBeanKey", form);
        response.addObject("fname", firstName);
        response.addObject("lname", lastName);
        //response.setViewName("registration/userList");
        List<User> users=userDao.findByFirstNameContainsIgnoreCaseAndLastNameContainsIgnoreCase(firstName, lastName);
        response.addObject("userListKey", users);
        return response;
    }







//Adding User to database
    @RequestMapping(value = "/registerSubmit", method = RequestMethod.GET)
    public ModelAndView registerSubmit(@Valid RegisterFormBean form, BindingResult errors) throws Exception {

        ModelAndView response = new ModelAndView();

        System.out.println(form);
        if(errors.hasErrors()) {
            for (FieldError error : errors.getFieldErrors()) {
                form.getErrorMessages().add(error.getDefaultMessage());
                System.out.println("error field = " + error.getField() + " message = " + error.getDefaultMessage());
            }
            response.addObject("formBeanKey", form);
            response.setViewName("registration/register");
        }else{
            User user;
            if(form.getId() == null) {
                //create one user in database
                user = new User();
            }
            else {
                //update record of one user in database
            user=userDao.findById(form.getId());
            }


            user.setEmail(form.getEmail());
            user.setFirstName(form.getFirstName());
            user.setLastName(form.getLastName());
            user.setUserName(form.getUserName());
            user.setPhone(form.getPhone());
            user.setPassword(form.getPassword());
            user.setPhone(form.getPhone());
           userDao.save(user);
            System.out.println(user);
            response.setViewName("redirect:/login");
        }

        return response;
    }



/*

    @RequestMapping(value = "/CRUDOperations", method = RequestMethod.GET)
    public ModelAndView CRUD(@RequestParam(required = false) String search, @RequestParam(required = false) String firstName,
                             @RequestParam(required = false) String lastName,@Valid RegisterFormBean form,
                             @RequestParam(required=false) Integer id , BindingResult errors) throws Exception {
        ModelAndView response = new ModelAndView();
      //  RegisterFormBean form = new RegisterFormBean();
        response.setViewName("registration/CRUDOperations");

        // display in form
        if(id!=null){
            User user =userDao.findById(id);

            form.setEmail(user.getEmail());
            form.setFirstName(user.getFirstName());
            form.setLastName(user.getLastName());
            form.setUserName(user.getUserName());
            form.setPhone(user.getPhone());
            form.setId(user.getId());



            response.addObject("formBeanKey", form);

        }
        else {

            response.addObject("formBeanKey", form);
        }

 // search
        if(!StringUtils.isEmpty(search)){
            List<User> users=userDao.findByFirstNameIgnoreCase(search);
            response.addObject("userListKey", users);
            response.setViewName("registration/CRUD");
        }


        if(!StringUtils.isEmpty(firstName) && !StringUtils.isEmpty(lastName)){
            User u= new User();
            u.setFirstName(firstName);
            u.setLastName(lastName);
            List<User> users=userDao.findByFirstNameIgnoreCaseAndLastNameIgnoreCase(firstName, lastName);
            response.addObject("userListKey", users);
            response.setViewName("registration/CRUD");
        }




       System.out.println(form);
        if(errors.hasErrors()) {
            for (FieldError error : errors.getFieldErrors()) {
                form.getErrorMessages().add(error.getDefaultMessage());
                System.out.println("error field = " + error.getField() + " message = " + error.getDefaultMessage());
            }
            response.addObject("formBeanKey", form);
            response.setViewName("registration/CRUD");
        }else{
            User user;
            if(form.getId() == null) {
                //create one user in database
                user = new User();
            }
            else {

                //update record of one user in database
                user=userDao.findById(form.getId());


            }

            // User user = new User();
            user.setEmail(form.getEmail());
            user.setFirstName(form.getFirstName());
            user.setLastName(form.getLastName());
            user.setUserName(form.getUserName());
            user.setPhone(form.getPhone());
            user.setPassword(form.getPassword());
            user.setPhone(form.getPhone());
            //userDao.save(user);
            System.out.println(user);
            response.setViewName("registration/CRUD");
        }



        return response;
    }
*/





}
