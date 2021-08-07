<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
    <%@ page import="model.JavaBeans" %>
    <%@ page import="java.util.ArrayList" %>
    <%
    	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>)request.getAttribute("clientes");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Clientes</title>
<link rel="stylesheet" href="style.css">
</head>
<body>

	<h1>Cadastro de Clientes</h1>
<!-- 	<a href="" class="Botao1">Novo Cliente</a> -->
<div>
	<h1>Novo Cliente</h1>
	<form name="frmCliente" action="insert">
		<table>
			<tr>
				<td><input type="text" name="razaoSocial" placeholder="Razão Social" class="Campo1"></td>
			</tr>
			<tr>
				<td><input type="text" name="cnpj" placeholder="CNPJ" class="Campo1"></td>
			</tr>
			<tr>
				<td><input type="text" name="regime" placeholder="Regime Tributário" class="Campo1"></td>
			</tr>
			<tr>
				<td><input type="text" name="email" placeholder="Email" class="Campo1"></td>
			</tr>
		</table>
		<input type="button" value="Cadastrar" class="Botao1" onClick="validar()">
	
	</form>
<script src="scripts/valida.js"></script>
</div>
<div>
	<h1>Lista de Clientes</h1>
	<table id="tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Razão Social</th>
				<th>CNPJ</th>
				<th>Regime Tributário</th>
				<th>Email</th>
				<th>Opções</th>
			</tr>	
		</thead>
		<tbody>
			<%for (int i = 0; i < lista.size(); i++) {%>
				<tr>
					<td><%=lista.get(i).getIdcli()%></td>
					<td><%=lista.get(i).getRazaoSocial()%></td>
					<td><%=lista.get(i).getCnpj()%></td>
					<td><%=lista.get(i).getRegime()%></td>
					<td><%=lista.get(i).getEmail()%></td>
					<td><a href="select?idcli=<%=lista.get(i).getIdcli()%>" class="Botao1">Editar</a>
					<a href="select?idcli=<%=lista.get(i).getIdcli()%>" class="Botao2">Excluir</a>
					</td>
				</tr>
			<%} %>
		</tbody>
	</table>
</div>
</body>
</html>