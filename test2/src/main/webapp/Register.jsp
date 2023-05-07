<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script type="text/javascript">
function checkregister(){
	var fname = document.form.fname.value;
	var username = document.form.username.value;
	var password = document.form.password.value;
	var cnfrmpassword = document.form.cnfrmpassword.value;
	if (fname == null || fname==""){
		alert("Name Can't be blank");
		return false;
	}
	else if(username == null || username == ""){
		alert("Username can't be blank");
		return false;
	}
	else if(password == null || password ==""){
		alert("enter passwrod");
		return false;
	}
	else if(password.length<8){
		alert("password should be min 8 characters");
		return false;
	}
	else if(password!=cnfrmpassword){
		alert("password do not match");
		return false;
	}else{
		document.getElementById("myForm").submit();
	}
	
}
</script>
</head>
<body>
<center><h2>ENTER YOUR DETAILS</h2></center>
<form name="form" id="myForm" action="RegisterServelet" method="post" >
<table align="center">
<tr>
<tr>
<td>Full Name</td>
<td><input type="text" name="fname"/></td>
</tr>
<tr>
<td>User Name</td>
<td><input type="text" name="username"/></td>
</tr>
<tr>
<td>Password</td>
<td><input type="password" name="password"/></td>
</tr>
<tr>
<td>Confirm Password</td>
<td><input type="password" name="cnfrmpassword"/></td>
</tr>
<tr>
<td><%=(request.getAttribute("errMessage") == null) ? "": request.getAttribute("errMessage")%></td>
         </tr>
<tr>
<td><input type="button" value="Register" onclick="checkregister()"></input><input type="reset" value="Reset"></td>
</tr>
</table>
</form>
</body>
</html>