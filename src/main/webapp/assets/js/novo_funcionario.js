var path = 'funcionarios/';

app.funcionario = {
	searchOption : 0,
	init : function() {
		app.funcionario.prepareForm();
		app.funcionario.prepareCancelButton();
		app.funcionario.findAndFillSelectors();
	},

	findAndFillSelectors : function() {
		var error = function(e) {
			app.showErrorMessage("Não foi possivel buscar outros valores!");
		};

		var findAndFillFilds = function(listPath, fillProccess) {
			var allReady = function(response) {
				app.funcionario.searchOption--;
				fillProccess(response);

				if (app.funcionario.searchOption == 0) {
					app.funcionario.verifyEditing();
				}

				setTimeout(function() {
					$('.modal-backdrop').remove();
				}, 500);
			};

			app.listEntity(listPath, allReady, error);
		}

		// findCategories
		app.funcionario.searchOption++;
		findAndFillFilds("cargos/", function(response) {
			app.addOptionsByName("#cargo", response);
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
			app.funcionario.back();
		};

		var error = function(e) {
			app
					.showErrorMessage("Ocorreu um erro ao tentar salvar as alterações!");
		};

		app.addEntity(path, '#form', success, error);
	},

	update : function() {
		var success = Function(response)
		{
			app
					.showErrorMessage("Ocorreu um erro ao tentar salvar as alterações!");
		};

		app.addEntity(path, '#form', success, error);
	},

	prepareForm : function() {
		var rules = {
			nome : {
				required : true
			},

			rg : {
				required : true,
				number : true
			},

			cpf : {
				required : true,
				number : true
			},
			login : {
				required : true
			}

		};

		var messages = {
			nome : 'Campo obrigatório!',
			rg : 'Informe um número!',
			cpf : 'Informe um número!',
			login : 'Informe um Login (nome.sobrenome)'
		};

		app.validateForm('#form', 'invalidField', rules, messages, this.add);
	},

	prepareCancelButton : function() {
		$('#backButton').click(app.funcionario.back);
	},

	back : function() {
		window.location.replace('funcionarios.jsp');
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
			form.nome.value = entity.nome;
			form.rg.value = entity.rg;
			form.cpf.value = entity.cpf;
			form.login.value = entity.login;
			form.senha.value = entity.senha;
			form.cargo.value = entity.cargo.id;
		}
	}
};

// $("#cargo").change(function(event) {
// if ($(this).val() === "Another") {
// app.funcionario.add();
// app.funcionario.back();
// $('#hiddenInputContainer').toggleClass('hide');
// }
// });

$(document).ready(app.funcionario.init);