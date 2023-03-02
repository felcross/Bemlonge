//Setando a data minima para o input com a data atual
var today = new Date().toISOString().split('T')[0];
document.getElementById("dataEmbarque").setAttribute('min', today);

//Desabilitando o input da data de volta
$("#dataDesembarque").attr('disabled','disabled');
diaEscolhido = $("#dataEmbarque");

//Setando comportamento para os inputs de data
diaEscolhido.focusout( function(){
	if(diaEscolhido.val() !=  0) {
		$("input").removeAttr('disabled');
	} else {
		$("#dataDesembarque").attr('disabled','disabled');
	}
	var dataVolta = diaEscolhido.val();
	document.getElementById("dataDesembarque").setAttribute('min', dataVolta);
});

$("#datepicker").datepicker( {
    format: "mm-yyyy",
    startView: "months", 
    minViewMode: "months"
});


