import {useEffect, useState} from 'react'; 
import SignUp from '../components/SignUp';

const SignUpContainer = ({users, setUsers}) => {
     
    

    // POST Request to create new user
    const postNewUser = async (newUser) => {
        const response = await fetch("http://localhost:8080/users", {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(newUser)
        })

    }
    
    return ( 
        <>
        <h1>Hey there!</h1>
        <h3>Welcome to Bright Tasks 
            where you can manage your day to day tasks in one place</h3>

        <SignUp postNewUser={postNewUser} users={users}/>

        <p>Already registered? <a href="">Login</a></p> 
        </>
     );
}
 
export default SignUpContainer;