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

//prikaz podataka o clanu koji je ulogovan
$(document).ready(function(){

    var korId = localStorage.getItem("id");
    $.ajax({
        type: "GET",
        url:"http://localhost:8090/api/korisnik/" + korId,
        dataType: "json",
        success: function(res){
            console.log("SUCCESS:\n", res);
            
                let row = "<tr>";
                row += "<td>" + res.korisnickoIme + "</td>";
                row += "<td>" + res.lozinka + "</td>";
                row += "<td>" + res.ime + "</td>";
                row += "<td>" + res.prezime + "</td>";
                row += "<td>" + res.kontaktTelefon + "</td>";
                row += "<td>" + res.eMail + "</td>";
                row += "<td>" + res.datumRodjenja + "</td>";
                

                let btn = "<button class='btnPregledPrijavljeni' data-id=" + res.id + ">Pregled prijavljenih</button>";
                let btn2 = "<button class='btnPregledOdradjeni' data-id=" + res.id + ">Pregled odradjenih</button>";
                let btn3 = "<button class='btnPregledNeocenjeni' data-id=" + res.id + ">Pregled neocenjeni</button>";
                let btn4 = "<button class='btnOcenjeniOdradjeni' data-id=" + res.id + ">Ocenjeni odradjeni</button>";
                let btn5 = "<button class='btnIzmeniProfil' data-id=" + res.id + ">Izmeni profil</button>";

                row += "<td>" + btn + "</td>";
                row += "<td>" + btn2 + "</td>";
                row += "<td>" + btn3 + "</td>";
                row += "<td>" + btn4 + "</td>";
                row += "<td>" + btn5 + "</td>";

                row += "</tr>";
                $('#zahtevi').append(row);
            
        },
        error: function(res){
            console.log("ERROR: \n", res);
            alert("GRESKA NISTE ADMIN");
            window.location.href="index.html";
        }
    });
});

$(document).on('click', '.btnPregledPrijavljeni', function(){
    window.location.href = "pregledPrijavljeni.html";
});

$(document).on('click', '.btnPregledOdradjeni', function(){
    window.location.href = "pregledOdradjeni.html";
});

$(document).on('click', '.btnPregledNeocenjeni', function(){
    window.location.href = "pregledNeocenjeni.html";
});

$(document).on('click', '.btnOcenjeniOdradjeni', function(){
    window.location.href = "pregledOO.html";
});