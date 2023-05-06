import './App.css';
import { useState, useEffect } from 'react';
import Product from './Product';
import { Link } from 'react-router-dom';

function Categories() {
    
    let [categories, setCategories] = useState([])

    useEffect(() => {
      fetch('/categories', {
        headers: {
          "accept": "application/json"
        }
      })
        .then(Response => Response.json())
        .then(data => setCategories(data))
  

  
  
    }, [])

    return (
        <ul>
        <h6>Categories</h6>
        {categories.map(category => <li><Link to={`../../category/` + category.categoryName}>{category.categoryName}</Link></li>)}
        </ul>
    );
  }

  export default Categories;