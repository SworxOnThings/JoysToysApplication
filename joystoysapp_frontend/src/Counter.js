import { useState } from "react";

//demonstrating how stale state influences setter behaviors, and 
//how this can be solved with the use of callbacks
export default function Counter(){
    let [amount, setAmount] = useState(0)
    return(
        <div>
            {amount}
            <button onClick={()=>{
                setAmount(previousAmount=>previousAmount + 1)
                setAmount(previousAmount=>previousAmount + 1)
            }}>Increment</button>
        </div>
    )
}