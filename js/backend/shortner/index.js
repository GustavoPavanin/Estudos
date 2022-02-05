const express = require("express");
const crypto = require("crypto");

const app = express();

app.use(express.json());

const PORT = 3000;

app.listen(PORT, () => {
    console.log(`Server running on PORT ${PORT} ----- Aplicação Iniciada`);
});

const users = [
    {
        id: crypto.randomUUID(),
        name: "Gustavo",
        city: "São José do Rio Preto",
    },
];

app.get('/api/user', (request, response, next) =>{
    response.send({users});
});

app.get('/api/user/:id', (request, response, next) =>{
      // Escrever validação:
    // Verificar se o usuário existe, caso não retornar status 404 com mensagem de erro
    const id = request.params.id;

    const user = users.find((user) => user.id === id);
    if (users.indexOf(users.find((user) => user.id === id)) < 0 ){
        response.status(404).send({ message: "Usuário não encontrado!"});
    } else{
        response.send({ user });
    }
    
});

app.post('/api/user/', (request, response, next) =>{

    const { name, city } = request.body;

    const user = {
        id: crypto.randomUUID(),
        name,
        city,
    }

    users.push(user);

    response.send({ message: "Usuário criado!", user});

});
// Fazer lógica de Update, recebendo parâmetro de usuário e o body
// Buscando o usuário e atualizando o mesmo
app.put('/api/user/:id', (request, response) => {

    const id = request.params.id;
    const position = users.findIndex((user) => user.id === id);

    if(position < 0){
        response.status(404).send({ message: "Usuário não encontrado!"});
    }else{
        const {name, city} = request.body
        const user = {
            id,
            name,
            city,
          };
          users[position] = user;
        response.status(200).json({ message: 'Usuário atualizado'});
    }
   
})

// Fazer lógica de Delete, recebendo o parâmetro do usuário (ID) e removendo o da lista
// Se der certo retornar um objeto com mensagem sucesso!
app.delete('/api/user/:id', (request, response) =>{
    const id = request.params.id;
    const pos = users.findIndex((user) => user.id === id);
    users.splice(pos, 1);
    if(pos < 0){
        response.status(404).send({ message: "Usuário não encontrado!"});
    }else{
        response.send({ message: "Usuário excluído com sucesso!", id});
    }
    
});

