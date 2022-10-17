//CATEGORIA
function traerCategoria(){
    //funcion GET
    $.ajax({
        url:'http://158.101.101.23/api/Category/all',
        type:'GET',
        dataType:'json',

        success: function(Categoria){  //funcion guarda la get data
            let ca = Categoria.items;
            $("#ListaCategoria").empty();
            for(i=0;i<ca.length;i++){
                $("#listaCategoria").append("<b>"+ca[i].id +' '+ca[i].descripcion+"</b> "+ca[i].nombrecategoria+"</br>")
            }
        },
        error: function(xhr, status){
            alert("ERROR ");
        }
    });
}

function guardarCategoria(){
    //funcion POST
    let idCategoria = $("#idCategoria").val();  //guardar los atrubitos en la funcion
    let descripcion = $("#descripcion").val();
    let nombrecategoria = $("#nombrecategoria").val();

    let Categoria = {   //crear json
        id : idCategoria,
        descripcion: descripcion,
        nombre_categoria: nombrecategoria,
    };
    const req = new XMLHttpRequest();
    req.open('POST', 'http://158.101.101.23/api/Category/save');
    req.setRequestHeader('Content-Type','application/json');
    req.addEventListener('load', function(){
        if(req.status == 201){  //si el estatus del rquest es exitoso
            console.log(req.status)
        }else{  // de lo contario lance error
            throw new Error("BAD POST REQUEST");
        }
    });
    req.send(JSON.stringify(Categoria));
}

function updateCategoria(){
    //funcion PUT
    let idCategoria = $("#idCategoria").val();  //Actualizar los atrubitos en la funcion
    let descripcion = $("#descripcion").val();
    let nombrecategoria = $("#nombrecategoria").val();

    let Categoria = {   //crear json
        id : idCategoria,
        descripcion: descripcion,
        nombre_categoria: nombrecategoria,
    };

    const req = new XMLHttpRequest();
    req.open('PUT', 'http://158.101.101.23/api/Category/update');
    req.setRequestHeader('content-type', 'application/json');
    req.addEventListener('load', function(){
        if(req.status == 200 ){
            console.log(req.status);
        }else{
            throw new Error("BAD PUT REQUEST")
        }
    });
    req.send(JSON.stringify(Categoria));
}

function deleteCategoria(){
    //funcion delete

    let idCategoria = $("#idCategoria").val();
    let Cate = {
        id: idCategoria
    };
    let datatosend = JSON.stringify(Cate);
    $.ajax({
        url:'http://158.101.101.23/api/Category/delete',
        type:'DELETE',
        data: datatosend,
        contentType:'application/json',
        dataType: 'json',
        success: function(respuesta){
            traerCategoria();
            alert("se ha eliminado");
        }
    })
}
