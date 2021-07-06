//prikaz svih treninga
// $(document).ready(function ()   {
//
//     $.ajax({
//         type: "GET",
//         url: "http://localhost:8090/api/trening",
//         dataType: "json",
//         success: function(res){
//             console.log("SUCCESS: \n", res);
//             for(i=0; i < res.length; i++){
//                 let row = "<tr>";
//                 row += "<td>" + res[i].naziv + "</td>";
//                 row += "<td>" + res[i].opis + "</td>";
//                 row += "<td>" + res[i].tipTreninga + "</td>";
//                 row += "<td>" + res[i].trajanje + "</td>";
//
//                 row += "</tr>";
//                 $('#trenings').append(row);
//             }
//         },
//         error: function (res){
//             console.log("ERROR: \n", res);
//         }
//     });
// });

$(document).ready(function ()   {


    $.ajax({
        type: "GET",
        url: "http://localhost:8090/api/termini/proba",
        dataType: "json",
        success: function(res){
            console.log("SUCCESS: \n", res);
            for(i=0; i < res.length; i++){
                let row = "<tr>";
                row += "<td>" + res[i].naziv + "</td>";
                row += "<td>" + res[i].opis + "</td>";
                row += "<td>" + res[i].tipTreninga + "</td>";
                row += "<td>" + res[i].trajanje + "</td>";
                row += "<td>" + res[i].vremeTermina + "</td>";
                row += "<td>" + res[i].cena + "</td>";

                row += "</tr>";
                $('#trenings').append(row);
            }
        },
        error: function (res){
            console.log("ERROR: \n", res);
        }
    });
});


$(document).ready(function() {
    $('.filter').multifilter();
})



