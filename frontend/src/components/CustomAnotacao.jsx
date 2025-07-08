
import {
  IconButton,
  TextField,
  Select,
  MenuItem,
  FormControl,
  InputLabel,
} from "@mui/material";
import ArrowBackIosNewRounded from "@mui/icons-material/ArrowBackIosRounded";
import SaveRoundedIcon from "@mui/icons-material/SaveRounded";
import DeleteRoundedIcon from "@mui/icons-material/DeleteRounded";

const MongoTexto = ({
  texto,
  versoes,
  versaoSelecionada,
  onTextoChange,
  onVersaoChange,
  onSave,
  onDelete,
  onBack,
}) => {
  return (
    <div
      style={{
        width: "100vw",
        height: "100vh",
        backgroundColor: "#121212",
        color: "#fff",
        padding: "40px",
      }}
    >
      <div style={{ display: "flex", alignItems: "center", gap: "12px" }}>
        <IconButton
          onClick={onBack}
          sx={{ backgroundColor: "#8234E9", color: "#fff" }}
        >
          <ArrowBackIosNewRounded />
        </IconButton>
        <h2 style={{ flexGrow: 1 }}>Estudo sobre MongoDB</h2>

        <IconButton
          sx={{ backgroundColor: "#8234E9", color: "#fff" }}
          onClick={onSave}
        >
          <SaveRoundedIcon />
        </IconButton>

        <IconButton sx={{ backgroundColor: "#8234E9", color: "#fff" }} onClick={onDelete}>
          <DeleteRoundedIcon />
        </IconButton>

        <FormControl variant="filled" sx={{ minWidth: 160 }}>
          <InputLabel sx={{ color: "#fff" }}>Versões</InputLabel>
          <Select
            value={versaoSelecionada}
            onChange={onVersaoChange}
            sx={{
              color: "#fff",
              backgroundColor: "#8234E9",
              borderRadius: "8px",
              "& .MuiSvgIcon-root": { color: "#fff" },
            }}
          >
            <MenuItem value="">
              <em>Atual</em>
            </MenuItem>
            {versoes.map((v) => (
              <MenuItem key={v.versao} value={v.versao}>
                Versão {v.versao}
              </MenuItem>
            ))}
          </Select>
        </FormControl>
      </div>

      <TextField
        multiline
        fullWidth
        minRows={10}
        value={texto}
        onChange={onTextoChange}
        variant="filled"
        sx={{
          mt: 3,
          backgroundColor: "#1e1e1e",
          borderRadius: "8px",
          "& .MuiFilledInput-root": { color: "#fff" },
          "& .MuiFilledInput-root:hover": { backgroundColor: "#2c2c2c" },
          "& .MuiFilledInput-root.Mui-focused": {
            backgroundColor: "#2c2c2c",
          },
        }}
      />
    </div>
  );
};

export default MongoTexto;
