import {useState} from 'react'; 

const SignUp = ({ postNewUser, users }) => {
    
    const [userName, setUserName] = useState("");
    const [email, setEmail] = useState("");
    const [confirmEmail, setConfirmEmail] = useState("");
    const [password, setPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");

    const handleSubmit = async (event) => {
        event.preventDefault();
        const newUser = {
            userName,
            email,
            password
        }
        if (handleValidation()){ 
            await postNewUser(newUser)
            console.log(users)
        }
    }


    const handleValidation = () => {
        
        const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        if (!userName || !email || !confirmEmail || !password || !confirmPassword){
            alert("Please fill in all fields!")
            return false
        }

        if (!emailRegex.test(email)) {
            alert("Please enter a valid email address!");
            return false;
        }

        if (email !== confirmEmail){
            alert("Email Address don't match!")
            return false
        }

        if (password !== confirmPassword){
            alert("Password don't match!")
            return false
        }

        if (users.some(user => user.email === email)){
            alert("Email already in use!")
            return false
        }

        return true

    }
    
    return ( 
        <>
        <h4 className="SignUp-Title">Get started!</h4>
        <form id="SignUp-Form" onSubmit={handleSubmit}>
            <input type="text" placeholder="name" onChange={(event) => setUserName(event.target.value)}/>
            <input type="text" placeholder="email" onChange={(event) => setEmail(event.target.value)}/>
            <input type="text" placeholder="confirm email" onChange={(event) => setConfirmEmail(event.target.value)}/>
            <input type="text" placeholder="password" onChange={(event) => setPassword(event.target.value)}/>
            <input type="text" placeholder="confirm password" onChange={(event) => setConfirmPassword(event.target.value)} />
            <input type="submit"  value="Sign Up"/>
        </form>
        </>
     );
}
 
export default SignUp;