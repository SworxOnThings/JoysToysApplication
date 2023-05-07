import logo from './logo.svg';
import './styles/App.css';
import Home from './pages/Home';
import CustomerLoginPage from './pages/CustomerLoginPage';
import CustomerHomepage from './pages/CustomerHomepage';
import Products from './pages/Products';
import { Routes ,Route } from 'react-router-dom';
import Checkout from './pages/Checkout';

function App() {


  return (
    <>
    <Routes>
      
       <Route path="/" element={<Home />} />
       <Route path="/Login" element={<CustomerLoginPage />} />
       <Route path="/CustomerHomepage" element={<CustomerHomepage />} />
       <Route path="/category/:category" element={<Products />} />
       
       <Route path="/checkout" element={<Checkout />} />
    </Routes>
 </>
  );
}

export default App;
