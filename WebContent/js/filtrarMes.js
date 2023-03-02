var filtro = document.getElementById("mesFiltro");
var select = filtro.options[filtro.selectedIndex].value;

function teste() {
	var select = filtro.options[filtro.selectedIndex].value;
	console.log(select);
	filtrarMes(select);
}
function filtrarMes(select) {
	var pesquisaClasse = "." + select;
	var index = 0;
	var meses = document.querySelectorAll(".meses");
	var mesPesquisado = document.querySelectorAll(pesquisaClasse);

	if (select!="Todos"){
		for(var i=0; i < meses.length; i++){
			meses[i].style.display = 'none'
		}
		for (; index < mesPesquisado.length; index++) {
			mesPesquisado[index].style.display = '';
		}	
	} else {
		for(var i=0; i < meses.length; i++){
			meses[i].style.display = ''
		}		
	}
	
}
