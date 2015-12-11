var path = 'login';

app.login = {
	init : function() {
		app.login.prepareloginButton();
	},

	prepareloginButton : function() {
		$('#loginButton').click(app.login.login);
	},

	login : function(path, success, error) {
		app.defaultAjaxCall(path + login + senha, 'POST', $('#form').serialize, success, error);
	},
}

$(document).ready(app.funcionario.init);