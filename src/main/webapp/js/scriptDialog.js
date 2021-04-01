$(document).ready(function(){
    $("#textSave").value = null;
    $(".back-dialog").hide(); //скрываем окно при загрузке страница
});

function openDialogEdit(id){
    let butEdit = document.getElementById("butEdit");
    let text = document.getElementById("nameEdit");
    let element = document.getElementById("element" + id);
    butEdit.value = element.value.split(" ")[0];
    text.value = element.value.split(" ")[1];
    $("#dialogEdit").fadeIn(); //плавное появление блока
}

function openDialogSave(){
    $("#dialogSave").fadeIn(); //плавное появление блока
}


function closedialog(){
    $(".back-dialog").fadeOut(); //плавное исчезание блока
}