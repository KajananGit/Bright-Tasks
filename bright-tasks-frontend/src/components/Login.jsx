import { useState } from "react";
import PropTypes from "prop-types";

const Login = ({ users, setLoggedInUser }) => {
  const [loginEmail, setLoginEmail] = useState("");
  const [loginPassword, setLoginPassword] = useState("");

  const handleSubmit = (event) => {
    event.preventDefault();
    validateUser();
  };

  const validateUser = () => {
    const filteredUser = users.find(
      (user) =>
        user.email.toLowerCase() === loginEmail.toLocaleLowerCase() &&
        user.password === loginPassword,
    );
    if (!filteredUser) {
      alert("Incorrect Email or Password entered!");
      return;
    }
    setLoggedInUser(filteredUser);
    console.log(filteredUser);
    alert(`Welcome ${filteredUser.userName}`);
  };

  return (
    <>
      <form id="Login-Form" onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="email"
          onChange={(event) => setLoginEmail(event.target.value)}
        />
        <input
          type="text"
          placeholder="password"
          onChange={(event) => setLoginPassword(event.target.value)}
        />
        <input type="submit" value="Login" />
      </form>
    </>
  );
};
Login.propTypes = {
  users: PropTypes.array.isRequired,
  setLoggedInUser: PropTypes.func.isRequired,
};

export default Login;
