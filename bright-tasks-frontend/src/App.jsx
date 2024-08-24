import "./App.css";
import SignUpContainer from "./containers/SignUpContainer";
import LoginContainer from "./containers/LoginContainer";
import Navigation from "./components/Navigation";
import { useEffect, useState } from "react";
import { createBrowserRouter, RouterProvider } from "react-router-dom";

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

  const routes = createBrowserRouter([
    {
      path: "/",
      element: <Navigation />,
      children: [
        {
          path: "/signup",
          element: <SignUpContainer users={users} setUsers={setUsers} />,
        },
        {
          path: "/login",
          element: <LoginContainer users={users} />,
        },
      ],
    },
  ]);

  return (
    <>
      <RouterProvider router={routes} />
    </>
  );
}

export default App;
