console.log("collectTextJs wurde geladen")

function collectTextFromBody() {
    const bodyElement = document.body;
    let textArray = [];

        function collectText(node) {
            if (node.nodeType === Node.TEXT_NODE) {
                const text = node.nodeValue.trim();
                if (text) {
                    textArray.push(text);
                }
            } else if (node.nodeType === Node.ELEMENT_NODE) {
                // Rekursiv durch die Kinder tags gehen
                for (let i = 0; i < node.childNodes.length; i++) {
                    collectText(node.childNodes[i]);
                }
            }
        }

    collectText(bodyElement);
    return textArray;
}

//todo hier müssten dann noch mitgeschickt welchen user/sitzung das zuzuweisen ist

function sendTextToAPI(text) {

    let request = new XMLHttpRequest();
    let url = "/ubergabewebsitetext";
    let params = JSON.stringify({"text":text})

    request.open('POST',url,true);
    request.setRequestHeader("Content-Type", "application/json");
    request.send(params);
    console.log("das sind die parameter die bei sendtexttoapi abschickt wurden ", params);

}



sendTextToAPI(collectTextFromBody());