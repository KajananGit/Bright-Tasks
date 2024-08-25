import SignUp from "../components/SignUp";
import PropTypes from "prop-types";

const SignUpContainer = ({ users }) => {
  // POST Request to create new user
  const postNewUser = async (newUser) => {
    await fetch("http://localhost:8080/users", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(newUser),
    });
  };

  return (
    <>
      <h1>Hey there!</h1>
      <h3>
        Welcome to Bright Tasks where you can manage your day to day tasks in
        one place
      </h3>

      <SignUp postNewUser={postNewUser} users={users} />

      <p>
        Already registered? <a href="/login">Login</a>
      </p>
    </>
  );
};

SignUpContainer.propTypes = {
  users: PropTypes.array.isRequired,
};

export default SignUpContainer;
