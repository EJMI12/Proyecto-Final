/**
*	 @author Emilio.Molina@unah.hn 
*	 @version 0.1.1
*    @date 2024/04/
* 	
*	 Nuestra clase Action donde crearemos los metodos para guardar el estado del sistema, crear la alertas, eliminar las alertas
*/ 



class Action {
	
	
	 static showModal(event) {

		 console.log(event.target.classList);
		 let modalId;
			 if (event.target.classList.contains("callFormModal")) {
				 modalId = "formModal";
			 } else if (event.target.classList.contains("callInfoModal")) {
				 modalId = "infoModal";
			 }
		 let modal = document.querySelector(`#${modalId}`);
		 let modalInstance = new bootstrap.Modal(modal);
		 modalInstance.show("");
	 }
  
	static formData(){
    let emailAddress = document.getElementById('emailAddress');
    let channelName = document.getElementById('channelName');
    let description = document.getElementById('description');
    let likes = document.getElementById('likes');
    let views = document.getElementById('views');
    let iFrame = document.getElementById('iFrame');
    let videoType = document.getElementById('videoType');

    let list=[];
    list.push(`emailAddress=${emailAddress.value}`);
    list.push(`channelName=${channelName.value}`);
    list.push(`likes=${likes.value}`);
    list.push(`views=${views.value}`);
    list.push(`description=${description.value}`);
    list.push(`iFrame=${iFrame.value}`);
    list.push(`videoType=${videoType.value}`);
    return list.join("&");
}
static processResponse(xhr, event) {
    console.log("Received response from server.");

    if (xhr.readyState == 4 && xhr.status == 200) {
        console.log("Response received successfully.");

        let dto = JSON.parse(xhr.responseText);
        console.log("Parsed response data:", dto);

        document.getElementById('emailAddress').value = dto.emailAddress;
        document.getElementById('channelName').value = dto.channelName;
        document.getElementById('likes').value = dto.likes;
        document.getElementById('views').value = dto.views;
        document.getElementById('iFrame').value = dto.iFrame;
        document.getElementById('videoType').value = dto.videoType;
        document.getElementById('description').value = dto.description;

        console.log("Updated form fields with response data.");
    } else {
        console.error("Failed to receive response from server.");
        console.error("Status:", xhr.status);
        console.error("Ready state:", xhr.readyState);
    }
}


static send(){
    const xhr = new XMLHttpRequest();
    xhr.open("POST", "controller/video/registry",true);
    xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
    xhr.addEventListener("readystatechange", Action.processResponse.bind(null, xhr));
    xhr.send(Action.formData());
    Action.clearFormFields();
    
}


static readArchive() {
  const xhr = new XMLHttpRequest();
  xhr.open("GET", "controller/setCounter/readText", true);
  xhr.setRequestHeader("Content-Type", "application/json");
  xhr.addEventListener("readystatechange", Action.processArchiveResponse.bind(null, xhr));
  xhr.send();
}

static processArchiveResponse(xhr) {
  if (xhr.readyState == 4 && xhr.status == 200) {
    const response = JSON.parse(xhr.responseText);
    Action.updateCounters(response);
  } else {
    console.error("Failed to read archive.");
  }
}

static updateCounters(response) {
  const scientificVideoCounter = document.getElementById("scientificVideoCounter");
  const educationVideoCounter = document.getElementById("educationVideoCounter");
  const entertainmentVideoCounter = document.getElementById("entertainmentVideoCounter");
  const otherVideoCounter = document.getElementById("otherVideoCounter");
  const totalVideoCounter = document.getElementById("videoCounterTittle");

  scientificVideoCounter.textContent = ` ${response.scientificVideos} : Videos Cientificos`;
  educationVideoCounter.textContent = ` ${response.educationVideos} : videos Educativos`;
  entertainmentVideoCounter.textContent = ` ${response.entertainmentVideos} : Videos de Entretenimiento`;
  otherVideoCounter.textContent = ` ${response.otherVideos} : Otros Videos`;
  totalVideoCounter.textContent = ` ${response.totalVideos} `;
}

static clearDataModel() {
    const xhr = new XMLHttpRequest();
    xhr.open("GET", "controller/clearDataModel", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.addEventListener("readystatechange",Action.processClearResponse(xhr));
    xhr.send();
}

static processClearResponse(xhr) {
    if (xhr.readyState == 4 && xhr.status == 200) {
        const response = JSON.parse(xhr.responseText);
        console.log("Data model cleared:", response.content);
        // Aquí puedes agregar lógica adicional si es necesario después de limpiar el modelo de datos.
    } else {
        console.error("Failed to clear data model.");
    }
}
static clearFormFields() {
    document.getElementById('emailAddress').value = '';
    document.getElementById('channelName').value = '';
    document.getElementById('description').value = '';
    document.getElementById('likes').value = '';
    document.getElementById('views').value = '';
    document.getElementById('iFrame').value = '';
    document.getElementById('videoType').value = '';
}

static saveFormFields() {
    const emailAddress = document.getElementById('emailAddress').value;
    const channelName = document.getElementById('channelName').value;
    const description = document.getElementById('description').value;
    const likes = document.getElementById('likes').value;
    const views = document.getElementById('views').value;
    const iFrame = document.getElementById('iFrame').value;
    const videoType = document.getElementById('videoType').value;

    // Guarda los campos del formulario en localStorage
    localStorage.setItem('emailAddress', emailAddress);
    localStorage.setItem('channelName', channelName);
    localStorage.setItem('description', description);
    localStorage.setItem('likes', likes);
    localStorage.setItem('views', views);
    localStorage.setItem('iFrame', iFrame);
    localStorage.setItem('videoType', videoType);
}

static loadFormFields() {
    // Carga los campos del formulario desde localStorage
    document.getElementById('emailAddress').value = localStorage.getItem('emailAddress');
    document.getElementById('channelName').value = localStorage.getItem('channelName');
    document.getElementById('description').value = localStorage.getItem('description');
    document.getElementById('likes').value = localStorage.getItem('likes');
    document.getElementById('views').value = localStorage.getItem('views');
    document.getElementById('iFrame').value = localStorage.getItem('iFrame');
    document.getElementById('videoType').value = localStorage.getItem('videoType');
}
}

 
 