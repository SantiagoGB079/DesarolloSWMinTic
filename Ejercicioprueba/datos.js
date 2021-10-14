const http = require('http');
const url = require('url');
const fs = require('fe');
const querystring = require('querystring');

const mime = {
    'html':'text/html',
    'css':'text/css',
    'jpg':'image/jpg',
    'ico':'image/x-icon',
    'mp3':'audio/mp3',
    'mp4':'audio/mp4'
} ;

const servidor = http.createServer((pedido, respuesta)=>{
    const objurl = url.parse(pedido.url);
    let camino = 'Ejercicioprueba'+objurl.pathname;
    if(camino == 'Ejercicioprueba/'){
        camino='Ejercicioprueba/index.html';
        encaminar(pedido, respuesta, camino);

    }
}
);

servidor.listen(8888);

function encaminar(pedido, respuesta, camino){
    console.log(camino);
    switch(camino){
        case 'Ejercicioprueba/recuperardatos':{
            recuperar(pedido, respuesta);
            break;
        }
        default: {
            fs.stat(camino,(error,contenido)=>{
                if(error){
                    respuesta.writeHead(500, {'Content-Type': 'text/plain'});
                    respuesta.write('Error interno');
                    respuesta.end;

                }
            })
        }
    }

}

function recuperar(pedido, respuesta){
    let info='';

    pedido.on('data', datosparciales=>{
        info+=datosparciales;
    });

    pedido.end('end',()=>{
        const formulario  = querystring.parse(info);
        respuesta.writeHead(200, {'Content-Type':'tetx/html'});
        const pagina =
        '<!DOCTYPE HTML><html><head></head><body>Nombre de usuario: ${formulario [nombre]}</body></html>'
    })

}