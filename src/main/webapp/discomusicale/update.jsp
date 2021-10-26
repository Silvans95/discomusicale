<!doctype html>
<%@page import="it.prova.discomusicale.model.DiscoMusicale"%>
<%@page import="java.text.SimpleDateFormat"%>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   <title>Aggiorna Elemento</title>
	 </head>
	   <body class="d-flex flex-column h-100">
	   
	   		<!-- Fixed navbar -->
	   		<jsp:include page="../navbar.jsp"></jsp:include>
	    
			
			<!-- Begin page content -->
			<main class="flex-shrink-0">
			  <div class="container">
			  
			  		<div class="alert alert-danger alert-dismissible fade show ${errorMessage==null?'d-none':'' }" role="alert">
					  ${errorMessage}
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-danger alert-dismissible fade show d-none" role="alert">
					  Esempio di operazione fallita!
					  <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
					<div class="alert alert-info alert-dismissible fade show d-none" role="alert">
					  Aggiungere d-none nelle class per non far apparire
					   <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close" ></button>
					</div>
			  
			  <div class='card'>
				    <div class='card-header'>
				        <h5>Aggiorna elemento</h5> 
				    </div>
				    <div class='card-body'>
		
							<h6 class="card-title">I campi con <span class="text-danger">*</span> sono obbligatori</h6>
		
		
							<form method="post" action="ExecuteUpdateServlet" class="row g-3" novalidate="novalidate">
							
								<% DiscoMusicale discoMusicaleInPagina = (DiscoMusicale)request.getAttribute("discoMusicaleDaAggiornare"); %>
							
								<input type="hidden" name = "id" value="<%=discoMusicaleInPagina.getId()%>">
							
								<div class="col-md-6">
									<label for="titolo" class="form-label">Titolo <span class="text-danger">*</span></label>
									<input type="text" name="titolo" id="titolo" class="form-control" placeholder="Inserire il titolo"  
										value="<%=discoMusicaleInPagina.getTitolo()!=null?discoMusicaleInPagina.getTitolo():"" %>" required>
								</div>
								
								<div class="col-md-6">
									<label for="autore" class="form-label">Autore <span class="text-danger">*</span></label>
									<input type="text" name="autore" id="autore" class="form-control" placeholder="Inserire l'autore"  
										value="<%=discoMusicaleInPagina.getAutore()!=null?discoMusicaleInPagina.getAutore():"" %>" required>
								</div>
							
								<div class="col-md-6">
									<label for="numeroTracce" class="form-label">NumeroTracce <span class="text-danger">*</span></label>
									<input type="number" class="form-control" name="numeroTracce" id="numeroTracce" placeholder="Inserire numeroTracce" 
									value="<%=discoMusicaleInPagina.getNumeroTracce()!=null?discoMusicaleInPagina.getNumeroTracce():"" %>" required>
								</div>
								
								<div class="col-md-3">
									<label for="dataRilascio" class="form-label">Data di Arrivo<span class="text-danger">*</span></label>
									<input class="form-control"  name="dataRilascio" id="dataRilascio" type="date" placeholder="dd/MM/yy" title="formato : gg/mm/aaaa" 
										value="<%=discoMusicaleInPagina.getDataRilascio()!=null? new SimpleDateFormat("yyyy-MM-dd").format(discoMusicaleInPagina.getDataRilascio()):""  %>" required/>
								</div>
								
								
							<div class="col-12">
								<button type="submit" name="submit" value="submit" id="submit" class="btn btn-outline-primary">Conferma</button>
								
								   <a href="ListServlet" class='btn btn-outline-secondary' style='width:100px'>
					            <i class='fa fa-chevron-left'></i> Indietro
					        </a>
							</div>
		
						</form>
  
				    
				    
					<!-- end card-body -->			   
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