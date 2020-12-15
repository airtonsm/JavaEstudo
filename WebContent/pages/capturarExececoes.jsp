<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Capturar Execeções</title>
<script>type="text/javascript" scr="https://code.jquery.com/jquery-3.5.1.min.js"</script>
</head>
<body>
<h3>Capturar Execeções com JQuery</h3>
<input type="text" value="teste dados" id="txtvalor">
<input type="button" onclick="testeJquery();" value="testar">

</body>

<script type="text/javascript">
	function testeJquery(){
		alert($('#txtvalor').val());		
	}
</script>
</html>