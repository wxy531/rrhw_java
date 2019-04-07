package com.example.demo;


import com.example.demo.readword;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;


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

