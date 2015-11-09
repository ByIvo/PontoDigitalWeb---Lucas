<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<div class="container">
            <div class="page-header">
                <h1>Cadastro de Funcionários</h1>
            </div>
            <form class="form">
                <div class="form-group">
                    <label> ID </label>
                    <input class="form-control" type="text" readonly/>
                </div>

                <div class="form-group">
                    <label> Nome completo </label>
                    <input class="form-control" type="text"/>
                </div>
                <div class="form-group">
                    <label> RG</label>
                    <input class="form-control" type="text"/>
                </div>
                <div class="form-group">
                    <label> CPF </label>
                    <input class="form-control" type="text"/>
                </div>
                <div class="form-group">
                    <label> Data de nascimento </label>
                    <input class="form-control" type="text"/>
                </div>
                <div class="dropdown">
                    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Cargos
                        <span class="caret"></span></button>
                    <ul class="dropdown-menu">
                        <li><a href="#">Cargo1</a></li>
                        <li><a href="#">Cargo2</a></li>
                        <li><a href="#">Cargo3</a></li>
                    </ul>
                </div>
                <div class="text-center">
                    <button class="btn btn-primary">Próximo</button>
                </div>
            </form>
        </div>
</body>
</html>