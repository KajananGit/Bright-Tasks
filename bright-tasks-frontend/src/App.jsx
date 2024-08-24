import "./App.css";
import SignUpContainer from "./containers/SignUpContainer";
import LoginContainer from "./containers/LoginContainer";
import { useEffect, useState } from "react";

function App() {
  const [users, setUsers] = useState([]);

  // GET Request to get all existing users
  const fetchUsers = async () => {
    const response = await fetch("http://localhost:8080/users");
    const data = await response.json();
    setUsers(data);
  };

  useEffect(() => {
    fetchUsers();
    console.log(users);
  }, []);

  return (
    <>
      <SignUpContainer users={users} setUsers={setUsers} />
      <LoginContainer users={users} />
    </>
  );
}

export default App;
