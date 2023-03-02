
var nomeInput = document.querySelectorAll('.validador');
nomeInput.forEach(function(a){
	a.addEventListener("keypress", function(e) {
		if(!checkChar(e)){
			e.preventDefault();
		}
	});
});


function checkChar(e) {
	const char = String.fromCharCode(e.keyCode);
	const pattern = '[a-zA-Z ~-´ç-Ç]';
	if(char.match(pattern)){
		console.log(char);
		return true;
	}
};

nomeInput.forEach(function(a){
	a.addEventListener("paste", function() {
		const regex = new RegExp("^[0-9a-zA-Z ~-´ç-Ç\b]+$");
		const self = this;
		setTimeout(function() {
			const text = self.value;
			if(!regex.test(text)) {
				self.value = "";
			}
		}, 10);
	});
});
