var precos = document.querySelectorAll('.preco');
for(var i = 0; i < precos.length; i++){
	const novoPreco = parseFloat(precos[i].textContent);
	const real = novoPreco.toLocaleString('pt-br',{style: 'currency', currency: 'BRL'});
	precos[i].textContent = real;
};
