import { useState } from "react";
import PropTypes from "prop-types";

const Login = ({ users }) => {
  const [loginEmail, setLoginEmail] = useState("");
  const [loginPassword, setLoginPassword] = useState("");

  const handleSubmit = (event) => {
    event.preventDefault();
    if (userValid()) {
      console.log("Login Sucess!");
    }
    if (!userValid()) {
      alert("Incorrect Email or Password entered!");
    }
  };

  const userValid = () => {
    const filteredUser = users.find(
      (user) =>
        user.email.toLowerCase() === loginEmail.toLocaleLowerCase() &&
        user.password === loginPassword,
    );
    return !!filteredUser; //return true if a user is found, otherwise false
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
};

export default Login;
