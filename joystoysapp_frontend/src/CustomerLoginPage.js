import './App.css';
import { useNavigate } from 'react-router-dom';
import React, { createContext, useState } from 'react';
import { useContext } from 'react';

export const UserContext = createContext(null);

export const UserProvider = ({ children }) => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
  
    return (
      <UserContext.Provider value={{ username, setUsername, password, setPassword }}>
        {children}
      </UserContext.Provider>
    );
  };
  

function CustomerLoginPage() {
    const navigate = useNavigate();

    const { username, setUsername, password, setPassword } = useContext(UserContext);  

    const handleUsernameChange = (event) => {
        setUsername(event.target.value);
        console.log(`username: ${username}`);
      };
      

    const handlePasswordChange = (event) => {
    setPassword(event.target.value);
    };
  
    const handleLogin = () => {

      navigate('/CustomerHomepage');
    };
  
    return (
      <div>
        <h1>Login Page</h1>
        <form onSubmit={handleLogin}>
            <label>
                Username:
                <input type="text" value={username} onChange={handleUsernameChange}/>
            </label>
            <label>
                Password:
                <input type="password" value={password} onChange={handlePasswordChange}/>
            </label>
            <button type="submit">Login</button>
        </form>
      </div>
    );
  }

  export default CustomerLoginPage;