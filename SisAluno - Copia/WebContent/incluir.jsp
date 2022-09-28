<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Incluir Alunos</title>
</head>
<body>
	<center>
	<table border="1" width="42%">
	<form action="ServletAlunos" method="get">   
		<input type = "hidden" name ="cmd" value="incluir"> <br />
		<tr>
			<th colspan="2"><h1>Cadastro de Alunos</h1></th>
		</tr>	
		<tr>
			<td>CA:</td> 
			<td><input type = "text" name = "txtCa"  size="60" maxlength = "60"></td>
			</tr>
		<tr>
			<td>Nome:</td> 
			<td><input type = "text" name =  "txtNome" size="60" maxlength = "60"></td>
		</tr>	
		<tr>
			<td>E-mail:</td> <td><input type = "text" size="60" name = "txtEmail" 
maxlength = "60"></td>
		</tr>
		<tr>
			<td>Data de Nascimento:</td> 
			<td><input type = "text" name = "txtData" size="60" id = "dtaNasc" 
maxlength = "60"></td>
		</tr>
		<tr>
			<td>Endereço:</td> 
			<td><input type = "text" name = "txtEndereco" size="60" maxlength = "60"></td>
		</tr>
		<tr>
			<td>Idade:</td> 
			<td><input type = "text" name = "txtIdade" size="60" maxlength = "60"></td>
		</tr>
		<tr>
			<td colspan="2" align="center"><input type="submit" value="Enviar"></td>
		</tr>	
	</form>
	</table>
	</center>
</body>
</html>
