package com.example.jspwebapplication4;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.mindrot.jbcrypt.BCrypt;

@WebServlet(name = "register", value = "/register")
public class Register extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {



        Connector connector=new Connector();
        Connection c = null;
        PreparedStatement ps = null;


        try {
            c =connector.connect() ;
            String username = request.getParameter("username");
            String plainPassword = request.getParameter("password");
            String hashedPassword = BCrypt.hashpw(plainPassword, BCrypt.gensalt());


            String sql = "INSERT INTO user(username, password) VALUES (?, ?)";
            ps = c.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, hashedPassword);


            int rowsInserted = ps.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("User successfully inserted into the database.");
                response.sendRedirect("index.jsp");
            } else {
                System.out.println("Failed to insert user into the database.");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (c != null) {
                    c.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }



//        response.setContentType("text/html");


        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + request.getParameter("username") + "</h1>");
//        out.println("<h1>" + request.getParameter("password") + "</h1>");
//        out.println("</body></html>");

    }

    public void destroy() {
    }
}