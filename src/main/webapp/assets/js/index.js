var app = {
	modalOpen : [],

	init : function() {
		app.verifyMessage();

		$(document).ajaxStart(app.openModal);
		$(document).ajaxComplete(app.closeModal);

		Handlebars.registerHelper('viewBoolean', function(bool) {
			return bool ? "SIM" : "NÃO";
		});
	},

	validateForm : function(form, errorClass, rules, messages, submitHandler) {
		$(form).validate({
			errorClass : errorClass,
			rules : rules,
			messages : messages,
			submitHandler : submitHandler
		});
	},

	addEntity : function(path, form, success, error) {
		app.defaultAjaxCall(path, 'POST', $(form).serialize(), success, error);
	},

	removeEntity : function(path, success, error) {
		app.defaultAjaxCall(path, 'DELETE', {}, success, error);
	},

	findEntity : function(path, success, error) {
		app.defaultAjaxCall(path, 'GET', {}, success, error);
	},

	passId : function(path, success, error) {
		app.defaultAjaxCall(path, 'GET', {}, success, error);
	},

	listEntity : function(path, success, error) {
		app.defaultAjaxCall(path, 'GET', {}, success, error);
	},

	defaultAjaxCall : function(path, method, data, success, error) {
		$.ajax({
			url : path,
			type : method,
			data : data,
			success : function(response) {
				success(response);
			},
			error : function(e) {
				error(e);
			}
		});
	},

	openModal : function() {
		if (app.modalOpen.length == 0) {
			setTimeout(function() {
				$('#modalLoading').modal({
					backdrop : 'static',
					keyboard : false
				})
			}, 0);
		}

		app.modalOpen.push(true);
	},

	closeModal : function() {
		app.modalOpen.pop();

		if (app.modalOpen.length == 0) {
			setTimeout(function() {
				$('#modalLoading').modal('toggle');
				$('.modal-backdrop').remove();
			}, 0);
		}
	},

	verifyMessage : function() {
		var message = sessionStorage.getItem('message');

		if (message != "") {
			var type = sessionStorage.getItem('message_type');
			this.message(type, message);
		}
	},

	prepareSuccessMessage : function(message) {
		sessionStorage.setItem('message', message);
		sessionStorage.setItem('message_type', "success");
	},

	prepareErrorMessage : function(message) {
		sessionStorage.setItem('message', message);
		sessionStorage.setItem('message_type', "danger");
	},

	showSuccessMessage : function(message) {
		this.message('success', message);
	},

	showErrorMessage : function(message) {
		this.message('danger', message);
	},

	message : function(type, message) {
		var source = $("#alert-template").html();
		var template = Handlebars.compile(source);

		var html = template({
			type : type,
			message : message
		});

		var readyAlert = $(html)[0];

		document.body.appendChild(readyAlert);
		setTimeout(function() {
			readyAlert.remove();
		}, 2000);

		sessionStorage.setItem('message', "");
		sessionStorage.setItem('message_type', "");
	},

	getUrlVars : function() {
		var vars = {};
		var parts = window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi,
				function(m, key, value) {
					vars[key] = value;
				});
		return vars;
	},

	addOptionsByName : function(option, values) {
		var joption = $(option);

		for (var i = 0; i < values.length; i++) {
			var opt = document.createElement("OPTION");

			opt.value = values[i].id;
			opt.innerHTML = values[i].nome;

			joption.append(opt);
		}
	}
};

$(document).ready(app.init);