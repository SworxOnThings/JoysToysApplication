import React from 'react';
import ShoppingCart from './ShoppingCart';

export default function ShopComponent(props) {
  const { items, quantities, addItem, removeItem, calculateTotal } = props;

  return (
    <div>
      <ShoppingCart 
        items = {items}
        quantities = {quantities}
        addItem = {addItem}
        removeItem = {removeItem}
        calculateTotal = {calculateTotal}
      >
      <main>
        {props.children}
      </main>
      </ShoppingCart>
    </div>
  );
}
