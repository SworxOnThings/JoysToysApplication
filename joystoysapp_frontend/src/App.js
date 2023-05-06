import logo from './logo.svg';
import './App.css';
import Home from './Home';
import CustomerLoginPage from './CustomerLoginPage';
import CustomerHomepage from './CustomerHomepage';
import Products from './Products';
import ActionFigures from './Action_Figures';
import BarbieDolls from './Barbie_Dolls';
import BabyDolls from './Baby_Dolls';
import ToyGuns from './Toy_Guns';
import ToyCars from './Toy_Cars';
import Sports from './Sports';
import ArtsCrafts from './Arts&Crafts';
import { useState, useEffect } from 'react';
import Product from './Product';
import { Routes ,Route } from 'react-router-dom';

function App() {


  return (
    <>
    <Routes>
       <Route path="/" element={<Home />} />
       <Route path="/CustomerLoginPage" element={<CustomerLoginPage />} />
       <Route path="/CustomerHomepage" element={<CustomerHomepage />} />
       <Route path="/category/:category" element={<Products />} />
    {/*
       <Route path="/Barbie_Dolls" element={<BarbieDolls />} />
       <Route path="/Baby_Dolls" element={<BabyDolls />} />
       <Route path="/Toy_Guns" element={<ToyGuns />} />
       <Route path="/Toy_Cars" element={<ToyCars />} />
       <Route path="/Sports" element={<Sports />} />
       <Route path="/Arts_Crafts" element={<ArtsCrafts />} />
  */}
    </Routes>
 </>
  );
}

export default App;
