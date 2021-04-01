document.addEventListener("DOMContentLoaded", selectedValue);

function findIdElements(elements, select, text, textHidden) {
    elements.values = elements.value.replace("[", "");
    elements.values = elements.value.replace("]", "");
    let tempMas = elements.value.split(",");
    let mas = new Array;
    for (let i = 0; i < tempMas.length; i++) {
        let temp = tempMas[i].split(" ");
        if (temp[0] === "") {
            mas[i] = temp[1];
        } else {
            mas[i] = temp[0];
        }
        mas[i] = mas[i].replace("[", "");
        mas[i] = mas[i].replace("]", "");
    }
    selectedElements(mas, select, text, textHidden)
}

function selectedElements(mas, select, text, textHidden) {
    let lengthS = select.options.length;
    let lengthM = mas.length;
    for (let i = 0; i < lengthS; i++) {
        select.options[i].selected = false;
        for (let j = 0; j < lengthM; j++) {
            let temp = select.options[i].value;
            if (temp == mas[j]) {
                select.options[i].selected = true;
            }
        }
    }
    helper(select, text, textHidden);
}

function selectedValue() {
    let selectA = document.getElementById("idActor");
    let textA = document.getElementById("idTextActor");
    let textHiddenA = document.getElementById("idHiddenActor");
    let elementsA = document.getElementById("currentActors")
    findIdElements(elementsA, selectA, textA, textHiddenA)
    let selectG = document.getElementById("idGenre");
    let textG = document.getElementById("idTextGenre");
    let textHiddenG = document.getElementById("idHiddenGenre");
    let elementsG = document.getElementById("currentGenres");
    findIdElements(elementsG, selectG, textG, textHiddenG);
    let select = document.getElementById("idCountry");
    let text = document.getElementById("idTextCountry");
    let textHidden = document.getElementById("idHiddenCountry");
    let elements = document.getElementById("currentCountries");
    findIdElements(elements, select, text, textHidden)
}

function helper(select, text, textHidden) {
    let length = select.options.length;
    let mas = new Array();
    let masHidden = new Array();
    let index = 0;

    text.readonly = false;
    for (let i = 0; i < length; i++) {
        if (select.options[i].selected === true) {
            mas[index] = select.options[i].text;
            masHidden[index++] = select.options[i].value;
        }
    }
    text.readonly = true;

    textHidden.value = masHidden;
    text.value = masHidden;
}

function addTextActor() {
    let select = document.getElementById("idActor");
    let text = document.getElementById("idTextActor");
    let textHidden = document.getElementById("idHiddenActor");
    helper(select, text, textHidden);
}

function addTextGenre() {
    let select = document.getElementById("idGenre");
    let text = document.getElementById("idTextGenre");
    let textHidden = document.getElementById("idHiddenGenre");
    helper(select, text, textHidden);
}

function addTextCountry() {
    let select = document.getElementById("idCountry");
    let text = document.getElementById("idTextCountry");
    let textHidden = document.getElementById("idHiddenCountry");
    helper(select, text, textHidden);
}