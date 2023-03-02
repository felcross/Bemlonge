<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Detalhes do Pacote</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" type="image/x-icon" href="assets/logo-2.png">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="navbar.jsp" flush="true" />

	<div class="container col-8 ">
		<div class="text-center mt-3 mb-3">
			<h3>
				Pacote
				<s:property value="pacote.descricao" />
			</h3>
		</div>
		<div class="table-responsive">
			<table id="tabela-historico" class="table table-striped text-center">
				<thead>
					<tr>
						<th col-index=1 scope="col">Local de Partida</th>
						<th col-index=2 scope="col">Destino</th>
						<th col-index=3 scope="col">Preço</th>
						<th col-index=4 scope="col">Vagas</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="passeiosDTO">
						<tr>
							<th scope="row"><s:property value="localPartida" /></th>
							<td><s:property value="destino" /></td>
							<td class="preco"><s:property value="preco" /></td>
							<td><s:property value="numVagas" /></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
		<div class="text-center">
			<a href="pacotesAdm.action" role="button" class="btn btn-primary">Voltar</a>
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
			<script src="js/jquery.js"></script>		
	<script src="js/currency.js"></script>
</body>
</html>