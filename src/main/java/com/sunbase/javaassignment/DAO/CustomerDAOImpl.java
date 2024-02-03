package com.sunbase.javaassignment.DAO;

import com.sunbase.javaassignment.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerDAOImpl implements CustomerDAO {
    private Connection conn;

    public CustomerDAOImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public boolean addCustomer(Customer c) {
        boolean f=false;
        try {
            String sql="insert into customer(uuid,firstName,lastName,city,email,phone,address,state,street) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setString(1,c.getUuid());
            ps.setString(2,c.getFirst_name());
            ps.setString(3,c.getLast_name());
            ps.setString(4,c.getCity());
            ps.setString(5,c.getEmail());
            ps.setString(6,c.getPhone());
            ps.setString(7,c.getAddress());
            ps.setString(8,c.getState());
            ps.setString(9,c.getStreet());
            int i= ps.executeUpdate();
            if(i==1){
                f=true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public boolean editCustomer(Customer c) {
        boolean f=false;
        try {
            String sql="update customer set firstName=?,lastName=?,city=?,email=?,phone=?,address=?,state=?,street=? where uuid=?";
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setString(1,c.getFirst_name());
            ps.setString(2,c.getLast_name());
            ps.setString(3,c.getCity());
            ps.setString(4,c.getEmail());
            ps.setString(5,c.getPhone());
            ps.setString(6,c.getAddress());
            ps.setString(7,c.getState());
            ps.setString(8,c.getStreet());
            ps.setString(9,c.getUuid());
            int i= ps.executeUpdate();
            if(i==1){
                f=true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public boolean deleteCustomer(String uuid) {
        boolean f= false;
        try {
            String sql="delete from customer where uuid=?";
            System.out.println("uuid = " + uuid);
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,uuid);
            int i=ps.executeUpdate();
            if(i==1){
                f=true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return f;
    }

    @Override
    public List<Customer> getCustomerList() {
        List<Customer> list=new ArrayList<Customer>();
        Customer b=null;

        try {
            String sql="select * from customer";
            PreparedStatement ps=conn.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                b=new Customer();
                b.setUuid(rs.getString(1));
                b.setFirst_name(rs.getString(2));
                b.setLast_name(rs.getString(3));
                b.setCity(rs.getString(4));
                b.setEmail(rs.getString(5));
                b.setPhone(rs.getString(6));
                b.setAddress(rs.getString(7));
                b.setState(rs.getString(8));
                list.add(b);

            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public Customer getCustomerByUuid(String uuid) {
        Customer c=null;
        try {
            String sql="select * from customer where uuid=?";
            PreparedStatement ps= conn.prepareStatement(sql);
            ps.setString(1,uuid);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                c=new Customer();
                c.setUuid(rs.getString(1));
                c.setFirst_name(rs.getString(2));
                c.setLast_name(rs.getString(3));
                c.setCity(rs.getString(4));
                c.setEmail(rs.getString(5));
                c.setPhone(rs.getString(6));
                c.setAddress(rs.getString(7));
                c.setState(rs.getString(8));
                c.setStreet(rs.getString(9));

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

        return c;
    }


}
