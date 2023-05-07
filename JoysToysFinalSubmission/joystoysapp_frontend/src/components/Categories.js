
import { useState, useEffect } from 'react';

import { Link } from 'react-router-dom';

function Categories() {
    
    let [categories, setCategories] = useState([]);
    const regex = /_/g

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
        <ul className='categoriesNav'>
        <h6>Categories</h6>
        {categories.map(category => <li><Link to={`../../category/` + category.categoryName}>{category.categoryName.replace(regex, ' ')}</Link></li>)}
        </ul>
    );
  }

  export default Categories;