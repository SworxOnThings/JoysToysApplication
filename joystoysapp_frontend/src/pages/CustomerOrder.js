import { useNavigate } from "react-router-dom";
import { Link, Navigate } from "react-router-dom";
import { useParams } from "react-router-dom";
import { useContextHook } from "../context";
import React, { useState, useEffect } from "react";
import Product from "../components/Product"

export default function CustomerHomepage() {
  const { username, password, customer, setCustomer, token } = useContextHook();
  let {orderID} = useParams();
  const [firstOrder, setFirstOrder] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    if (token) {

        fetch(`http://localhost:8080/customer_order/${orderID}`, {
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
        Your order number {orderID}
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
