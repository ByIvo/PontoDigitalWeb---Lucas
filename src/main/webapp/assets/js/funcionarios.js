var path = 'funcionarios/';

app.funcionario = {
	init : function() {
		app.funcionario.listAll();
	},

	listAll : function() {
		var error = function(e) {
			app.showErrorMessage("Erro ao buscar os dados no servidor!");
		};
		
		app.listEntity(path, this.buildTable, error);
	},

	remove : function(id) {
		app.removeEntity(path, id, function() {
			
		}, function() {
			
		})
	},

	buildTable : function(list) {
		var source = $("#data-table").html();
		var template = Handlebars.compile(source);

		var html = template({
			list : list,
			path : path
		});
		$("#table-results")[0].innerHTML = html;
	},

	confirmDeletation : function(id) {
		var success = function(response) {
			app.funcionario.listAll();
			app.showSuccessMessage("Exclusão realizada com sucesso!");
			setTimeout(function() {
				$('.modal-backdrop').remove();
			}, 500);
		};

		var error = function(e) {
			app.showErrorMessage("Problema ao excluir!");
			$('.modal-backdrop').remove();
		};

		$('#confirm').modal({
			backdrop : 'static',
			keyboard : false
		}).one('click', '#delete', function() {
			$('#confirm').modal('toggle');
			app.removeEntity(path + "/" + id, success, error);
		});
	}
	//passID : function(id) {
	//	var success = function(response){
	//	app.passID("pontos/new/"+id, success, error);
	//	}
}

$( "#cargo" ).change(function(event) {
    if ($(this).val() === "Another") {
    	app.validateForm('#form', 'invalidField',rules,messages, this.add);
    	app.funcionario.back();
        $('#hiddenInputContainer').toggleClass('hide');        
    }
});
$(document).ready(app.funcionario.init);