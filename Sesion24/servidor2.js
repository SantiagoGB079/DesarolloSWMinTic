const express = require('express');
const app = express();
const port = 4040;

app.get('/registro', function(req, res){
    res.send(`Bienvenido ${req.query.user}`)
});

app.listen(port,function(){
    console.log(`conectado a puerto ${port}`);
});