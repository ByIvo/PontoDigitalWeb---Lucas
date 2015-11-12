<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Login</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<form class="form-horizontal" role="form">
				<div class="form-group">
					<label for="campoEmail" class="col-sm-3 control-label">
						Email</label>
					<div class="col-sm-9">
						<input type="email" class="form-control" id="campoEmail"
							placeholder="Digite seu Email" required>
					</div>
				</div>
				<div class="form-group">
					<label for="campoSenha" class="col-sm-3 control-label">
						Senha</label>
					<div class="col-sm-9">
						<input type="password" class="form-control" id="campoSenha"
							placeholder="Digite sua senha" required>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-9">
						<div class="checkbox">
							<label> <input type="checkbox" /> Continuar Logado
							</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-3 col-sm-9"></div>
				</div>
				<div class="form-group last">
					<div class="col-sm-offset-3 col-sm-9">
						<button type="submit" class="btn btn-success btn-sm">
							Entrar</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>
