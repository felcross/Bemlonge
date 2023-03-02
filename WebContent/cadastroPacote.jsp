<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page language="java"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Cadastro Pacote</title>
<link rel="icon" type="image/x-icon" href="assets/logo-2.png">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script type="text/javascript">
	function reload() {
		document.getElementById("formulario").reset();
	}
	window.onload = reload;
</script>
</head>
<body>

	<jsp:include page="navbar.jsp" flush="true" />
	
	<div class="container fluid mt-5 col-lg-8 col-md-6" >

		<h1 class="d-flex justify-content-center mt-5 text-center">Cadastro Pacote</h1>

		<s:form action="salvarPacote" cssClass="card-body mt-3" theme="simple">

			<div class="row d-flex justify-content-center">

				<div class="col-lg-4 col-md-12 mt-3 ">
					<label for="nome">Descrição</label>
					<s:textfield  name="nome" label="nome" required="true"
						cssClass="form-control col-lg-12 validador" id="descricao" placeholder="Tour Rio de Janeiro" />
						<p>
						<s:if test="resultado==0">
							<p class="text-danger">Não pode começar em branco.</p>
						</s:if>
						</p>
				</div>

				<div class="col-lg-4 col-md-12 mt-3">
					<label for="dataEmbarque">Data de Embarque</label>
					<s:textfield id="dataEmbarque" label="dataEmbarque" required="true" type="date" min="" name="dataEmbarque"
						cssClass="form-control" />
				</div>
				
				<div class="col-lg-4 col-md-12 mt-3" id="datepicker">
					<label for="dataDesembarque">Data de Desembarque</label>
					<s:textfield id="dataDesembarque" label="dataDesembarque" required="true" type="date" min="" name="dataDesembarque"
						cssClass="form-control" />
				</div>				

			</div>

			<s:submit id="botao" cssClass="btn btn-primary mt-4 p-2 col-lg-3 col-md-12" value="Cadastrar" />
					
		</s:form>

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
	<script src="js/jquery.mask.js"></script>
	<script src="js/inputsData.js"></script>
	<script src="js/validacao.js"></script>
</body>
</html>