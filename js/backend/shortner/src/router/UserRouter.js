import express from "express";
import UserController from "../controller/UserController.js";

const router = express.Router();

//const {Router} = require("express"); /* sem type modules */ 
//const router = Router(); /* sem type modules */ 
//const UserController = require("../controller/UserController"); /* sem type modules */ 

//router.get('/api/user', (request, response, next) => UserController.index(request, response) );
router.get('/api/user',UserController.index);
router.get('/api/user/:id', UserController.getOne);
router.post('/api/user/', UserController.store);
router.put('/api/user/:id', UserController.update);
router.delete('/api/user/:id', UserController.remove);

export default router;
//module.exports = router; /* sem type modules */ 