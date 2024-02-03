package com.sunbase.javaassignment.DBOperation;

import com.sunbase.javaassignment.Customer;
import com.sunbase.javaassignment.DAO.CustomerDAOImpl;
import com.sunbase.javaassignment.DBConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.UUID;
@WebServlet("/newCustomer")
public class AddNewCustomer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
//                String uuid=req.getParameter("uuid");

                String uuid = UUID.randomUUID().toString();
                String firstName=req.getParameter("fname");
                String lastName=req.getParameter("lname");
                String street=req.getParameter("street");
                String address=req.getParameter("address");
                String city=req.getParameter("city");
                String email=req.getParameter("email");
                String phone=req.getParameter("phone");
                String state=req.getParameter("state");

            Customer c=new Customer( uuid,  firstName,  lastName,  street,
                     address,  city,  state,  email,  phone);
            CustomerDAOImpl dao =new CustomerDAOImpl(DBConnect.getConn());


            boolean f=dao.addCustomer(c);
            HttpSession session=req.getSession();

            if(f){
                session.setAttribute("Msg","New Customer Add Successfully");
                resp.sendRedirect("addCustomer.jsp");

            }else{
                session.setAttribute("Failed","Something went wrong");
                resp.sendRedirect("addCustomer.jsp");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
