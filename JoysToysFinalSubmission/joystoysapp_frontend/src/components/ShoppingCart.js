import cartIcon from "../assets/cart-shopping-solid.svg"
import { useEffect, useState } from "react";
import ShoppingCartItem from "./ShoppingCartItem";
import Home from "../pages/Home";
import { useContextHook } from "../context";
import { useNavigate } from "react-router-dom";
import ShoppingList from "./ShoppingList";


export default function ShoppingCart(){
    let [show, setShow] = useState(false);
    let navigate = useNavigate();

    return(
        <>
        <div>
            <img alt='cartIcon' src={cartIcon} onClick={() => setShow(!show)} width='40px' />
        </div>
        {show&&
        <>
        <ShoppingList />
        <div>
            <button onClick={ () => navigate("./checkout") }>Checkout</button>    
        </div>
        </>
        }
        </>

    )
}