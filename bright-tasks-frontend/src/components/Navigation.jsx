import { Link, Outlet } from "react-router-dom";
import "../styling/NavigationStyle.css";

const Navigation = () => {
  return (
    <>
      <nav>
        <ul>
          <a>
            <Link to="/home">Home</Link>
          </a>
          <a>
            <Link to="/aboutus">About</Link>
          </a>
          <a>
            <Link to="/signup">Sign Up</Link>
          </a>
          <a>
            <Link to="/login">Login</Link>
          </a>
        </ul>
      </nav>
      <Outlet />
    </>
  );
};

export default Navigation;
