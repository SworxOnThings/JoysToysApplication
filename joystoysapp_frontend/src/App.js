import logo from './logo.svg';
import './App.css';
import { useState, useEffect } from 'react';
import Product from './Product';

function App() {
  let [products, setProducts] = useState([])
  let [product_id, setProductID] = useState(1)
  let [categories, setCategories] = useState([])
  useEffect(()=>{
    fetch('/categories', {
      headers: {
        "accept": "application/json"
      }
    })
    .then(Response => Response.json())
    .then(data => setCategories(data))


    let id = 1;
    while(id <= 43){
      
      fetch(`/products/${id}`, {
        headers: {
          "accept": "application/json"
        }
      })
        .then(Response => Response.json())
        .then(data => setProducts(previousProducts=>previousProducts.find(product=>product.product_id==data.product_id) ? previousProducts : [...previousProducts, data]))
      
        id++
    }
  }, [])
  function handleDelete(id){
    let index = products.findIndex(product=>product.product_id==id)
    products.splice(index, 1)
    setProducts([...products])
  }
  function handleFetch() {
    fetch(`/products/${product_id}`, {
      headers: {
        "accept": "application/json"
      }
    })
      .then(Response => Response.json())
      .then(data => setProducts([...products, data]))
  }
  return (
    <div>
      <h1 class="App-Header">Joys Toys</h1>
      <ol>Categories</ol>
      {categories.map(category => <li>{category.category_name}</li>)}
      {products.length ? <div>{products.map(product => <Product product={product} handleDelete={handleDelete}/> )}</div> : "hit the button"}
      <input value={product_id} onChange={(event) => setProductID(event.target.value)} />
      <button onClick={handleFetch} disabled={products.find(product=>product.product_id==product_id)}>Fetch API</button>
    </div>
  );
}

export default App;
