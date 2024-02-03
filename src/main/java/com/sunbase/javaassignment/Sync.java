package com.sunbase.javaassignment;

import com.nimbusds.jose.shaded.gson.Gson;
import com.nimbusds.jose.shaded.gson.reflect.TypeToken;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

@WebServlet("/sync")
public class Sync extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Connection conn = DBConnect.getConn();
        System.out.println(conn);

        HttpSession session = req.getSession();
        String bearerToken = (String) session.getAttribute("bearerToken");
        if(bearerToken == null){
            resp.sendRedirect("login.jsp");
            return;
        }
        System.out.println("bearerToken = " + bearerToken);

        String token = bearerToken.substring(17, bearerToken.length() - 2);
        System.out.println("token = " + token);
        System.out.println("Sync.doGet");
        String url = "https://qa.sunbasedata.com/sunbase/portal/api/assignment.jsp?cmd=get_customer_list";
        System.out.println("This is Token : " + token);

        HttpURLConnection con = null;

        try {
            URL obj = new URL(url);
            con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Authorization", "Bearer " + token);
            con.setDoOutput(true);

            int responseCode = con.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
            StringBuilder response1 = new StringBuilder();
            String responseLine;
            while ((responseLine = br.readLine()) != null) {
                response1.append(responseLine.trim());
            }
            String responseData = response1.toString();
            System.out.println("Response Data: " + responseData);
            Gson gson = new Gson();

            List<Customer> customerList = gson.fromJson(responseData, new TypeToken<List<Customer>>() {}.getType());

            req.setAttribute("data", customerList);
            System.out.println("customerList = " + customerList);
            System.out.println(customerList.get(0).getFirst_name());

            try{
                for (Customer customer : customerList) {
                    System.out.println("customer = " + customer.getFirst_name());
                    String sql = "insert into customer(uuid,firstName,lastName,city,email,phone,address,state,street) values(?,?,?,?,?,?,?,?,?) ON DUPLICATE KEY UPDATE uuid = VALUES(uuid)";
                    System.out.println("sql = " + sql);
                    PreparedStatement ps = conn.prepareStatement(sql);

                    ps.setString(1, customer.getUuid());
                    ps.setString(2, customer.getFirst_name());
                    ps.setString(3, customer.getLast_name());
                    ps.setString(4, customer.getCity());
                    ps.setString(5, customer.getEmail());
                    ps.setString(6, customer.getPhone());
                    ps.setString(7, customer.getAddress());
                    ps.setString(8, customer.getState());
                    ps.setString(9, customer.getStreet());
                    ps.executeUpdate();
                }


            }catch (Exception e){
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (con != null) {
                con.disconnect();
            }
        }

        session.setAttribute("Msg","Customer List Sync Successfully !");
        resp.sendRedirect("home.jsp");
    }

    }
