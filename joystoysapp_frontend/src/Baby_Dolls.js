import App from "./App";
import Product from "./Product";
import { useState } from "react";
import { useEffect } from "react";


export default function BabyDolls(){

    const [Baby_Dolls, setBaby_Dolls] = useState([]);

    useEffect(() => {
        fetch('/products/product_category?CategoryName=Baby_Dolls', {
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
            setBaby_Dolls(data);})
            .catch(error => console.error(error));

    }, [])    

    return(
        <>
        <div>
            { <div>{Baby_Dolls && Baby_Dolls.map(Baby_Dolls => <Product product={Baby_Dolls}/>)}</div> }
        </div>
        </>
    );

}