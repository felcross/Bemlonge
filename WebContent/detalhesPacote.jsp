<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Detalhes do Pacote</title>
<link rel="icon" type="image/x-icon" href="assets/logo-2.png">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>

<body>
	<jsp:include page="navbarCliente.jsp" flush="true" />

	<div class="container mt-3 col-lg-8 col-md-6">
		

		<div class="d-inline col-lg-5 float-right ml-5 mt-5"
			style="border: 1px solid gray">
			<div id="divMensagemCheckbox" class="text-danger"></div>
			<s:form action="consultaCadPacote" cssClass="mt-3">
					
					<s:checkboxlist role="button" cssClass="mt-2" style="width: 6rem;"
					list="detalhesPacote" name="passeioSelecionado" 
					listValue="toString()" listKey="idPasseio" />
			
				<s:textfield style="display:none;" name="id"></s:textfield>
				<s:submit id="submit" class="btn btn-primary mt-3 col-12 mb-2" value="Continuar" onclick="return verificar()"></s:submit>
			</s:form>	
		</div>
		
		
	
		<div class="col-lg-7 col-sm-12 mt-5">
			<div class="card" style="height: 23rem;">
				<div class="card-header">
					<h2>Detalhes</h2>
				</div>
				<ul class="list-group list-group-flush">
					<li class="list-group-item mt-4">
						<h3>
							Pacote:
							<s:property value="descricao" />
						</h3> <br>
						<p>
							Data de embarque:
							<s:property value="dataEmbarque" />
						</p>
						<p>
							Data de desembarque:
							<s:property value="dataDesembarque" />
						</p>
						<div>
							Vagas Disponíveis: 
							<small style="font-size: 1rem;" id="vaga"><s:property value="vagasDisponiveis" /></small>
							<small style="font-size: 1rem;"> / <s:property value="vagas" /> <br></small>
							<p> </p>
						</div>
						<div>
						<small class="font-weight-bold text-secondary" style="font-size: 1rem;">Preço:</small>
						<small class="font-weight-bold text-secondary preco" style="font-size: 1rem;"><s:property value="precoPacote" /></small>
						</div>
					</li>
				</ul>
			</div>
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
		crossorigin="anonymous"></script>
	<script type="text/javascript" src="js/validacaoCheckboxList.js"></script>
	<script src="js/jquery.js"></script>
	<script src="js/teste.js"></script>
	<script src="js/currency.js"></script>
</body>
</html>