var path = 'contratos/';

app.contrato = {
	searchOption : 0,
	init : function() {
		app.contrato.prepareForm();
		app.contrato.prepareCancelButton();
		app.contrato.findAndFillSelectors();
	},

	findAndFillSelectors : function() {
		var error = function(e) {
			app.showErrorMessage("Não foi possivel buscar outros valores!");
		};

		var findAndFillFilds = function(listPath, fillProccess) {
			var allReady = function(response) {
				app.contrato.searchOption--;
				fillProccess(response);

				if (app.contrato.searchOption == 0) {
					app.contrato.verifyEditing();
				}

				setTimeout(function() {
					$('.modal-backdrop').remove();
				}, 500);
			}

			app.listEntity(listPath, allReady, error);
		}

		// findFuncionarios
		app.contrato.searchOption++;
		findAndFillFilds("funcionarios", function(response) {
			app.addOptionsByName("#funcionario", response);
		});

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
			app.contrato.back();
		};
		b

		var error = function(e) {
			app
					.showErrorMessage("Ocorreu um erro ao tentar salvar as alterações!");
		};

		app.addEntity(path, '#form', success, error);
	},

	prepareForm : function() {
		var rules = {
				horasMensais: {
					 required: true,
					 number: true
			     },
			     
			     salario: {
					 required: true,
					 number: true
			     }
			    
		};

		var messages = {
			description : 'Campo obrigatório!'
		};

		app.validateForm('#form', 'invalidField', rules, messages, this.add);
	},

	prepareCancelButton : function() {
		$('#backButton').click(app.contrato.back);
	},

	back : function() {
		window.location.replace('contratos.jsp');
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
			form.horasMensais.value = entity.horasMensais;
			form.salario.value = entity.salario;
			form.dataContrato.value = entity.dataContrato;
			form.funcionario.value = entity.funcionario.id;

		}
	}
}

$(document).ready(app.contrato.init);