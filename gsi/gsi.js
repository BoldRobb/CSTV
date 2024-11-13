const http = require('http');
const fs = require('fs');
const port = 3000;
const host = '127.0.0.1';

let latestGameState = null; // Variable para almacenar el último estado del juego

const server = http.createServer((req, res) => {
    // Habilitar CORS
    res.setHeader('Access-Control-Allow-Origin', '*');
    res.setHeader('Access-Control-Allow-Methods', 'POST, GET, OPTIONS');
    res.setHeader('Access-Control-Allow-Headers', 'Content-Type');
    
    if (req.method === 'OPTIONS') {
        res.writeHead(204);
        res.end();
        return;
    }

    if (req.method === 'POST') {
        let body = '';
        req.on('data', data => {
            body += data;
        });
        req.on('end', () => {
            latestGameState = JSON.parse(body); // Actualiza el último estado del juego
            console.log("Estado del juego actualizado:", JSON.stringify(latestGameState, null, 2));
            res.writeHead(200, {'Content-Type': 'text/html'});
            res.end('');
        });
    } else if (req.method === 'GET') {
        // Enviar el último estado del juego a Angular
        res.writeHead(200, {'Content-Type': 'application/json'});
        res.end(JSON.stringify(latestGameState));
    } else {
        res.writeHead(405, {'Content-Type': 'text/plain'});
        res.end('Method not allowed');
    }
});

server.listen(port, host);
console.log(`Listening at http://${host}:${port}`);
