import PropTypes from "prop-types";
import Login from "../components/Login";

const LoginContainer = ({ users, setLoggedInUser }) => {
  return (
    <>
      <h1>Hey there!</h1>
      <Login users={users} setLoggedInUser={setLoggedInUser} />
      <p>
        New Here? <a href="/signup">Sign Up</a>
      </p>
    </>
  );
};

LoginContainer.propTypes = {
  users: PropTypes.array.isRequired,
  setLoggedInUser: PropTypes.func.isRequired,
};

export default LoginContainer;
