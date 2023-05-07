import { useState } from "react"
import Home from "./Home";

export default function Product({product, handleDelete, addItem}){
    let [imageURL, setImageURL] = useState(product.imageurl);

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
            <button onClick={ () => addItem(this) }>Add to Cart</button>
        </div>
    )
}