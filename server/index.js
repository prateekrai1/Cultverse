const express = require("express");
const cors = require("cors");
const app = express();
const db = require("./database.config");
app.use(express.json());
app.use(cors());

app.post("/items", (req, res) => {
  const { name, price, image } = req.body;
  db.query(
    "INSERT INTO items (item_name,item_price,item_image) VALUES(?,?,?)",
    [name, price, image],
    (err, result) => {
      if (err) {
        console.log(err);
      } else {
        console.log(result);
      }
    }
  );
  const message = "items saved";
  res.send(message);
});
app.get("/items", (req, res) => {
  db.query(
    "SELECT * FROM items",
    (err, result) => {
        if(err){
            console.log(err)
        }else{
            res.send(result)
        }
    }
  );
});

app.get("/items/:id", async (req,res)=>{
    const id = req.params.id;
    db.query(
        "SELECT * FROM items WHERE id= ?",id,
        (err, result) => {
            if(err){
                console.log(err)
            }else{
                res.send(result)
            }
        }
      );
})
app.listen("5000", () => {
  console.log("server has started");
});
