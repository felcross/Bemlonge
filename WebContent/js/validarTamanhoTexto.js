function validarTexto(){
	var resp1,resp2;
	
	const campo = document.getElementsByClassName('validarNome');
	var divMensagem = document.getElementById('divMensagem');
	for(let i = 0;i < campo.length; i++ ){
		const tamanho = campo[i].value.length;
		console.log(tamanho);
		
		if(tamanho <5){
			divMensagem.innerHTML = 'Minimo de 5 caracteres';
			resp1= false;
		}else{
			   divMensagem.innerHTML = '';
			   resp1 = true;
			}
	}
	
	const campoCpf = document.getElementsByClassName('validarCpf');
	 var divMensagemC = document.getElementById('divMensagemCPF');
	 
	for(let i = 0;i < campoCpf.length; i++ ){
		const tamanho = campoCpf[i].value.length;
		console.log(tamanho);
		
		if(tamanho < 14){
			//alert("Teste");
			//divMensagem.style.color = "Red";
			divMensagemC.innerHTML = 'Preencha o campo cpf';
			resp2 = false;
			//return false;
		}else{
			   divMensagemC.innerHTML = '';
			   resp2 = true;
			}
	}
	
	if (resp1 == false || resp2 == false ) {
		return false;
	}
}