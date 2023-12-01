import { useEffect, useState,useContext } from "react";
import { useParams } from "react-router-dom";
import { InfinitySpin } from 'react-loader-spinner';
import "./oneitem.css";
import { CartContext } from "./Context/CartProvider";
export default function Oneitem() {
  const { id } = useParams();
  const [currentItem, setCurrentItem] = useState([]);
  const {cartItems,addToCart}= useContext(CartContext)
  const [itemid, setItemId] = useState(id);
  useEffect(() => {
    async function getItem(id) {
      const req = await fetch(`http://localhost:5000/items/${itemid}`);
      const data = await req.json();
      setCurrentItem(data);
    }
    getItem(itemid);
  }, [itemid]);
  const [item] = [...currentItem];
  return (
    <div>
      {item ? (
        <div className="item-container">
          <div className="column1">
            <img src={`http://localhost:3000/${item.item_image}`} alt="d" />
          </div>
          <div className="column2">
            <div>
              <span id="description">{item.item_description}</span>
              <span>No ratings</span>
              <div>
                <div className=" mt-2 card">
                  <span>
                    Color <i class="fas fa-chevron-down"></i>
                  </span>
                </div>
                <div className="card">
                  <span>
                    Sizes <i class="fas fa-chevron-down"></i>
                  </span>
                </div>
              </div>
            </div>
            <span className="price">${item.item_price}</span>
            <button onClick={()=> {if(cartItems.find(cartitem => cartitem.id === item.id )) { alert('item already in cart'); return} else addToCart(item);return alert('item added to cart') }}>Add to cart</button>
          </div>
        </div>
      ) : (
        <div  className="spinner"> 
          <InfinitySpin width="200" color="#4fa94d" />
        </div>
      )}
    </div>
  );
}
