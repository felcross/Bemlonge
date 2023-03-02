<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Buscar Passeios</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="icon" type="image/x-icon" href="assets/logo-2.png">
<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
<script src="https://kit.fontawesome.com/8a1b6adff0.js" crossorigin="anonymous"></script>
<style>
#page-container {
  position: relative;
  min-height: 68vh;
}
 #form{
 	position: absolute;
  bottom: 0;
  width: 100%;
  height: 2.5rem;
   }
</style>

</head>
<body>
	<jsp:include page="navbarCliente.jsp" flush="true" />

<div id="page-container">
<div class="container mt-3 w-100">
			
		<h2 class="d-flex justify-content-center text-center">Buscar por Passeio</h2>

		<s:form id="formulario" action="filtrarPasseio" cssClass="card-body " theme="simple" onsubmit="return valida()" >
			<div class="row justify-content-center">
				<div class="col-lg-4 col-sm-4 col-4">
					<s:textfield id="destino" label="Destino"
						name="passeioDTO.destino" cssClass="form-control validador"
						placeholder="Digite seu destino..." />
					<div id="divMensagemNome" class="text-danger"></div>
				</div>
				<div class=".dropdown-menu-right col-lg-4 col-sm-4 col-4">
					<div class=".dropdown-menu-right ">
						<s:select headerKey="" headerValue="Selecione o preco" 
							id="preco" list="#{'1':'Até R$100','2':'Até R$ 200','3':'Até R$ 300','4':'Até R$ 500','5':'Até R$ 1000'}" 
							 cssClass="form-control "
							  name="precoFiltro"/> 
							 <div id="divMensagemPreco" class="text-danger"></div> 
					</div>
				</div>
			<s:submit id="botao" cssClass="btn btn-outline-primary col-lg-2 col-md-4 h-50 col-sm-4 col-4" value="Buscar" />
			</div>
		</s:form>
</div>
<s:if test="passeios.isEmpty()">
		<h3 class="text-center mt-5">Nenhum passeio encontrado</h3>
</s:if>			
<div class="card-deck row card-body w-100 p-3">

		<s:iterator value="passeios" var="passeio">
	 	 <div class="col-lg-4 col-md-6">
		    <div class="card-body card mt-3">
		      <h5 class="card-title"><s:property value="destino" /></h5>
		      <p class="card-text font-weight-light">Local de partida: <s:property value="localPartida"/></p>
		      <div class="d-flex justify-content-between">
		      	<div>
			      	<p class="mb-0 font-weight-bold text-secondary preco"><s:property value="preco" /></p>
		      	</div>
		      	<s:form action="detalharPasseio">
<%-- 		       <a href="consultaCadCliente.jsp?id=<s:property value="id"/>&destino=<s:property value="destino"/> --%>
<%-- 		      	 &preco=<s:property value="preco"/>&nomeGuia=<s:property value="nomeGuia"/>&localPartida=<s:property value="localPartida"/>" class="btn btn-primary"> --%>
<!-- 		      	</a> -->
		      	 
                  	<s:textfield style="display:none;" name="id"></s:textfield>
                   	<button type="submit" class="btn btn-primary"><i class="fa-solid fa-cart-shopping mr-2"></i>Comprar</button>
                  </s:form>
		      </div>
		    </div>
	 	 </div>
		</s:iterator>
	</div>
</div>


<div class="bg-light footer navbar-fixed-bottom">
  <div class="py-3 w-75">
  
	 <img src="assets/mensagem.png" class="float-left ml-5 pl-5" alt="..." style="width: 230px; height: 100px;"/>
			<h2 class="text-center font-weight-light">Inscreva-se para receber Ofertas Exclusivas!!</h2>
			<div class="row justify-content-end">
				<div class="col-8 mr-5">
				<button type="button" class="btn btn-outline-primary" data-toggle="modal" data-target="#exampleModal">
		 		 Quero me inscrever <i class="fa-sharp fa-solid fa-envelope-circle-check"></i>
				</button>
				</div>
			</div>
	
		<!-- Modal -->
		<div class="modal fade bd-example-modal-lg" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog modal-lg" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="exampleModalLabel">Receba Ofertas Personalizadas!</h5>
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
		          <span aria-hidden="true">&times;</span>
		        </button>
		      </div>
		      <s:form action="cadastrarClientePotencialPasseio" cssClass="justify-content-center" theme="simple">
			      <div class="modal-body">
			      	<div class="form-inline">
			      		<s:textfield id="nome" required="true" label="Name" name="clienteDto.nome" cssClass="form-control mb-2 mr-sm-2 w-25 validador" placeholder="Digite seu nome..." />
					 	<s:textfield  id="email" required="true" type="email" label="EMAIL" name="clienteDto.email" cssClass="form-control w-50 mb-2 mr-sm-2" placeholder="email@example.com"/>
						<button type="button" class="btn btn-secondary mb-2 mr-2" data-dismiss="modal">Voltar</button>
			        	<button type="submit" class="btn btn-primary mb-2">Salvar</button>
					</div>
			      	 <small class="form-text text-muted">Faça parte do nosso time!<a href="iniciarCliente.action" class="text-info"> Cadastre-se já</a>.</small>
			      </div>
		      </s:form>
		    </div>
		  </div>
		</div>
	</div>
</div>


	<script
		type="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.15/jquery.mask.min.js"></script>
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
		
	<script src="js/validarFiltroPasseio.js"></script>
	<script src="js/jquery.js"></script>
	<script src="js/currency.js"></script>
	<script src="js/validacao.js"></script>
	<script src="js/autocomplete.js"></script>
	
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
  	<script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	
</body>
</html>