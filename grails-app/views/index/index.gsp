<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Muzaka</title>
		
	</head>
	<body>
		
		

	

				<header class="major container 75%">
					<h2>"Freedom is the core of spirit and mind; there where is no freedom, mind and spirit 
					<br/>dry out like plants without water."- Sami Frashëri
					<!-- -h2>"Liria është thelbi i shpirtit dhe i mendjes; aty ku s'ka liri, mendja dhe shpirti 
					<br/>thahen si bima pa ujë" - Sami Frashëri
				 -->
					</h2>
					<!--
					<p>Tellus erat mauris ipsum fermentum<br />
					etiam vivamus nunc nibh morbi.</p>
					-->
				</header>
			<div class="box container">
				<header>
					<h3>Search for your favourite Song</h3>
				</header>
				<g:formRemote name="searchForm" id="searchForm" url="[controller: 'search', action:'search']" update="result">
					<div class="row">
						<div class="12u">
				  			<input type="text"  name="searchString" placeholder="Search...">
				 		</div>
				 	</div>
				 	<div class="row">
				 		<div class="12u">
							<ul class="actions">
								<li><input type="submit"  value="Search" /></li>
								<li><input type="reset" value="Reset" class="alt" /></li>
							</ul>
						</div>
					</div>
				</g:formRemote>
				<br/>
				<!-- the result of the search will be rendered inside this div -->
				<div id="result"></div>
							
			</div>
			<div class="box container">
			<section>
						<header>
							<h3>Top Titles 2015</h3>
						</header>
						
				<div id="list-user" class="content scaffold-list" role="main">			
						<g:if test="${songList != null}">
								<div class="table-wrapper">
									<table class="default">
										<thead>
											<tr>
												<th>ID</th>
												<th>Song</th>
												<th>Download</th>
											
											</tr>
										</thead>
										<tbody>
										<g:set var="songID" value="${0}"/>
										<g:each in="${songList}">
										<g:set var="songID" value="${songID + 1}"/>
											<tr>
												<td>${songID}</td>
												<td><a href="${it.url}">${it.songName}</a></td>
												<td><a class ="inline-exclude" href="${it.url}" download="true"><span class="logo icon fa-download"></span></a></td>
											
											</tr>
										    
										</g:each>
						
						
										</tbody>							
									</table>
									<div class="pagination">
									
										<g:paginate controller="index" action="index" total="${songNameCount}" />
									</div>
							
								</div>
							</g:if>
									</div>
					</section>
					
					<footer class="major container 75%">
						<h3>Enjoy Albania!</h3>
						<iframe width="560" height="315" src="https://www.youtube.com/embed/xHWr9-YtzEo" frameborder="0" allowfullscreen></iframe>
					</footer>	
				</div>
	</body>
</html>
