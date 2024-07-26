import Login from "../components/Login";

const LoginContainer = ({users}) => {
    


    return ( 
        <>
        <h1>Hey there!</h1>
        <Login users={users}/>
        <p>New Here? <a href="">Sign Up</a></p> 
        </>
     );
}
 
export default LoginContainer;