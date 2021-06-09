$(document).ready(function(){
    $.ajax({
        type: "GET",
        url:"http://localhost:8090/api/korisnik/zahteviTreneri",
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

                let btn = "<button class='btnAccept' data-id=" + res[i].id + ">Prihvati</button>";
                let btn2 = "<button class='btnReject' data-id=" + res[i].id + ">Odbij</button>";
                row += "<td>" + btn + "</td>";
                row += "<td>" + btn2 + "</td>";

                row += "</tr>";
                $('#zahtevi').append(row);
            }
        },
        error: function(res){
            console.log("ERROR: \n", res);
        }
    });
});

$(document).on('click', '.btnAccept', function(){
    let korId = this.dataset.id;


    $.ajax({
        type: "PUT",
        url: "http://localhost:8090/api/korisnik/zahteviTreneri/" + korId,
        dataType: "json",
        contentType:"application/json",
        success: function(res){
            console.log("SUCCESS:\n", res);
        },
        error: function(res){
            console.log("ERROR\n", res);
        }
    });
});

$(document).on('click', '.btnReject', function(){
    let korId = this.dataset.id;

    $.ajax({
        type: "DELETE",
        url: "http://localhost:8090/api/korisnik/" + korId,
        dataType: "json",
        contentType: "application/json",
        success: function(res){
            console.log("SUCCES:\n", res);
        },
        error: function(res){
            console.log("ERROR\n", res);
        }
    });
});