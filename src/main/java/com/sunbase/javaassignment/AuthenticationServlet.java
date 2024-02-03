package com.sunbase.javaassignment;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

@WebServlet("/authentication")
public class AuthenticationServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String apiUrl = "https://qa.sunbasedata.com/sunbase/portal/api/assignment_auth.jsp";

        // User credentials
        String email = request.getParameter("email");
        String password = request.getParameter("password");
//        String loginId = "test@sunbasedata.com";
//        String password = "Test@123";

        // Construct JSON request body
        String requestBody = "{\"login_id\": \"" + email + "\", \"password\": \"" + password + "\"}";

        try {
            // Create URL object
            URL url = new URL(apiUrl);

            // Open connection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set the necessary HTTP method and headers
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json"); // Set content type to JSON

            // Enable input/output streams
            connection.setDoOutput(true);

            // Write the JSON request body to the output stream
            try (OutputStream outputStream = connection.getOutputStream()) {
                outputStream.write(requestBody.getBytes());
            }

            // Get the response code
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Read and process the API response
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                    StringBuilder responseBuilder = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        responseBuilder.append(line);
                    }

                    // Parse the JSON response to extract the Bearer token
                    String jsonResponse = responseBuilder.toString();
                    System.out.println("API Response: " + jsonResponse);

                    // Assuming the API response provides a Bearer token
                    String bearerToken = jsonResponse;

                    System.out.println("Bearer Token: " + bearerToken);

                    // Storing the bearer token in session
                    request.getSession().setAttribute("bearerToken", bearerToken);

                    response.sendRedirect("home.jsp");
                }
            } else {
                // Authentication failed
//                response.sendRedirect("/login.jsp?error=authentication_failed");
            }
        } catch (IOException e) {
            e.printStackTrace(); // Log the exception or handle it as appropriate
//            response.sendRedirect("/login.jsp?error=authentication_error");
        }
    }
}