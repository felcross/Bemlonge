$(function() {
  let passeios = [
    "Aquario",
    "Angra dos Reis",
    "Arraial do Cabo",
    "Cristo Redentor",
    "Museu do Amanha",
    "Museu CCBB",
    "Pao de Acucar",
    "Rio das Pedras"
  ];
  $("#destino").autocomplete({
    source: passeios
  });
});

$(function() {
	  let pacotes = [
	    "Rio de Janeiro",
	    "Sao Paulo",
	    "Minas Gerais",
	    "Bahia"
	  ];
	  $("#descricao").autocomplete({
	    source: pacotes
	  });
	});



