import { Link, Outlet } from "react-router-dom";

const Navigation = () => {
  return (
    <>
      <nav>
        <ul>
          <li>
            <Link to="/signup">Sign Up</Link>
          </li>
          <li>
            <Link to="/login">Login</Link>
          </li>
        </ul>
      </nav>
      <Outlet />
    </>
  );
};

export default Navigation;
