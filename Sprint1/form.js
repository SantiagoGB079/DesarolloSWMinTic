function validation(){

    if(checkUsername() && checkCorreo() && checkContrasena() && checkConfirmContrasena()){
        return true;
    } else {
        return false;
    }
}


function checkUsername(){
    let valor = document.getElementById('Username').value;
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

function checkCorreo(){

    var valor = document.getElementById('Correo').value;
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

function checkContrasena(){
    let valor = document.getElementById('Contrasena').value;
    ///^(?=.*\d)(?=.*[\u0021-\u002b\u003c-\u0040])(?=.*[A-Z])(?=.*[a-z])\S{8,16}$/;
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

function checkConfirmContrasena(){
    let valor = document.getElementById('Contrasena').value;
    let valor2 = document.getElementById('Confirmar contrasena').value;
    ///^(?=.*\d)(?=.*[\u0021-\u002b\u003c-\u0040])(?=.*[A-Z])(?=.*[a-z])\S{8,16}$/;
    var regexp = /^(?=.*\d)(?=.*[A-Z])(?=.*[a-z])\S{8,16}$/;
    if(valor2 === ""){
        alert('El campo confirmar contraseña no puede estar vacío');
        return false;
    }
    if(!regexp.test(valor2)){
        alert('El campo confirmar contraseña no cumple con el formato');
        return false;
    }
    if (valor!=valor2){
        alert('las contraseñas no coinciden');
        return false;
    }
    return true;
}

module.export.checkUsername = checkUsername;
module.export.checkCorreo = checkCorreo;
module.export.checkContrasena = checkContrasena;
module.export.checkConfirmContrasena = checkConfirmContrasena;


