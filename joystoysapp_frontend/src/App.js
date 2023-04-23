import logo from './logo.svg';
import './App.css';
import Home from './Home';
import ActionFigures from './Action_Figures';
import BarbieDolls from './Barbie_Dolls';
import { useState, useEffect } from 'react';
import Product from './Product';
import { Routes ,Route } from 'react-router-dom';

function App() {

  return (
    <>
    <Routes>
       <Route path="/" element={<Home />} />
       <Route path="/Action_Figures" element={<ActionFigures />} />
       <Route path="/Barbie_Dolls" element={<BarbieDolls />} />
    </Routes>
 </>
  );
}

export default App;
