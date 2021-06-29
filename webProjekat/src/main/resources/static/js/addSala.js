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

    var fitnessID = localStorage.getItem("fitnessId");

    var kapacitet = $("#kapacitet").val();
    var oznakaSale = $("#oznakaSale").val();


    var newSala = {
        kapacitet,
        oznakaSale
    }
    console.log(newSala);

    $.ajax({
        type: "POST",
        url: "http://localhost:8090/api/sala/" + fitnessID,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newSala),
        success: function (res){
            console.log(res);
            alert("Sala je uspesno kreirana");
            window.location.href = "fitnessCentar.html";
        },
        error: function(){
            alert("Greska!");
        }
    });

});