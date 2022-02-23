import mongoose from "mongoose";

//mapeando eschema
const UserSchema = new mongoose.Schema({
        name: {type: String, required: true},
        email: {type: String, required: true},
        state: {
            type: String,
            enum: ["SP", "RJ","MG","MT", "Other"],
        },
        password: {type: String, required: true},
        birthDate: {type: String, required: true},
        phones: [String],
    },
    {
        timestamps: true,
    });

    const UserModel = mongoose.model("user", UserSchema);

    export default UserModel;
    
// import crypto from "crypto";
// //const crypto = require("crypto");

// const users = [
//     {
//         id: crypto.randomUUID(),
//         name: "Gustavo",
//         city: "São José do Rio Preto",
//     },
// ];

// export default users;
//module.exports = users;