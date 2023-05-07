import React from 'react';
import ShoppingCart from '../components/ShoppingCart';
import { useLocation } from 'react-router-dom';

export default function ShopComponent({ children }) {
  let location = useLocation();

  return (
    <>
    {location.pathname != '/checkout' &&
      <ShoppingCart />
    }
      <main>
        {children}
      </main>
    </>
  );
}
