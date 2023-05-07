import App from "./App";
import { useEffect, useState } from "react";
import ShoppingCartItem from "./ShoppingCartItem";
import Home from "./Home";


export default function ShoppingCart(props){
    console.log(props);
    const { items, quantities, addItem, removeItem, calculateTotal } = props;

    return(
        <div>
            {items.map((item, index) => {
                <ShoppingCartItem
                    key={index}
                    item={item}
                    quantity={quantities[index]}
                    onAdd={ () => addItem(item) }
                    onRemove={ () => removeItem(item) }
                />
            
                
            })}

            <div>Total: { calculateTotal(items) }</div>       
        </div>

    )
}