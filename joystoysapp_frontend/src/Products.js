import React, { useEffect } from 'react';
import './App.css';
import Product from './Product';
import { useState } from 'react';
import { useParams, useNavigation } from 'react-router-dom';
import Categories from './Categories';


export default function Products(){

    let {category} = useParams()

    const [products, setProducts] = useState([]);
 
    useEffect(() => {
    fetch(`/products/product_category?CategoryName=${category}`, {
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
        setProducts(data);})
        .catch(error => console.error(error));


}, [category    ])


    return(
        <div className='row'>
            <Categories />
            <div className='productContainer'>
                {products && products.map(product => <Product product={product}/>)}
            </div>
        </div>
    );

}
