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


$(document).ready(function ()   {
    var salaID = localStorage.getItem("salaId");
    $.ajax({
        type: "GET",
        url: "http://localhost:8090/api/sala/listaTerminaClan/" + salaID,
        dataType: "json",
        success: function(res){
            console.log("SUCCESS: \n", res);
            for(i=0; i < res.length; i++){
                let row = "<tr>";
                row += "<td>" + res[i].vremeTermina + "</td>";
                row += "<td>" + res[i].cena + "</td>";
                row += "<td>" + res[i].brojPrijavljenihClanova + "</td>";
                row += "<td>" + salaID + "</td>";
                row += "<td>" + res[i].naziv + "</td>";
                row += "<td>" + res[i].opis + "</td>";
                row += "<td>" + res[i].tipTreninga + "</td>";
                row += "<td>" + res[i].trajanje + "</td>";

                
                let btn = "<button class='btnPrijava' data-id=" + res[i].id + ">PRIJAVA</button>"; //ovde se cuva ID_termina
            
                row += "<td>" + btn + "</td>";
                
                row += "</tr>";
                $('#idTermin').append(row);
            }
        },
        error: function (res){
            console.log("ERROR: \n", res);
        }
    });
});

$(document).on('click', '.btnPrijava', function(){
    
    let terminID = this.dataset.id;
    let korID = localStorage.getItem("id");

    var odradjen = false;
    var ocena = 0;

    var newPrijava = {
        odradjen,
        ocena
    }
    console.log(newPrijava);


    $.ajax({
        type: "POST",
        url: "http://localhost:8090/api/prijava/" + terminID + "/" + korID,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newPrijava),
        success: function(res){
            console.log("SUCCES:\n", res);
            //location.reload();
            alert("PRIJAVA je uspesno kreirana");
        },
        error: function(res){
            console.log("ERROR\n", res);
        }
    });
});

