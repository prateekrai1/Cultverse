import './maincontent.css'
import Item from './Item';
import { useState,useEffect } from 'react';
import { Link } from "react-router-dom";

export default function Maincontent() {
  const [items,setItems] = useState([]);

  useEffect(()=>{
    async function fetchItems(){
      const req = await fetch('http://localhost:5000/items',);
      const data = await req.json();
      setItems(data)
    }
    fetchItems()
  },[]
  )


  return <div className='grid-container'>
  {items.map(item =>
     <Link to={`item/${item.id}`}><Item  key={item.id} item={item}/></Link> 
  )} 
  
  </div>
}
