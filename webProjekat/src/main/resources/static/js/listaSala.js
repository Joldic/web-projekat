$(document).ready(function(){
    var korId = localStorage.getItem("id");

    $.ajax({
        type: "GET",
        url:"http://localhost:8090/api/korisnik/Uloga/" + korId,
        dataType: "json",
        contentType: "application/json",
        success: function (res){
            console.log(res);
            //alert("admin je na stranici");
        },
        error: function (){
            alert("Greska niste ADMIN");
            window.location.href = "index.html";
        }
    });
});

//prikaz svih sala
$(document).ready(function(){
    var fitID = localStorage.getItem("fitnessId");

    $.ajax({
        type: "GET",
        url: "http://localhost:8090/api/fitnesscentar/listaSala/" + fitID ,
        dataType: "json",
        success: function(res){
            console.log("SUCCESS:\n", res);
            for(let temp of res){
                let row = "<tr>";

                row += "<td>" + temp.oznakaSale + "</td>";
                row += "<td>" + temp.kapacitet + "</td>";
                row += "<td>" + fitID + "</td>";


                let btn = "<button class='btnDeleteSala' data-id=" + temp.id + ">DELETE</button>";
                let btn2 = "<button class='btnIzmeni' data-id=" + temp.id + ">Izmeni</button>";

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

$(document).on('click', '.btnIzmeni', function(){
    localStorage.setItem("salaId", this.dataset.id);
    window.location.href = "izmenaSale.html";
});


//brisanje sale
$(document).on('click', '.btnDeleteSala', function(){
    let salaId = this.dataset.id;
    console.log(salaId);

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8090/api/sala/" + salaId,
        dataType: "json",
        contentType: "application/json",
        success: function(res){
            console.log("SUCCES:\n", res);
            location.reload();
        },
        error: function(res){
            console.log("ERROR\n", res);
        }
    });
});
