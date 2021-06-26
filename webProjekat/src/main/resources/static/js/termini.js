$(document).ready(function ()   {

    $.ajax({
        type: "GET",
        url: "http://localhost:8090/api/termini",
        dataType: "json",
        success: function(res){
            console.log("SUCCESS: \n", res);
            for(i=0; i < res.length; i++){
                let row = "<tr>";
                row += "<td>" + res[i].brojPrijavljenihClanova + "</td>";
                row += "<td>" + res[i].vremeTermina + "</td>";
                row += "<td>" + res[i].cena + "</td>";

                row += "</tr>";
                $('#idTermin').append(row);
            }
        },
        error: function (res){
            console.log("ERROR: \n", res);
        }
    });
});

$(document).on('click', '#cenaASC', function(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8090/api/termini/cenaASC",
        dataType: "json",
        success: function(response){
            console.log("SUCCESS:\n", response);
            $('#idTermin').find('tbody').children( 'tr:not(:first)').remove();
            for(let termin of response){
                let row = "<tr>";

                row += "<td>" + termin.brojPrijavljenihClanova + "</td>";
                row += "<td>" + termin.vremeTermina + "</td>";
                row += "<td>" + termin.cena + "</td>";

                row += "</tr>";
                $('#idTermin').append(row);
            }
        },
        error: function(response){
            console.log("ERROR: \n", response);
        }
    });
});

$(document).on('click', '#cenaDESC', function(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8090/api/termini/cenaDESC",
        dataType: "json",
        success: function(response){
            console.log("SUCCESS:\n", response);
            $('#idTermin').find('tbody').children( 'tr:not(:first)').remove();
            for(let termin of response){
                let row = "<tr>";

                row += "<td>" + termin.brojPrijavljenihClanova + "</td>";
                row += "<td>" + termin.vremeTermina + "</td>";
                row += "<td>" + termin.cena + "</td>";

                row += "</tr>";
                $('#idTermin').append(row);
            }
        },
        error: function(response){
            console.log("ERROR: \n", response);
        }
    });
});

$(document).on('click', '#vremeASC', function(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8090/api/termini/vremeASC",
        dataType: "json",
        success: function(response){
            console.log("SUCCESS:\n", response);
            $('#idTermin').find('tbody').children( 'tr:not(:first)').remove();
            for(let termin of response){
                let row = "<tr>";

                row += "<td>" + termin.brojPrijavljenihClanova + "</td>";
                row += "<td>" + termin.vremeTermina + "</td>";
                row += "<td>" + termin.cena + "</td>";

                row += "</tr>";
                $('#idTermin').append(row);
            }
        },
        error: function(response){
            console.log("ERROR: \n", response);
        }
    });
});

$(document).on('click', '#vremeDESC', function(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8090/api/termini/vremeDESC",
        dataType: "json",
        success: function(response){
            console.log("SUCCESS:\n", response);
            $('#idTermin').find('tbody').children( 'tr:not(:first)').remove();
            for(let termin of response){
                let row = "<tr>";

                row += "<td>" + termin.brojPrijavljenihClanova + "</td>";
                row += "<td>" + termin.vremeTermina + "</td>";
                row += "<td>" + termin.cena + "</td>";

                row += "</tr>";
                $('#idTermin').append(row);
            }
        },
        error: function(response){
            console.log("ERROR: \n", response);
        }
    });
});