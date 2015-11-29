<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="models/start_page.jsp"%>
<%@include file="models/header.jsp"%>

<div class="page-header">
	<h1 class="text-center">Cadastro de pontos</h1>
	<ol class="breadcrumb">
		<li><a href="index.jsp">Home</a></li>
		<li><a href="pontos.jsp">Pontos</a></li>
		<li class="active">Cadastro</li>
	</ol>
</div>

<div class="container">
	<div
		class="col-xs-12 col-sm-10 col-md-8 col-lg-6 col-sm-offset-1 col-md-offset-2 col-lg-offset-3">
		<form id="form" class="form">
			<input type="text" name="id" id="id" />
			<div class="form-group">
				<label for="funcionario">Funcionário:</label> <input type="text"
					class="form-control" name="funcionario" id="funcionario"
					placeholder="Funcionário" />
			</div>
			<div class="form-group">
				<label for="entrada">Data de Entrada:</label> <input type="time"
					class="form-control" name="entrada" id="entrada"
					placeholder="Data de Entrada" />
			</div>

			<div class="form-group">
				<label for="saida">Data de Saída:</label> <input type="time"
					class="form-control" name="saida" id="saida"
					placeholder="Data de Saída" />
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
<script src="../assets/js/novo_ponto.js"></script>

<%@include file="models/final_page.jsp"%>