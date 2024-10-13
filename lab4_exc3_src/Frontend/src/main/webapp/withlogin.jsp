
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Arrays"%>
<%@page import="Helper.Scholarship"%>
<%@page import="Helper.ScholarshipXML"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Scholarships</title>
    </head>
    <style>
        body{
            background: -webkit-linear-gradient(85deg, #f3f2ef 50%, #fff 50%);
            margin: auto;
            height: 100vh;
        }
        .center{
            margin-left: auto;
            margin-right: auto;
        }
        
        #scholarships{
              border-collapse: collapse;
        }
        
        #scholarships td, #scholarships th {
            border: 1px solid lightgrey;
            padding: 8px;
        }
       
        #scholarships th {
            padding-top: 12px;
            padding-bottom: 12px;
            text-align: left;
            background-color: #acc8fa;
            color: black;
}   
    </style>
<body>
    <center><h2>Welcome <%=request.getAttribute("username")%></h2></center>
    <br>
    <center><p>Look through the scholarships in the table below. If you see any that interest you, click on the "Apply" button to write and submit an application.</p></center>
    <br>
    <form action="apply.html" method="post"> 
                <input type="hidden" name="pageName" value="apply"/>
                <table id="scholarships" class = "center">

                <tr>  
                    <th> Name </th>
                    <th> Description </th>
                    <th> Requirements </th>
                    <th> Due Date </th>
                    <th> Value </th>
                    <th> Apply </th>
                </tr>
                
                <tr>
                    <td>Ontario's Golden Student</td>
                    <td>For the smartest individuals.</td>
                    <td>GPA > 3.5</td>
                    <td>2023-07-30</td>
                    <td>500</td>
                    <td> <input type="submit" value="Apply" ></td>
                </tr>
                
                <tr>
                    <td>Women in Engineering</td>
                    <td>Open to all female undergrad engineering students.</td>
                    <td>Female Identifying</td>
                    <td>2023-09-30</td>
                    <td>750</td>
                    <td> <input type="submit" value="Apply" ></td>
                </tr>
               
                </table>
            </form>
        
</body>
</html>