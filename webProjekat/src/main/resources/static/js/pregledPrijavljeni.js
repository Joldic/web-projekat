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
    var korID = localStorage.getItem("id");
    $.ajax({
        type: "GET",
        url: "http://localhost:8090/api/prijava/prijavljeni/" + korID,
        dataType: "json",
        success: function(res){
            console.log("SUCCESS: \n", res);
            for(i=0; i < res.length; i++){
                let row = "<tr>";
                row += "<td>" + res[i].vremeTermina + "</td>";
                row += "<td>" + res[i].cena + "</td>";
                row += "<td>" + res[i].brojPrijavljenihClanova + "</td>";
                row += "<td>" + res[i].naziv + "</td>";
                row += "<td>" + res[i].opis + "</td>";
                row += "<td>" + res[i].tipTreninga + "</td>";
                row += "<td>" + res[i].trajanje + "</td>";

                
                let btn = "<button class='btnOtkazi' data-id=" + res[i].prijavaID + ">OTKAZI</button>"; //ovde se cuva ID_prijave
                let btn2 = "<button class='btnOdradi' data-id=" + res[i].prijavaID + ">Odradi</button>"; 
                //console.log(res[i].prijavaID);

                row += "<td>" + btn + "</td>";
                row += "<td>" + btn2 + "</td>";
                
                row += "</tr>";
                $('#idTermin').append(row);
            }
        },
        error: function (res){
            console.log("ERROR: \n", res);
        }
    });
});

$(document).on('click', '.btnOtkazi', function(){
    prijavaID = this.dataset.id;

   
        $.ajax({
            type: "DELETE",
            url: "http://localhost:8090/api/prijava/" + prijavaID,
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



$(document).on('click', '.btnOdradi', function(){
    prijavaID = this.dataset.id;

   
        $.ajax({
            type: "PUT",
            url: "http://localhost:8090/api/prijava/odradi/" + prijavaID,
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
