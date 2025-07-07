
import CustomDialog from '../components/CustomDialog';
import CustomAddButtom from '../components/CustomAddButtom';
import axios from 'axios';
import React, { useState, useEffect } from 'react';
import {useNavigate} from 'react-router-dom';


const Quadros = () => {
  const navigate = useNavigate();
  const [open, setOpen] = React.useState(false);
  const userId = localStorage.getItem('userId');
  const [quadros, setQuadros] = useState([]);
  const handleClickOpen = () => setOpen(true);
  const handleClose = () => setOpen(false);

  const handleCardClick = (id, titulo) => {
    localStorage.setItem('quadroId', id);
    localStorage.setItem('quadroTitulo', titulo);
    navigate(`/quadro`);
  };

  const fetchQuadros = () => {
    axios
      .get(`http://localhost:8080/api/usuarios/${userId}/quadros`)
      .then((response) => setQuadros(response.data))
      .catch((error) => console.error("Erro ao buscar dados:", error));
  };


  useEffect(() => {
    fetchQuadros();
  }, [userId]);


  const handleCriarQuadro = (nomeDoQuadro) => {
    axios.post(`http://localhost:8080/api/usuarios/${userId}/quadros`, {
      titulo: nomeDoQuadro,
      userId: userId 
    })
    .then(() => {
      fetchQuadros();
    })
    .catch((err) => {
      console.error('Erro ao criar quadro:', err);
    });
  };

  return (
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
                    Quadros
                </h1>
            </div>

            <div style={{
                height: '73vh',
                width: '100vw',
                justifyContent:'center',
                padding: '40px',
                display: 'flex',
                flexWrap: 'wrap',
                gap: '10px'
            }}>
                 {quadros.map((quadro) => (
                    <div
                        key={quadro.id}
                        onClick={() => handleCardClick(quadro.id, quadro.titulo)}
                        style={{
                        width: '200px',
                        height: '200px',
                        padding: '20px',
                        backgroundColor: '#252525',
                        color: '#fff',
                        borderRadius: '20px',
                        boxShadow: '0 8px 24px rgba(0,0,0,0.1)',
                        fontFamily: 'Ubuntu',
                        display: 'flex',
                        alignItems: 'center',
                        justifyContent: 'center',
                        textAlign: 'center',
                        cursor: 'pointer', 
                        transition: 'transform 0.2s ease',
                      }}
                      onMouseEnter={(e) => e.currentTarget.style.transform = 'scale(1.03)'}
                      onMouseLeave={(e) => e.currentTarget.style.transform = 'scale(1)'}
                    >
                        <h2>{quadro.titulo}</h2>
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

                <CustomDialog
                    open={open}
                    onClose={handleClose}
                    onSubmit={handleCriarQuadro}
                    titulo="Novo Quadro"
                    label="Nome do Quadro"
                />
            </div>
        </div>
  );
};

export default Quadros;
