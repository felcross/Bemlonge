function limparFormulario() {
    document.getElementById("bairro").value = "";
    document.getElementById("logradouro").value = "";
    document.getElementById("uf").value = "";
}

var submitCep = null;
cep.addEventListener("blur", (e) => {
    let Cep = document.getElementById("cep").value;
    if (Cep == "") {
        limparFormulario();
    }
    else {
        let search = cep.value.replace("-", "");
        var divMensagemC = document.getElementById('divMensagemCEP');
        var validacep = /^[0-9]{8}$/;
        if(validacep.test(search)) {
        fetch(`https://viacep.com.br/ws/${search}/json/`).then((response) => {
            response.json().then(data => {
                let erro = data.erro;
                if (!erro == true) {
                    document.getElementById("bairro").value = data.bairro;
                    document.getElementById("logradouro").value = data.logradouro;
                    document.getElementById("uf").value = data.uf;
                    divMensagemC.innerHTML = null;
                    submitCep = true;
                }
                else {
                    divMensagemC.innerHTML = 'CEP incorreto.';
                 	limparFormulario();
                 	submitCep = false;
                }

            })
        })
    }else {
        divMensagemC.innerHTML = 'CEP invalido.';
         limparFormulario();
         submitCep = false;
    }
    }
});