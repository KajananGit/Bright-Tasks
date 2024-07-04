import {useState} from 'react'; 
import SignUp from '../components/SignUp';

const SignUpContainer = () => {
    
    const [user, setUser] = useState([]); 
    
    return ( 
        <>
        <h2>Hey there!</h2>
        <h4>Welcome to Bright Tasks 
            where you can manage your day to day tasks in one place</h4>
        <SignUp />
        </>
     );
}
 
export default SignUpContainer;