<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">

<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Cadastro Pacote-Passeio</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="icon" type="image/x-icon" href="assets/logo-2.png">

</head>


<body>
	<jsp:include page="navbar.jsp" flush="true" />

	<div class="container mt-5 w-50">

		<h1 class="d-flex justify-content-center mt-5 text-center">Cadastro
			Passeios no Pacote</h1>

		<s:form id="formulario" action="cadastrarPasseioPacote"
			cssClass="card-body mt-3" theme="simple">

			<div class="row">

				<div class=".dropdown-menu-right col-lg-6 col-md-12 mt-3">

					<div class=".dropdown-menu-right">
						<label for="descricao">Pacotes</label>
						<s:select headerKey="" headerValue="--- Selecione ---"
							id="descricao" label="listapacote" required="true" list="pacotes"
							listValue="descricao" cssClass="form-control"
							name="pacoteSelecionado" listKey="id" required="true" />
					</div>
				</div>

				<div class="col-lg-6 col-md-12 mt-3">
					<div class="col">
						<label>Passeios</label>
						<div class="dropdown show">
							<a class="btn btn-light dropdown-toggle"
								style="text-align: center" role="button" id="dropdownMenuLink"
								data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="false"> Selecione os passeios</a>

							<div class="dropdown-menu form-check" style="text-align: center"
								aria-labelledby="dropdownMenuLink">
								<s:checkboxlist list="passeios" name="passeioSelecionado" 
									cssClass="form-check col-5" listValue="destino"
									listKey="id"  />
							</div>
						</div>
						
						<div id="divMensagemCheckbox" class="text-danger"></div>
						
					</div>

				</div>
			</div>
			<s:submit id="botao" cssClass="btn btn-primary mt-4 col-lg-4 p-2"
				value="Cadastrar" onclick="return verificar()" />
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
		crossorigin="anonymous"></script>

	<script type="text/javascript" src="js/validacaoCheckboxList.js">
		
	</script>
</body>
</html>