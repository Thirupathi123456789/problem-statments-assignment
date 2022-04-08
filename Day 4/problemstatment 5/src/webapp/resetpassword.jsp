<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="yellow">
     <form action="ResetServlet" method="post">
     	 <center>
             <table border="1" width="30%" cellpadding="5" bgcolor="yellow" style="color:black">
                <thead>
                    <tr>
                        <th colspan="2">Enter Your Information Here</th>
                    </tr>
                </thead>
                <tbody>
                     <tr>
                        <td>
                            <b>Email:</b>
                        </td>
                        <td>
                            <input type="email" name="uemail" required>
							<span>* </span>
                        </td>
                    </tr>
                    <tr>
                        <td>User Name</td>
                        <td><input type="text" name="uname" required/>
                        <span>* </span>
                        </td>                        
                    </tr>
                     <tr>
                        <td><input type="submit" value="Submit" /></td>                        
                    </tr>
                </tbody>     
     </form>
</body>
</html>