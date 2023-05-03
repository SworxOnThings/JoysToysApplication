import React, { useEffect } from 'react';
import './App.css';
import Product from './Product';
import { useState } from 'react';


export default function Sports(){

    const [Sports, setSports] = useState([]);
 
    useEffect(() => {
    fetch('/products/product_category?CategoryName=Sports', {
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
        setSports(data);})
        .catch(error => console.error(error));


}, [])


    return(
        <div>
            { <div>{Sports && Sports.map(Sports => <Product product={Sports}/>)}</div> }
        </div>
    );

}
