<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Barra de progresso</title>


<style type="text/css">
/* fundo da barra de progresso - cor cinza */
#myprogress{
width: 100%;
background-color: #ddd;   
}

/*Cor da barra de progresso*/
#myBar{
width: 0.5%;
height: 30px;
background-color: #4CAF50;
}
	
</style>
</head>
<body>
	<h1>Exemplo com JavaScript</h1>
	<div id="myprogress"> <!-- Fundo da barra -->
		<div id="myBar"></div> <!-- Barra de progresso -->
	</div>	
	<br/>
	<button onclick="exibirBarra()">Iniciar a Barra de progresso</button>
	
	<script type="text/javascript">
	
	function exibirBarra() {
		var elem = document.getElementById("myBar");
		var width = 1;
		var id = setInterval(frame, 10);
		
		function frame() {
			if(width >= 100){
				clearInterval(id);
			}else {
				width ++;
				elem.style.width = width + "%";
			}
		}
	}
</script>
	
</body>


</html>