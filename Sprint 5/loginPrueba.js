let registros = [{nombre:'Santi',
correo: 'santi@este.com',
contrasena:'123'}];

function agregarRegistro(){

    let nombre = document.getElementById('username').value;
    let correo = document.getElementById('correo').value;
    let password = document.getElementById('contrasena').value;

    registros.push({nombre:nombre, correo:correo, contrasena:password});

}

function login(evt){

    evt.preventDefault();

    let nombreLogin = document.getElementById('username/correo').value;
    let contrasenaLogin = document.getElementById('contrasena').value;
    let respuesta = document.getElementById('captcha').value

    alert(registros.length);

    for (let i = 0; i < registros.length; i++) {

        alert(registros[i].nombre);
      
        if (nombreLogin == registros[i].nombre || nombreLogin == registros[i].correo){
            if(registros[i].contrasena == contrasenaLogin){
                if(validarCAPTCHA(respuesta)==false){
                    alert('Captcha incorrecto')
                    return false;
                } else{
                    alert('Bienvenido')
                    return true;
                }

            } else{
                alert('contrasena incorrecta');
            }
        
        } 
    }

}

function validarCAPTCHA(valor){
    
    if(valor.trim().toLowerCase() == 'budapest'){
        alert('Correcto');
        return true;
    } else{
        return false;
    }

}

module.exports.login = login;
module.exports.registros = registros;
module.exports.agregarRegistro = agregarRegistro;
module.exports.validarCAPTCHA = validarCAPTCHA;