import { createContext, useContext, useEffect, useState } from "react";
import { CartContext } from "./Context/CartProvider";
import "./cart.css";

export default function Cart() {
  const { cartItems, removeFromCart,addToCart, clearCart, getCartTotal } =
    useContext(CartContext);
    const [total, setTotal] = useState(getCartTotal());
  useEffect(() =>{ setTotal(getCartTotal())},[getCartTotal]);
  return (
    <>
     {cartItems.length > 0 ?
      <>
       <div className="total">
      <span>Total: ${total}</span>
      <button onClick={clearCart}>Clear cart</button>
      <button>Checkout</button>
    </div>
      <div className="cart-container">
      <div>
        {cartItems.map((item) => {
          return (
            <div className="cart-items">
              <img src={item["item_image"]} alt="" />
              <div className="item-body">
                <h2>{item['item_description']}</h2>
                <span className="item-price d-block">${item['item_price']}</span>
                <button onClick={()=>addToCart(item)}>+</button><input type="number" name="" value={item['quantity']} id="" /><button onClick={()=> removeFromCart(item)}>-</button>
              </div>
            </div>
          );
        })}
      </div>
    </div>
    </>
    : 
    <div style={{padding:'30px',textAlign:'center'}}>
      Your cart is empty :)
    </div>
    
      }

    </>
)
}