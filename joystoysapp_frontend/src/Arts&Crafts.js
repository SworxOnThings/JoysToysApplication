import React, { useEffect } from 'react';
import './App.css';
import Product from './Product';
import { useState } from 'react';


export default function ArtsCrafts(){

    const [Arts_Crafts, setArts_Crafts] = useState([]);
 
    useEffect(() => {
    fetch('/products/product_category?CategoryName=Arts&Crafts', {
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
        setArts_Crafts(data);})
        .catch(error => console.error(error));


}, [])


    return(
        <div>
            { <div>{Arts_Crafts && Arts_Crafts.map(Arts_Crafts => <Product product={Arts_Crafts}/>)}</div> }
        </div>
    );

}
