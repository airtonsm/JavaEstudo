<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload file</title>
<script src="../resources/js/jquery-3.5.1.min.js">
	
</script>
</head>
<body>
<form enctype="application/x-www-form-urlencoded">
	<input type="file" id="file" name="file" onchange="uploadFile();" />
	<img alt="Imagem"  id="target" width="200" height="200">
	</form>
</body>

<script type="text/javascript">
	function uploadFile() {

		var target = document.querySelector('img');
		var file = document.querySelector('input[type=file]').files[0];

		var reader = new FileReader();

		reader.onloadend = function() {
			target.src = reader.result;
			
			///// ----------- upload ajax ------
			
			$.ajax({
				 method: "POST",
				 url: "fileUpload", //para qual servelt
				 data: { fileUpload : reader.result }
			 }).done(function(response) {// resposta ok - nenhum erro
			 		alert("Sucesso! " + response);
			 	// fazer algo
				})
				.fail(function(xhr, status, errorThrown) {
					alert("Error: " + xhr.responseText);//mostra a resposta do servidor
				});
			
		};

	}
</script>
</html>