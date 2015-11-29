var path = 'cargos/';

app.cargo = {
	init: function() {
		app.cargo.prepareForm();
		app.cargo.prepareCancelButton();
		app.cargo.verifyEditing();
		
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
			app.cargo.back();
		};
		
		var error = function(e) {
			app.showErrorMessage("Ocorreu um erro ao tentar salvar as alterações!");
		};
		
		app.addEntity(path, '#form', success,error);
	},
	
	prepareForm: function() {
		 var rules = {
				 nome: {
					 required: true
			     },
			     
			     horasMensais: {
					 required: true,
					 number: true
			     },
			     
			     padraoHorasDiaTrabalho: {
					 required: true,
					 number: true
			     }
		 };
		 
		 var messages = {
				 nome: 'Campo obrigatório!',
				 horasMensais: 'Informe um número!',
				 padraoHorasDiaTrabalho: 'Informe um número!'
		 };
		
		app.validateForm('#form', 'invalidField',rules,messages, this.add);
	},
	
	prepareCancelButton: function() {
		$('#backButton').click(app.cargo.back); 
	},
	
	back: function() {
		window.location.replace('cargos.jsp');
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
			form.nome.value = entity.nome;
			form.horasMensais.value = entity.horasMensais;
			form.padraoHorasDiaTrabalho.value = entity.padraoHorasDiaTrabalho;
		}
	}
}

$(document).ready(app.cargo.init);