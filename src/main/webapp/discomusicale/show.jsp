<!doctype html>
<%@page import="it.prova.discomusicale.model.DiscoMusicale"%>
<%@page import="java.text.SimpleDateFormat"%>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Visualizza Elemento</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class='card'>
					    <div class='card-header'>
					        <h5>Visualizza Dettagli</h5>
					    </div>
					     <% DiscoMusicale discoMusicaleInPagina = (DiscoMusicale)request.getAttribute("show_discoMusicale_attr"); %>
					    
					
					    <div class='card-body'>
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Titolo</dt>
							  <dd class="col-sm-9"><%=discoMusicaleInPagina.getTitolo() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Autore:</dt>
							  <dd class="col-sm-9"><%=discoMusicaleInPagina.getAutore() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">NumeroTracce:</dt>
							  <dd class="col-sm-9"><%=discoMusicaleInPagina.getNumeroTracce() %></dd>
					    	</dl>
					    	
					    	<dl class="row">
							  <dt class="col-sm-3 text-right">Data di Rilascio:</dt>
							  <dd class="col-sm-9"><%=discoMusicaleInPagina.getDataRilascio()!=null? new SimpleDateFormat("dd/MM/yyyy").format(discoMusicaleInPagina.getDataRilascio()):"N.D."  %></dd>
					    	</dl>
					    	
					    </div>
					    
					    <div class='card-footer'>
					        <a href="ListServlet" class='btn btn-outline-secondary' style='width:100px'>
					            <i class='fa fa-chevron-left'></i> Indietro
					        </a>
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