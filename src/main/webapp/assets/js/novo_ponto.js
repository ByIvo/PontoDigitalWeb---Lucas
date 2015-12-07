var path = 'pontos/';

app.ponto = {
	init : function() {
		app.ponto.prepareForm();
		app.ponto.prepareCancelButton();
		app.ponto.verifyEditing();

	},

	findEntity : function(id) {
		var success = this.fillForm;

		var error = function(e) {
			app.showErrorMessage("Não foi possivel iniciar a edição!");
		};

		app.findEntity(path + id, success, error);
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
			entrada : {
				required : true
			},

			saida : {
				required : true,
			}
		};

		var messages = {
			entrada : 'Campo obrigatório!',
			saida : 'Campo obrigatório!'
		};

		app.validateForm('#form', 'invalidField', rules, messages, this.add);
	},

	prepareCancelButton : function() {
		$('#backButton').click(app.ponto.back);
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
		var e = new Date(entity.entrada).toUTCString();
		var s = new Date(entity.saida).toUTCString();

		if (entity) {
			form.id.value = entity.id;
			form.funcionario.id.value = entity.funcionario.id;
			form.funcionario.nome.value = entity.funcionario.nome;
			form.entrada.value = e;
			form.saida.value = s;
		}
	}
}

$(document).ready(app.ponto.init);