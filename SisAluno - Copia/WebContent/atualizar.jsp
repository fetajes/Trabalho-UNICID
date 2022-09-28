<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Atualizar Alunos</title>
</head>
<body>
    <center>
        <table border="1">
            <form action="ServletAlunos?cmd=atu" method="post">
            <tbody>
                <tr>
                    <th colspan="2"><h2>Atualizar Alunos</h2></th>
                </tr>
                <tr>
                    <td>CA do Aluno:</td>
                    <td>
                        <input type="text" name="txtCa" size="10" maxlenght="10" />
                    </td>
                </tr>

                <tr>
                    <td colspan="2" align="center"><input type="submit" value="Enviar"></td>
                </tr>

            </tbody>
           </form>
        </table>
    </center>
</body>
</html>
