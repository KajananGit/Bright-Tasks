import PropTypes from "prop-types";
import Login from "../components/Login";

const LoginContainer = ({ users }) => {
  return (
    <>
      <h1>Hey there!</h1>
      <Login users={users} />
      <p>
        New Here? <a href="/signup">Sign Up</a>
      </p>
    </>
  );
};

LoginContainer.propTypes = {
  users: PropTypes.array.isRequired,
};

export default LoginContainer;
