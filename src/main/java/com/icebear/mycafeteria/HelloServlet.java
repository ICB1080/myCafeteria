package com.icebear.mycafeteria;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.icebear.mycafeteria.entity.Customer;
import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Welcome to myCafeteria!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json");
        ObjectMapper mapper = new ObjectMapper();

        Customer c = new Customer();
        c.setEmail("yqin108@gmail.com");
        c.setPassword("1080");
        c.setFirstName("Yuzhou");
        c.setLastName("Qin");
        response.getWriter().println(mapper.writeValueAsString(c));
//
//        JSONObject customer = new JSONObject();
//        customer.put("email", "yqin108@gmail.com");
//        customer.put("name", "Yuzhou Qin");
//        customer.put("age", 24);
//        response.getWriter().println(customer);
    }

//    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
//        JSONObject jsonRequest = new JSONObject(IOUtils.toString(request.getReader()));
//        // read customer information from request body.
//        String email = jsonRequest.getString("email");
//        String firstName = jsonRequest.getString("first name");
//        String lastName = jsonRequest.getString("last name");
//        int age = jsonRequest.getInt("age");
//        // print these information in IDE
//        System.out.println("Email is " + email);
//        System.out.println("First name is " + firstName);
//        System.out.println("Last name is " + lastName);
//        System.out.println("Age is " + age);
//        // Return status = ok as response body to the client
//        response.setContentType("application/json");
//        JSONObject jsonResponse = new JSONObject();
//        jsonResponse.put("status", "ok");
//        response.getWriter().println(jsonResponse);
//    }
    public void destroy() {
    }
}