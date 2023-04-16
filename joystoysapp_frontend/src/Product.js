import { useState } from "react"

export default function Product({product, handleDelete}){
    let [imageURL, setImageURL] = useState(product.imageurl);

    return(
        <div>
            <h6>
                {product.product_name}
            </h6>
            <div>
                {product.price}
            </div>
            <div>
                <img src= {product.imageURL} alt="" width="auto" height="200"/>
            </div>    
            
            <button onClick={()=>handleDelete(product.product_id)}>Delete</button>
        </div>
    )
}