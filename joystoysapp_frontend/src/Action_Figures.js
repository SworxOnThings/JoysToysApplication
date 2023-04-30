import React, { useEffect } from 'react';
import './App.css';
import Product from './Product';
import { useState } from 'react';


export default function ActionFigures(){

    const [Action_Figures, setAction_Figures] = useState([]);
 
    useEffect(() => {
    fetch('/products/product_category?CategoryName=Action_Figures', {
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
        setAction_Figures(data);})
        .catch(error => console.error(error));


}, [])


    return(
        <div>
            { <div>{Action_Figures && Action_Figures.map(Action_Figure => <Product product={Action_Figure}/>)}</div> }
        </div>
    );

}
