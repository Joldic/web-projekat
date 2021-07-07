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

//autofil forma
$(document).ready(function(){
    var fitnessID = localStorage.getItem("fitnessId");

    $.ajax({
        type: "GET",
        url:"http://localhost:8090/api/fitnesscentar/" + fitnessID,
        dataType: "json",
        contentType: "application/json",
        success: function (res){
            console.log(res);
            document.getElementById('naziv').value = res.naziv;
            document.getElementById('adresa').value = res.adresa;
            document.getElementById('brojTelefonaCentrale').value = res.brojTelefonaCentrale;
            document.getElementById('eMail').value = res.eMail;
        },
        error: function (){
            alert("Greska");
            window.location.href = "index.html";
        }
    });
});




//update novog fitness centra
$(document).on("submit", "form", function(event){
    event.preventDefault();

    var fitId = localStorage.getItem("fitnessId");

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
        type: "PUT",
        url: "http://localhost:8090/api/fitnesscentar/" + fitId,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newFitnessCentar),
        success: function (res){
            console.log(res);
            alert("Fitnes centar je uspesno azuriran");
            window.location.href = "fitnessCentar.html";
        },
        error: function(){
            alert("Greska!");
        }
    });

});