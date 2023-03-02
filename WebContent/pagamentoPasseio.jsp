<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<head>
<title>Pagamento Passeio</title>
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
		<s:form cssClass="card-body mt-3" theme="simple"
			action="realizarCompraPasseio">

			<nav aria-label="breadcrumb">
			<ol class="breadcrumb justify-content-center mt-3 bg-light">
				<li class="breadcrumb-item"><a href="">Detalhes</a></li>
				<li class="breadcrumb-item"><a href="#">Dados</a></li>
				<li class="breadcrumb-item active" aria-current="page">Pagamento</li>
			</ol>
			</nav>

			<div class="row">

				<div class="col-lg-6 col-sm-12 mt-5">
					
					<div class="col-lg-6 col-sm-12 mt-3">
						<div class="card" style="width: 18rem;">
							<div class="card-header">
								<h3>Passeio</h3>
							</div>
							<ul class="list-group list-group-flush">
								<li class="list-group-item">

									<h4>
										Guia:
										<s:property value="passeio.NomeGuia" />
									</h4>
									<p>
										Partida:
										<s:property value="passeio.LocalPartida" />
										<br>
									</p>
									<p>
										Destino:
										<s:property value="passeio.Destino" />
									</p>
									<p class="font-weight-bold text-secondary">
										Preço:
										<s:property value="passeio.Preco" />
									</p>
									<p>
										Data selecionada:
										<s:property value="dataAgendamento" />
									</p>
								</li>
							</ul>
						</div>
					</div>

				</div>

				<div class="col-lg-6 col-sm-12 mt-5">
					<div class="row">

						<div class="col-lg-6 col-md-12">
							<label for="nome">Nome</label>
							<s:textfield id="nome" required="true" label="Name"
								name="cliente.nome" cssClass="form-control" readonly="true"
								key="cliente.nome" />
						</div>

						<div class="col-lg-6 col-md-12">
							<label for="email">Email</label>
							<s:textfield id="email" type="email" label="EMAIL"
								name="cliente.email" cssClass="form-control" readonly="true"
								key="cliente.email" />
						</div>

					</div>

					<div class="row">
						<div class="col-lg-6 col-md-12">
							<label for="telefone">Telefone</label>
							<s:textfield id="telefone" label="Telefone" required="true"
								type="tel" id="TEL" name="cliente.telefone"
								cssClass="form-control" readonly="true" key="cliente.telefone" />
						</div>

						<div class="col-lg-6 col-md-12">
							<label for="CPF">CPF</label>
							<s:textfield id="CPF" label="CPF" name="cliente.cpf"
								cssClass="form-control" readonly="true" key="cliente.cpf" />
						</div>

					</div>

					<div class="row">
						<div id="preco" style="margin-top: 15px; margin-bottom: 15px;"
							class="form-control-lg border col-lg-12 col-md-12">
							Valor total: R$
							<s:property value="passeio.Preco" />
						</div>
					</div>

					<s:hidden name="cliente.id" value="%{cliente.id}" />
					<s:hidden name="pagamento.valorAPagar" value="%{passeio.preco}" />
					<s:hidden name="passeio.id" value="%{passeio.id}" />
					<s:hidden name="agenda.data" value="%{dataAgendamento}" />
					<s:submit cssClass="btn btn-primary mt-4 col-lg-6 col-md-12 p-2"
						value="Finalizar compra" />

				</div>

			</div>
		</s:form>
	</div>

</body>
</html>