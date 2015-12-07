var path = 'pontos/';

app.ponto = {
	init : function() {
		app.ponto.listAll();
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
	
	obterValores : function(id, data1, data2){
		
		
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
			app.ponto.listAll();
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

//$(document).ready(app.ponto.init);