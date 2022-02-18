
//const crypto = require("crypto");
import UserModel from "../model/UserModel.js";
//const users = require("../model/UserModel")
import bcryptjs from "bcryptjs";
import jsonwebtoken from "jsonwebtoken";
import detEnv from 'dotenv';

detEnv.config();

const JWT_SECRET = process.env.JWT_SECRET;

class UserController {

    hashPassword(password){
        const salt = bcryptjs.genSaltSync(10);
        const hash = bcryptjs.hashSync(password, salt);
    
        return hash;
    }

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

    
    async login(request, response) {
        const {email, password} = request.body;
    
        const user = await UserModel.findOne({email}).lean();
        
        if(!user){
            return response.status(404).json({message: "User not found"});
        }

        if(!bcryptjs.compareSync(password, user.password)){
            return response.status(404).json({message: "Password Invalid"});
        }

        const token = jsonwebtoken.sign({
            id: user.id,
            name: user.name,
            email: user.email
        }, JWT_SECRET/*, {expiresIn: 600}*//*expiração do token*/);
        return response.json({ token });
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