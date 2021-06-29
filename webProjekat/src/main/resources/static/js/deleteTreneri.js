$(document).ready(function(){
    var korId = localStorage.getItem("id");

    $.ajax({
        type: "GET",
        url:"http://localhost:8090/api/korisnik/Uloga/" + korId,
        dataType: "json",
        contentType: "application/json",
        success: function (res){
            console.log(res);
            // alert("admin je na stranici");
        },
        error: function (){
            alert("Greska niste ADMIN");
            window.location.href = "index.html";
        }
    });
});

$(document).ready(function(){
    $.ajax({
        type: "GET",
        url:"http://localhost:8090/api/korisnik/lista/treneri" ,
        dataType: "json",
        success: function(res){
            console.log("SUCCESS:\n", res);
            for(i=0; i<res.length; i++){
                let row = "<tr>";
                row += "<td>" + res[i].korisnickoIme + "</td>";
                row += "<td>" + res[i].lozinka + "</td>";
                row += "<td>" + res[i].ime + "</td>";
                row += "<td>" + res[i].prezime + "</td>";
                row += "<td>" + res[i].kontaktTelefon + "</td>";
                row += "<td>" + res[i].eMail + "</td>";
                row += "<td>" + res[i].datumRodjenja + "</td>";
                row += "<td>" + res[i].prosecnaOcena + "</td>";

                let btn = "<button class='btnDelete' data-id=" + res[i].id + ">DELETE</button>";
                row += "<td>" + btn + "</td>";


                row += "</tr>";
                $('#delete').append(row);
            }
        },
        error: function(res){
            console.log("ERROR: \n", res);
            alert("GRESKA NISTE ADMIN");
            window.location.href="index.html";
        }
    });
});


$(document).on('click', '.btnDelete', function(){
    let korId = this.dataset.id;

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8090/api/korisnik/" + korId,
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