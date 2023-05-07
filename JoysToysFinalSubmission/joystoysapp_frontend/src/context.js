import React, { createContext, useState } from "react";
import { useContext } from "react";

export const UserContext = createContext(null);
export const useContextHook = () => useContext(UserContext);

export const UserProvider = ({ children }) => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const [items, setItems] = useState([]);
  const [quantities, setQuantities] = useState([]);

  const [customer, setCustomer] = useState({});

  function addItem(item) {
    const index = items.indexOf(item);
    if (index >= 0) {
      //... is called the "spread operator"
      const newQuantities = [...quantities];
      newQuantities[index]++;
      setQuantities(newQuantities);
    } else {
      //add a new item into the item list
      setItems([...items, item]);
      setQuantities([...quantities, 1]);
    }
  }

  function removeItem(item) {
    const index = items.indexOf(item);
    if (index >= 0) {
      const newItems = [...items];
      const newQuantities = [...quantities];
      if (quantities[index] == 1) {
        newItems.splice(index, 1);
        newQuantities.splice(index, 1);
        setItems(newItems);
      } else {
        newQuantities[index]--;
      }
      setQuantities(newQuantities);
    }
  }

  function calculateTotal(items) {
    let total = 0;
    for (let i = 0; i < items.length; ++i) {
      total += items[i].price * quantities[i];
    }
    return total;
  }

  /*
    function handleDelete(id) {
      let index = products.findIndex(product => product.product_id == id)
      products.splice(index, 1)
      setProducts([...products])
    }
    */

  return (
    <UserContext.Provider
      value={{
        username,
        setUsername,
        password,
        setPassword,
        items,
        quantities,
        addItem,
        removeItem,
        calculateTotal,
        customer, 
        setCustomer
      }}
    >
      {children}
    </UserContext.Provider>
  );
};
