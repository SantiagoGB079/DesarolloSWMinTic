const express = require('express');
const app = express();
const port = 4040;

app.use(express.urlencoded());
app.use(express.json());

app.post('/registro', function(req, res){
    res.send(`Bienvenido ${req.body.user}`)
});

app.listen(port,function(){
    console.log(`conectado a puerto ${port}`);
});