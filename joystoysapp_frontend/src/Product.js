import { useState } from "react"

export default function Product({product, handleDelete}){
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
        </div>
    )
}