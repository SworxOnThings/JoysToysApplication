import { useState, useEffect } from "react";
import Product from "../components/Product";
import { Link } from "react-router-dom";
import Categories from "../components/Categories";
import ShopComponent from "./ShopComponent";

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

  function handleFetch() {
    fetch(`/products`, {
      headers: {
        accept: "application/json",
      },
    })
      .then((Response) => Response.json())
      .then((data) => setProducts(data));
  }
  return (
    <div>
      <h1 className="App-Header">Joys Toys</h1>
      <Link to="/CustomerLoginPage">
        <button align="right">Login</button>
      </Link>
      <Categories />
      <h1>Best Sellers</h1>
      {products.length ? (
            <div className='productContainer'>
            {products.map((product) => (
            <Product product={product} />
          ))}
        </div>
      ) : (
        "hit the button"
      )}
      <input
        value={product_id}
        onChange={(event) => setProductID(event.target.value)}
      />
      <button
        onClick={handleFetch}
        disabled={products.find((product) => product.product_id == product_id)}
      >
        Fetch API
      </button>
    </div>
  );
}

export default Home;
