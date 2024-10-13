
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Arrays"%>
<%@page import="Helper.*"%>
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
            .topnav {
  overflow: hidden;
  background-color: #e9e9e9;
}

.topnav a {
  float: center;
  display: block;
  color: black;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

.topnav a:hover {
  background-color: #ddd;
  color: black;
  
}

.topnav a.active {
  background-color: #2196F3;
  color: white;
}

.topnav .login-container {
  float: right;
  justify-content: center;
  
}

.topnav input[type=text] {
  padding: 6px;
  margin-top: 8px;
  font-size: 17px;
  border: none;
  width:120px;
  justify-content: center;
}

.topnav .login-container button {
  float: right;
  padding: 6px 10px;
  margin-top: 8px;
  margin-right: 16px;
  background-color: #555;
  color: white;
  font-size: 17px;
  border: none;
  cursor: pointer;
  justify-content: center;
}

.topnav .login-container button:hover {
  background-color: green;
  justify-content: center;
}


    </style>
<body>
    
    <center><h2>Welcome!</h2></center>
    <br>
    <center>
        Login into the system to be able to apply for scholarships.
          <form action="FrontEnd" method="post">
             <input type="hidden" name="pageName" value="login"/>
            <input type="text" placeholder="Username" name="username">
            <input type="password" placeholder="Password" name="psw">
            <button type="submit">Login</button>
          </form>
    </center>
    <center><p>Look through the scholarships in the table below. If you see any that interest you, please login/register to Apply.</p></center>
    <br>
    
                <input type="hidden" name="pageName" value="apply"/>
                <table id="scholarships" class = "center">

                <tr>  
                    <th> Name </th>
                    <th> Description </th>
                    <th> Requirements </th>
                    <th> Due Date </th>
                    <th> Value </th>
                </tr>
                
                <tr>
                    <td>Ontario's Golden Student</td>
                    <td>For the smartest individuals.</td>
                    <td>GPA > 3.5</td>
                    <td>2023-07-30</td>
                    <td>500</td>
                </tr>
                
                <tr>
                    <td>Women in Engineering</td>
                    <td>Open to all female undergrad engineering students.</td>
                    <td>Female Identifying</td>
                    <td>2023-09-30</td>
                    <td>750</td>
                </tr>
               
                </table>
            
        
</body>
</html>