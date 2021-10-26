<!doctype html>
<%@page import="it.prova.discomusicale.model.DiscoMusicale"%>
<%@page import="java.text.SimpleDateFormat"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Rimuovi Disco</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class='card'>
					    <div class='card-header'>
					        <h5>Rimuovi con dettaglio</h5>
					    </div>
					     <% DiscoMusicale discoMusicaleInPagina = (DiscoMusicale)request.getAttribute("discoMusicaleDaRimuovere"); %>
					    
					
					    <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Titolo</dt>
							  <dd class="col-sm-9">${discoMusicaleDaRimuovere.titolo}</dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Autore:</dt>
							  <dd class="col-sm-9">${discoMusicaleDaRimuovere.autore}</dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">NumeroTracce:</dt>
							  <dd class="col-sm-9">${discoMusicaleDaRimuovere.numeroTracce}</dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Data di Rilascio:</dt>
							  <fmt:formatDate value="${discoMusicaleDaRimuovere.dataRilascio}" pattern="dd/MM/yyyy" var="dataRilascio"/>				                 
							  <dd class="col-sm-9">${dataRilascio}</dd>
					    	</dl>
					    	
					    </div>
					    
					    <div class='card-footer'>
					    	<form method="post" action="ExecuteRemoveServlet" class="row g-3" novalidate="novalidate">		
						    	<input type="hidden" name="idDaRimuovere" value="<%=discoMusicaleInPagina.getId() %>">
								<input type="submit" value="Conferma" class='btn btn-outline-danger' style='width:100px'>
					      		&nbsp;&nbsp;
					      	  <a href="ListServlet" class='btn btn-outline-secondary' style='width:100px'>
					     	       <i class='fa fa-chevron-left'></i> Indietro
					      	  </a>
					        </form>					    	
					    </div>
					    
					<!-- end card -->
					</div>	
			    
			  <!-- end container -->  
			  </div>
			  
			</main>
			
			<!-- Footer -->
			<jsp:include page="../footer.jsp" />
	  </body>
</html>