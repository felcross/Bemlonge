$(document).ready(function() {
	$('#Tabela').DataTable({
		"searching" : false,
		"aaSorting" : [],
		"columnDefs" : [ {
			type : 'date-uk',
			targets : [ 2, 3 ]
		} ],
		"pagingType" : "simple_numbers",
		"language" : {
			paginate : {
				next : '&#8594;',
				previous : '&#8592;'
			},
			"url" : "//cdn.datatables.net/plug-ins/1.13.1/i18n/pt-BR.json"
		},
		"lengthMenu" : [ [ 5, 10, 15, -1 ], [ 5, 10, 15, 'All' ], ]
	});
});