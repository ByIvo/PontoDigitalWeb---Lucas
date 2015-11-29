<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="models/start_page.jsp"%>
<%@include file="models/header.jsp"%>

<div class="page-header">
	<h1 class="text-center">Cadastro de Contrato</h1>
	<ol class="breadcrumb">
		<li><a href="index.jsp">Home</a></li>
		<li><a href="contratos.jsp">Contratos</a></li>
		<li class="active">Cadastro</li>
	</ol>
</div>

<div class="container">
	<div
		class="col-xs-12 col-sm-10 col-md-8 col-lg-6 col-sm-offset-1 col-md-offset-2 col-lg-offset-3">
		<form id="form" class="form">
			<input type="hidden" name="id" id="id" />
			<div class="form-group">
				<label for="horasMensais">horasMensais:</label> <input type="text"
					class="form-control" name="horasMensais" id="horasMensais" maxlength="80"
					placeholder="horas Mensais" />
			</div>
			
			<div class="form-group">
				<label for="salario">Salário:</label> <input type="text"
					class="form-control" name="salario" id="salario"
					placeholder="Salário" />
			</div>
			
			<div class="form-group">
				<label for="dataContrato">data Contrato:</label> <input type="text"
					class="form-control" name="dataContrato" id="dataContrato"
					placeholder="Data do Contrato" />
			</div>
			
			<div class="form-group">
				<label for="description">Funcionário:</label> 
				<select class="form-control" name="funcionario" id="funcionario">
				</select>
			</div>

			<div class="form-group text-center">
				<button class="btn btn-primary" name="send" id="send">
					Salvar</button>

				<button id="backButton" type="reset" class="btn btn-default"
					name="reset" id="reset">Cancelar</button>
			</div>
		</form>
	</div>
</div>

<%@include file="models/scripts.jsp"%>
<script src="../assets/js/novo_contrato.js"></script>

<%@include file="models/final_page.jsp"%>