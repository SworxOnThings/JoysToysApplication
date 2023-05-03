import React, { useEffect } from 'react';
import './App.css';
import Product from './Product';
import { useState } from 'react';


export default function ToyCars(){

    const [Toy_Cars, setToy_Cars] = useState([]);
 
    useEffect(() => {
    fetch('/products/product_category?CategoryName=Toy_Cars', {
        //if method left out, then react defaults to GET request
        method: "GET", 

        headers: {
            "accept": "application/json",
            "Content-Type" : "application/json",
        },
        
    } )
    .then(Response => Response.json())
    .then(data => {
        console.log(data); 
        setToy_Cars(data);})
        .catch(error => console.error(error));


}, [])


    return(
        <div>
            { <div>{Toy_Cars && Toy_Cars.map(Toy_Cars => <Product product={Toy_Cars}/>)}</div> }
        </div>
    );

}
