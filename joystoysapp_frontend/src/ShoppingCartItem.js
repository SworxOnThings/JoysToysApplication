import React from 'react';
import Product from './Product';


export default function ShoppingCartItem({ props }) {

  return (
    <div>
      <Product product={props.item} />
      <div>Quantity: {props.quantity}</div>
      <div>Price: {props.price}</div>
      <button onClick={props.onAdd}>+</button>
      <button onClick={props.onRemove}>-</button>
    </div>
  );
}

