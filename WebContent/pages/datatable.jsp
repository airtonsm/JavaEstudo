<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>DataTable jQuery</title>
<link rel="stylesheet"
	href="//cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css">

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="//cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>

</head>
<body>

	<table id="minhatabela" class="display" style="width: 100%">
		<thead>
			<tr>
				<th>Name</th>
				<th>Position</th>
				<th>Office</th>
				<th>Age</th>
				<th>Start date</th>
				<th>Salary</th>
			</tr>
		</thead>
	</table>

</body>
<script type="text/javascript">

$(document).ready(function() { // faz processamento na hora que abre a tela
    $('#minhatabela').DataTable( {
        "processing": true,
        "serverSide": true,
        "ajax": "carregarDadosDataTable" //URL de retorno retorno dos dados do servidor
    } );
} );

</script>
</html>