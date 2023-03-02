var inputs = document.querySelectorAll('input');

function verificar() {
	let estaChecado = false;
	for ( var i = 0; i < inputs.length; i++) {
		if (inputs[i].checked) {
			estaChecado = true;
		}
	}
	if (!estaChecado)
		document.querySelector("#divMensagemCheckbox").innerHTML = "selecione pelo menos um passeio";
	return estaChecado;
};

