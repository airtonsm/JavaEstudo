<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1">
<link rel="shortcut icon" href="caminhodoarquivo/favicon.ico" />
<title>Capturar Exece��es</title>
<script src="../resources/js/jquery-3.5.1.min.js"> </script>
</head>
<body>
<h3>Capturar Exece��es com JQuery</h3>
<input type="text" value="teste dados" id="txtvalor">
<input type="button" onclick="testeJquery();" value="testar">
</body>

<script type="text/javascript">
	function testeJquery() {
		alert($('#txtvalor').val());
	}
</script>
</html>