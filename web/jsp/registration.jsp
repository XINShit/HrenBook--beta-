<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="ru">
    <meta charset="UTF-8">
    <title>Авторизация</title>
    <script src="../js/jquery-1.11.0.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../css/global.css"/>
    <link rel="stylesheet" href="../css/login.css">
</head>
<body>
<div class="container">
    <form class="form-signin" action="/registration" method="post">
        <h2 class="form-signin-heading">Регистрация</h2>

        <div class="control-group" id="login">
            <div class="controls">
                <input type="text" class="input-block-level" placeholder="Login" name="login">
            </div>
        </div>

        <div class="control-group" id="password">
            <div class="controls">
                <input type="password" class="input-block-level" placeholder="Password" name="password">
            </div>
        </div>

        <div class="control-group" id="name">
            <div class="controls">
                <input type="text" class="input-block-level" placeholder="Name" name="name">
            </div>
        </div>

        <div class="control-group" id="lastname">
            <div class="controls">
                <input type="text" class="input-block-level" placeholder="Lastname" name="lastname">
            </div>
        </div>

        <div class="control-group" id="age">
            <div class="controls">
                <select name="age" class="input-block-level">
                    <%
                        for(int i = 10; i<85; i++) {
                            out.print("<option>"+i+"</option>");
                        }
                    %>
                </select>
            </div>
        </div>


        <input type="submit" class="btn btn-large btn-block btn-primary" value="Зарегистрироваться" name="action">
    </form>
</div>
</body>
</html>
