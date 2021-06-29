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

//prikaz svih sala za fitnes centar kom pripada nas trener
$(document).ready(function(){
    var fitID = localStorage.getItem("fitnessId");
    var trenerId = localStorage.getItem("id");

    $.ajax({
        type: "GET",
        url: "http://localhost:8090/api/fitnesscentar/listaSala/trener/" + trenerId ,
        dataType: "json",
        success: function(res){
            console.log("SUCCESS:\n", res);
            for(let temp of res){
                let row = "<tr>";

                row += "<td>" + temp.oznakaSale + "</td>";
                row += "<td>" + temp.kapacitet + "</td>";


                let btn = "<button class='btnShowTermini' data-id=" + temp.id + ">Show termini</button>";
                let btn2 = "<button class='btnAddTermin' data-id=" + temp.id + ">Add termin</button>";  //ovde mi se nalazi id sale

                row += "<td>" + btn + "</td>";
                row += "<td>" + btn2 + "</td>";

                row += "</tr>";
                $('#sale').append(row);
            }
        },
        error: function(res){
            console.log("ERROR:\n", res);
        }
    });
});

//prikaz liste sala
$(document).on('click', '.btnShowTermini', function(){
    localStorage.setItem("salaId", this.dataset.id);
    window.location.href = "listaTermina.html";
});

$(document).on('click', '.btnAddTermin', function(){
    localStorage.setItem("salaId", this.dataset.id);
    window.location.href = "addTermin.html";
});