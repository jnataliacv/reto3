// RESERVACION
function traerRerserva(){
    //funcion GET
    $.ajax({
        url:'http://158.101.101.23/api/Reservation/all',
        type:'GET',
        dataType:'json',

        success: function(Reservacion){  //funcion guarda la get data en variable Mensaje
            let cv = Reservacion.items;
            $("#ListaReservacion").empty();
            for(i=0;i<cv.length;i++){
                $("#listaReservacion").append("<b>"+cv[i].id +' '+cv[i].fechainicio+"</b> "+cv[i].fechadevolucion+"</br>")
            }
        },
        error: function(xhr, status){
            alert("ERROR ");
        }
    });
}

function guardarReservacion(){
    //funcion POST
    let idReservacion = $("#idReservacion").val();  //guardar los atrubitos en la funcion
    let Fechainicio = $("#fechainicio").val();
    let fechadevolucion = $("#fechadevolucion").val();

    let Reservacion = {   //crear json
        id : idReservacion,
        fecha_inicio: fechainicio,
        fecha_devolucion: fechadevolucion,
    };
    const req = new XMLHttpRequest();
    req.open('POST', 'http://158.101.101.23/api/Reservation/save');
    req.setRequestHeader('Content-Type','application/json');
    req.addEventListener('load', function(){
        if(req.status == 201){  //si el estatus del rquest es exitoso
            console.log(req.status)
        }else{  // de lo contario lance error
            throw new Error("BAD POST REQUEST");
        }
    });
    req.send(JSON.stringify(Reservacion));
}

function updateReservacion(){
    //funcion PUT
    let idReservacion = $("#idReservacion").val();  //actualiza los atributos
    let fechainicio = $("#fechainicio").val();
    let fechadevolucion = $("#fechadevolucion").val();

    let Reserva = {
        id : idReservacion,
        fecha_inicio: fechainicio,
        fecha_devolucion: fechadevolucion,
    };

    const req = new XMLHttpRequest();
    req.open('PUT', 'http://158.101.101.23/api/Reservation/update');
    req.setRequestHeader('content-type', 'application/json');
    req.addEventListener('load', function(){
        if(req.status == 200 ){
            console.log(req.status);
        }else{
            throw new Error("BAD PUT REQUEST")
        }
    });
    req.send(JSON.stringify(info));
}

function deleteReservacion(){
    //funcion delete

    let idReservacion = $("#idReservacion").val();
    let Reserva = {
        id: idReservacion
    };
    let datatosend = JSON.stringify(info);
    $.ajax({
        url:'http://158.101.101.23/api/Reservation/delete',
        type:'DELETE',
        data: datatosend,
        contentType:'application/json',
        dataType: 'json',
        success: function(response){
            traerRerserva();
            alert("se ha eliminado");
        }
    })
};