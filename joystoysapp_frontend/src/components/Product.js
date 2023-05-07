import { useState } from "react"
import { useContextHook } from "../context";

export default function Product({product}){
    let [imageURL, setImageURL] = useState(product.imageurl);
    let { handleDelete, addItem } = useContextHook();

    return(
        <div className="card">

                <img src= {product.imageURL} />
   
            <h6>
                {product.product_name}
            </h6>
            <div>
                {product.price}
            </div>
            
            <button onClick={()=>handleDelete(product.product_id)}>Delete</button>
            <button onClick={ () => addItem(product) }>Add to Cart</button>
        </div>
    )
}