package com.example.jspwebapplication4;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.mindrot.jbcrypt.BCrypt;

@WebServlet(name = "logout", value = "/logout")
public class LogOut extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
     doPost(request,response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }


        response.sendRedirect("index.jsp");
    }


    public void destroy() {

    }

}
