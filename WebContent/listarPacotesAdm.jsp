<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar Pacotes ADM</title>
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
		  <a href="consultaPasseio.action" type="button" class="btn btn-outline-secondary btn-lg pl-5 pr-5 pt-0 pb-0">Passeio</a>
		  <a href="pacotesAdm.action" role="button" class="btn btn-secondary btn-lg pl-5 pr-5 pt-0 pb-0" >Pacote</a>
		  <a href="guias.action" role="button" class="btn btn-outline-secondary btn-lg pl-5 pr-5 pt-0 pb-0" >Guias</a>
		</div>
	</div>
	
	<div class="container w-100">
		<s:form id="formulario" action="filtrarPacotesAdm" cssClass="card-body " theme="simple"
			onsubmit="return valida()">
			<div
				class="container-fluid form-group d-inline-flex mt-3 justify-content-center">
				<div class="col-lg-6 col-sm-4 col-4">
					<s:textfield id="nome" label="Nome" name="nome"
						cssClass="form-control validador" placeholder="Buscar por descrição" />
					<div id="divMensagemNome" class="text-danger"></div>
				</div>
				<s:submit id="botao"
					cssClass="btn btn-outline-primary col-lg-1 col-md-4 h-50 col-sm-4 col-4"
					value="Filtrar" />
			</div>
		</s:form>
	</div>

	<div class="col-12 ">
		<div class="table-responsive container col-10">
			<table id="Tabela" class="table table-striped text-center">
				<thead>
					<tr>
						<th class="text-center" col-index=1 scope="col">Descrição</th>
						<th class="text-center" col-index=2 scope="col">Data de Embarque</th>
						<th class="text-center" col-index=3 scope="col">Data de Desembarque</th>
						<th class="text-center" col-index=4 scope="col">Preço</th>
						<th class="text-center" col-index=5 scope="col">Detalhes</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="pacotes" var="pacote">
						<tr>
							<th scope="row"><s:property value="descricao" /></th>
							<td><s:property value="dataEmbarque" /></td>
							<td><s:property value="dataDesembarque" /></td>
							<td class="preco"><s:property value="preco" /></td>
							<td><a href="admDetalhesPacote?id=<s:property value="id" />&descricao=<s:property value="descricao"/>"
								class="btn btn-outline-primary">Ver Detalhes</a></td>
						</tr>
					</s:iterator>
				</tbody>
			</table>
		</div>
	</div>


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

	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script
		src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.13.1/js/dataTables.bootstrap4.min.js"></script>
		<script src="js/jquery.mask.js"></script>
	<script src="js/mascaras.jquery.js"></script>
	<script src="js/validacao.js"></script>
	<script type="text/javascript" src="js/dataTablePacotesAdm.js"></script>
	<script src="js/currency.js"></script>
</body>
</html>