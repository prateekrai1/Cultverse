import Home from "./components/Home";
import { Routes, Route } from "react-router-dom";
import Oneitem from "./components/Oneitem";
import Navbar from "./components/Navbar";
import Admin from "./components/Admin";
import Cart from "./components/Cart";

function App() {
  return (
    <>
      <Navbar />
      <Routes>
        <Route path="/">
          <Route index element={<Home />} />
        </Route>
        <Route path="item/:id" element={<Oneitem />}></Route>
        <Route path="admin" element={<Admin />}></Route>
        <Route path="cart" element={<Cart />}></Route>
      </Routes>
    </>
  );
}

export default App;
