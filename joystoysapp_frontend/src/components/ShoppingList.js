import { useContextHook } from "../context";
import ShoppingCartItem from "./ShoppingCartItem";

export default function ShoppingList(){
    const { items, quantities, addItem, removeItem, calculateTotal } = useContextHook();

    return(
        <>
        {items.map((item, index) => 
            <ShoppingCartItem
                key={index}
                item={item}
                quantity={quantities[index]}
                onAdd={ () => addItem(item) }
                onRemove={ () => removeItem(item) }
            />
        
            
        )}

        <div>Total: { calculateTotal(items) }</div>   
        </>

    )
}