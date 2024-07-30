package com.example.jspwebapplication4;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.mindrot.jbcrypt.BCrypt;

@WebServlet(name = "login", value = "/login")
public class Login extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        Connector connector = new Connector();
        Connection c = null;
        PreparedStatement ps = null;
        PrintWriter out = response.getWriter();

        try {
            c = connector.connect();
            String username = request.getParameter("username");
            String password = request.getParameter("password");


            String sql = "select * from jdbcdb.user where username=?";
            ps = c.prepareStatement(sql);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();


            if (rs.next()) {

                String usernameDb = rs.getString("username");
                String passwordDb = rs.getString("password");
                String emailDb = rs.getString("email");
                int ageDb = rs.getInt("age");



                if (verifyPassword(password, passwordDb)) {
                    HttpSession httpSession = request.getSession();
                    httpSession.setAttribute("login", true);

                    Cookie usernameCookie = new Cookie("username", username);
                    Cookie emailCookie = new Cookie("email", emailDb);
                    Cookie ageCookie = new Cookie("age", Integer.toString(ageDb));

                    response.addCookie(usernameCookie);
                    response.addCookie(emailCookie);
                    response.addCookie(ageCookie);


                    boolean login = (boolean) request.getSession().getAttribute("login");
                    if (login) {
                        out.println("Succesfull Login");
                        response.sendRedirect("list.jsp");
                    } else {
                        response.sendRedirect("index.jsp");

                    }

                }
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

    public static boolean verifyPassword(String pasword, String dbPassword) {
        return BCrypt.checkpw(pasword, dbPassword);
    }


    public void destroy() {
    }
}
