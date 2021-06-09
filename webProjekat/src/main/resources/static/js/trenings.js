//prikaz svih treninga
$(document).ready(function ()   {

    $.ajax({
        type: "GET",
        url: "http://localhost:8090/api/trening",
        dataType: "json",
        success: function(res){
            console.log("SUCCESS: \n", res);
            for(i=0; i < res.length; i++){
                let row = "<tr>";
                row += "<td>" + res[i].naziv + "</td>";
                row += "<td>" + res[i].opis + "</td>";
                row += "<td>" + res[i].tipTreninga + "</td>";
                row += "<td>" + res[i].trajanje + "</td>";

                row += "</tr>";
                $('#trenings').append(row);
            }
        },
        error: function (res){
            console.log("ERROR: \n", res);
        }
    });
});


$(document).on('click', '#nazivASC', function(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8090/api/trening/nazivASC",
        dataType: "json",
        success: function(response){
            console.log("SUCCESS:\n", response);
            $('#trenings').find('tbody').children( 'tr:not(:first)').remove();
            for(let trening of response){
                let row = "<tr>";
               
                row += "<td>" + trening.naziv + "</td>";
                row += "<td>" + trening.opis + "</td>";
                row += "<td>" + trening.tipTreninga + "</td>";
                row += "<td>" + trening.trajanje + "</td>";

                row += "</tr>";
                $('#trenings').append(row);
            }
        },
        error: function(response){
            console.log("ERROR: \n", response);
        }
    });
});

$(document).on('click', '#nazivDESC', function(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8090/api/trening/nazivDESC",
        dataType: "json",
        success: function(response){
            console.log("SUCCESS:\n", response);
            $('#trenings').find('tbody').children( 'tr:not(:first)').remove();
            for(let trening of response){
                let row = "<tr>";
               
                row += "<td>" + trening.naziv + "</td>";
                row += "<td>" + trening.opis + "</td>";
                row += "<td>" + trening.tipTreninga + "</td>";
                row += "<td>" + trening.trajanje + "</td>";

                row += "</tr>";
                $('#trenings').append(row);
            }
        },
        error: function(response){
            console.log("ERROR: \n", response);
        }
    });
});

$(document).on('click', '#opisASC', function(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8090/api/trening/opisASC",
        dataType: "json",
        success: function(response){
            console.log("SUCCESS:\n", response);
            $('#trenings').find('tbody').children( 'tr:not(:first)').remove();
            for(let trening of response){
                let row = "<tr>";
               
                row += "<td>" + trening.naziv + "</td>";
                row += "<td>" + trening.opis + "</td>";
                row += "<td>" + trening.tipTreninga + "</td>";
                row += "<td>" + trening.trajanje + "</td>";

                row += "</tr>";
                $('#trenings').append(row);
            }
        },
        error: function(response){
            console.log("ERROR: \n", response);
        }
    });
});

$(document).on('click', '#opisDESC', function(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8090/api/trening/opisDESC",
        dataType: "json",
        success: function(response){
            console.log("SUCCESS:\n", response);
            $('#trenings').find('tbody').children( 'tr:not(:first)').remove();
            for(let trening of response){
                let row = "<tr>";
               
                row += "<td>" + trening.naziv + "</td>";
                row += "<td>" + trening.opis + "</td>";
                row += "<td>" + trening.tipTreninga + "</td>";
                row += "<td>" + trening.trajanje + "</td>";

                row += "</tr>";
                $('#trenings').append(row);
            }
        },
        error: function(response){
            console.log("ERROR: \n", response);
        }
    });
});

$(document).on('click', '#tipASC', function(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8090/api/trening/tipTreningaASC",
        dataType: "json",
        success: function(response){
            console.log("SUCCESS:\n", response);
            $('#trenings').find('tbody').children( 'tr:not(:first)').remove();
            for(let trening of response){
                let row = "<tr>";
               
                row += "<td>" + trening.naziv + "</td>";
                row += "<td>" + trening.opis + "</td>";
                row += "<td>" + trening.tipTreninga + "</td>";
                row += "<td>" + trening.trajanje + "</td>";

                row += "</tr>";
                $('#trenings').append(row);
            }
        },
        error: function(response){
            console.log("ERROR: \n", response);
        }
    });
});

$(document).on('click', '#tipDESC', function(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8090/api/trening/tipTreningaDESC",
        dataType: "json",
        success: function(response){
            console.log("SUCCESS:\n", response);
            $('#trenings').find('tbody').children( 'tr:not(:first)').remove();
            for(let trening of response){
                let row = "<tr>";
               
                row += "<td>" + trening.naziv + "</td>";
                row += "<td>" + trening.opis + "</td>";
                row += "<td>" + trening.tipTreninga + "</td>";
                row += "<td>" + trening.trajanje + "</td>";

                row += "</tr>";
                $('#trenings').append(row);
            }
        },
        error: function(response){
            console.log("ERROR: \n", response);
        }
    });
});

$(document).on('click', '#trajanjeASC', function(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8090/api/trening/trajanjeASC",
        dataType: "json",
        success: function(response){
            console.log("SUCCESS:\n", response);
            $('#trenings').find('tbody').children( 'tr:not(:first)').remove();
            for(let trening of response){
                let row = "<tr>";
               
                row += "<td>" + trening.naziv + "</td>";
                row += "<td>" + trening.opis + "</td>";
                row += "<td>" + trening.tipTreninga + "</td>";
                row += "<td>" + trening.trajanje + "</td>";

                row += "</tr>";
                $('#trenings').append(row);
            }
        },
        error: function(response){
            console.log("ERROR: \n", response);
        }
    });
});

$(document).on('click', '#trajanjeDESC', function(){
    $.ajax({
        type: "GET",
        url: "http://localhost:8090/api/trening/trajanjeDESC",
        dataType: "json",
        success: function(response){
            console.log("SUCCESS:\n", response);
            $('#trenings').find('tbody').children( 'tr:not(:first)').remove();
            for(let trening of response){
                let row = "<tr>";
               
                row += "<td>" + trening.naziv + "</td>";
                row += "<td>" + trening.opis + "</td>";
                row += "<td>" + trening.tipTreninga + "</td>";
                row += "<td>" + trening.trajanje + "</td>";

                row += "</tr>";
                $('#trenings').append(row);
            }
        },
        error: function(response){
            console.log("ERROR: \n", response);
        }
    });
});