import express from "express";
import UserController from "../controller/UserController.js";

const userController = new UserController;
const router = express.Router();

//const {Router} = require("express"); /* sem type modules */ 
//const router = Router(); /* sem type modules */ 
//const UserController = require("../controller/UserController"); /* sem type modules */ 

//router.get('/api/user', (request, response, next) => UserController.index(request, response) );
router.get('/api/users',userController.index);
router.get('/api/users/:id', userController.getOne);
router.post('/api/users/', userController.store);
router.put('/api/users/:id', userController.update);
router.delete('/api/users/:id', userController.remove);

export default router;
//module.exports = router; /* sem type modules */ 