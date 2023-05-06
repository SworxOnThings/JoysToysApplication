import './App.css';
import { useState, useEffect } from 'react';
import Product from './Product';
import { Link } from 'react-router-dom';
import Categories from './Categories';

function Home() {
    let [products, setProducts] = useState([])
    let [product_id, setProductID] = useState(1)

    useEffect(() => {
      
  
  
      fetch(`/products`, {
        headers: {
          "accept": "application/json"
        }
      })
        .then(Response => Response.json())
        .then(data => setProducts(data))
  
  
  
    }, [])
    
    function handleDelete(id) {
      let index = products.findIndex(product => product.product_id == id)
      products.splice(index, 1)
      setProducts([...products])
    }
    function handleFetch() {
      fetch(`/products`, {
        headers: {
          "accept": "application/json"
        }
      })
        .then(Response => Response.json())
        .then(data => setProducts(data))
    }
    return (
      <div>
        <h1 class="App-Header">Joys Toys</h1>
        <Link to ='/CustomerLoginPage'>
        <button align='right'>Login</button>
        </Link>
        <Categories/>
        <h1>Best Sellers</h1>
        {products.length ? <div>{products.map(product => <Product product={product} handleDelete={handleDelete} />)}</div> : "hit the button"}
        <input value={product_id} onChange={(event) => setProductID(event.target.value)} />
        <button onClick={handleFetch} disabled={products.find(product => product.product_id == product_id)}>Fetch API</button>
      </div>
    );
  }

  export default Home;