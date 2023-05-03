import App from "./App";
import Product from "./Product";
import { useState } from "react";
import { useEffect } from "react";


export default function BarbieDolls(){

    const [Barbie_Dolls, setBarbie_Dolls] = useState([]);

    useEffect(() => {
        fetch('/products/product_category?CategoryName=Barbie_Dolls', {
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
            setBarbie_Dolls(data);})
            .catch(error => console.error(error));

    }, [])    

    return(
        <>
        <div>
            { <div>{Barbie_Dolls && Barbie_Dolls.map(Barbie_Dolls => <Product product={Barbie_Dolls}/>)}</div> }
        </div>
        </>
    );

}