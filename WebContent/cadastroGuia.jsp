<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Cadastro Guia</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="icon" type="image/x-icon" href="assets/logo-2.png">
<script type="text/javascript">
	function reload() {
		document.getElementById("formulario").reset();
	}
	window.onload = reload;
</script>
</head>


<body>
<jsp:include page="navbar.jsp" flush="true" />

	<div class="container mt-5 w-50">

		<h1 class="d-flex justify-content-center mt-5 text-center">Cadastro Guia</h1>

		<s:form id="formulario" action="salvarGuia" cssClass="card-body mt-3"
			theme="simple" onsubmit="return validarTexto()">

			<p>
				<s:if test="guiaDto.resultado==0">
					<p class="alert alert-danger">CPF ja cadastrado</p>
				</s:if>
			</p>
			<p>
				<s:if test="guiaDto.validacaoCpf==0">
					<p class="alert alert-danger">CPF invalido</p>
				</s:if>
			</p>

			<div class="row">

				<div class="col-lg-6 col-sm-12 mt-3">
					<label for="nome">Nome completo</label>
					<s:textfield id="nome" label="Name" name="guiaDto.nome"
						cssClass="form-control validarNome validador" placeholder="Nome completo" required="true" />
					<div id="divMensagem" class="text-danger"></div>
				</div>

				<div class="col-lg-6 col-sm-12 mt-3">
					<label for="cpf">CPF</label>
					<s:textfield id="CPF" label="CPF" name="guiaDto.cpf" maxlength="14"
						cssClass="form-control validarCpf" placeholder="222.222.222-22" required="true" />
						<div id="divMensagemCPF" class="text-danger"></div>
				</div>

			</div>

			<s:submit id="botao" cssClass="btn btn-primary mt-4 col-lg-4 col-sm-12 p-2"
				value="Cadastrar" />

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