<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Consultar Cliente ADM</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.1/css/dataTables.bootstrap4.min.css">
<link rel="icon" type="image/x-icon" href="assets/logo-2.png">

</head>
<body>

	<jsp:include page="navbar.jsp" flush="true" />
	<div class="container mt-3 col-lg-12 col-md-6 text-center">
		<div class="btn-group" role="group" aria-label="Basic example">
		  <a href="listarClientesAdm.action" type="button" class="btn btn-secondary btn-lg pl-5 pr-5 pt-0 pb-0">Cliente</a>
		  <a href="consultaPasseio.action" type="button" class="btn btn-outline-secondary btn-lg pl-5 pr-5 pt-0 pb-0">Passeio</a>
		  <a href="pacotesAdm.action" role="button" class="btn btn-outline-secondary btn-lg pl-5 pr-5 pt-0 pb-0" >Pacote</a>
		  <a href="guias.action" role="button" class="btn btn-outline-secondary btn-lg pl-5 pr-5 pt-0 pb-0" >Guias</a>
		</div>
	</div>

	<div class="container w-100">
		<s:form id="formulario" action="filtrarClientesAdm"
			cssClass="card-body " theme="simple">
			<div
				class="container-fluid form-group d-inline-flex mt-3 justify-content-center">
				<div class="col-lg-6 col-sm-4 col-4">
					<s:textfield id="nome" label="Nome" name="filtroCliente"
						cssClass="form-control validador" placeholder="Buscar por nome..." />
					<div id="divMensagemNome" class="text-danger"></div>
				</div>
				<s:submit id="botao"
					cssClass="btn btn-outline-primary col-lg-1 col-md-4 h-50 col-sm-4 col-4"
					value="Filtrar" />
			</div>
		</s:form>
	</div>


	<div class="mt-3 col-lg-11 col-md-11 mx-auto">
		<div class="table-responsive">

			<table id="idTabela" class="table table-striped text-center">
				<thead>
					<tr>
						<th class="text-center" col-index=1 scope="col">Nome</th>
						<th id="cpf" class="text-center" col-index=2 scope="col">CPF</th>
						<th class="text-center" col-index=3 scope="col">Email</th>
						<th class="text-center" col-index=4 scope="col">Telefone</th>
						<th class="text-center" col-index=5 scope="col"></th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="listaClientes">
						<tr>
							<td><s:property value="nome" /></td>
							<td><s:property value="cpf" /></td>
							<td><s:property value="email" /></td>
							<td><s:property value="telefone" /></td>
							<td><s:if test="cpf!=null">
									<a class="btn btn-outline-primary"
										href="listarFaturaClienteAdmin?cpfConsultado=<s:property value="cpf"/>">Detalhes</a>
								</s:if></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>

	<script
		type="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/validarTamanhoTextoCliente.js"></script>
	<script
		src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.13.1/js/dataTables.bootstrap4.min.js"></script>
	<script src="//cdn.datatables.net/plug-ins/1.13.1/sorting/date-uk.js"></script>
	<script type="text/javascript" src="js/dataTableClientesAdm.js"></script>
	<script src="js/jquery.mask.js"></script>
	<script src="js/mascaras.jquery.js"></script>
	<script src="js/validacao.js"></script>
</body>
</html>