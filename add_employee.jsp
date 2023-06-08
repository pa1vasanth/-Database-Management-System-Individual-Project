<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Query Result</title>
</head>
    <body>
    <%@page import="jsp_azure_test.DataHandler"%>
    <%@page import="java.sql.ResultSet"%>
    <%@page import="java.sql.Array"%>
    <%
    // The handler is the one in charge of establishing the connection.
    DataHandler handler = new DataHandler();

    // Get the attribute values passed from the input form.
    String e_name = request.getParameter("e_name");
    String e_address = request.getParameter("e_address");
    float salary = Float.parseFloat(request.getParameter("salary"));
    String type = request.getParameter("type");
    int produce_per_day = Integer.parseInt(request.getParameter("produce_per_day"));
    String type_of_product = request.getParameter("type_of_product");
    String position = request.getParameter("position");
    String degree1 = request.getParameter("degree1");
    String degree2 = request.getParameter("degree2");
    String degree3 = request.getParameter("degree3");

    /*
     * If the user hasn't filled out all the emp_name, emp_address, emp_salary and type_of_product. This is very simple checking.
     */
    if (e_name.equals("") || e_address.equals("") || request.getParameter("salary").equals("")) {
        response.sendRedirect("add_employee_form.jsp");
    } else {
        /* float salary = Float.parseFloat(sal); */
        /* int produce_per_day = Integer.parseInt(pro); */
        
        // Now perform the query with the data from the form.
        boolean success = handler.addEmployee(e_name, e_address, salary, type, produce_per_day, 
        		type_of_product, position, degree1, degree2, degree3);
        if (!success) { // Something went wrong
            %>
                <h2>There was a problem inserting the Employee</h2>
            <%
        } else { // Confirm success to the Employee.
            %>
            <h2>New Employee:</h2>

            <ul>
                <li>Employee Name: <%=e_name%></li>
                <li>Employee Address: <%=e_address%></li>
                <li>Employee Salary: <%=salary%></li>
                <li>Type of Employee: <%=type%></li>
                <li>Produce Per Day: <%=produce_per_day%></li>
                <li>Type_of_Product: <%=type_of_product%></li>
                <li>Position: <%=position%></li>
                <li>Degree1: <%=degree1%></li>
                <li>Degree2: <%=degree2%></li>
                <li>Degree3: <%=degree3%></li>
            </ul>

            <h2>Was successfully inserted.</h2>
            
            <a href="get_all_employees.jsp">See all Employee Details.</a>
            <%
        }
    }
    %>
    </body>
</html>
