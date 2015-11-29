<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="models/start_page.jsp"%>
<%@include file="models/header.jsp"%>

<div class="page-header">
	<h1 class="text-center">Cadastro de Regras</h1>
	<ol class="breadcrumb">
		<li><a href="index.jsp">Home</a></li>
		<li><a href="regras.jsp">Regras</a></li>
		<li class="active">Cadastro</li>
	</ol>
</div>

<div class="container">
	<div
		class="col-xs-12 col-sm-10 col-md-8 col-lg-6 col-sm-offset-1 col-md-offset-2 col-lg-offset-3">
		<form id="form" class="form">
			<input type="hidden" name="id" id="id" />
			<div class="form-group">
				<label for="tipoDia">tipoDia:</label> <input type="text"
					class="form-control" name="tipoDia" id="tipoDia" maxlength="80"
					placeholder="Tipo Dia" />
			</div>
			
			<div class="form-group">
				<label for="valor">Valor:</label> <input type="text"
					class="form-control" name="valor" id="valor"
					placeholder="Valor" />
			</div>
			
			<div class="form-group">
				<label for="porcentagemHoraExtra">Porcentagem da Hora Extra:</label> <input type="text"
					class="form-control" name="porcentagemHoraExtra" id="porcentagemHoraExtra"
					placeholder="Porcentagem da Hora Extra" />
			</div>
			
			<div class="form-group">
				<label for="horasTrabalho">Horas de Trabalho:</label> <input type="text"
					class="form-control" name="horasTrabalho" id="horasTrabalho"
					placeholder="Horas Trabalho" />
			</div>
			
			<div class="form-group">
				<label for="description">Regras de Trabalho:</label> 
				<input type="text"
					class="form-control" name="regraTrabalho" id="regraTrabalho"
					placeholder="Regra de Trabalho" />
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
<script src="../assets/js/novo_regra.js"></script>

<%@include file="models/final_page.jsp"%>