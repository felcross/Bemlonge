function valida(){
	var sel = document.getElementById("destino");
	var resp1,resp2;
	if (sel.options[sel.selectedIndex].value==""){
		document.querySelector("#divMensagem").innerHTML = "selecione ao menos uma opcao";
           sel.focus();
           resp1 = false;
        }else{
        	resp1= true;
        	document.querySelector("#divMensagem").innerHTML = "";
        }
	
	var sel2 = document.getElementById("preco");
		if(sel2.options[sel2.selectedIndex].value==""){
			document.querySelector("#divMensagemPreco").innerHTML = "selecione ao menos uma opcao";
			sel2.focus();
	        resp2 = false;
		}else{
			resp2 = true;
			document.querySelector("#divMensagemPreco").innerHTML = "";
		}
	
	if(resp1 == true || resp2 == true){
		document.querySelector("#divMensagem").innerHTML = "";
		document.querySelector("#divMensagemPreco").innerHTML = "";
		return true;
	}else{
		return false;
	}
        
}
