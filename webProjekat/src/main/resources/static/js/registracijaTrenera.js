$(document).on("submit", "form", function(event){
    event.preventDefault();

    var korisnickoIme = $("#korisnickoIme").val();
    var lozinka = $("#lozinka").val();
    var ime = $("#ime").val();
    var prezime = $("#prezime").val();
    var kontaktTelefon = $("#kontaktTelefon").val();
    var eMail = $("#eMail").val();
    var datumRodjenja = $("#datumRodjenja").val();
    
    

    var newTrener = {
        korisnickoIme,
        lozinka,
        ime,
        prezime,
        kontaktTelefon,
        eMail,
        datumRodjenja,  
    }

    console.log(newTrener);

    $.ajax({
        type: "POST",
        url: "http://localhost:8090/api/korisnik/registracijaTrenera",
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newTrener),
        success: function(res){
            console.log(res);
            window.location.href = "login.html";
        },
        error: function(){
            alert("Greska!");
        }
    });

});