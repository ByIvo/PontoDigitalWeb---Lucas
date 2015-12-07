var path = 'pontos/';

app.ponto = {
	init : function() {
		app.ponto.prepareForm();
		app.ponto.prepareCancelButton();
		app.ponto.verifyEditing();

	},

	findPontoByFuncionarioId : function(funcionarioId) {
		var success = this.fillPonto;

		var error = function(e) {
			app.showErrorMessage("Não foi possivel iniciar a edição!");
		};

		app.findEntity(path + id, success, error);

	},
	
	salvar : function(){
		var success = function(response) {
			app.prepareSuccessMessage('Cadastrado com sucesso!');
			app.ponto.back();
		};

		var error = function(e) {
			app
					.showErrorMessage("Ocorreu um erro ao tentar salvar as alterações!");
		};

		app.addEntity(path, '#form', success, error);
	},
	
	fillPonto : function(entity) {
		var form = $('#form')[0];
		if (entity){
				form.id.value = entity.id;
				form.entrada.value = entity.entrada;
				form.saida.value = entity.saida;			
		}
	},

	add : function() {
		var success = function(response) {
			app.prepareSuccessMessage('Cadastrado com sucesso!');
			app.ponto.back();
		};

		var error = function(e) {
			app
					.showErrorMessage("Ocorreu um erro ao tentar salvar as alterações!");
		};

		app.addEntity(path, '#form', success, error);
	},

	prepareForm : function() {
		var rules = {
			funcionario : {
				required : true
			}
		};

		var messages = {
			funcionario : 'Campo obrigatório!',
		};

		app.validateForm('#form', 'invalidField', rules, messages, this.add);
	},

	prepareCancelButton : function() {
		$('#backButton').click(app.ponto.back);
	},

	findPontoByFuncionario : function(path, success, error) {
		var success = this.fillForm;

		var error = function(e) {
			app.showErrorMessage("Não foi possivel iniciar a edição!");
		};
		app.findEntity(path + id, success, error);
	},

	back : function() {
		window.location.replace('pontos.jsp');
	},

	verifyEditing : function() {
		var vars = app.getUrlVars();

		if (vars['e']) {
			this.findEntity(vars['e']);
		}
	},

	fillForm : function(entity) {
		var form = $('#form')[0];
		if (entity) {
			form.id.value = entity.id;
			form.funcionario.value = entity.funcionario.id;
			form.funcionario.value = entity.funcionario.nome;
			form.entrada.value = entity.entrada;
			form.saida.value = entity.saida;
		}
	}
}

$(document).ready(app.ponto.init);