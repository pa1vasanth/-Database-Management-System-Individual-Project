<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Add Employee</title>
    </head>
    <body>
        <h2>New Employee</h2>
        <!--
            Form for collecting user input for the new movie_night record.
            Upon form submission, add_movie.jsp file will be invoked.
        -->
        <form action="add_employee.jsp">
            <!-- The form organized in an HTML table for better clarity. -->
            <table border=1>
                <tr>
                    <th colspan="2">Enter the Employee Data:</th>
                </tr>
                <tr>
                    <td>Employee_Name:</td>
                    <td><div style="text-align: center;">
                    <input type=text name=e_name>
                    </div></td>
                </tr>
                <tr>
                    <td>Employee_Address:</td>
                    <td><div style="text-align: center;">
                    <input type=text name=e_address>
                    </div></td>
                </tr>
                <tr>
                    <td>Employee_Salary:</td>
                    <td><div style="text-align: center;">
                    <input type=text name=salary>
                    </div></td>
                </tr>
                <tr>
                    <td>Type_of_Employee:</td>
                    <td><div style="text-align: center;">
                    <input type=text name=type>
                    </div></td>
                </tr>
                <tr>
                    <td>Produce_Per_Day</td>
                    <td><div style="text-align: center;">
                    <input type=text name=produce_per_day>
                    </div></td>
                </tr>
                <tr>
                    <td>Type_of_Product</td>
                    <td><div style="text-align: center;">
                    <input type=text name=type_of_product>
                    </div></td>
                </tr>
                <tr>
                    <td>Position</td>
                    <td><div style="text-align: center;">
                    <input type=text name=position>
                    </div></td>
                </tr>
                <tr>
                    <td>Degree1</td>
                    <td><div style="text-align: center;">
                    <input type=text name=degree1>
                    </div></td>
                </tr>
                <tr>
                    <td>Degree2</td>
                    <td><div style="text-align: center;">
                    <input type=text name=degree2>
                    </div></td>
                </tr>
                <tr>
                    <td>Degree3</td>
                    <td><div style="text-align: center;">
                    <input type=text name=degree3>
                    </div></td>
                </tr>
                <tr>
                    <td><div style="text-align: center;">
                    <input type=reset value=Clear>
                    </div></td>
                    <td><div style="text-align: center;">
                    <input type=submit value=Insert>
                    </div></td>
                </tr>
            </table>
        </form>
    </body>
</html>
