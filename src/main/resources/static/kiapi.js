

alert("script wurd geladen")
document.getElementById("stadtLaatzenLabel").innerHTML = "Wettin-Löbejün OT Brachwitz";


// Dynamisches Laden des zweiten Skripts
function loadcollectText() {
    const script = document.createElement('script');
    script.src = '/lade-collecttextjs'; // das laden
    script.onerror = () => console.error('Fehler beim Laden von collectText.js');
    console.log("lade collect text erfolgreich");
    document.head.appendChild(script); // hier wird dann das dom object bearbeitet und der script tag hinzugefügt
}


 function loadplugin() {

let request = new XMLHttpRequest();
request.open("GET","lade-plugin",true);

request.send();

request.onload = function () {
    const response = request.responseText;

    console.log("request response: ", response);

    const newElement = document.createElement("div");

    newElement.innerHTML = response

    document.body.appendChild(newElement);
}

}

loadcollectText();
loadplugin();
