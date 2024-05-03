/**
 * 
 * 
 * 
 */

let callFormModal = document.querySelectorAll(".callFormModal");
let callInfoModal = document.querySelectorAll(".callInfoModal");


let emailLabel = document.querySelector("#emailAddress");
let channelNameLabel = document.querySelector("#channelName");
let likesLabel = document.querySelector("#likes");
let viewsNameLabel = document.querySelector("#views");
let descriptionLabel = document.querySelector("textarea#description");
let videoType=document.querySelector("videoType");
let iFrameLabel = document.querySelector("#iFrame");
document.addEventListener("DOMContentLoaded",Action.readArchive);



let sendButton = document.querySelector("#saveVideoBtn");
sendButton.addEventListener("click",Action.send);

for (let i = 0; i < callFormModal.length; i++) {
  callFormModal[i].addEventListener("click", Action.showModal);
}

for (let i = 0; i < callInfoModal.length; i++) {
 callInfoModal[i].addEventListener("click", Action.showModal);

}