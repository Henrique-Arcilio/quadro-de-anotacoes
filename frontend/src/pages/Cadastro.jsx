
import CustomTextField from '../components/CustomTextField';
import CustomButtomOutlined from '../components/CustomButtomOutlined';
import CustomButtonContained from '../components/CustomButtonContained';

import PersonAddAlt1Icon from '@mui/icons-material/PersonAddAlt1';
import LoginIcon from '@mui/icons-material/Login'

import axios from "axios";
import {useState} from "react";
import {useNavigate} from 'react-router-dom';

const Cadastro = () => {

    const navigate = useNavigate();

    const [formData, setFormData] = useState({
        nome: '',
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
        axios.post('http://localhost:8080/api/usuarios', formData)
        .then(() => {
            navigate('/login')
        })
        .catch((erro) => {
            console.log(erro);
        });
    }

    const redirectLogin = () => {
        navigate('/login');
    }

    return (
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
                width: '360px',
                height: '480px',
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
                    Sign Up
                </h1>

                <form onSubmit={handleSubmit}>

                        <CustomTextField
                        label="Nome"
                        name="nome"
                        onChange={handleChange}
                        />

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
                            startIcon= {<LoginIcon/>}
                            texto="Sign In"
                            onClick= {redirectLogin}
                        />

                        <CustomButtonContained
                            variant="contained"
                            color="primary"
                            type="submit"
                            startIcon={<PersonAddAlt1Icon/>}
                            texto="Sign Up"
                        />

                    </div>


                </form>
            </div>
        </div>
    );
}

export default Cadastro;