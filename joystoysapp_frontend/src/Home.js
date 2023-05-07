import './App.css';
import { useState, useEffect } from 'react';
import Product from './Product';
import { Link } from 'react-router-dom';
import Categories from './Categories';
import ShopComponent from './ShopComponent';
import ShoppingCart from './ShoppingCart';

function Home() {
    let [products, setProducts] = useState([])
    let [product_id, setProductID] = useState(1)
    
    const [items, setItems] = useState([]);
    const [quantities, setQuantities] = useState([]);

    useEffect(() => {
      
      fetch(`/products`, {
        headers: {
          "accept": "application/json"
        }
      })
        .then(Response => Response.json())
        .then(data => setProducts(data))
  
  
  
    }, [])


    function addItem(item){

        const index = items.indexOf(item);
        if(index >= 0){
            //... is called the "spread operator"
            const newQuantities = [...quantities];
            newQuantities[index]++;
            setQuantities(newQuantities);
        }
        else{
            //add a new item into the item list
            setItems([...items, item]);
            setQuantities([...quantities, 1])
        }
    }

    function removeItem(item){
        const index = items.indexOf(item);
        if(index >= 0){
            const newItems = [...items];
            newItems.splice(index, 1);
            const newQuantities = [...quantities];
            setItems(newItems);
            setQuantities(newQuantities);        
        }
    }

    function calculateTotal(items){
        let total = 0;
        for(let i = 0; i < items.length; ++i){
            total += items[i].product.price * quantities[i];
        }
        return total;
    }
    
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
        <ShopComponent items = {items} quantities={quantities} addItem={addItem} removeItem={removeItem} calculateTotal={calculateTotal} />
          <h1 class="App-Header">Joys Toys</h1>
          <Link to ='/CustomerLoginPage'>
          <button align='right'>Login</button>
          </Link>
          <Categories/>
          <h1>Best Sellers</h1>
          {products.length ? <div>{products.map(product => <Product product={product} handleDelete={handleDelete} addItem={addItem} />)}</div> : "hit the button"}
          <input value={product_id} onChange={(event) => setProductID(event.target.value)} />
          <button onClick={handleFetch} disabled={products.find(product => product.product_id == product_id)}>Fetch API</button>
      </div>
    );
  }

  export default Home;