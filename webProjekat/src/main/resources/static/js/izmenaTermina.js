$(document).ready(function(){
    var korId = localStorage.getItem("id");

    $.ajax({
        type: "GET",
        url:"http://localhost:8090/api/korisnik/Uloga/trener/" + korId,
        dataType: "json",
        contentType: "application/json",
        success: function (res){
            console.log(res);
            // alert("admin je na stranici");
        },
        error: function (){
            alert("Greska niste TRENER");
            window.location.href = "index.html";
        }
    });
});

//autofil forma
$(document).ready(function(){
    var terminID = localStorage.getItem("terminId");

    $.ajax({
        type: "GET",
        url:"http://localhost:8090/api/termini/" + terminID,
        dataType: "json",
        contentType: "application/json",
        success: function (res){
            console.log(res);
            document.getElementById('cena').value = res.cena;
            document.getElementById('vremeTermina').value = res.vremeTermina;
        },
        error: function (){
            alert("Greska");
            window.location.href = "index.html";
        }
    });
});





$(document).on("submit", "form", function(event){
    event.preventDefault();

    var terminID = localStorage.getItem("terminId");

    var cena = $("#cena").val();
    var vremeTermina = $("#vremeTermina").val();

    var newTermin = {
        cena,
        vremeTermina,
    }

    console.log(newTermin);

    $.ajax({
        type: "PUT",
        url: "http://localhost:8090/api/termini/izmeniTermin/" + terminID,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newTermin),
        success: function (res){
            console.log(res);
            alert("Termin je uspesno azuriran");
            window.location.href = "listaTermina.html";
        },
        error: function(){
            alert("Greska!");
        }
    });

});