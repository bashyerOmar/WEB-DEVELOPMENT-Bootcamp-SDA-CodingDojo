const express = require("express");
const app = express();
const {faker} = require('@faker-js/faker')

class User {

  constructor(){
     this.id = faker.datatype.uuid() ;
     this.Fname = faker.name.firstName();
     this.Lname = faker.name.lastName();
     this.phone = faker.phone.number('9665-####-####');
     this.email=faker.internet.email();
     this.password =faker.internet.password();

  }
 
}

class Company {

  constructor(){
      this.id = faker.datatype.uuid();
      this.name=faker.company.name();
      this.address = {
          street:faker.address.street() ,
          city:faker.address.city() ,
          state:faker.address.state() , 
          zipCode:faker.address.zipCode() ,
          country:faker.address.county()
      }
  }
}

const company = new Company();
const user =new User();


app.get("/api/users/new", (req, res) => 
         {res.send(user);}    // `new user : ${user}`
       );

app.get("/api/companies/new", (req, res) => 
          {res.send(company);}
       );
       
app.get("/api/user/company", (req, res) => 
          {res.send({user , company});}
       );



const server = app.listen(8000, () =>
  console.log(`Server is locked and loaded on port ${server.address().port}!`)
);
