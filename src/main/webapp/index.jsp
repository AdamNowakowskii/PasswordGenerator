<%@ page import="app.PasswordGeneratorResult"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Password Generator</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <form action="PasswordGeneratorControler" method="post" >
        <h1>Random Password Generator</h1>
        <div id="password-div">
            <%PasswordGeneratorResult password = (PasswordGeneratorResult)request.getAttribute("password");%>
            <%if(password != null){%>
            <p id="password"><%=password.getResults() %></p>
            <%}%>
        </div>
        <div id="input-div">
            <label for="passwordLenght">Password Lenght</label>
            <input type="number" name="passwordLenght" id="passwordLenght"  min="4" max="32"  placeholder="4>">
            <input type="checkbox" id="uppercase" name="checkboxs" value="uppercase" checked>
            <label for="uppercase">Caplital letters</label><br>
            <input type="checkbox" id="lowercase" name="checkboxs" value="lowercase">
            <label for="lowercase">Small letters</label>
            <input type="checkbox" id="numbers" name="checkboxs" value="numbers">
            <label for="numbers">Numbers</label>
            <input type="checkbox" id="symbols" name="checkboxs" value="symbols">
            <label for="symbols">Special signs</label>
        </div>
        <div id="button-div">
            <button id="button" type="submit">Generate</button>
        </div>
    </form>
</body>
</html>
