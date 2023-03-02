<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Acesso do Cliente</title>
<link rel="icon" type="image/x-icon" href="assets/logo-2.png">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>

<body>
	<jsp:include page="navbarCliente.jsp" flush="true" />

		<h1 class="d-flex justify-content-center mt-5 text-center">Área do Cliente</h1>

	<div class="container mt-3 col-lg-8 col-md-6">
		<img src="assets/logo-2.png" class="float-right img-fluid" alt="..." style="opacity: 0.7;">
		<s:form id="formulario" action="consultaCadastro" cssClass="card-body mt-3"
			theme="simple" onsubmit="return validarTexto()">
				
				<h3 class="text-secondary col-4">Possui Cadastro?</h3>
				<div class="form-group col-md-6 col-4">
				<p>
					<s:if test="clienteDto.resultado==0">
						<p class="alert alert-danger">CPF não encontrado!</p>
					</s:if>
				</p>
					<div class="row col-md-auto ">
						<label for="cpf">CPF</label>
							<s:textfield id="CPF" label="CPF" name="clienteDto.cpf" maxlength="14"
								cssClass="form-control validarCpf"
								placeholder="222.222.222-22" required="true" />
					</div>
					<div id="divMensagemCPF" class="text-danger"></div>	
						
				</div>
				<div class="d-flex justify-content-end col-md-6 col-auto">
					<s:submit id="botao" cssClass="btn btn-primary col-sm-auto col-auto col-md-auto" value="Proximo" />
					<a class="btn btn-outline-primary ml-2 col-sm-auto col-auto col-md-auto" href="iniciarCliente.action" role="button">Criar Conta</a>
				
				</div>
		</s:form>
	</div>
	<script
		type="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js">
	</script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous">
		
	</script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="js/validarTamanhoTexto.js"></script>
	<script src="js/validacao.js"></script>
	<script src="js/jquery.mask.js"></script>
	<script src="js/mascaras.jquery.js"></script>

</body>
</html>