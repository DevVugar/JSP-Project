<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" type="text/css" href="styleRegister.css">
</head>
<body>
<h1>Register</h1>
<div class="container">
    <form action="register" method="post">

        <label for="username">Username</label>
        <input type="text" id="username" name="username" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>

        <button type="submit">Register</button>

    </form>

    <br>
    <br>

    <h4>Do you have account?</h4>
    <a href="index.jsp"><button>Log in</button></a>

</div>

<br/>

</body>
</html>
