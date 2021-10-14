const http = require('http');

const servidor = http.createServer((pedido, respuesta)=>{
    respuesta.writeHead(200, {'Content-Type':'text/html'});
    respuesta.write('<!DOCTYPE HTML> <html><head></head><body><h1>Sitio en desarrollo</h1></body></html>');
    respuesta.end();
});

servidor.listen(8888);

console.log('Servidor iniciado');