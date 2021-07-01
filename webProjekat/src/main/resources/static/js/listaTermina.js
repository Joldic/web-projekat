$(document).ready(function ()   {
    var salaID = localStorage.getItem("salaId");
    $.ajax({
        type: "GET",
        url: "http://localhost:8090/api/sala/listaTermina/" + salaID,
        dataType: "json",
        success: function(res){
            console.log("SUCCESS: \n", res);
            for(i=0; i < res.length; i++){
                let row = "<tr>";
                row += "<td>" + res[i].brojPrijavljenihClanova + "</td>";
                row += "<td>" + res[i].vremeTermina + "</td>";
                row += "<td>" + res[i].cena + "</td>";
                row += "<td>" + salaID + "</td>";

                
                let btn = "<button class='btnIzmeniTermin' data-id=" + res[i].id + ">Izmeni</button>";
            
                row += "<td>" + btn + "</td>";
                
                row += "</tr>";
                $('#idTermin').append(row);
            }
        },
        error: function (res){
            console.log("ERROR: \n", res);
        }
    });
});




$(document).on('click', '.btnIzmeniTermin', function(){
    localStorage.setItem("terminId", this.dataset.id);
    window.location.href = "izmenaTermina.html";
});
