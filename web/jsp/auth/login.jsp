<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head lang="ru">
    <meta charset="UTF-8">
    <title>Авторизация</title>
    <script src="../../js/jquery-1.11.0.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../../css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../../css/global.css"/>
    <link rel="stylesheet" href="../../css/login.css">
</head>
<body>
<div class="container">
    <form class="form-signin" action="/login" method="post">
        <h2 class="form-signin-heading">Авторизация</h2>

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
        ${error}
        <input type="submit" class="btn btn-large btn-block btn-primary" value="Войти" name="action">
    </form>
</div>
</body>
</html>
