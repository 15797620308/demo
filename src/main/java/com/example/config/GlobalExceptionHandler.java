package com.example.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.util.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String IMOOC_ERROR_VIEW = "404";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, HttpServletResponse response,  Exception e){
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        System.out.println("=====================全局异常信息捕获=======================");

        e.printStackTrace();

        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", e.getMessage());
        mav.setViewName(IMOOC_ERROR_VIEW);

        return mav;
    }
}
