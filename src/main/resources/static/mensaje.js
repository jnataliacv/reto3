// MENSAJES
function traerMensaje(){
    //funcion GET
    $.ajax({
        url:'http://158.101.101.23/api/Message/all',
        type:'GET',
        dataType:'json',

        success: function(Mensaje){  //funcion guarda la get data en variable Mensaje
            let cr = Mensaje.items;
            $("#Listamensajes").empty();
            for(i=0;i<cr.length;i++){
                $("#Listamesajes").append("<b>"+cr[i].id +' '+cr[i].messagetext+"</br>")
            }
        },
        error: function(xhr, status){
            alert("ERROR ");
        }
    });
}

function guardarMensaje(){
    //funcion POST
    let idMensaje = $("#idMensaje").val();  //guardar los atrubitos en la funcion
    let Text = $("#messagetext").val();

    let Mensajes = {   //crear json
        id : idMensaje,
        messagetext : Text
    };
    const req = new XMLHttpRequest();
    req.open('POST', 'http://158.101.101.23/api/Message/save');
    req.setRequestHeader('Content-Type','application/json');
    req.addEventListener('load', function(){
        if(req.status == 201){  //si el estatus del rquest es exitoso
            console.log(req.status)
        }else{  // de lo contario lance error
            throw new Error("BAD POST REQUEST");
        }
    });
    req.send(JSON.stringify(Mensajes));
}

function updateMensaje(){
    //funcion PUT
    let idMensaje = $("#idMensaje").val();
    let Text = $("#messagetext").val();

    let info = {
        id : idMensaje,
        messagetext : Text
    };

    const req = new XMLHttpRequest();
    req.open('PUT', 'http://158.101.101.23/api/Message/update');
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

function deleteMensaje(){
    //funcion delete

    let idMensaje = $("#idMensaje").val();
    let info = {
        id: idMensaje
    };
    let datatosend = JSON.stringify(info);
    $.ajax({
        url:'http://158.101.101.23/api/Message/delete',
        type:'DELETE',
        data: datatosend,
        contentType:'application/json',
        dataType: 'json',
        success: function(respuesta){
            traerMensaje();
            alert("se ha eliminado");
        }
    })
};