<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Visualizar Cliente</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="icon" type="image/x-icon" href="assets/logo-2.png">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.13.1/css/dataTables.bootstrap4.min.css">

</head>

<body>
	<jsp:include page="navbarCliente.jsp" flush="true" />
	<div class="container mt-3 col-lg-8 col-md-9 ">

		<!-- 	Tabs -->
		<ul class="nav nav-tabs" id="myTab" role="tablist">
			<li class="nav-item"><a class="nav-link active" id="home-tab"
				data-toggle="tab" href="#dadosCliente" role="tab"
				aria-controls="home" aria-selected="true">Alterar Dados</a></li>
			<li class="nav-item"><a class="nav-link" id="profile-tab"
				data-toggle="tab" href="#historicoCliente" role="tab"
				aria-controls="profile" aria-selected="false">Histórico de
					Compra</a></li>
		</ul>
		<div class="tab-content border border-top-0" id="myTabContent">

			<!-- 		Alterar Dados -->
			<br>
			<s:if test="clienteDto.resultado==1">
				<div class="alert alert-success alert-dismissible fade show"
					role="alert">
					Dados alterados com sucesso
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
			</s:if>
			<div class="tab-pane fade show active" id="dadosCliente"
				role="tabpanel" aria-labelledby="home-tab">
				<s:form action="alterarCliente" cssClass="card-body mt-3"
					theme="simple" onsubmit="return validarTexto()">
					<div class="row">
						<div class="col-lg-6 col-md-6">
							<label for="nome">Nome completo</label>
							<s:textfield id="nome" required="true" label="Name"
								name="clienteDto.nome"
								cssClass="form-control validarTexto validador"
								placeholder="Digite seu nome..." />
							<div id="divMensagemNome" class="text-danger"></div>
						</div>
						<div class="col-lg-6 col-md-6">
							<label for="email">E-mail</label>
							<s:textfield id="email" required="true" type="email"
								label="EMAIL" name="clienteDto.email" cssClass="form-control"
								placeholder="email@example.com" />
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6 col-md-6">
							<label for="Telefone">Telefone</label>
							<s:textfield label="Telefone" required="true" type="tel"
								maxlength="14" id="TEL" name="clienteDto.telefone"
								cssClass="form-control validarTel" placeholder="(XX) XXXXX-XXXX" />
							<div id="divMensagemTel" class="text-danger"></div>
						</div>
						<div class="col-lg-6 col-md-6">
							<label for="cpf">CPF</label>
							<s:textfield id="CPF" label="CPF" required="true" maxlength="14"
								name="clienteDto.cpf" tooltip="Enter your Name here"
								cssClass="form-control validarCpf " placeholder="000.000.000-00"
								readonly="true" />
							<div id="divMensagem" class="text-danger"></div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6 col-md-6">
							<label for="RG">RG</label>
							<s:textfield id="RG" maxlength="12" required="true" label="RG"
								name="clienteDto.rg" cssClass="form-control validarRG"
								placeholder="Digite seu RG..." readonly="true" />
							<div id="divMensagemRG" class="text-danger"></div>
						</div>
						<div class="col-lg-6 col-md-6">
							<label for="org_exp_">Orgão Expedidor</label>
							<s:textfield id="org_exp" label="orgaoExpedidor" required="true"
								name="clienteDto.orgExpedidor"
								cssClass="form-control validarOrgao" placeholder="Detran"
								readonly="true" />
							<div id="divMensagemOrgao" class="text-danger"></div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6 col-md-6">
							<label for="cep">CEP</label>
							<s:textfield id="cep" maxlength="9" label="CEP" required="true"
								name="clienteDto.endereco.cep"
								cssClass="form-control validarCEP" placeholder="00000-000" />
							<div id="divMensagemCEP" class="text-danger"></div>
						</div>
						<div class="col">
							<label for="endereco">Endereço</label>
							<s:textfield id="logradouro" label="endereco" required="true"
								name="clienteDto.endereco.logradouro"
								placeholder="Ex: Rua X, nº0..." cssClass="form-control" />
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6 col-md-6">
							<label for="uf">UF</label>
							<s:select id="uf" label="uf" headerKey=""
								headerValue="--- Selecione ---" required="true" list="ufs"
								listValue="sigla" listKey="sigla" cssClass="form-control"
								name="clienteDto.endereco.uf" emptyOption="false" />
						</div>
						<div class="col">
							<label for="bairro">Bairro</label>
							<s:textfield id="bairro" label="bairro" required="true"
								name="clienteDto.endereco.bairro" placeholder="Ex: Centro"
								cssClass="form-control" />
						</div>
					</div>
					<s:submit id="botao"
						cssClass="btn btn-primary mt-4 col-lg-4 col-md-6 p-2"
						value="Salvar Alterações" />
				</s:form>
			</div>

			<!-- 		Histórico Cliente -->
			<div class="tab-pane fade" id="historicoCliente" role="tabpanel"
				aria-labelledby="profile-tab">
				<br>
				<div>
					<div class="row justify-content-end">			

						<!-- 				TABELA DE HISTORICO -->
						<div class="container col-12 ">
							<div class="table-responsive">
								<table id="tabela-historico"
									class="table table-striped text-center">
									<thead>
										<tr>
											<th class="text-center" col-index=1 scope="col">Item</th>
											<th class="text-center" col-index=2 scope="col">Preço</th>
											<th class="text-center" col-index=3 scope="col">Data da Compra</th>
											<th class="text-center" col-index=4 scope="col">Data da Realização</th>
											<th class="text-center" col-index=5 scope="col">Forma de Pagamento</th>
											<!-- 									<th col-index=6 scope="col"></th> -->
										</tr>
									</thead>
									<tbody>
										<s:iterator value="listaHistorico">
											<tr>
												<th scope="row"><s:if test="ordem==1">Pacote</s:if> <s:else>Passeio</s:else>
													<s:property value="descricao" /></th>
												<td class="preco"><s:property value="valorAPagar" /></td>
												<td><s:property value="dataCompra" /></td>
												<td><s:property value="dataEmbarque" /></td>
												<td><s:property value="tipo.getValorExibicao()" /> <s:if
														test="tipo.getValorExibicao()!='A Vista'">x<s:property
															value="numeroParcelas" />
													</s:if></td>
												<!-- 										<td><button type="button" class="btn btn-outline-primary">Detalhes</button></td> -->
											</tr>
										</s:iterator>
									</tbody>
								</table>
							</div>
						</div>
					</div>
				</div>
			</div>
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
	<script src="js/validacao.js"></script>
	<script src="js/filtrarMes.js"></script>
	<script src="js/jquery.mask.js"></script>
	<script src="js/mascaras.jquery.js"></script>
	<script type="text/javascript" src="js/cepScript.js"></script>
	<script src="//cdn.datatables.net/plug-ins/1.13.1/sorting/date-uk.js"></script>
	<script type="text/javascript" src="js/dataTableHistorico.js"></script>
	<script src="js/currency.js"></script>
</body>
</html>