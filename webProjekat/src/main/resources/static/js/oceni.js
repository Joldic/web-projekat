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


$(document).on("submit", "form", function(event){
    event.preventDefault();

    var prijavaID = localStorage.getItem("prijavaId");

    var ocena = $("#ocena").val();

    console.log(ocena);

    $.ajax({
        type: "PUT",
        url: "http://localhost:8090/api/prijava/" + prijavaID,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(ocena),
        success: function (res){
            console.log(res);
            alert("ocena je uspesno dodata");
            window.location.href = "profil.html";
        },
        error: function(){
            alert("Greska!");
        }
    });

});