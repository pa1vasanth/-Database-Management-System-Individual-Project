<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
    <meta charset="UTF-8">
        <title>Employees</title>
    </head>
    <body>
        <%@page import="jsp_azure_test.DataHandler"%>
        <%@page import="java.sql.ResultSet"%>
        <%
            // We instantiate the data handler here, and get all the movies from the database
            final DataHandler handler = new DataHandler();
            final ResultSet employee = handler.getAllEmployees();
        %>
        <!-- The table for displaying all the movie records -->
        <table cellspacing="2" cellpadding="2" border="1">
            <tr> <!-- The table headers row -->
              <td align="center">
                <h4> Employee Name</h4>
              </td>
              <td align="center">
                <h4>Employee Address</h4>
              </td>
              <td align="center">
                <h4>Salary</h4>
              </td>
              <!-- <td align="center">
                <h4>Type of Employee</h4>
              </td>
              <td align="center">
                <h4>Produce Per Day</h4>
              </td>
              <td align="center">
                <h4>Type of Product</h4>
              </td>
              <td align="center">
                <h4>Position</h4>
              </td>
              <td align="center">
                <h4>Degree 1</h4>
              </td>
              <td align="center">
                <h4>Degree 2</h4>
              </td>
              <td align="center">
                <h4>Degree 3</h4>
              </td> -->
            </tr>
            <%
               while(employee.next()) { // For each movie_night record returned...
                   // Extract the attribute values for every row returned
                   final String emp_name = employee.getString("e_name");
                   final String emp_address = employee.getString("e_address");
                   final String emp_salary = employee.getString("salary");
                   /* final String type_of_emp = employee.getString("type");
                   System.out.println(type_of_emp.getClass().getName());
                   final String produce_per_day = employee.getString("produce_per_day");
                   final String type_of_product = employee.getString("type_of_product");
                   final String position = employee.getString("position");
                   final String degree1 = employee.getString("degree1");
                   final String degree2 = employee.getString("degree2");
                   final String degree3 = employee.getString("degree3"); */
                   
                   out.println("<tr>"); // Start printing out the new table row
                   out.println( // Print each attribute value
                        "<td align=\"center\">" + emp_name +
                        "</td><td align=\"center\"> " + emp_address +
                        "</td><td align=\"center\"> " + emp_salary+ /* +
                        "</td><td align=\"center\"> " + type_of_emp +
                        "</td><td align=\"center\"> " + produce_per_day +
                        "</td><td align=\"center\"> " + type_of_product +
                        "</td><td align=\"center\"> " + position +
                        "</td><td align=\"center\"> " + degree1 + 
                        "</td><td align=\"center\"> " + degree2 +
                        "</td><td align=\"center\"> " + degree3 + */"</td>");
                   out.println("</tr>");
               }
               %>
          </table>
    </body>
</html>
