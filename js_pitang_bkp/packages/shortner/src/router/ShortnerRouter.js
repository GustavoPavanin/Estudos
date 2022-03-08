import express from "express";
import ShortnerController from "../controller/ShortnerController.js";

const shortnerController = new ShortnerController;
const router = express.Router();

//const {Router} = require("express"); /* sem type modules */ 
//const router = Router(); /* sem type modules */ 
//const UserController = require("../controller/UserController"); /* sem type modules */ 

//router.get('/api/user', (request, response, next) => UserController.index(request, response) );
router.get('/api/shortner',shortnerController.index);
router.get('/api/shortner/:id', shortnerController.getOne);
router.post('/api/shortner/', shortnerController.store);
router.put('/api/shortner/:id', shortnerController.update);
router.delete('/api/shortner/:id', shortnerController.remove);

export default router;
//module.exports = router; /* sem type modules */ 