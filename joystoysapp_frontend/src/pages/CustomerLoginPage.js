import { useNavigate } from 'react-router-dom';
import { useContextHook } from '../context';  

function CustomerLoginPage() {
    const navigate = useNavigate();

    const { username, setUsername, password, setPassword } = useContextHook();  

    const handleUsernameChange = (event) => {
        setUsername(event.target.value);
        console.log(`username: ${username}`);
      };
      

    const handlePasswordChange = (event) => {
    setPassword(event.target.value);
    };
  
    const handleLogin = (event) => {
      event.preventDefault()
      fetch("/login",{
        method: "POST",
        headers:{
          "content-type": "application/json"
        },
        body: JSON.stringify({
          login: username, password
        })
      })

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