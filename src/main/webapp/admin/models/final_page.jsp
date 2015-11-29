<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script id="alert-template" type="text/x-handlebars-template">
    	<div class="alert alert-dismissible alert-{{type}}">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			{{message}}
		</div>
    </script>

<!-- Modal -->
<div class="modal fade" id="modalLoading" tabindex="-1" role="dialog"
	aria-labelledby="modalLoadingLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header text-center"
				style="background-color: #a00201"></div>
			<div class="modal-body text-center">

				<h4 class="modal-title" id="modalLoadingLabel">
					<span class="rotateInfinite glyphicon glyphicon-refresh"></span> <Strong>Carregando...</Strong>
				</h4>
			</div>
		</div>
	</div>
</div>

</body>
</html>