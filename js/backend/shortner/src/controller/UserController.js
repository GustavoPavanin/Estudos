
//const crypto = require("crypto");
import UserModel from "../model/UserModel.js";
//const users = require("../model/UserModel")
import bcryptjs from "bcryptjs";

const hashPassword = (password) => {
    const salt = bcryptjs.genSaltSync(10);
    const hash = bcryptjs.hashSync(password, salt);
}

class UserController {
    async getOne(request, response){
        // Escrever validação:
        // Verificar se o usuário existe, caso não retornar status 404 com mensagem de erro
        const id = request.params.id;

        try{
            const user = await UserModel.findById(id);
        
            if (user){
                return response.send({ user });  
            }

            response.status(404).send({message: "User not found"})
        }catch (error){
            console.log(error.stack);
            return response.status(400).send({ message: "an unexpected error happened!"});
        }

    }


    async index(request, response){
        const users = await UserModel.find();
        response.send({users});
    }


    // Fazer lógica de Delete, recebendo o parâmetro do usuário (ID) e removendo o da lista
    // Se der certo retornar um objeto com mensagem sucesso!
    async remove(request, response){
        const id = request.params.id;
        const  user = await UserModel.findById(id);
        
        if(user){
            await user.remove();
            return response.send({ message: "User Removed"});
        }

        response.status(404).send({ message: "Usuário não encontrado!"});
    }


    async store(request, response){

        const { name, phones, email, password, birthDate, state } = request.body;
        try{
            const user = await UserModel.create({
                name,
                phones,
                email,
                password: hashPassword(password),
                birthDate,
                state,
            });
            
            return response.send({ message: "Usuário criado!", user});
        }catch (error){
            console.log(error.stack);
            return response.status(400).send({ message: "an unexpected error happened!"});
        }
    }


    // Fazer lógica de Update, recebendo parâmetro de usuário e o body
    // Buscando o usuário e atualizando o mesmo
    async update(request, response){
        
            const id = request.params.id;
            const { name, phones, email, password, birthdate, state } = request.body;
            
            const user = await UserModel.findByIdAndUpdate(id, {
                name,
                phones,
                email,
                password : hashPassword(password),
                birthdate,
                state,
            }, {
                new: true
            });
            
            response.send(user);
    }

}


export default UserController
//module.exports = Controller;