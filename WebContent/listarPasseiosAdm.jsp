<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Consultar Passeios ADM</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
	<link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.1/css/dataTables.bootstrap4.min.css">
	<link rel="icon" type="image/x-icon" href="assets/logo-2.png">
	
</head>
<body>

	<jsp:include page="navbar.jsp" flush="true" />
	<div class="container mt-3 col-lg-12 col-md-6 text-center">
		<div class="btn-group" role="group" aria-label="Basic example">
		  <a href="listarClientesAdm.action" type="button" class="btn btn-outline-secondary btn-lg pl-5 pr-5 pt-0 pb-0">Cliente</a>
		  <a href="consultaPasseio.action" type="button" class="btn btn-secondary btn-lg pl-5 pr-5 pt-0 pb-0">Passeio</a>
		  <a href="pacotesAdm.action" role="button" class="btn btn-outline-secondary btn-lg pl-5 pr-5 pt-0 pb-0" >Pacote</a>
		  <a href="guias.action" role="button" class="btn btn-outline-secondary btn-lg pl-5 pr-5 pt-0 pb-0" >Guias</a>
		</div>
	</div>

	<div class="container w-100">
		<s:form id="formulario" action="filtrarPasseiosAdm"
			cssClass="card-body " theme="simple" onsubmit="return valida()">
			<div
				class="container-fluid form-group d-inline-flex mt-3 justify-content-center">
				<div class="col-lg-6 col-sm-4 col-4">
					<s:textfield id="nome" label="Nome" name="passeioDTO.destino"
						cssClass="form-control validador" placeholder="Buscar por destino" />
					<div id="divMensagemNome" class="text-danger"></div>
				</div>
				<s:submit id="botao"
					cssClass="btn btn-outline-primary col-lg-1 col-md-4 h-50 col-sm-4 col-4"
					value="Filtrar" />
			</div>
		</s:form>
	</div>

	<div class="col-lg-12">
		<div class="container col-10">
			<table id="tabela-historico" class="table table-striped text-center">
				<thead>
					<tr>
						<th class="text-center" col-index=1 scope="col">Local de Partida</th>
						<th class="text-center" col-index=2 scope="col">Destino</th>
						<th class="text-center" col-index=3 scope="col">Preço</th>
						<th class="text-center" col-index=4 scope="col">Vagas</th>
						<th class="text-center" col-index=5 scope="col">Status</th>
						<th class="text-center" col-index=6 scope="col">Detalhes</th>
						<!-- 									<th col-index=6 scope="col"></th> -->
					</tr>
				</thead>
				<tbody>
					<s:iterator value="passeios">
						<tr>
							<td><s:property value="localPartida" /></td>
							<td><s:property value="destino" /></td>
							<td class="preco"><s:property value="preco" /></td>
							<td><s:property value="numVagas" /></td>
							<td><s:property value="situacao" /></td>
							<td><a href="editarPasseio?idPasseio=<s:property value="id" />"
								class="btn btn-outline-primary">Ver Detalhes</a></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
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
	<script src="//cdn.datatables.net/plug-ins/1.13.1/sorting/date-uk.js"></script>
	<script type="text/javascript" src="js/dataTableHistorico.js"></script>
	<script src="js/jquery.js"></script>
	<script
		src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.13.1/js/dataTables.bootstrap4.min.js"></script>
	<script src="js/currency.js"></script>
	<script src="js/jquery.mask.js"></script>
	<script src="js/mascaras.jquery.js"></script>
	<script src="js/validacao.js"></script>
</body>
</html>