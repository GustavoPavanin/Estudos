
import crypto from "crypto";
//const crypto = require("crypto");
import users from "../model/UserModel.js";
//const users = require("../model/UserModel")

const Controller = {
    getOne(request, response){
        // Escrever validação:
        // Verificar se o usuário existe, caso não retornar status 404 com mensagem de erro
        const id = request.params.id;
        const user = users.find((user) => user.id === id);

        if (user){
            return response.send({ user });  
        }

        response.status(404).send({ message: "Usuário não encontrado!"});
    },
    index(request, response){
        response.send({users});
        //response.json({ message: "index"});

    },
    // Fazer lógica de Delete, recebendo o parâmetro do usuário (ID) e removendo o da lista
    // Se der certo retornar um objeto com mensagem sucesso!
    remove(request, response){
        const id = request.params.id;
        const pos = users.findIndex((user) => user.id === id);

        if(pos !== -1){
            users.splice(pos, 1);
            return response.send({ message: "Usuário excluído com sucesso!", id});
        }

        response.status(404).send({ message: "Usuário não encontrado!"});
    },
    store(request, response){
        try{
            const name = request.body.name.trim();
            const city = request.body.city.trim();
    
            if(name && city ){
                const user = {
                    id: crypto.randomUUID(),
                    name,
                    city,
                }
        
            users.push(user);
        
            return response.send({ message: "Usuário criado!", user});    
        }
        
        response.status(400).send({ message: "data invalid"}); 
        } catch (error){
            console.log(error);
    
            response.status(500).send({ message: "Something bad happen"}); 
        }
    },
    // Fazer lógica de Update, recebendo parâmetro de usuário e o body
    // Buscando o usuário e atualizando o mesmo
    update(request, response){
        try{
        
            const id = request.params.id;
            const name = request.body.name.trim();
            const city = request.body.city.trim();
            
            if(name && city){
                const position = users.findIndex((user) => user.id === id);
    
                if(position !== -1){
                    users[position] = { id, name, city };
    
                    return response.status(200).json({ message: 'Usuário atualizado'});
                }
            }
            
            response.status(404).send({ message: "Usuário não encontrado!"});
        } catch(error){
            console.log(error);
    
            response.status(500).send({ message: "Something bad happen"}); 
        }
    }

}
export default Controller
//module.exports = Controller;