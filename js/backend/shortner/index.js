const express = require("express");

const app = express();

const PORT = 3000;

app.get('/', (request, response, next) =>{
    response.status(200).send({ 
        message: "hello Word",
        currentDate: new Date().toISOString(),
        });
})

app.listen(PORT, () => {
    console.log(`Server running on PORT ${PORT} ----- Aplicação Iniciada`);
});