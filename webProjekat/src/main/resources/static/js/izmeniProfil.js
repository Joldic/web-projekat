$(document).ready(function(){
    var korId = localStorage.getItem("id");

    $.ajax({
        type: "GET",
        url:"http://localhost:8090/api/korisnik/Uloga/clan/" + korId,
        dataType: "json",
        contentType: "application/json",
        success: function (res){
            console.log(res);
            document.getElementById('korisnickoIme').value = res.korisnickoIme;
            document.getElementById('lozinka').value = res.lozinka;
            document.getElementById('ime').value = res.ime;
            document.getElementById('prezime').value = res.prezime;
            document.getElementById('kontaktTelefon').value = res.kontaktTelefon;
            document.getElementById('eMail').value = res.eMail;
            document.getElementById('datumRodjenja').value = res.datumRodjenja;
        },
        error: function (){
            alert("Greska niste CLAN");
            window.location.href = "index.html";
        }
    });
});


$(document).on("submit", "form", function(event){
    event.preventDefault();

    var korId = localStorage.getItem("id");

    var korisnickoIme = $("#korisnickoIme").val();
    var lozinka = $("#lozinka").val();
    var ime = $("#ime").val();
    var prezime = $("#prezime").val();
    var kontaktTelefon = $("#kontaktTelefon").val();
    var eMail = $("#eMail").val();
    var datumRodjenja = $("#datumRodjenja").val();



    var newKorisnik = {
        korisnickoIme,
        lozinka,
        ime,
        prezime,
        kontaktTelefon,
        eMail,
        datumRodjenja
    }
    console.log(newKorisnik);

    $.ajax({
        type: "PUT",
        url: "http://localhost:8090/api/korisnik/izmeniProfil/" + korId,
        dataType: "json",
        contentType: "application/json",
        data: JSON.stringify(newKorisnik),
        success: function (res){
            console.log(res);
            alert("Korisnik  je uspesno azuriran");
            window.location.href = "profil.html";
        },
        error: function(){
            alert("Greska!");
        }
    });

});