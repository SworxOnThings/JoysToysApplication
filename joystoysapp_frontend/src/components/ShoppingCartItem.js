import React from 'react';
import Product from './Product';


export default function ShoppingCartItem({ quantity, price, onAdd, onRemove, item }) {

  return (
    <div>
      <div>{item.product_name}</div>
      <div>Quantity: {quantity}</div> 
      
      <div>Price: {price}</div>
      <button onClick={onAdd}>+</button>
      <button onClick={onRemove}>-</button>
    </div>
  );
}

