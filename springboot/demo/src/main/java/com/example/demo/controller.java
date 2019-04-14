package com.example.demo;


import com.example.demo.readword;

import org.apache.tomcat.jni.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;


@RestController
public class controller {

    @RequestMapping(value = "/ladder", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    
    public String ladder(@RequestParam("start") String start, @RequestParam("end") String end) throws IOException
    {
        readword test = new readword();
        String result = test.read(start, end);
        return result;
    }
};
