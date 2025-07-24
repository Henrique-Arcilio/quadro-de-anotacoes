// src/pages/Anotacao.jsx
import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import MongoTexto from "../components/CustomAnotacao";
import { TextField } from "@mui/material";
import api from '../api';

const Anotacao = () => {
  const anotacaoId = localStorage.getItem("anotacaoId");
  const quadroId = localStorage.getItem("quadroId");
  const userId = localStorage.getItem("userId");
  const quadroTitulo = localStorage.getItem("quadroTitulo");
  const navigate = useNavigate();

  const [texto, setTexto] = useState("");
  const [titulo, setTitulo] = useState("");
  const [tags, setTags] = useState("");
  const [versoes, setVersoes] = useState([]);
  const [versaoSelecionada, setVersaoSelecionada] = useState("");

  useEffect(() => {
    api
      .get(
        `/usuarios/${userId}/quadros/${quadroId}/anotacoes/${anotacaoId}`
      )
      .then((res) => setTexto(res.data.texto))
      .catch((err) => console.error(err));
  }, [userId, quadroId, anotacaoId]);

  useEffect(() => {
    api
      .get(
        `/usuarios/${userId}/quadros/${quadroId}/anotacoes/${anotacaoId}/versoes`
      )
      .then((res) => setVersoes(res.data))
      .catch((err) => console.error(err));
  }, [userId, quadroId, anotacaoId]);

  const handleSave = () => {
    api.put(
    `/usuarios/${userId}/quadros/${quadroId}/anotacoes/${anotacaoId}`,
    {
       texto: texto,
       titulo: titulo,

    }
)

  };

  const handleVersaoChange = (e) => {
    const versao = e.target.value;
    setVersaoSelecionada(versao);
    const v = versoes.find((v) => v.versao === versao);
    if (v) setTexto(v.texto);
  };

  const handleDelete = () => {
    api
      .delete(
        `/usuarios/${userId}/quadros/${quadroId}/anotacoes/${anotacaoId}`
      )
      .then(handleBack)
      .catch((err) => console.error(err));
  };

  const handleBack = () => {
    navigate("/quadro");
  };

  return (

    <MongoTexto
      texto={texto}
      versoes={versoes}
      versaoSelecionada={versaoSelecionada}
      onTextoChange={(e) => setTexto(e.target.value)}
      onVersaoChange={handleVersaoChange}
      onSave={handleSave}
      onDelete={handleDelete}
      onBack={handleBack}
    />
  );
};

export default Anotacao;
