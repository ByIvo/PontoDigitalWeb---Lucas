var path = 'regras/';

app.regra = {
	init : function() {
		app.regra.listAll();
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
			app.regra.listAll();
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
}

$(document).ready(app.regra.init);