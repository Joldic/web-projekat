$(document).ready(function(){
    var korId = localStorage.getItem("id");

    $.ajax({
        type: "GET",
        url:"http://localhost:8090/api/korisnik/Uloga/clan/" + korId,
        dataType: "json",
        contentType: "application/json",
        success: function (res){
            console.log(res);
            // alert("admin je na stranici");
        },
        error: function (){
            alert("Greska niste CLAN");
            window.location.href = "index.html";
        }
    });
});

//prikaz sala za taj fitness centar
$(document).ready(function(){
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


                let btn = "<button class='btnShowTerm' data-id=" + temp.id + ">Show termini</button>";

                row += "<td>" + btn + "</td>";

                row += "</tr>";
                $('#sale').append(row);
            }
        },
        error: function(res){
            console.log("ERROR:\n", res);
        }
    });
});


$(document).on('click', '.btnShowTerm', function(){
    localStorage.setItem("salaId", this.dataset.id);
    window.location.href = "listaTerminaClan.html";
});