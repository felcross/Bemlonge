<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Cadastro Passeio</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
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

	<div class="container fluid mt-5 w-50">

		<h1 class="d-flex justify-content-center mt-5 text-center">Cadastro
			Passeio</h1>

		<s:form id="formulario" action="salvarPasseio"
			cssClass="card-body mt-3" theme="simple"
			onsubmit="return validarTexto()">

			<p>
				<s:if test="resultado==0">
				</s:if>
			</p>

			<div class="row">
				<div class="col-lg-6 mt-3">
					<label for="localPartida">Local de Partida</label>
					<s:textfield label="LocalPartida" name="passeioDTO.LocalPartida"
						cssClass="form-control validar validador" placeholder="Ex. Pão de Acúcar" required="true" />
				</div>

				<div class="col-lg-6 mt-3">
					<label for="destino">Destino</label>
					<s:textfield label="Destino" name="passeioDTO.Destino"
						cssClass="form-control validar validador" placeholder="Ex. Cristo Redentor" required="true" />
				</div>
				<div class="col-lg-6 mt-3">
					<label for="preco">Preço</label>
					<s:textfield label="Preco" id="preco" name="passeioDTO.Preco" placeholder="R$ 00.00"
						cssClass="form-control" onkeyup="somenteNumeros(this)"
						required="true" maxlength="7"/>
				</div>

				<div class="col-lg-6 mt-3">
					<label for="numVagas">Vagas</label>
					<s:textfield label="numVagas" name="passeioDTO.NumVagas" placeholder="20"
						cssClass="form-control" required="true" maxlength="2"/>
				</div>

			</div>

			<label for="guia" class="mt-4">Guias Disponíveis:</label>
			<s:select id="idGuia" headerKey="" headerValue="Selecione o Guia:"
				list="guias" listValue="nome" listKey="id"
				cssClass="form-control mt-2" name="guiaEscolhido" emptyOption="false"
				required="true" />

			<s:submit id="botao"
				cssClass="btn btn-primary mt-4 p-2 col-lg-4 col-sm-12"
				value="Cadastrar" />
		</s:form>



	</div>

	<script src="js/script.js"></script>
	<script src="js/validarTamanhoTexto.js"></script>
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous">
	</script>
	<script src="js/jquery.mask.js"></script>
	<script src="js/mascaras.jquery.js"></script>
	<script src="js/validacao.js"></script>	

</body>
</html>