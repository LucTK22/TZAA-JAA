package com.example.tienda_perfumes.interceptores;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class InterceptorAdmin implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {

        String passAdmin = "";

        if (request.getParameter("pass-login-admin") != null){

            passAdmin = request.getParameter("pass-login-admin");

            if (passAdmin.equals("123")){

                request.getSession().setAttribute("admin", "ok");

                response.sendRedirect("admin/inicioAdmin");
                return false;
            }
        }

        System.out.println("hola desde el interceptor ");

        if (request.getRequestURI().contains("/admin/")){

            if (!(
                    request.getSession().getAttribute("admin") != null
                    && request.getSession().getAttribute("admin").equals("ok")
            )){

                response.sendRedirect("../loginAdmin");
                return false;
            }
        }

        return true;
    }
}
