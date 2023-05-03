import React, { useEffect } from 'react';
import './App.css';
import Product from './Product';
import { useState } from 'react';


export default function ToyGuns(){

    const [Toy_Guns, setToy_Guns] = useState([]);
 
    useEffect(() => {
    fetch('/products/product_category?CategoryName=Toy_Guns', {
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
        setToy_Guns(data);})
        .catch(error => console.error(error));


}, [])


    return(
        <div>
            { <div>{Toy_Guns && Toy_Guns.map(Toy_Guns => <Product product={Toy_Guns}/>)}</div> }
        </div>
    );

}
