import { useNavigate } from "react-router-dom";
import { Link, Navigate } from "react-router-dom";
import { useContextHook } from "../context";
import React, { useState, useEffect } from "react";
import Product from "../components/Product"

export default function CustomerHomepage() {
  const { username, password, customer, setCustomer, token } = useContextHook();
  const [firstOrder, setFirstOrder] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    console.log(`username: ${username}`);
    if (token) {
      fetch(`http://localhost:8080/customer?username=${username}`, {
        headers: {
          Authorization: "Bearer " + token,
          "Access-Control-Origin": "*",
        },
      })
        .then((response) => response.json())
        .then((customer) => setCustomer(customer))
        .catch();

        fetch(`http://localhost:8080/customer_order/1`, {
        headers: {
          Authorization: "Bearer " + token,
          "Access-Control-Origin": "*",
        },
      })
        .then((response) => response.json())
        .then((data) => setFirstOrder(data))
        .catch();
    }
    else{
      navigate("/Login");
    }
  }, [token]);

  
    return (
      <div>
        <h1>Hello {username}:</h1>
        <pre>{JSON.stringify(customer, null, 2)}</pre>
        Your order number 1
        {firstOrder?
                      <div className='productContainer'>
                      {firstOrder.orderedProductsSet.map(product => <Product product={product.products}/>)}
                      </div>
                      :
                      <div>Loading...</div>
      }
      </div>
    );
  
}
