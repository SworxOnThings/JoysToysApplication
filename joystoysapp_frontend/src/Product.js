export default function Product({product, handleDelete}){
    return(
        <div>
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