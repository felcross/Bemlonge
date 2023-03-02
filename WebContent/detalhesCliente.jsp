<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Detalhes do Cliente</title>
<link rel="icon" type="image/x-icon" href="assets/logo-2.png">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body>
	<jsp:include page="navbarCliente.jsp" flush="true" />

	<div class="container mt-3 col-lg-8 col-md-6">
		
			
			<div class="row">
				<div class="col-lg-6 col-md-12">
					<label for="nome">Nome completo</label>
					<s:textfield id="nome" required="true" 
						name="clienteDto.nome" cssClass="form-control validarTexto validador"
						placeholder="Digite seu nome..." readonly="true" />
					
				</div>
				<div class="col-lg-6 col-md-12">
					<label for="email">E-mail</label>
					<s:textfield id="email" required="true" type="email" 
						name="clienteDto.email" cssClass="form-control"
						placeholder="email@example.com" readonly="true" />
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6 col-md-12">
					<label for="Telefone">Telefone</label>
					<s:textfield required="true" type="tel"
						maxlength="14" id="TEL" name="clienteDto.telefone"
						cssClass="form-control validarTel" placeholder="(XX) XXXXX-XXXX"
						readonly="true"/>
					
				</div>
				<div class="col-lg-6 col-md-12">
					<label for="cpf">CPF</label>
					<s:textfield id="CPF" required="true" maxlength="14"
						name="clienteDto.cpf" tooltip="Enter your Name here"
						cssClass="form-control validarCpf " placeholder="000.000.000-00"
						readonly="true"/>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6 col-md-12">
					<label for="RG">RG</label>
					<s:textfield id="RG" maxlength="12" required="true"
						name="clienteDto.rg" cssClass="form-control validarRG"
						placeholder="Digite seu RG..." readonly="true"/>
				
				</div>
				<div class="col-lg-6 col-md-12">
					<label for="org_exp_">Orgão Expedidor</label>
					<s:textfield id="orgExpedidor" required="true"
						name="clienteDto.orgExpedidor" cssClass="form-control validarOrgao"
						placeholder="Detran" readonly="true"/>
			
				</div>
			</div>
			<div class="row">
				<div class="col-lg-6 col-md-12">
					<label for="cep">CEP:</label>
					<s:textfield id="cep" maxlength="9" required="true"
						name="clienteDto.endereco.cep" cssClass="form-control validarCEP"
						placeholder="00000-000" readonly="true" />
				</div>
				<div class="col">
					<label for="endereco">Endereço</label>
					<s:textfield id="logradouro" label="endereco" required="true"
						name="clienteDto.endereco.logradouro" placeholder="Ex: Rua X, nº0..." cssClass="form-control" readonly="true"/>
				</div>

			</div>
			<div class="row">
				<div class="col-lg-6 col-md-12">
					<label for="uf">UF</label>
					<s:textfield id="UF" required="true"
						name="clienteDto.endereco.bairro" placeholder="Ex: RJ" cssClass="form-control" readonly="true"/>
				</div>
				<div class="col">
					<label for="bairro">Bairro</label>
					<s:textfield id="bairro"  disable="true"
						name="clienteDto.endereco.bairro" placeholder="Ex: Centro" cssClass="form-control" readonly="true"/>
				</div>
			</div>
	</div>

	
	

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>

	
</body>
</html>