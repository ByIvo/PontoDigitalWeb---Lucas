<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="models/start_page.jsp"%>
<%@include file="models/header.jsp"%>

<div class="page-header">
	<h1 class="text-center">Listagem de Pontos</h1>

	<ol class="breadcrumb">
		<li><a href="index.jsp">Home</a></li>
		<li class="active">Pontos</li>
	</ol>
</div>

<div class="container">
	<div
		class="col-xs-12 col-sm-10 col-md-8 col-lg-8 col-sm-offset-1 col-md-offset-2 col-lg-offset-2">
		<form class="form-inline">
			<div class="form-group">
				<label class="sr-only" for="data1">Período:</label><input
					type="date" class="form-control" id="data1">
			</div>
			<div class="form-group">
				<input type="date" class="form-control" id="data2">
			</div>
			<button type="submit" class="btn btn-default" onclick="obterValores">Buscar</button>
			
		</form>

		<table id="table-results"
			class="data-table table table-striped table-hover table-bordered">
		</table>
		<form class="form-inline">
			<div class="form-group">
				<label class="sr-only" for="horasNormais"></label>Horas Normais: <input
					type="text" class="form-control" id="horasNormais" readonly>
			</div>
			<div class="form-group">
				<label class="sr-only" for="valorNormal"></label>Valor Normal: <input
					type="text" class="form-control" id="valorNormal" readonly>
			</div>
		</form>
		<br/>
		<form class="form-inline">
		<div class="form-group">
			<input type="text" class="form-control" id="teste" readonly>
		</div>
			<div class="form-group">
				<label class="sr-only" for="horasExtras"></label>Horas Extras: <input
					type="text" class="form-control" id="horasExtras" readonly>
			</div>
			<div class="form-group">
				<label class="sr-only" for="valorExtra"></label>Valor Horas Extras:
				<input type="text" class="form-control" id="valorExtra" readonly>
			</div>
		</form>
		<br/>
		<form class="form-inline">
			<div class="form-group">
				<label class="sr-only" for="totalTrabalhado"></label>Total de Horas:
				<input type="text" class="form-control" id="totalTrabalhado"
					readonly>
			</div>
			<div class="form-group">
				<label class="sr-only" for="totalGanho"></label>Total Ganho: <input
					type="text" class="form-control" id="totalGanho" readonly>
			</div>
		</form>
		<div class="col-sm-12 text-center">
			<a href="index.jsp" class="col-sm-12 btn btn-default">Voltar</a>
		</div>
	</div>
</div>

<%@include file="models/scripts.jsp"%>
<script src="../assets/js/historico.js"></script>

<script id="data-table" type="text/x-handlebars-template">
 				<tr>
					<th class="id">Id</th>
					<th class="funcionario">Funcionário</th>
					<th class="entrada">Hora de Entrada</th>
					<th class="saida">Horas de Saída</th>					
					<th class="contrato">Contrato</th>
					<th class="options">Opções</th>
				</tr>

		{{#each list}}
			<tr>
				<td class="id">{{id}}</td>
				<td class="funcionario">{{funcionario.nome}}</td>
				<td class="entrada">{{entrada}}</td>
				<td class="saida">{{saida}}</td>
				<td class="contrato">
					<a href="novo_contrato.jsp?e={{id}}" class="btn btn-warning btn-sm" title="Contrato">
						<span class="glyphicon glyphicon-edit"></span>
					</a>
				</td>							
				<td class="options">
					<a href="novo_ponto.jsp?e={{id}}" class="btn btn-warning btn-sm" title="Alterar">
						<span class="glyphicon glyphicon-edit"></span>
					</a>

					<button onclick="app.ponto.confirmDeletation({{id}});" class="btn btn-danger btn-sm" title="Remover">
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


