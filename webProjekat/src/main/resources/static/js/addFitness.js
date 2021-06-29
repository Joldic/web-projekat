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







//kreiranje novog fitness centra
$(document).on("submit", "form", function(event){
    event.preventDefault();

    var naziv = $("#naziv").val();
    var adresa = $("#adresa").val();
    var brojTelefonaCentrale = $("#brojTelefonaCentrale").val();
    var eMail = $("#eMail").val();

    var newFitnessCentar = {
        naziv,
        adresa,
        brojTelefonaCentrale,
        eMail
    }
    console.log(newFitnessCentar);

    $.ajax({
        type: "POST",
        url: "http://localhost:8090/api/fitnesscentar",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newFitnessCentar),
        success: function (res){
            console.log(res);
            alert("Fitnes centar je uspesno kreairan");
            window.location.href = "fitnessCentar.html";
        },
        error: function(){
            alert("Greska!");
        }
    });

});