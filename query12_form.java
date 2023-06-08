<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>  Retrieve Employee Data </title>
    </head>
    <body>
        <h2>Enter The salary range</h2>
        <!--
            Form for collecting user input for the new movie_night record.
            Upon form submission, add_movie.jsp file will be invoked.
        -->
        <form action="employee_query12.jsp">
            <!-- The form organized in an HTML table for better clarity. -->
            <table border=1>
                <tr>
                    <th colspan="2">Enter the Employee Data:</th>
                </tr>
                <tr>
                    <td>Salary</td>
                    <td>
                    <div style="text-align: center;">
                    <input type=text name="salary"/>
                    </div>
                    </td>
                </tr>
                <tr>
                    <td><div style="text-align: center;">
                    <input type=reset value=Clear>
                    </div></td>
                    <td><div style="text-align: center;">
                    <input type=submit value=Search>
                    </div></td>
                </tr>
            </table>
        </form>
    </body>
</html>
