$(document).ready(function(){
    var korId = localStorage.getItem("id");

    $.ajax({
        type: "GET",
        url:"http://localhost:8090/api/korisnik/Uloga/" + korId,
        dataType: "json",
        contentType: "application/json",
        success: function (res){
            console.log(res);
           // alert("admin je na stranici");
        },
        error: function (){
            alert("Greska niste ADMIN");
            window.location.href = "index.html";
        }
    });
});


$(document).on("submit", "form", function(event){
    event.preventDefault();

    var salaId = localStorage.getItem("salaId");

    var kapacitet = $("#kapacitet").val();
    var oznakaSale = $("#oznakaSale").val();


    var newSala = {
        kapacitet,
        oznakaSale
    }
    console.log(newSala);

    $.ajax({
        type: "PUT",
        url: "http://localhost:8090/api/sala/" + salaId,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newSala),
        success: function (res){
            console.log(res);
            alert("Sala je uspesno azurirana");
            window.location.href = "listaSala.html";
        },
        error: function(){
            alert("Greska!");
        }
    });

});