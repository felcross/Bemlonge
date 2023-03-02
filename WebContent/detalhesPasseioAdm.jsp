<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Editar Passeio</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>
<body>
	<s:set var="id"><s:property value="passeioDTO.id"/></s:set>

	<jsp:include page="navbar.jsp" flush="true" />

	<h2 class="text-center mt-4">Detalhes do Passeio</h2>

	
		<div class="container card-body col-10 mt-3"> 
			<div class="row">
				<div class="col-lg-6 col-md-12">
					<label>Local de Partida</label>
					<p readonly="true" class="form-control">
						<s:property value="passeioDTO.localPartida" />
					</p>
					<div id="divMensagemNome" class="text-danger"></div>
				</div>
				<div class="col-lg-6 col-md-12">
					<label for="destino">Destino</label>
					<p readonly="true" class="form-control">
						<s:property value="passeioDTO.destino" />
					</p>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6 col-md-12">
					<label for="preco">Preço</label>
					<p readonly="true" class="form-control">
						<s:property value="passeioDTO.preco" />
					</p>
					<div id="divMensagemTel" class="text-danger"></div>
				</div>
				<div class="col-lg-6 col-md-12">
					<label for="vagas">Vagas</label>
					<p readonly="true" class="form-control">
						<s:property value="passeioDTO.numVagas" />
					</p>
					<div id="divMensagem" class="text-danger"></div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6 col-md-12">
					<label for="guia">Guia</label>
					<p readonly="true" class="form-control">
						<s:property value="passeioDTO.nomeGuia" />
					</p>
					<div id="divMensagemRG" class="text-danger"></div>
				</div>
				<div class="col-lg-6 col-md-12 inline">
					<label>Status</label>
					<p class="form-control">
						<s:property value="passeioDTO.situacao" />
					</p>
				</div>				
			</div>
		</div>
		<s:form action="editar?idPasseio=%{#id}">
			<s:div>
			<s:select required="true" style="width: 20rem; margin-left: 8rem;"
						list="#{'1':'Ativar','2':'Inativar'}" name="status"
						cssClass="form-control col-12 validarOrgao" />
			<s:submit class="btn btn-primary mt-2 inline" 
					  style="width: 20rem; margin-left: 8rem;" value="Alterar"></s:submit>
			</s:div>
		</s:form>
		<div class="col text-center mt-3 mb-3">
			<a href="consultaPasseio.action" role="button" class="btn btn-primary mr-3">Voltar</a>
		</div>
		
	

	<script
		type="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
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
</body>
</html>