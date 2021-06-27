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

                let btn = "<button class='btnDelete' data-id=" + res[i].id + ">DELETE</button>";
                let btn2 = "<button class='btnAddSala' data-id=" + res[i].id + ">Dodaj salu</button>";

                row += "<td>" + btn + "</td>";
                row += "<td>" + btn2 + "</td>";

                row += "</tr>";
                $('#fitnesscentar').append(row);
            }
        },
        error: function(res){
            console.log("ERROR:\n", res);
        }
    });
});

//brisanje fitness centra
$(document).on('click', '.btnDelete', function(){
    let fitnessCentarId = this.dataset.id;


    $.ajax({
        type: "DELETE",
        url: "http://localhost:8090/api/fitnesscentar/" + fitnessCentarId,
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

//dodavanje sale za odabrani fintess centar
$(document).on('click', '.btnAddSala', function(){
    localStorage.setItem("fitnessId", this.dataset.id);
    window.location.href = "addSala.html";
});




// $(document).on('click', '.addId', function(){
//     var korId = localStorage.getItem(("id"));
//     console.log(localStorage.getItem("id"));
//
//     $.ajax({
//         type: "GET",
//         url:"http://localhost:8090/api/korisnik/Uloga/" + korId,
//         dataType: "json",
//         contentType: "application/json",
//         success: function (res){
//             console.log(res);
//             alert("admin je na stranici");
//             window.location.href = "add-fintessCentar.html";
//         },
//         error: function (){
//             alert("Greska niste ADMIN");
//         }
//     });
//
// });
$(document).on('click', '.addId', function(){
   window.location.href = "add-fintessCentar.html";
});

//Kreiranje novog fitness centra
// $(document).on("submit", "form", function(event){
//     event.preventDefault();
//
//     var naziv = $("#naziv").val();
//     var adresa = $("#adresa").val();
//     var brojTelefonaCentrale = $("#brojTelefonaCentrale").val();
//     var eMail = $("#eMail").val();
//
//     var newFitnessCentar = {
//         naziv,
//         adresa,
//         brojTelefonaCentrale,
//         eMail
//     }
//     console.log(newFitnessCentar);
//
//     $.ajax({
//         type: "POST",
//         url: "http://localhost:8090/api/fitnesscentar",
//         dataType: "json",
//         contentType: "application/json",
//         data: JSON.stringify(newFitnessCentar),
//         success: function (res){
//             console.log(res);
//             alert("Fitnes centar je uspesno kreairan");
//             window.location.href = "fitnessCentar.html";
//         },
//         error: function(){
//             alert("Greska!");
//         }
//     });
//
// });