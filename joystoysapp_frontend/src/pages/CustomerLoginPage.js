import { useNavigate } from 'react-router-dom';
import { useContextHook } from '../context';  
import { useCookies } from 'react-cookie';
import { useEffect } from 'react';

function CustomerLoginPage() {
    const navigate = useNavigate();
    const [cookies, setCookies] = useCookies();

    const { username, setUsername, password, setPassword, token, setToken } = useContextHook();  

    const handleUsernameChange = (event) => {
        setUsername(event.target.value);
        console.log(`username: ${username}`);
      };
      

    const handlePasswordChange = (event) => {
    setPassword(event.target.value);
    };
  
    const handleLogin = (event) => {
      event.preventDefault()
      fetch("/customer/token",{
        method: "POST",
        headers:{
          "content-type": "application/json"
        },
        body: JSON.stringify({
          username, password
        })
      })
      .then(res => res.json())
      .then(data => {
        setToken(data.token)
        setCookies("token", data.token)
        setCookies("username", username)
      })

      navigate('/CustomerHomepage');
    };
  
    useEffect(()=> {
      if(token){
        navigate('/CustomerHomepage');
      }
    }, [token])
   

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