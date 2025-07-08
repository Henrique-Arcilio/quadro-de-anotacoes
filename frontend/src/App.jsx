import { useState } from 'react'
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import { ThemeProvider, CssBaseline } from '@mui/material';
import theme from './theme/theme';

import Login from './pages/Login';
import Cadastro from './pages/Cadastro';
import Quadros from  './pages/Quadros'
import Quadro from  './pages/Quadro'
import Anotacao from './pages/Anotacao';
import './index.css';

function App() {
  return (
     <ThemeProvider theme={theme}>
        <CssBaseline />
        <BrowserRouter>
          <Routes>
            <Route path="/" element={<Login />} />
            <Route path="/login" element={<Login />} />
            <Route path='/cadastro' element={<Cadastro />} />
            <Route path='/quadros' element={<Quadros />} />
            <Route path='/quadro' element={<Quadro />} />
            <Route path='/anotacao' element={<Anotacao />} />
          </Routes>
        </BrowserRouter>
     </ThemeProvider>
  );
}
export default App;
