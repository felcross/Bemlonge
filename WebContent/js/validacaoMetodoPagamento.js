const inputMetodoPagamento = document.getElementById("metodo_pagamento");
const inputParcelas = document.getElementById("parcelas");

document.querySelector("form").addEventListener("submit", function(e) {
	inputParcelas.removeAttribute("disabled");
});

function validarMetodoPagamento() {
	if (inputMetodoPagamento[1].selected) {
		inputParcelas[1].selected = true;
		inputParcelas.setAttribute("readonly", true);
		inputParcelas.setAttribute("disabled", "disabled");
	} else {
		inputParcelas.removeAttribute("disabled");
		inputParcelas.removeAttribute("readonly");
	}
}