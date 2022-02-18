import { json } from "express";
import jsonWebToken from "jsonwebtoken";
import detEnv from 'dotenv';

detEnv.config();

const JWT_SECRET = process.env.JWT_SECRET;

console.log(JWT_SECRET);

export const AuthMiddleware = (request, response, next) =>{
    const { authorization } = request.headers;
    console.log("AuthMiddleware");

    if(request.url === "/api/login" || request.url === '/api/users' && request.method === "POST"){
        return next();
    }
    
    if(!authorization){
        return response.status(401).json({message:"Autorization not found"})
    }

    const [, token] = authorization.split(" ");

    try {
        const user = jsonWebToken.verify(token, JWT_SECRET);
        console.log(user);
    }catch (error){
        return response.status(401).json({message:"Invalid Token"})
    }

    next();
}