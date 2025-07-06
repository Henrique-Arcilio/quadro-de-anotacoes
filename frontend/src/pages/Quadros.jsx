import * as React from 'react';
import {
  Button,
  TextField,
  Dialog,
  DialogActions,
  DialogContent,
  DialogTitle
} from '@mui/material';
import axios from 'axios';

const Quadros = () => {
  const [open, setOpen] = React.useState(false);

  const handleClickOpen = () => {
    setOpen(true);
  };

  const handleClose = () => {
    setOpen(false);
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    const formData = new FormData(event.currentTarget);
    const formJson = Object.fromEntries(formData.entries());
    const nome = formJson.nome;
    axios.post('')
    handleClose();
  };

  return (
    <React.Fragment>
      <Button
        variant="outlined"
        onClick={handleClickOpen}
        sx={{
          color: '#8234E9',
          borderColor: '#8234E9',
          '&:hover': {
            backgroundColor: '#8234E910',
            borderColor: '#8234E9'
          }
        }}
      >
        Criar Quadro
      </Button>

      <Dialog
        open={open}
        onClose={handleClose}
        PaperProps={{
          sx: {
            backgroundColor: '#252525',
            borderRadius: '16px',
            color: '#fff',
            fontFamily: 'Ubuntu'
          }
        }}
      >
        <DialogTitle
          sx={{
            fontSize: '20px',
            fontWeight: '600',
            color: '#fff'
          }}
        >
          Novo Quadro
        </DialogTitle>

        <DialogContent sx={{ paddingBottom: 0 }}>
          <form onSubmit={handleSubmit}>
            <TextField
              autoFocus
              required
              margin="dense"
              id="name"
              name="nome"
              label="Nome do Quadro"
              type="text"
              fullWidth
              variant="outlined"
              sx={{
                input: { color: '#fff' },
                label: { color: '#bbb' },
                '& label.Mui-focused': { color: '#8234E9' },
                '& .MuiOutlinedInput-root': {
                  '& fieldset': {
                    borderColor: '#444'
                  },
                  '&:hover fieldset': {
                    borderColor: '#8234E9'
                  },
                  '&.Mui-focused fieldset': {
                    borderColor: '#8234E9'
                  }
                }
              }}
            />

            <DialogActions sx={{ marginTop: 2 }}>
              <Button
                onClick={handleClose}
                sx={{
                  color: '#aaa',
                  '&:hover': {
                    backgroundColor: '#333'
                  }
                }}
              >
                Cancelar
              </Button>
              <Button
                type="submit"
                variant="contained"
                sx={{
                    
                    backgroundColor: '#8234E9',
                    color: '#fff',
                    '&:hover': {
                        backgroundColor: '#6e27cc'
                  }
                }}
              >
                Criar
              </Button>
            </DialogActions>
          </form>
        </DialogContent>
      </Dialog>
    </React.Fragment>
  );
};

export default Quadros;
