package com.xxx.web;

import com.xxx.pojo.user;
import com.xxx.service.DataTransfer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");
        DataTransfer dt = new DataTransfer();
        user user = dt.selectUserAll(account,password);
        if(user == null)
        {
            req.setAttribute("username_err","您输入的用户名或密码有误");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
        else
        {
            HttpSession session = req.getSession();
            session.setAttribute("user",user);
            session.setAttribute("test","test");
            if("1".equals(remember))
            {
                Cookie cookie = new Cookie("account",account);
                cookie.setMaxAge(60*60*24*7);
                Cookie cookie1 = new Cookie("password",password);
                cookie1.setMaxAge(60*60*24*7);
                resp.addCookie(cookie);
                resp.addCookie(cookie1);

            }
            resp.sendRedirect("/cookie-session2/selectAll");

        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
