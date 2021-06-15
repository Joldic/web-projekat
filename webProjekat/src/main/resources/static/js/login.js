$(document).on("submit", "form", function(event){
    event.preventDefault();
    console.log("usao");
    var korisnickoIme = $("#korisnickoIme").val();
    var lozinka = $("#lozinka").val();

    $.ajax({
        type: "GET",
        url: "http://localhost:8090/api/korisnik/" + korisnickoIme +"/" + lozinka,
        dataType: "json",
        contentType: "application/json",
        success: function(res){
            console.log("SUCCESS:\n",res);
            localStorage.setItem("id", res.id);
            console.log(localStorage.getItem("id"));
           // if(res.uloga == "ADMINISTRATOR"){
               // window.location.href = "NOVASTRANICA.html";
           // }else{
             //   window.location.href = "KORISNIKSTRANICA.html";
           // }
           window.location.href = "login.html";
        },
        error: function(res){
            console.log("ERROR:\n", res);
        }

    });
});

// $(document).on('click', '.zahteviID', function(){
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
//             window.location.href = "treneriZahtevi.html";
//         },
//         error: function (){
//             alert("Greska niste ADMIN");
//         }
//     });
//
// });