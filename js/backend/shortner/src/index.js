import express from "express";
//const express = require("express"); /* sem type modules */ 
import morgan from "morgan";
//const morgan = require("morgan"); /* sem type modules */ 
import UserRouter from "./router/UserRouter.js"
//const UserRouter = require("./router/UserRouter"); /* sem type modules */ 

const app = express();
const PORT = 3000;

app.use(express.json());
app.use(morgan("dev"));
app.use(UserRouter);

app.listen(PORT, () => {
    console.log(`Server running on PORT ${PORT} ----- Aplicação Iniciada`);
});

