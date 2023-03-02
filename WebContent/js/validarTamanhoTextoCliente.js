//document.getElementById("botao").addEventListener("click", validar, false);
//
//function validar() {
  //var divMensagem = document.getElementById('divMensagem');
  //var txtNome = document.getElementById('cpf');
  	//divMensagem.style.backgroundcolor = "Red";

  //if (txtNome.value.length <= 5){
   // divMensagem.innerHTML = 'O nome deve ser informado';
		//return false;
 // }
  //else{
   //divMensagem.innerHTML = '';
	//}
//}

function validarTexto(){
	const campoCpf = document.getElementsByClassName('validarCpf');
	 var divMensagem = document.getElementById('divMensagem');
	 var resp1,resp2,resp3,resp4,resp5,resp6;
	 
	for(let i = 0;i < campoCpf.length; i++ ){
		const tamanho = campoCpf[i].value.length;
		
		if(tamanho < 14){
			//alert("Teste");
			//divMensagem.style.color = "Red";
			divMensagem.innerHTML = 'Preencha o campo cpf';
			resp1 = false;
			//return false;
		}else{
			   divMensagem.innerHTML = '';
			   resp1 = true;
			}
	}
	var divMensagemN = document.getElementById('divMensagemNome');
	const campoTexto = document.getElementsByClassName('validarTexto');
	for(let i = 0;i < campoTexto.length; i++ ){
		const tamanho = campoTexto[i].value.length;
		
		if(tamanho < 5){
			divMensagemN.innerHTML = 'Minimo de 5 caracteres';
			resp2 = false;
		}else{
			   divMensagemN.innerHTML = '';
			   resp2 = true;
			}
	}
	var divMensagemO = document.getElementById('divMensagemOrgao');
	const campoO = document.getElementsByClassName('validarOrgao');
	for(let i = 0;i < campoO.length; i++ ){
		const tamanho = campoO[i].value.length;
		
		if(tamanho < 5){
			divMensagemO.innerHTML = 'Minimo de 5 caracteres';
			resp6 = false;
		}else{
			   divMensagemO.innerHTML = '';
			   resp6 = true;
			}
	}
	
	 var divMensagemT = document.getElementById('divMensagemTel');
	const campoTel = document.getElementsByClassName('validarTel');
	for(let i = 0;i < campoTel.length; i++ ){
		const tamanho = campoTel[i].value.length;
		
		if(tamanho < 14){
			divMensagemT.innerHTML = 'Por favor, preencha o campo Telefone';
			resp3 = false;
		}else{
			   divMensagemT.innerHTML = '';
			   resp3 = true;
			}
	}
	var divMensagemR = document.getElementById('divMensagemRG');
	const campoRG = document.getElementsByClassName('validarRG');
	for(let i = 0;i < campoRG.length; i++ ){
		const tamanho = campoRG[i].value.length;
		
		if(tamanho < 12){
			divMensagemR.innerHTML = 'Por favor, preencha o campo RG';
			resp4 = false;
		}else{
			   divMensagemR.innerHTML = '';
			   resp4 = true;
			}
	}
	var divMensagemC = document.getElementById('divMensagemCEP');
	const campoCEP = document.getElementsByClassName('validarCEP');
	for(let i = 0;i < campoCEP.length; i++ ){
		const tamanho = campoCEP[i].value.length;
		
		if(tamanho < 9){
			divMensagemC.innerHTML = 'Por favor, preencha o campo CEP';
			resp5 = false;
		}else{
			   divMensagemC.innerHTML = '';
			   resp5 = true;
			}
	}
	
	if (submitCep ==false){
		divMensagemC.innerHTML = 'CEP incorreto ou invalido.';
	}
	
	if (submitCep == false || resp1 == false || resp2 == false || resp3== false|| resp4== false|| resp5== false || resp6==false) {	
		return false;
	}
}