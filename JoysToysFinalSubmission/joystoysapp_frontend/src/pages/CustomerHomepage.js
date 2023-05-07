
import { Link } from 'react-router-dom';
import { useContextHook } from '../context';
import React, { useState, useEffect } from 'react';


export default function CustomerHomepage(){

    const { username, password, customer, setCustomer} = useContextHook();


    useEffect(() => {
    
    const basicAuth = 'Basic ' + btoa(username + ':' + password);

    console.log(`username: ${username}`);
    fetch(`http://localhost:8080/customer?username=${username}`, {
        headers: {
          'Authorization': basicAuth,
          'Access-Control-Origin': '*' 
        }
      })
      .then(response => response.json())
      .then(customer => setCustomer(customer))
      .catch();
    }, []);

    return(
        <div>
        <h1>Dipshit Customer of Joys Toys:</h1>
        <pre>{JSON.stringify(customer, null, 2)}</pre>
      </div>
    )
}