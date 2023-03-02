$(document).ready(function() {
	$('#idTabela').DataTable({
		"searching" : false,
		"aaSorting" : [],
		"columnDefs" : [ {
			 "targets": [1],
			 "visible": true,
			 "searchable": false,
			 "render": function(data, type, row) {
				 if(data === ""){
					 return "-";
				 }
				 
			   return data.substring(0, 3) + "." + data.substring(3, 6) + "." + data.substring(6, 9) + "-"
			   		+ data.substring(9, 11) ;
			  }
			 }, 
		
			{
				 "targets": [3],
				 "visible": true,
				 "searchable": false,
				 "render": function(data, type, row) {
					 
					 if(data === ""){
						 return "-";
					 }
					 
				   return "(" + data.substring(0,2) + ")" + data.substring(2,7) + "-" + data.substring(7,11);
				   }
			}
		],
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