<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
<link rel="shortcut icon" href="caminhodoarquivo/favicon.ico" />
<title>Capturar Execeções</title>
<script src="../resources/js/jquery-3.5.1.min.js"> </script>
</head>
<body>
<h3>Capturar Execeções com JQuery</h3>
<input type="text" value="valor informado" id="txtvalor">
<input type="button" onclick="testeExcecao();" value="testeExcecao">
</body>

<script type="text/javascript">
	function testeExcecao() {
		 valorInformado =  $('#txtvalor').val();
		 
		 $.ajax({
			 method: "POST",
			 url: "capturarExcecoes", //para qual servelt?
			 data: {valorParam: valorInformado}
		 })
		 	.always(function(response) {// sempre captar o retorno
		 		alert(response);				
			});
	}
</script>
</html>