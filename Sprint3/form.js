function checkUsername(valor){
 
    var regExp =  /^([a-zA-Z0-9_-]){1,16}$/;
    
    if(valor === ""){
        alert('El nombre no puede estar vacío');
        return false;
    }
    if(valor.length>30){
        alert('El nombre es muy largo');
        return false;
    }

    if(!regExp.test(valor)){
        alert('El nombre no cumple con la politica');
        return false;
    }

    return true;
}

function checkCorreo(valor){

    var regexp=  /^[^@]+@[^@]+\.[a-zA-Z]{2,3}$/;

    if(valor === ""){
        alert('El campo correo no puede estar vacío');
        return false;
    }
    if(!regexp.test(valor)){
        alert('El campo correo no tiene un formato válido');
        return false;
    }
    
    return true;

}

function checkContrasena(valor){

    var regexp = /^(?=.*\d)(?=.*[A-Z])(?=.*[a-z])\S{8,16}$/;
    if(valor === ""){
        alert('El campo contraseña no puede estar vacío');
        return false;
    }
    if(!regexp.test(valor)){
        alert('El campo contraseña no cumple con el formato');
        return false;
    }
    return true;
}

function checkConfirmContrasena(valor1, valor2){
   
    var regexp = /^(?=.*\d)(?=.*[A-Z])(?=.*[a-z])\S{8,16}$/;
    if(valor2 === ""){
        alert('El campo confirmar contraseña no puede estar vacío');
        return false;
    }
    if(!regexp.test(valor2)){
        alert('El campo confirmar contraseña no cumple con el formato');
        return false;
    }
    if (valor1!=valor2){
        alert('las contraseñas no coinciden');
        return false;
    }
    return true;
}

module.exports.checkUsername = checkUsername;
module.exports.checkCorreo = checkCorreo;
module.exports.checkContrasena = checkContrasena;
module.exports.checkConfirmContrasena = checkConfirmContrasena;


