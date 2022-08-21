package com.mglcl.controller;


import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErreurController  implements ErrorController  {

	 
    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletResponse response)
    {
        ModelAndView modelAndView = new ModelAndView();
 
        if (response.getStatus() == HttpStatus.NOT_FOUND.value()) {
            modelAndView.setViewName("erreur/404");
        }
        else if (response.getStatus() == HttpStatus.FORBIDDEN.value()) {
            modelAndView.setViewName("erreur/403");
        }
        else if (response.getStatus() == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            modelAndView.setViewName("erreur/500");
        }
        else {
            modelAndView.setViewName("erreur/erreur");
        }
 
        return modelAndView;
    }
 
    public String getErrorPath() {
        return "erreur/erreur";
    }

}