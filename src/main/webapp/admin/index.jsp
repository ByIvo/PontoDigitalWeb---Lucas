<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="models/start_page.jsp"%>
<%@include file="models/header.jsp"%>

<div class="page-header">

	<ol class="breadcrumb">
		<li class="active">Home</li>
	</ol>
</div>

<div class="container">
	<div
		class="col-xs-12 col-sm-10 col-md-8 col-lg-6 col-sm-offset-1 col-md-offset-2 col-lg-offset-3">
		<form id="form" class="form">
			<input type="text" name="id" id="id" hidden="true" />
			<div class="form-group">
				<label for="funcionarioId">Funcionario ID:</label> <input type="text"
					class="form-control" name="funcionario" id="funcionario"
					placeholder="ID do Funcionario"/>
			</div>
			<div class="form-group">
				<label for="entrada">Data de Entrada:</label> <input type="time"
					class="form-control" name="entrada" id="entrada"
					placeholder="Data de Entrada" readonly />
			</div>

			<div class="form-group">
				<label for="saida">Data de Saída:</label> <input type="time"
					class="form-control" name="saida" id="saida"
					placeholder="Data de Saída" readonly />
			</div>
			<div class="form-group">
				<button class="btn btn-primary" name="send" id="send">
					Registrar</button>
			</div>
		</form>
	</div>
</div>

<%@include file="models/scripts.jsp"%>
<script src="../assets/js/index_f.js"></script>
<%@include file="models/final_page.jsp"%>


