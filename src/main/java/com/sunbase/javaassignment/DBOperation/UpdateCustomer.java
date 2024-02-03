package com.sunbase.javaassignment.DBOperation;

import com.sunbase.javaassignment.Customer;
import com.sunbase.javaassignment.DAO.CustomerDAO;
import com.sunbase.javaassignment.DAO.CustomerDAOImpl;
import com.sunbase.javaassignment.DBConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
@WebServlet("/update")
public class UpdateCustomer extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            String uuid=req.getParameter("uuid");
            String firstName=req.getParameter("fname");
            String lastName=req.getParameter("lname");
            String street=req.getParameter("street");
            String address=req.getParameter("address");
            String city=req.getParameter("city");
            String email=req.getParameter("email");
            String phone=req.getParameter("phone");
            String state=req.getParameter("state");

            System.out.println("uuid = " + uuid);
            System.out.println("firstName = " + firstName);
            System.out.println("lastName = " + lastName);
            System.out.println("street = " + street);


            Customer c=new Customer();
            c.setUuid(uuid);
            c.setFirst_name(firstName);
            c.setLast_name(lastName);
            c.setStreet(street);
            c.setAddress(address);
            c.setCity(city);
            c.setEmail(email);
            c.setPhone(phone);
            c.setState(state);


            CustomerDAOImpl dao=new CustomerDAOImpl(DBConnect.getConn());
            System.out.println(c);
            boolean f= dao.editCustomer(c);
            System.out.println(f);
            HttpSession session=req.getSession();

            if(f){
                session.setAttribute("Msg","Customer Update Successfully..");
                resp.sendRedirect("editCustomer.jsp?uuid="+uuid);
            }else{
                session.setAttribute("Failed","Something went wrong !");
                resp.sendRedirect("editCustomer.jsp?uuid="+uuid);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
