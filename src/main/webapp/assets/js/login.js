var path = 'funcionarios/';

app.login = {
	init : function() {
		app.login.prepareloginButton();
		},

		// passID : function(id) {
		// var success = function(response){
		// app.passID("pontos/new/"+id, success, error);
		// }
	prepareloginButton: function() {
		$('#loginButton').click(app.login.login); 
	},
	
	login : function(path, success, error) {
		app.defaultAjaxCall(path, 'GET', {}, success, error);
	},
}

$(document).ready(app.funcionario.init);