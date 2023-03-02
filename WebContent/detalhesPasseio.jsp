<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Detalhes Pedido</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="icon" type="image/x-icon" href="assets/logo-2.png">
<script type="text/javascript">
	function reload() {
		document.getElementById("formulario").reset();
	}
	window.onload = reload;
</script>
</head>


<body>
 
 <jsp:include page="navbarCliente.jsp" flush="true" />

<s:form id="formulario" action="detalharPasseioCad"
			cssClass="card-body mt-3" theme="simple">
	<div class="container mt-3 col-lg-8 col-md-6 ">
	<nav aria-label="breadcrumb">
	<ol class="breadcrumb justify-content-center mt-3 bg-light">
		<li class="breadcrumb-item active" aria-current="page">Detalhes</li>
		<li class="breadcrumb-item"><a href="#">Dados</a></li>
		<li class="breadcrumb-item"><a href="#">Pagamento</a></li>
	</ol>
	</nav>
	
	<div class="d-inline col-lg-4 float-right mt-5">
		<label id="agendar" for="agendar"><b>Agendar</b></label>
		<s:textfield id="dataEmbarque" required="true" label=""  type="date"
			min="" name="dataAgendamento" cssClass="form-control" />
			
			 <s:form action="detalharPasseioCad">	
                <s:textfield style="display:none;" name="id"></s:textfield>      
                   	<button type="submit" class="btn btn-primary mt-5 col-lg-12 col-sm-12"><i class="fa-solid fa-cart-shopping mr-2"></i>Continuar</button>
                  </s:form>

	</div>
		<div class="col-lg-6 col-sm-12 mt-3">
			  <div class="card" style="width: 18rem;">
                      <div class="card-header">
                           <h3>Passeio</h3>
                                 </div>
                                    <ul class="list-group list-group-flush">
                                      <li class="list-group-item">		
                                                      
                                          <h4>Guia:   <s:property value="passeioDTO.NomeGuia" /></h4>
                                          <p>Partida: <s:property value="passeioDTO.LocalPartida" /><br></p>
		                                  <p>Destino: <s:property value="passeioDTO.Destino" /></p>
		                                  <p>Vagas:   <s:property value="passeioDTO.NumVagas" /></p>
		                                  <small class="font-weight-bold text-secondary" style="font-size: 1rem;">Preço:</small>
										  <small class="font-weight-bold text-secondary preco" style="font-size: 1rem;"><s:property value="passeioDTO.Preco" /></small>
		                                  </li>
		                                  
                                    </ul>
                               </div>
			</div>

	</div>
	</s:form>
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
	<script src="js/currency.js"></script>
</body>
</html>