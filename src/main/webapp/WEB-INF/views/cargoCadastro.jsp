<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="page-header">
			<h1>Cadastro de Cargos</h1>
		</div>
		<f:form method="POST"  action="cadastro" modelAttribute="cargo">
			<div class="form-group">
				<f:label path="id">ID</f:label>
				<f:input path="id"/>
			</div>
			<div class="form-group">
				<f:label path="nome"> Nome do cargo </f:label>
				<f:input path="nome"/>
			</div>
			<div class="form-group">
				<f:label path="horasMensais"> Horas Mensais </f:label>
				<f:input path="horasMensais"/>
			</div>

			<div class="text-center">
				<button class="command" type="submit">CADASTRAR</button>
			</div>
		</f:form>
	</div>
</body>
</html>