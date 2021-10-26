<%@page import="it.prova.discomusicale.model.DiscoMusicale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>

<!doctype html>
<html lang="it" class="h-100" >
	 <head>
	 
	 	<!-- Common imports in pages -->
	 	<jsp:include page="../header.jsp" />
	   
	   
	   <title>Lista Dischi</title>
	 </head>
	 
	<body class="d-flex flex-column h-100">
	 
		<!-- Fixed navbar -->
		<jsp:include page="../navbar.jsp"></jsp:include>
	 
	
		<!-- Begin page content -->
		<main class="flex-shrink-0">
		  <div class="container">
		  
		  		<div class="alert alert-success alert-dismissible fade show ${successMessage == null?'d-none':'' }" role="alert">
				 ${successMessage}
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
				        <h5>Lista dei risultati</h5> 
				    </div>
				    <div class='card-body'>
				    	<a class="btn btn-outline-success " href="PrepareInsertServlet">Aggiungi Nuovo</a>
				    
				        <div class='table-responsive'>
				            <table class='table table-striped ' >
				                <thead>
				                    <tr>
			                         	<th>Id</th>
				                        <th>Titolo</th>
				                        <th>Autore</th>
				                        <th>NumeroTracce</th>
				                        <th>Data di Rilascio</th>
				                        <th>Azioni</th>
				                    </tr>
				                </thead>
				                <tbody>
				                		 <c:forEach var="tempDiscoMusicale" items="${listAttribute}">
				                		 <fmt:formatDate value="${tempDiscoMusicale.dataRilascio}" pattern="dd/MM/yyyy" var="dataRilascio"/>
				                    <tr >
				                        <td>${tempDiscoMusicale.id}</td>
				                        <td>${tempDiscoMusicale.titolo}</td>
				                        <td>${tempDiscoMusicale.autore}</td>
				                        <td>${tempDiscoMusicale.numeroTracce}</td>
				                        <td>${dataRilascio}</td>
				                    
				                    
				                        <td>
											<a class="btn  btn-sm btn-outline-secondary" href="ExecuteDetailsServlet?idDiscoMusicale=${tempDiscoMusicale.id}">Dettagli</a>
											<a class="btn  btn-sm btn-outline-primary ml-2 mr-2" href="PrepareUpdateServlet?discoMusicaleDaAggiornare=${tempDiscoMusicale.id}">Modifica</a>
											<a class="btn btn-outline-danger btn-sm" href="PrepareRemoveServlet?discoMusicaleDaRimuovere=${tempDiscoMusicale.id}">Rimuovi</a>
										</td>
										
				                    </tr>                 				   
				                    </c:forEach>	
				                </tbody>
				            </table>
				        </div>
				   
					<!-- end card-body -->			   
			    </div>
			<!-- end card -->
			</div>	
		 
		   
		 <!-- end container -->  
		  </div>
		  
		</main>
		
		<!-- Footer -->
		<jsp:include page="../footer.jsp" />
		
		<!-- Modal conferma delete -->
		<div class="modal fade" id="deleteModal" tabindex="-1" aria-labelledby="deleteModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h5 class="modal-title" id="deleteModalLabel">Conferma Operazione</h5>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
		      <div class="modal-body">
		        Continuare con l'operazione?
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Annulla</button>
		        <button type="button" class="btn btn-primary">Continua</button>
		      </div>
		    </div>
		  </div>
		</div>
		<!-- End Modal conferma delete -->
		
	</body>
</html>