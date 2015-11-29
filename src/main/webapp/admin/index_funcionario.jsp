<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="models/start_page.jsp"%>
<%@include file="models/header_funcionario.jsp"%>

<div class="page-header">
	<h1 class="text-center"></h1>

	<ol class="breadcrumb">
		<li class="active">Home</li>
	</ol>
</div>

<div class="container">
	<div
		class="col-xs-12 col-sm-10 col-md-8 col-lg-8 col-sm-offset-1 col-md-offset-2 col-lg-offset-2">
		<div style="margin: 10px" class="col-sm-12 text-center">
			<a href="cargos.jsp" class="col-sm-12 btn btn-primary">Cargos</a>
		</div>
		<div style="margin: 10px" class="col-sm-12 text-center">
			<a href="contratos.jsp" class="col-sm-12 btn btn-primary">Contratos</a>
		</div>
		<div style="margin: 10px" class="col-sm-12 text-center">
			<a href="funcionarios.jsp" class="col-sm-12 btn btn-primary">Funcionários</a>
		</div>
		<div style="margin: 10px" class="col-sm-12 text-center">
			<a href="pontos.jsp" class="col-sm-12 btn btn-primary">Pontos</a>
		</div>
	</div>
</div>

<%@include file="models/scripts.jsp"%>

<%@include file="models/final_page.jsp"%>


