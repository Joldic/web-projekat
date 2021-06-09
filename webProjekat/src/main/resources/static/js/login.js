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
            alert("logovao sam se");
            if(res.uloga == "ADMINISTRATOR"){
                window.location.href = "NOVASTRANICA.html";
            }else{
                windows.location.href = "KORISNIKSTRANICA.html";
            }    
        },
        error: function(res){
            console.log("ERROR:\n", res);
        }

    });
});
