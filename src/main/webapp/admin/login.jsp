<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@include file="models/start_page.jsp"%>
<%@include file="models/header.jsp"%>
	<div class="container">
		<div class="row">
			<form class="form-horizontal" role="form">
				<div class="form-group">
					<label for="campoEmail" class="col-sm-3 control-label">
						Login</label>
					<div class="col-sm-9">
						<input type="text" class="form-control" id="login"
							placeholder="Digite seu Login" required>
					</div>
				</div>
				<div class="form-group">
					<label for="campoSenha" class="col-sm-3 control-label">
						Senha</label>
					<div class="col-sm-9">
						<input type="password" class="form-control" id="senha"
							placeholder="Digite sua senha" required>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-9">
						<div class="checkbox">
							<label> <input type="checkbox" id="checkBoxLogado"/> Continuar Logado
							</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-9"></div>
				</div>
				<div class="form-group last">
					<div class="col-sm-offset-3 col-sm-9">
						<button type="submit" id="login" name="login" class="btn btn-success btn-sm">
							Entrar</button>
					</div>
				</div>
			</form>
		</div>
	</div>
<%@include file="models/final_page.jsp"%>
