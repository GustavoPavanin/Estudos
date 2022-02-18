import express from "express";
import mongoose from "mongoose";
//const express = require("express"); /* sem type modules */ 
import morgan from "morgan";
//const morgan = require("morgan"); /* sem type modules */ 
import UserRouter from "./router/UserRouter.js"
import ShortnerRouter from "./router/ShortnerRouter.js"
//const UserRouter = require("./router/UserRouter"); /* sem type modules */ 
import detEnv from 'dotenv';
import { AuthMiddleware } from "./middleware/auth.middleware.js";

detEnv.config();

const DATABASE_URL = process.env.DATABASE_URL;
const PORT = process.env.PORT;

mongoose
    .connect(DATABASE_URL)
    .then(() =>{
        console.log("Database Connected...")
    }).catch((error) =>{
        console.log(error);
    });

const app = express();



app.use(express.json());
app.use(morgan("dev"));
app.use(AuthMiddleware);
app.use(UserRouter);
app.use(ShortnerRouter);


app.listen(PORT, () => {
    console.log(`Server running on PORT ${PORT} ----- Aplicação Iniciada`);
});


