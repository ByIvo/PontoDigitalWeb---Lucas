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
                <h1>Cadastro de Cargos</h1>
            </div>
            <form class="form">
                <div class="form-group">
                    <label> ID </label>
                    <input class="form-control" type="text" readonly/>
                </div>

                <div class="form-group">
                    <label> Nome do cargo </label>
                    <input class="form-control" type="text"/>
                </div>
                <div class="form-group">
                    <label> Horas Mensais </label>
                    <input class="form-control" type="text"/>
                </div>

                <div class="text-center">
                    <button class="btn btn-primary">CADASTRAR</button>
                </div>
            </form>
        </div>
</body>
</html>