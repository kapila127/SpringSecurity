/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import org.directwebremoting.annotations.RemoteMethod;
import org.directwebremoting.annotations.RemoteProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.RequestMethod;

import service.UserService;
/*import dto.UserRegisterationDto;*/

@Controller
@RemoteProxy(name="onlineExamController")
@RequestMapping(value = "/onlineExam")
public class OnlineExamController {
   
	@Autowired
	UserService userService;
	
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ModelAndView index()
    {
    ModelAndView mav=new ModelAndView("/onlineExam/index");
    return mav;
    }
    
    @RequestMapping(value = "/userRegisteration",method = RequestMethod.GET)
    public ModelAndView userRegisteration()
    {
    ModelAndView mav=new ModelAndView("/onlineExam/Registration");
    return mav;
    }
    
    @RequestMapping(value = "/AboutUs",method = RequestMethod.GET)
    public ModelAndView aboutUs()
    {
    ModelAndView mav=new ModelAndView("/onlineExam/AboutUs");
    return mav;
    }
    
    @RequestMapping(value = "/ContactUs",method = RequestMethod.GET)
    public ModelAndView ContactUs()
    {
    ModelAndView mav=new ModelAndView("/onlineExam/ContactUs");
    return mav;
    }
    
  /*  @RemoteMethod
    public void userRegisteration(UserRegisterationDto dto)
    {
     
    	userService.RegisterUser(dto.getUserRegistration());
    	
    }*/
    
    
}
