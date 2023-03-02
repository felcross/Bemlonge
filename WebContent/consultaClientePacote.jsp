<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="br.com.bemlonge.dto.PasseioDTO"%>
	<%@page import="br.com.bemlonge.facade.impl.PasseioServiceFacadeImpl"%>
	<%@page import="java.util.List" %>
<html>
<head>
<title>teste</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="icon" type="image/x-icon" href="assets/logo-2.png">
</head>


<body>

	<jsp:include page="navbarCliente.jsp" flush="true" />
 


	<div class="container w-50">
		<div class="row">
			<div class="col-12">
				<h1 class="d-flex justify-content-center mt-5 text-center">Possui
					Cadastro?</h1>
			</div>
		</div>
		<s:form id="formulario" action="pagamentoPacote"
							cssClass="card-body mt-3" theme="simple"
							onsubmit="return validarTexto()">
		<div class="row">
		
			<div class="col-lg-6">
				<div class="row">
					<div class="col-lg-7 col-sm-12 mt-3">

					
							<p>
								<s:if test="resultado==1">
									<p class="alert alert-danger">CPF não encontrado</p>
								</s:if>
							</p>
							
							<div style="width: 15rem;">
								<div class="align-middle">
									<label for="cpf">CPF</label>
									<s:textfield id="CPF" label="CPF" name="cpf" maxlength="14"
										cssClass="form-control validarCpf"
										placeholder="222.222.222-22" required="true" />
									<div id="divMensagemCPF" class="text-danger"></div>
								</div>
							</div>
					</div>
				</div>
				<div class="row mt-2">
					<div class="col-lg-12">
						<s:submit id="botao" cssClass="btn btn-primary" value="Proximo" />
						<a class="btn btn-secondary" href="iniciarCliente"
							role="button">Criar Conta</a>
					</div>
				</div>
			</div>
			<div class="col-lg-6 col-sm-12 mt-3">
			  <div class="card" style="width: 18rem;">
                      <div class="card-header">
                           <h3><s:property value="detalhePacoteDTO.descricao" /></h3>
                                 </div>
                                    <ul class="list-group list-group-flush">
                                      <li class="list-group-item">		         
                                          <p>Data de Embarque: <s:property value="detalhePacoteDTO.dataEmbarque" /></p>
		                                  <p>Data de Desembarque: <s:property value="detalhePacoteDTO.dataDesembarque" /></p>
		                                  <small class="font-weight-bold text-secondary" style="font-size: 1rem;">Preço:</small>
										  <small class="font-weight-bold text-secondary preco" style="font-size: 1rem;"><s:property value="precoDosPasseiosSelecionados" /></small>
		                              </li>
		                              <li class="list-group-item">
		                                  Passeios selecionados:
		                                  <p class="font-weight-light">
		                                  <s:iterator value="passeiosDTO" status="stat">
		                                  	<s:property value="destino" />;
		                                  	<s:hidden name="passeios[%{#stat.index}].destino" value="%{destino}"/>
		                                  	<s:hidden name="passeios[%{#stat.index}].id" value="%{id}"/>
		                                  	
		                                  	<s:hidden name="passeiosDTO[%{#stat.index}].destino" value="%{destino}"/>
		                                  	<s:hidden name="passeiosDTO[%{#stat.index}].id" value="%{id}"/>
		                                  </s:iterator></p>
		                              </li>
                                    </ul>
                               </div>
			</div>
			
		</div>
		<s:hidden name="preco" value="%{precoDosPasseiosSelecionados}"/>
		<s:hidden name="pacote.dataEmbarque" value="%{detalhePacoteDTO.dataEmbarque}"/>
		<s:hidden name="pacote.descricao" value="%{detalhePacoteDTO.descricao}"/>
		<s:hidden name="pacote.dataDesembarque" value="%{detalhePacoteDTO.dataDesembarque}"/>
		<s:hidden name="pacote.id" value="%{id}"/>
		
		
		<s:hidden name="precoDosPasseiosSelecionados" value="%{precoDosPasseiosSelecionados}"/>
		<s:hidden name="dataEmbarque" value="%{dataEmbarque}"/>
		<s:hidden name="descricao" value="%{descricao}"/>
		<s:hidden name="dataDesembarque" value="%{dataDesembarque}"/>
		<s:hidden name="id" value="%{id}"/>
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
	<script type="text/javascript" src="js/validarTamanhoTexto.js"></script>
	<script src="js/validacao.js"></script>
	<script src="js/jquery.mask.js"></script>
	<script src="js/mascaras.jquery.js"></script>
	<script src="js/currency.js"></script>
</body>
</html>