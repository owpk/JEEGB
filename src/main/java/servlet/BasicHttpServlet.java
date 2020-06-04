package servlet;


import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;


@WebServlet(name = "HttpServlet", urlPatterns = "/get/*")
public class BasicHttpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Arrays.stream(req.getClass().getDeclaredMethods())
                .filter(m -> m.getModifiers() == Modifier.PUBLIC)
                .filter(m -> m.getParameterTypes().length == 0)
                .filter(m -> m.getReturnType() == String.class)
                .forEach(m -> {
                    try {
                        resp.getWriter().write("<br> Param: " + m.getName().substring(3) + "::  " + m.invoke(req) + "</br>");
                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | IOException e) {
                        LoggerFactory.getLogger(this.getClass()).info(e.getMessage());
                    }
                });

    }

}
