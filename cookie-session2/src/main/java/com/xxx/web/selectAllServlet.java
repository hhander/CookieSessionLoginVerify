package com.xxx.web;

import com.xxx.pojo.brand;
import com.xxx.service.DataTransfer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.List;

@WebServlet("/selectAll")
public class selectAllServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DataTransfer dt = new DataTransfer();
        List<brand> brands = dt.selectAll();
        req.setAttribute("brands",brands);
        req.getRequestDispatcher("selectAll.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
