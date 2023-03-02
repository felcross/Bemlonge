<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Cadastro Cliente</title>
<link rel="icon" type="image/x-icon" href="assets/logo-2.png">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body>
	<jsp:include page="navbarCliente.jsp" flush="true" />

	<div class="container mt-3 col-lg-8 col-md-6">
		<h1 class="d-flex justify-content-center text-center">Cadastro
			Cliente</h1>
		<s:form action="cadastrarCliente" cssClass="card-body mt-3"
			theme="simple" onsubmit="return validarTexto()">
			<p>
				<s:if test="clienteDto.resultado==0">
					<p class="alert alert-danger">CPF já cadastrado</p>
				</s:if>
			</p>
			<p>
				<s:if test="clienteDto.validacaoCpf==0">
					<p class="alert alert-danger">CPF inválido</p>
				</s:if>
			</p>
			<div class="row">
				<div class="col-lg-6 col-md-12">
					<label for="nome">Nome completo</label>
					<s:textfield id="nome" required="true" label="Name"
						name="clienteDto.nome" cssClass="form-control validarTexto validador"
						placeholder="Digite seu nome..." />
					<div id="divMensagemNome" class="text-danger"></div>
				</div>
				<div class="col-lg-6 col-md-12">
					<label for="email">E-mail</label>
					<s:textfield id="email" required="true" type="email" label="EMAIL"
						name="clienteDto.email" cssClass="form-control"
						placeholder="email@example.com" />
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6 col-md-12">
					<label for="Telefone">Telefone</label>
					<s:textfield label="Telefone" required="true" type="tel"
						maxlength="14" id="TEL" name="clienteDto.telefone"
						cssClass="form-control validarTel" placeholder="(XX) XXXXX-XXXX"
						/>
					<div id="divMensagemTel" class="text-danger"></div>
				</div>
				<div class="col-lg-6 col-md-12">
					<label for="cpf">CPF</label>
					<s:textfield id="CPF" label="CPF" required="true" maxlength="14"
						name="clienteDto.cpf" tooltip="Enter your Name here"
						cssClass="form-control validarCpf " placeholder="000.000.000-00"
						/>
					<div id="divMensagem" class="text-danger"></div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6 col-md-12">
					<label for="RG">RG</label>
					<s:textfield id="RG" maxlength="12" required="true" label="RG"
						name="clienteDto.rg" cssClass="form-control validarRG"
						placeholder="Digite seu RG..." />
					<div id="divMensagemRG" class="text-danger"></div>
				</div>
				<div class="col-lg-6 col-md-12">
					<label for="org_exp_">Orgão Expedidor</label>
					<s:textfield id="orgExpedidor" label="orgaoExpedidor" required="true"
						name="clienteDto.orgExpedidor" cssClass="form-control validarOrgao"
						placeholder="Detran" />
					<div id="divMensagemOrgao" class="text-danger"></div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6 col-md-12">
					<label for="cep">CEP</label>
					<s:textfield id="cep" maxlength="9" label="CEP" required="true"
						name="clienteDto.endereco.cep" cssClass="form-control validarCEP"
						placeholder="00000-000" />
					<div id="divMensagemCEP" class="text-danger"></div>
				</div>
				<div class="col">
					<label for="endereco">Endereço</label>
					<s:textfield id="logradouro" label="endereco" required="true"
						name="clienteDto.endereco.logradouro" placeholder="Ex: Rua X, nº0..." cssClass="form-control" />
				</div>

			</div>
			<div class="row">
				<div class="col-lg-6 col-md-12">
					<label for="uf">UF</label>
					<s:select id="uf" label="uf" headerKey=""
						headerValue="--- Selecione ---" required="true"
						list="ufs" listValue="sigla" listKey="sigla"
						cssClass="form-control" name="clienteDto.endereco.uf" emptyOption="false" />
				</div>
				<div class="col">
					<label for="bairro">Bairro</label>
					<s:textfield id="bairro" label="bairro" required="true"
						name="clienteDto.endereco.bairro" placeholder="Ex: Centro" cssClass="form-control" />
				</div>
			</div>
			<s:submit id="botao"
				cssClass="btn btn-primary mt-4 col-lg-4 col-md-12 p-2"
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
		<script type="text/javascript" src="js/validarTamanhoTextoCliente.js"></script>
	<script src="js/validacao.js"></script>
	<script src="js/jquery.mask.js"></script>
	<script src="js/mascaras.jquery.js"></script>
	<script type="text/javascript" src="js/cepScript.js"></script>
	
</body>
</html>