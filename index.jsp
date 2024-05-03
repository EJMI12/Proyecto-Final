<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="author" content="Emilio.Molina@unah.hn" />
		<meta name="version" content="0.1.2" />
		<meta name="date" content="2024/04/25" />
		<meta name="since" content="2024/04/23" />
		<title>Insert title here</title>
		<link rel="stylesheet" href="assets/css/bootstrap.min.css" />
		<link rel="stylesheet" href="assets/css/style.css" />
	</head>
	<body class="bg-info-subtle">
	<section class="container">
		<div class="container text-center">
			<div class="row align-items-start">
				<div class="col-md-8" id="col-1">
					<div id="container-2">
						<h3 id="videoCounterTittle">Videos Registrados:</h3>
						<div class="modal fade" id="videoModal" tabindex="-1"
							aria-labelledby="videoModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="videoModalLabel">Detalles del
											Video</h5>
										<button type="button" class="btn-close"
											data-bs-dismiss="modal" aria-label="Close"></button>
									</div>
									<div class="modal-body">
										<div id="videoDetails">
											<!-- Aquí se mostrarán los detalles del video -->
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
					
				</div>
				<div class=" col-md-4" id="col-2">
					<div id="container-1">
						<h3 id="videoCounterTittle1">Acaemico:</h3>
						<div id="scientificVideoCounter">0: Videos Cientificos</div>
						<div id="educationVideoCounter">0 : videos Educativos</div>
					</div>
					<div id="container-1">
						<h3 id="videoCounterTittle2" style="margin-top: 10px">No Academico:</h3>
						<div id="EntertaimentVideoCounter">0: Videos de Entretenimiento</div>
						<div id="otherVideoCounter">0 : Otros Videos</div>
					</div>
					<div id= "container-1">
						<h3 style="color: blue;">Total de videos</h3>
						<h1 style="color: blue;" class="display-1" id="videoCounterTittle">0</h1>
					</div>
				</div>
			</div>
		</div>
		<nav class="navbar navbar-expand-lg fixed-bottom bg-body-tertiary">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">VidReg 1.1- Emilio Molina</a>
				<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item btn-group dropup"><a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false"> Inicio</a>
							<ul class="dropdown-menu">
								<li><a class="dropdown-item callFormModal" href="#">Agregar Video</a></li>
								<li><hr class="dropdown-divider"></li>
								<li><a class="dropdown-item bg-danger " style="color: white;" href="#">Limpiar Modelo de Datos</a></li>
							</ul>
						<li class="nav-item btn-group dropup"><a class="nav-link dropdown-toggle callInfoModal" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" > Acerca de </a>
					</ul>
				</div>
			</div>
		</nav>

		<div class="modal fade" id="infoModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">Acerca de</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						Emilio@unah.hn 2020211030861
						El proyecto consiste en un sistema de
						videos categorizados que utiliza técnicas de programación
						orientada a objetos (POO), servlets y sistema de persistencia de
						datos. La aplicación permite a los usuarios navegar y ver videos
						clasificados en diversas categorías, como científicos, educativos,
						de entretenimiento, entre otros. Se han utilizado principios de
						POO para organizar el código de manera modular y reutilizable, lo
						que facilita el mantenimiento y la escalabilidad del sistema. Los
						servlets se utilizan para manejar las solicitudes HTTP y gestionar
						la lógica de negocio, como la lectura y escritura de datos.
						Además, se implementa un sistema de persistencia de datos para
						almacenar la información de los videos y las categorías de manera
						eficiente y duradera. En resumen, el proyecto combina conceptos
						avanzados de programación con tecnologías web para crear un
						sistema robusto y funcional de gestión de videos.</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary" data-bs-dismiss="modal">Ok</button>
					</div>
				</div>
			</div>
		</div>
		<div class="modal" tabindex="-1" id="formModal">
			<div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">Resgistro de Videos</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					</div>
					<div class="modal-body">
					<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">Responsable de quien realiza este registro (email)</label> 
							<input type="text" class="form-control" id="emailAddress" placeholder="nombre@example.com">
						</div>
						<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">Nombre del canal de YouTube</label> 
							<input type="text" class="form-control" id="channelName" placeholder="nombre@example.com">
						</div>
						<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">Likes</label> 
							<input type="text" class="form-control" id="likes" placeholder="xxx,xxx">
						</div>
						<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">Visitas</label> 
							<input type="text" class="form-control" id="views" placeholder="xxx,xxx">
						</div>
						<div class="mb-3">
							<label for="exampleFormControlTextarea1" class="form-label">Descripcion</label>
							<textarea class="form-control" id="description" rows="3" placeholder= "Descripcion del video"></textarea>
						</div>
						<select class="form-select" aria-label="Default select example" id="videoType">
							 <option selected>Seleccione un tipo de video</option>
							<option value="education">Educativo</option>
							<option value="scientific">Cientifico</option>
							<option value="entretaiment">Entretenimiento</option>
							<option value="other">Otro</option>
						</select>
						<div class="mb-3">
							<label for="exampleFormControlInput1" class="form-label">iFrame del video a registrar</label> 
							<input type="text" class="form-control" id="iFrame" placeholder="<iFrame></iFrame>">
						</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-danger" data-bs-dismiss="modal" >Cancelar</button>
						<button type="button" class="btn btn-success" id="saveVideoBtn">Agregar Video</button>
					</div>
				</div>
			</div>
		</div>
		

	</section>
	<script src="assets/js/bootstrap.bundle.min.js"></script>
<script src="assets/js/Action.js"></script>
<script src="assets/js/main.js"></script>
</body>
</html>