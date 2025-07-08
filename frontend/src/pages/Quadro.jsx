import axios from 'axios';
import React, { useState, useEffect } from 'react';
import {useNavigate} from 'react-router-dom';
import CustomEditIcon from '../components/CustomEditIcon';
import CustomAddButtom from '../components/CustomAddButtom';
import CustomDialogAnotacao from '../components/CustomDialogAnotacao';

const Quadro = () => {
    const navigate = useNavigate();
    const userId = localStorage.getItem('userId');
    const quadroId = localStorage.getItem('quadroId');
    const quadroTitulo = localStorage.getItem('quadroTitulo')
    const [anotacoes, setAnotacoes] = useState([]);
    const [open, setOpen] = React.useState(false);
    const handleClose = () => setOpen(false);
    const handleClickOpen = () => setOpen(true);

    const fetchAnotacoes = () => {
    axios
      .get(`http://localhost:8080/api/usuarios/${userId}/quadros/${quadroId}/anotacoes`)
      .then((response) => setAnotacoes(response.data))
      .catch((error) => console.error("Erro ao buscar dados:", error));
    };

    useEffect(() => {
        fetchAnotacoes();
    }, [userId, quadroId]);

    const handleCriarAnotacao = (anotacao) => {
        axios.post(`http://localhost:8080/api/usuarios/${userId}/quadros/${quadroId}/anotacoes`, {
            ...anotacao,
            userId,
            quadroId
        })
        .then(() => fetchAnotacoes())
        .catch((err) => {
            console.error('Erro ao criar anotação:', err);
        });
    };

    const handleCardClick = (anotacao) => {
        localStorage.setItem('anotacaoId', anotacao.id);
        navigate('/anotacao');
    }

    return(
        <div style={{
            display: 'flex',
            flexDirection: 'column',
            justifyContent: 'center',
            alignItems: 'center',
            height: '100vh',
            width: '100vw',
            backgroundColor: 'primary',
            fontFamily: 'ubuntu'
        }}>
            <div style={{
                width: '100vw',
                height: '15vh'
            
            }}>
                <h1 style={{
                    textAlign: 'initial',
                    fontSize: '30px',
                    fontWeight: '500',
                    color: '#ffffff',
                    marginLeft: '30px'

                }}>
                    {quadroTitulo}
                </h1>
            </div>

            <div style={{
                height: '73vh',
                width: '100vw',
                justifyContent:'center',
                padding: '40px',
                display: 'flex',
                flexWrap: 'wrap',
                gap: '15px'
            }}>
                 {anotacoes.map((anotacao) => (
                    <div
                        key={anotacao.titulo}
                        style={{
                            width: '350px',
                            height: '350px',
                            padding: '15px',
                            backgroundColor: '#252525',
                            color: '#fff',
                            borderRadius: '20px',
                            boxShadow: '0 8px 24px rgba(0,0,0,0.1)',
                            fontFamily: 'Ubuntu',
                            display: 'flex',
                            flexDirection: 'column',
                            cursor: 'pointer',
                            transition: 'transform 0.2s ease',
                            overflow: 'hidden'
                        }}
                        onMouseEnter={(e) => e.currentTarget.style.transform = 'scale(1.03)'}
                        onMouseLeave={(e) => e.currentTarget.style.transform = 'scale(1)'}
                        >
                        <h3>{anotacao.titulo}</h3>

                        <div style={{ 
                            display: 'flex', 
                            flexWrap: 'wrap', 
                            gap: '4px'
                        }}>
                            {anotacao.tags && anotacao.tags.map((tag, index) => (
                            <span
                                key={index}
                                style={{
                                backgroundColor: '#8234E940',
                                color: '#9F50FF',
                                padding: '4px 8px',
                                borderRadius: '12px',
                                fontSize: '12px',
                                fontWeight: 'bold',
                                display: 'inline-block'
                                }}
                            >
                                {tag}
                            </span>
                            ))}
                        </div>

                        <div
                            style={{
                            overflow: 'auto',
                            flexGrow: 1,
                            marginTop: '10px',
                            marginBottom: '50px',
                            whiteSpace: 'pre-wrap',
                            wordBreak: 'break-word'
                            }}
                        >
                            {anotacao.texto}
                        </div>

                        <div style={{
                            position: 'fixed',
                            bottom: '24px',
                            right: '24px',
                            zIndex: 1000 
                        }}>
                            <CustomEditIcon
                            onClick={() => handleCardClick(anotacao)}
                            />
                        </div>
                        </div>

                    ))}
            </div>
            <div style={{
                position: 'fixed',
                bottom: '24px',
                right: '24px',
                zIndex: 1000 
                }}>
                <CustomAddButtom
                    onClick={handleClickOpen}
                />

                <CustomDialogAnotacao
                    openNote={open}
                    onCloseNote={handleClose}
                    onSubmitNote={handleCriarAnotacao}
                    tituloNote="Nova Anotacao"
                    labelNote="Nome da Anotacao"
                />
            </div>
        </div>
    );
};

export default Quadro;