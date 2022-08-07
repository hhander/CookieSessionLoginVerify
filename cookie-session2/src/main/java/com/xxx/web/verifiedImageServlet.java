package com.xxx.web;

import com.xxx.util.VeryfiedImageGetterUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/imageServlet")
public class verifiedImageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletOutputStream os = resp.getOutputStream();
        String s = VeryfiedImageGetterUtils.VerifyCodeUtils.outputVerifyImage(100, 50, os, 4);
        String verifyCode = req.getParameter("verifiedImage");
        HttpSession session = req.getSession();
        session.setAttribute("checkCodeGen",s);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
