<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <link rel="stylesheet" type="text/css" href="styleLogin.css">
</head>
<body>
<h1>Login</h1>
<div class="container">
    <form action="login" method="post">

        <label for="username">Username</label>
        <input type="text" id="username" name="username" required>

        <label for="password">Password</label>
        <input type="password" id="password" name="password" required>

        <button type="submit">Log in</button>

    </form>

    <br>

    <h5>Do you have not account?</h5>
    <a href="register.jsp"><button>Sign up</button></a>

</div>

<br/>

</body>
</html>
