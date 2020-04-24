<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
    <%@ taglib prefix = "sql" uri = "http://java.sun.com/jsp/jstl/sql" %>
    
       
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" 
crossorigin="anonymous">
<meta charset="ISO-8859-1">

<title>Insert title here</title>
</head>

<body style="background-color: aqua">
<jsp:useBean id="pdao" class="prod.ProdutoDao" scope="page"/>
	<h2 style="text-align: center;">Estoque</h2><br/><br/>
	<div class="dropdown" style="text-align: center">
  		<button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
    		Cadastrar
  		</button>
  		<div class="dropdown-menu" aria-labelledby="dropdownMenu2" style="background-color: aqua">
   			<a class="dropdown-item" href="cadastrar.jsp">Novo Produto</a>
  		</div>
	</div>
	<br/><br/><br/>
		
	<div class="table-responsive" style="width: 80%; margin-left: 10%">
	<table border="1px" class="table table-dark table-sm" >
	  <thead>
	    <tr>
	    	<th scope="col">Id</th>
			<th scope="col">Produto</th>
			<th scope="col">Marca</th>
			<th scope="col">Quantidade</th>
			<th scope="col">Preço de Venda</th>
			<th scope="col">Preço de Custo</th>
		</tr>
	  </thead>	
			<c:forEach var="p" items="${pdao.listar()}">
				<tbody>
					<tr>
						<td class="bg-info">${p.idProduto}</td>
						<td class="bg-info">${p.descricao}</td>
						<td class="bg-info">${p.marca}</td>
						<td class="bg-info">${p.quantidade}</td>
						<td class="bg-info">${p.venda}</td>
						<td class="bg-info">${p.custo}</td>
						<td class="bg-info"><a href="excluir.jsp?idProduto=${p.getIdProduto()}">Excluir</a></td>
					</tr>
				</tbody>
			</c:forEach>
		
	</table>
	<table border="1px" class="table table-dark table-sm" >
	  <thead>
	    <tr>
	    	<th scope="col">Total de Estoque</th>
			<th scope="col">Total Valor Venda</th>
			<th scope="col">Total Valor Custo</th>
			<th scope="col">Lucro</th>
		</tr>
	  </thead>	
	  	
	   	<tbody>
			<tr>
				<td class="bg-info">${pdao.getTotalq(pdao.listar())}</td>
				<td class="bg-info"><fmt:formatNumber type = "number" pattern = "0.00" value = "${pdao.getTotalv(pdao.listar())}" /></td>
				<td class="bg-info"><fmt:formatNumber type = "number" pattern = "0.00" value = "${pdao.getTotalc(pdao.listar())}" /></td>
				<td class="bg-info"><fmt:formatNumber type = "number" pattern = "0.00" value = "${pdao.getLucro(pdao.listar())}" /></td>
			</tr>
		</tbody>
		
	</table>
	</div>
	
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" 
integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" 
crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" 
integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" 
crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" 
integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" 
crossorigin="anonymous"></script>
</body>
</html>