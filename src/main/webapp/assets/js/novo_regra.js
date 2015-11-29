var path = 'regras/';

app.regra = {
	init: function() {
		app.regra.prepareForm();
		app.regra.prepareCancelButton();
		app.regra.verifyEditing();
		
	},
	
	findEntity: function(id) {
		var success = this.fillForm;
		
		var error = function(e) {
			app.showErrorMessage("Não foi possivel iniciar a edição!");
		};
		
		
		app.findEntity(path + id,success, error);
	},
	
	add: function() {
		var success = function(response) 
		{
			app.prepareSuccessMessage('Cadastrado com sucesso!');
			app.regra.back();
		};
		
		var error = function(e) {
			app.showErrorMessage("Ocorreu um erro ao tentar salvar as alterações!");
		};
		
		app.addEntity(path, '#form', success,error);
	},
	
	prepareForm: function() {
		 var rules = {
				 valor: {
					 required: true,
					 number: true
			     },
			     
			     porcentagemHoraExtra: {
					 required: true,
					 number: true
			     },
			     
			     horasTrabalho: {
					 required: true,
					 number: true
			     }
		 };
		 
		 var messages = {
				 valor: 'Campo obrigatório!',
				 porcentagemHoraExtra: 'Informe um número!',
				 horasTrabalho: 'Informe um número!'
		 };
		
		app.validateForm('#form', 'invalidField',rules,messages, this.add);
	},
	
	prepareCancelButton: function() {
		$('#backButton').click(app.regra.back); 
	},
	
	back: function() {
		window.location.replace('regras.jsp');
	},
	
	verifyEditing: function() {
		var vars = app.getUrlVars();
		
		if(vars['e']) {
			this.findEntity(vars['e']);
		}
	},
	
	fillForm: function(entity) {
		var form = $('#form')[0];
		if(entity){
			form.id.value = entity.id;
			form.tipoDia.value = entity.tipoDia;
			form.valor.value = entity.valor;
			form.porcentagemHoraExtra.value = entity.porcentagemHoraExtra;
			form.regraTrabalho.value = entity.regraTrabalhos.id;
		}
	}
}

$(document).ready(app.regra.init);