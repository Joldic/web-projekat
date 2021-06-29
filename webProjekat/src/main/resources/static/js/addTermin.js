$(document).on("submit", "form", function(event){
    event.preventDefault();

    var salaID = localStorage.getItem("salaId");

    var cena = $("#cena").val();
    var vremeTermina = $("#vremeTermina").val();
    var brojPrijavljenihClanova = 0;

    var newTermin = {
        cena,
        vremeTermina,
        brojPrijavljenihClanova
    }
    console.log(newTermin);

    $.ajax({
        type: "POST",
        url: "http://localhost:8090/api/termini/" + salaID,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newTermin),
        success: function (res){
            console.log(res);
            alert("Termin je uspesno kreirana");
            window.location.href = "trenerTermini.html";
        },
        error: function(){
            alert("Greska!");
        }
    });

});