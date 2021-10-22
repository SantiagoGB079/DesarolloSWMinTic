let registros = [];

function agregarRegistro(){

    let nombre = document.getElementById('username').value;
    let correo = document.getElementById('correo').value;
    let password = document.getElementById('contrasena').value;

    registros.push({nombre:nombre, correo:correo, contrasena:password});

}

function login(){

    let nombreLogin = document.getElementById('username/correo').value;
    let contrasenaLogin = document.getElementById('contrasena').value;
    let respuesta = document.getElementById('captcha').value

    for (let i = 0; i < registros.length; i++) {
      
        if (nombreLogin == registros[i].nombre || nombreLogin == registros[i].correo){
            if(registros[i].contrasena == contrasenaLogin){
                if(validarCAPTCHA(respuesta)==false){

                    return false;
                } else{
                    return true;
                }

            } else{
                return false;
            }
        
        } 
    }

}

function validarCAPTCHA(valor){
    
    if(valor.trim().toLowerCase() == 'budapest'){
        return true;
    } else{
        return false;
    }

}

module.exports.login = login;
module.exports.registros = registros;
module.exports.agregarRegistro = agregarRegistro;
module.exports.validarCAPTCHA = validarCAPTCHA;