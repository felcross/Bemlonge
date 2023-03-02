<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Consultar Guias</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="icon" type="image/x-icon" href="assets/logo-2.png">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.1/css/dataTables.bootstrap4.min.css">
</head>
<body>

	<jsp:include page="navbar.jsp" flush="true" />
	<div class="container mt-3 col-lg-12 col-md-6 text-center">
		<div class="btn-group" role="group" aria-label="Basic example">
		  <a href="listarClientesAdm.action" type="button" class="btn btn-outline-secondary btn-lg pl-5 pr-5 pt-0 pb-0">Cliente</a>
		  <a href="consultaPasseio.action" type="button" class="btn btn-outline-secondary btn-lg pl-5 pr-5 pt-0 pb-0">Passeio</a>
		  <a href="pacotesAdm.action" role="button" class="btn btn-outline-secondary btn-lg pl-5 pr-5 pt-0 pb-0" >Pacote</a>
		  <a href="guias.action" role="button" class="btn btn-secondary btn-lg pl-5 pr-5 pt-0 pb-0" >Guias</a>
		
		</div>
	</div>

	<div class="container w-100">
		<s:form id="formulario" action="filtrarGuias" cssClass="card-body "
			theme="simple" onsubmit="return valida()">
			<div
				class="container-fluid form-group d-inline-flex mt-3 justify-content-center">
				<div class="col-lg-6 col-sm-4 col-4">
					<s:textfield id="nome" label="Nome" name="guiaDto.nome"
						cssClass="form-control validador" placeholder="Buscar por nome..." />
					<div id="divMensagemNome" class="text-danger"></div>
				</div>
				<s:submit id="botao"
					cssClass="btn btn-outline-primary col-lg-1 col-md-4 h-50 col-sm-4 col-4"
					value="Filtrar" />
			</div>
		</s:form>
	</div>

	<div class="mt-3 col-lg-11 col-md-11 mx-auto w-75">
		<div class="table-responsive">
			<table id="guias" class="table table-striped text-center">
				<thead>
					<tr>
						<th class="text-center" col-index=1 scope="col">Nome</th>
						<th class="text-center" col-index=2 scope="col">CPF</th>
					</tr>
				</thead>
					<tbody>
						<s:iterator value="guias">
						<tr>
							<td><s:property value="nome" /></td>
							<td id="cpf"><s:property value="cpf" /></td>
						</tr>
						</s:iterator>
					</tbody>
				
			</table>
		</div>
	</div>

	<script type="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/validarTamanhoTextoCliente.js"></script>
	<script src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
	<script src="https://cdn.datatables.net/1.13.1/js/dataTables.bootstrap4.min.js"></script>
	<script src="//cdn.datatables.net/plug-ins/1.13.1/sorting/date-uk.js"></script>
	<script src="js/jquery.mask.js"></script>
	<script src="js/mascaras.jquery.js"></script>
	<script src="js/validacao.js"></script>
	<script src="js/dataTableGuias.js"></script>
	
</body>
</html>