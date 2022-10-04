const express = require("express");
const app = express();

const cors = require('cors')
app.use(cors()) 
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

require("./server/config/mongoose.config")

const authorRoutes = require("./server/routes/author.routes");
authorRoutes(app);

app.listen(8000, () => console.log("Our application is running on port 8000"));
