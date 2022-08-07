package com.xxx.web;

import com.xxx.pojo.user;
import com.xxx.service.DataTransfer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password1 = req.getParameter("password_first");
        String password2 = req.getParameter("password_second");

        HttpSession session = req.getSession();
        String checkCodeGen = (String) session.getAttribute("checkCodeGen");
        String userCode = req.getParameter("verifiedImage");
        if(!(checkCodeGen.equalsIgnoreCase(userCode)))
        {
            req.setAttribute("success","验证码错误");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
            return;
        }


        DataTransfer dt = new DataTransfer();
        user u1 = dt.selectByAccount(account);


        if(u1 != null)
        {
            req.setAttribute("register_err","账户已存在");
            req.getRequestDispatcher("register.jsp").forward(req,resp);
        }
        else
        {
            if(password1.equals(password2))
            {
                dt.insertUser(account,password1);
                req.setAttribute("success","注册成功");
                req.getRequestDispatcher("register.jsp").forward(req,resp);
            }
            else
            {
                req.setAttribute("password_err","两次密码不统一");
                req.getRequestDispatcher("register.jsp").forward(req,resp);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
