let registros = [];

function agregarRegistro(){

    let nombre = document.getElementById('username').value;
    let correo = document.getElementById('correo').value;
    let password = document.getElementById('contrasena').value;

    registros.push({nombre:nombre, correo:correo, contrasena:password});

}

function obtenerUsername(arreglo){
    var arreglonombres=[];
    var regExp = /(?=.*[0-9])+/gi;

    for (let i = 0; i < arreglo.length; i++) {
        
        if(arreglo[i].nombre.match(regExp) != null){
            arreglonombres.push(arreglo[i].nombre);
        }
        
    }

    return arreglonombres;

}

function filtrarCorreo(arreglo){
    var arreglocorreo=[];
    var regExp3 = /\bhotmail.com$\b/;

    for (let i = 0; i < arreglo.length; i++) {
        
        if(arreglo[i].correo.match(regExp3) != null){
            arreglocorreo.push(arreglo[i].correo);
        }
    }
    
    return arreglocorreo;

}

module.exports.registros = registros;
module.exports.obtenerUsername = obtenerUsername;
module.exports.agregarRegistro = agregarRegistro;
module.exports.filtrarCorreo = filtrarCorreo;

