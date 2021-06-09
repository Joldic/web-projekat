//prikaz svih fitnes centara
$(document).ready(function(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8090/api/fitnesscentar",
        dataType: "json",
        success: function(res){
            console.log("SUCCESS:\n", res);
            for(i=0; i < res.length; i++){
                let row = "<tr>";
                row += "<td>" + res[i].naziv + "</td>";
                row += "<td>" + res[i].adresa + "</td>";
                row += "<td>" + res[i].brojTelefonaCentrale + "</td>";
                row += "<td>" + res[i].eMail + "</td>";

               // let btn = "<button class=btnSeeMore data-id=" + res[i].id + ">SeeMore</button>";
                //row += "<td>" + btn + "<td>";
                row += "</tr>";
                $('#fitnesscentar').append(row);
            }
        },
        error: function(res){
            console.log("ERROR:\n", res);
        }
    });
});

//Kreiranje novog fitness centra
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