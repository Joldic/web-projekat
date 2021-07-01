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