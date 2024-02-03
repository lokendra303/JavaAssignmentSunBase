package com.sunbase.javaassignment.DBOperation;

import com.sunbase.javaassignment.DAO.CustomerDAOImpl;
import com.sunbase.javaassignment.DBConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/delete")
public class DeleteCustomer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            String uuid=req.getParameter("uuid");
            System.out.println("uuid = " + uuid);
            CustomerDAOImpl dao =new CustomerDAOImpl(DBConnect.getConn());
            boolean f= dao.deleteCustomer(uuid);
            HttpSession session=req.getSession();

            if(f){
                session.setAttribute("Msg","Customer Delete Successfully..");
                resp.sendRedirect("home.jsp");
            }else{
                session.setAttribute("FailedMsg","Something went wrong !");
                resp.sendRedirect("home.jsp");
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
