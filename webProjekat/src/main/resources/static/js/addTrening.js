
//sta se desi kad se klikne add
$(document).on("submit", "form", function(event){
    event.preventDefault();

    var korID = localStorage.getItem("id");

    var naziv = $("#naziv").val();
    var opis = $("#opis").val();
    var tipTreninga = $("#tipTreninga").val();
    var trajanje = $("#trajanje").val();


    var newTrening = {
        naziv,
        opis,
        tipTreninga,
        trajanje
    }
    console.log(newTrening);

    $.ajax({
        type: "POST",
        url: "http://localhost:8090/api/trening/" + korID,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newTrening),
        success: function (res){
            console.log(res);
            alert("Trening je uspesno kreiran");
            window.location.href = "addTermin.html";
        },
        error: function(){
            alert("Greska!");
        }
    });

});