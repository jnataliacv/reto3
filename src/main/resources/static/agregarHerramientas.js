// HERRAMIENTAS
function getHerramientas(){
    //FUNCION GET
    $.ajax({
        url:'http://158.101.101.23/api/Tool/all',
        type:'GET',
        dataType:'json',
        success: function(Herramientas){
            let ct = Herramientas.items;
            $("#listaHerramientas").empty();
            for(i=0; i<ct.length;i+=1){
                $("#listaHerramientas").append("<b>"+ct[i].id+''+ct[i].marca+"</b>"+ct[i].modelo+"</br>")
            }
            console.log()
        },
        error: function(xhr, status){
            alert("ERROR");
        }
    });
}
//FUNCION POST
function guardasHerramientas(){
    let idHerramientas = $("#idHerramientas").val();
    let marcaHerramientas = $("#marca").val();
    let modeloHerramientas = $("#modelo").val();
    let categoriaHerramientas = $("#categoria").val();
    let nombreHerramientas = $("#nombre").val();

    let data = {
        id: idHerramientas,
        marca: marcaHerramientas,
        modelo: modeloHerramientas,
        categoria: categoriaHerramientas,
        nombre: nombreHerramientas
    }

    const req = new XMLHttpRequest();
    req.open('POST', 'http://158.101.101.23/api/Tool/save');
    req.setRequestHeader('Content-Type', 'application/json')
    req.addEventListener('load', function(){
        if(req.status == 201){
            console.log(req.status);
        }else{
            throw new Error("BAD POST REQUEST")
        }
    })
    req.send(JSON.stringify(data));
}

function updateHerramientas(){
    //FUNCION PUT
    let idHerramientas = $("#idHerramientas").val();
    let marcaHerramientas = $("#marca").val();
    let modeloHerramientas = $("#modelo").val();
    let categoriaHerramientas = $("#categoria").val();
    let nombreHerramientas = $("#nombre").val();

    let data = {
        id: idHerramientas,
        marca: marcaHerramientas,
        modelo: modeloHerramientas,
        categoria: categoriaHerramientas,
        nombre: nombreHerramientas
    }

    const req = new XMLHttpRequest();
    req.open('PUT', 'http://158.101.101.23/api/Tool/update');
    req.setRequestHeader('Content-Type', 'application/json')
    req.addEventListener('load', function(){
        if(req.status == 201){
            console.log(req.status);
        }else{
            throw new Error("BAD PUT REQUEST")
        }
    })
    req.send(JSON.stringify(data));
}

function deleteHerramientas(){
    //FUNCIOn DELETE
    let idHerramientas = $("#idHerramientas").val();
    let data = {
        id:idHerramientas
    }
    let datatosend = JSON.stringify(data);
    $.ajax({
        url:'http://158.101.101.23/api/Tool/delete',
        type:'DELETE',
        data: datatosend,
        contentType: 'application/json',
        dataType:'json',
        success: function(respuesta){
            getHerramientas();
            alert("SE HA ELIMINADO")
        }
    })
};