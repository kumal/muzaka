<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Welcome to Muzaka</title>
		
	</head>
	<body>
		
		<!-- Header -->
			<div id="header">
			
				<span class="icon">			
				<asset:image src="logo.png" />
				</span>
				<h1>Welcome to Muzaka.</h1>
				<p>The Albanian Search Engine for Music.
				<br />
				Please look for an Albanian song of your desire.</p>			
	
			</div>

		<!-- Main -->
			<div id="main">

				<header class="major container 75%">
					<h2>"Liria është thelbi i shpirtit dhe i mendjes; aty ku s'ka liri, mendja dhe shpirti 
					<br/>thahen si bima pa ujë" - Sami Frashëri
		
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
							<h3>Top Titles</h3>
						</header>
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
									<tr>
										<td>1</td>
										<td><a href ="mp3/ELINEL - Na Thej 2014.MP3.mp3">Elinel - Na thej 2014</a></td>
										<td><span class="logo icon fa-download"></span></td>
									
									</tr>
									<tr>
										<td>2</td>
										<td><a href ="mp3/Butrint Imeri - Merre zemren tem 2015.MP3.mp3">Butrint Imeri - Merre zemren tem</a></td>
											<td><span class="logo icon fa-download"></span></td>
										
									</tr>
									<tr>
										<td>3</td>
										<td><a href ="mp3/Era Istrefi ft. Ledri Vula - Shume pis 2015.MP3.mp3">Era Istrefi ft. Ledri Vula - Shume pis</a></td>
										<td><span class="logo icon fa-download"></span></td>
										
									</tr>
									<tr>
										<td>4</td>
										<td><a href ="mp3/Era Istrefi - Njo si ti 2015.MP3.mp3">Era Istrefi - Njo si ti</a></td>
										<td><span class="logo icon fa-download"></span></td>
									
									</tr>
								</tbody>							
							</table>
						</div>
					</section>
					
						<footer class="major container 75%">
					<h3>Get shady with science</h3>
					<p>Vitae natoque dictum etiam semper magnis enim feugiat amet curabitur tempor orci penatibus. Tellus erat mauris ipsum fermentum etiam vivamus.</p>
					<ul class="actions">
							<li><a href="#" class="button">Join our crew</a></li>
						</ul>
					</footer>
				</div>
			</div>
	</body>
</html>
