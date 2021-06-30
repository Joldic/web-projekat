
//prikaz svih treninga
$(document).ready(function ()   {

    var korID = localStorage.getItem("id");

    $.ajax({
        type: "GET",
        url: "http://localhost:8090/api/trening/" + korID,
        dataType: "json",
        success: function(res){
            console.log("SUCCESS: \n", res);
            for(i=0; i < res.length; i++){
                let row = "<tr>";
                row += "<td>" + res[i].naziv + "</td>";
                row += "<td>" + res[i].opis + "</td>";
                row += "<td>" + res[i].tipTreninga + "</td>";
                row += "<td>" + res[i].trajanje + "</td>";

                let btn = "<button class='btnIzaberi' data-id=" + res[i].id + ">izaberi trening</button>";      // u res[i].id se krije id treninga

                row += "<td>" + btn + "</td>";

                row += "</tr>";
                $('#trenings').append(row);
            }
        },
        error: function (res){
            console.log("ERROR: \n", res);
        }
    });
});

$(document).on('click', '.btnIzaberi', function(){
    localStorage.setItem("treningId", this.dataset.id);

});



$(document).on("submit", "form", function(event){
    event.preventDefault();

    var salaID = localStorage.getItem("salaId");
    var treningID = localStorage.getItem("treningId");

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
        url: "http://localhost:8090/api/termini/" + salaID + "/" + treningID,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newTermin),
        success: function (res){
            console.log(res);
            alert("Termin je uspesno kreiran");
            window.location.href = "trenerTermini.html";
        },
        error: function(){
            alert("Greska!");
        }
    });

});

$(document).on('click', '.addTrening', function(){
    window.location.href = "addTrening.html";
 });