import crypto from "crypto";
//const crypto = require("crypto");

const users = [
    {
        id: crypto.randomUUID(),
        name: "Gustavo",
        city: "São José do Rio Preto",
    },
];

export default users;
//module.exports = users;