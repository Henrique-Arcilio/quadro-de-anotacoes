
import CustomTextField from '../components/CustomTextField';
import CustomButtomOutlined from '../components/CustomButtomOutlined';
import CustomButtonContained from '../components/CustomButtonContained';

import PersonAddAlt1Icon from '@mui/icons-material/PersonAddAlt1';
import LoginIcon from '@mui/icons-material/Login';
import api from '../api';
import {useState} from "react";
import {useNavigate} from 'react-router-dom';



const Login = () => {
    const navigate = useNavigate();

    const [formData, setFormData] = useState({
        id: '',
        login: '',
        senha: ''
    });

    const handleChange = (e) => {
        setFormData({
            ...formData,
            [e.target.name]: e.target.value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        api.post('/auth', formData)
        .then((res) => {
            console.log(res);
            localStorage.setItem('userId', res.data.id);
            navigate('/quadros');
        })
        .catch((erro) => {
            console.log(erro);
        });
    }

    const redirectCadastrar = () => {
        navigate('/cadastro');
    }


    return(
        <div style={{
            display: 'flex',
            justifyContent: 'center',
            alignItems: 'center',
            height: '100vh',
            width: '100vw',
            backgroundColor: 'primary',
            fontFamily: 'ubuntu'
        }}>
            <div style={{
                width: '350px',
                height: '430px',
                margin: '30px auto',
                padding: '50px',
                backgroundColor: '#252525',
                borderRadius: '20px',
                boxShadow: '0 8px 24px rgba(0,0,0,0.1)',
                fontFamily: 'Ubuntu'
            }}>
                <h1 style={{
                    textAlign: 'center',
                    fontSize: '35px',
                    fontWeight: '500',
                    color: '#ffffff',
                    marginBottom: '35px'
                }}>
                    Sign In
                </h1>
                

                <form onSubmit={handleSubmit}>

                     <CustomTextField
                        label="Login"
                        name="login"
                        onChange={handleChange}
                        />

                     <CustomTextField
                        label="Password"
                        name="senha"
                        type='password'
                        onChange={handleChange}
                        />

                    <div 
                        style={{
                            display: 'flex',
                            justifyContent: 'space-between',
                            marginTop: '20px'
                        }}
                    >
                        <CustomButtomOutlined
                            variant = "outlined"
                            color="primary"
                            startIcon= {<PersonAddAlt1Icon/>}
                            texto="Sign Up"
                            onClick= {redirectCadastrar}
                        />

                        <CustomButtonContained
                            variant="contained"
                            color="primary"
                            type="submit"
                            startIcon={<LoginIcon/>}
                            texto="Sign In"
                        />

                    </div>


                </form>
            </div>
        </div>
        

    );
}

export default Login;