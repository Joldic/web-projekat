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


//dobavljanje liste treninga
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
  
                
                row += "</tr>";
                $('#idTermin').append(row);
            }
        },
        error: function (res){
            console.log("ERROR: \n", res);
        }
    });
});