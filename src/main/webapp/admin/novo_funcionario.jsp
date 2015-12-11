<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="models/start_page.jsp"%>
<%@include file="models/header.jsp"%>

<div class="page-header">
	<h1 class="text-center">Cadastro de Funcionários</h1>
	<ol class="breadcrumb">
		<li><a href="index.jsp">Funcionários</a></li>
		<li class="active">Cadastro</li>
	</ol>
</div>

<div class="container">
	<div
		class="col-xs-12 col-sm-10 col-md-8 col-lg-6 col-sm-offset-1 col-md-offset-2 col-lg-offset-3">
		<form id="form" class="form">
			<input type="hidden" name="id" id="id" />
			<div class="form-group">
				<label for="nome">Nome:</label> <input type="text"
					class="form-control" name="nome" id="nome" maxlength="80"
					placeholder="Nome" />
			</div>

			<div class="form-group">
				<label for="rg">RG:</label> <input type="text" class="form-control"
					name="rg" id="rg" maxlength="8" placeholder="RG" />
			</div>

			<div class="form-group">
				<label for="cpf">CPF:</label> <input type="text"
					class="form-control" name="cpf" id="cpf" maxlength="11"
					placeholder="Nome" />
			</div>
			
			<div class="form-group">
				<label for="login">Login:</label> <input type="text"
					class="form-control" name="login" id="login" maxlength="15"
					placeholder="Login" />
			</div>
			<div class="form-group">
				<label for="senha">Senha:</label> <input type="password"
					class="form-control" name="senha" id="senha"
					placeholder="Senha" />
			</div>
			
			<div class="form-group">
				<label for="description">Cargo:</label> 
				<select class="form-control" name="cargo" id="cargo">
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
<script src="../assets/js/novo_funcionario.js"></script>

<%@include file="models/final_page.jsp"%>