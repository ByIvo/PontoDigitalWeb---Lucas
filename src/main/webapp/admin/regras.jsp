<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="models/start_page.jsp"%>
<%@include file="models/header.jsp"%>

<div class="page-header">
	<h1 class="text-center">Listagem de Regras</h1>

	<ol class="breadcrumb">
		<li><a href="index.jsp">Home</a></li>
		<li class="active">regras</li>
	</ol>
</div>

<div class="container">
	<div
		class="col-xs-12 col-sm-10 col-md-8 col-lg-8 col-sm-offset-1 col-md-offset-2 col-lg-offset-2">
		<div class="col-sm-12 text-right"
			style="margin: 10px 0px; padding: 0px;">
			<a href="novo_regra.jsp"
				class="col-sm-4 col-sm-offset-8 btn btn-primary">Novo</a>
		</div>
		<table id="table-results"
			class="data-table table table-striped table-hover table-bordered">
		</table>

		<div class="col-sm-12 text-center">
			<a href="index.jsp" class="col-sm-12 btn btn-default">Voltar</a>
		</div>
	</div>
</div>

<%@include file="models/scripts.jsp"%>
<script src="../assets/js/regras.js"></script>

<script id="data-table" type="text/x-handlebars-template">
 				<tr>
					<th class="id">Id</th>
					<th class="tipoDia">Tipo Dia</th>
					<th class="valor">Valor</th>
					<th class="porcentagemHoraExtra">Porcentagem da Hora Extra</th>
					<th class="horasTrabalho">Horas de trabalho</th>
					<th class="regraTrabalho">Regras de Trabalho</th>
					<th class="options">Opções</th>
				</tr>

		{{#each list}}
			<tr>
				<td class="id">{{id}}</td>
				<td class="tipoDia">{{tipoDia}}</td>
				<td class="valor">{{valor}}</td>
				<td class="porcentagemHoraExtra">{{porcentagemHoraExtra}}</td>
				<td class="horasTrabalho">{{horasTrabalho}}</td>
				<td class="regraTrabalho">{{regraTrabalho.nome}}</td>

				<td class="options">
					<a href="novo_regra.jsp?e={{id}}" class="btn btn-warning btn-sm" title="Alterar">
						<span class="glyphicon glyphicon-edit"></span>
					</a>

					<button onclick="app.regra.confirmDeletation({{id}});" class="btn btn-danger btn-sm" title="Remover">
						<span class="glyphicon glyphicon-trash"></span>
					</button>
				</td>
			</tr>
		{{/each}}
</script>

<!-- Modal -->
<div class="modal fade" id="confirm" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">
					<Strong>Confirmar exclusão</Strong>
				</h4>
			</div>
			<div class="modal-body">
				<Strong>Deseja mesmo excluir?</Strong>
			</div>
			<div class="modal-footer">
				<button type="button" id="delete" class="btn btn-primary">Sim</button>
				<button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
			</div>
		</div>
	</div>
</div>

<%@include file="models/final_page.jsp"%>


