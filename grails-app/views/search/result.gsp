
<section>
	<header>
		<h3>Results</h3>
	</header>
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
		</div>
	</g:if>
</section>
