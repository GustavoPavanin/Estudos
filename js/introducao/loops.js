const student = {
    name: "Keven",
    city: "Recife",
    state: "Pernambuco"
};

for (let i = 0; i < 10; i++) {
    //console.log(i);
    //more statements
}

//For in
for(const key in student){
    //console.log(key, student[key])
}

const names = ["Keven", "Gustavo", "Fernando"]
//For of
for (const value of names){
    //console.log(value);
}

while (true){
 console.log("Data atual" + new Date());
}