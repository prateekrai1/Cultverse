import "./navbar.css";
import { Link } from "react-router-dom";
import { useContext } from "react";
import { CartContext } from "./Context/CartProvider";
import Cartcount from "./Cartcount";
export default function Navbar() {
  const { cartItems } = useContext(CartContext);
  console.log(cartItems.length)
  return (
    <nav>
      <div className="items">
        <div className="icon">
          <a href="https://random">
            <img src="\assets\images\Cultverse logo.jpg" alt="img" />
          </a>
        </div>
        <ul className="nav-items">
          <li>
            <Link to="/" className="nav-links">
              Products
            </Link>
          </li>
          <li>
            <a href="https://random" className="nav-links">
              About us
            </a>
          </li>
          <li>
            <a href="https://random" className="nav-links">
              Random
            </a>
          </li>
        </ul>
      </div>

      <div className="cart">
        <Link to="cart">
          <i style={{ color: "white" ,position:'relative'}} class="fas fa-shopping-cart">
          {
            cartItems.length >= 0 ? <Cartcount number={cartItems.length} top={-10} right={-18} /> : ''
          }
          </i>
        </Link>
      </div>
    </nav>
  );
}
