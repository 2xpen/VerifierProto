
    function sendMessage() {
    const inputField = document.querySelector('.input-row input[type="text"]');
    const message = inputField.value;

    if (message) {
    const contentDiv = document.querySelector('.window-content');
    const newMessage = document.createElement('p');
    newMessage.textContent = "Du: " + message;
    contentDiv.appendChild(newMessage);
    inputField.value = "";
    contentDiv.scrollTop = contentDiv.scrollHeight; // Scroll nach unten
}

}

