import { useState, useEffect } from "react";
import Product from "../components/Product";
import { Link } from "react-router-dom";
import Categories from "../components/Categories";
import ShopComponent from "./ShopComponent";
import JoysToysLogo from "../assets/result.svg"

function Home() {
  let [products, setProducts] = useState([]);
  let [product_id, setProductID] = useState(1);

  useEffect(() => {
    fetch(`/products`, {
      headers: {
        accept: "application/json",
      },
    })
      .then((Response) => Response.json())
      .then((data) => setProducts(data));
  }, []);

  return (
    <>
    <div>
      <h1 className="App-Header">
        <div className="center">
        <img alt="JoysToysLogo" src={JoysToysLogo} width="200px" />
        </div>
      </h1>
      <Link to="/Login">
        <button className="loginButton">Login</button>
      </Link>
      <Categories />
      <h1 className="center">
        Best Sellers
      </h1>
      {products.length ? (
            <div className='productContainer'>
            {products.map((product) => (
            <Product product={product} />
          ))}
        </div>
        
      ) : (
        "hit the button"
      )}
      
    </div>
    </>
  );
}

export default Home;
