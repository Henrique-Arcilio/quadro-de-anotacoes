import React from 'react';
import {
  Dialog,
  DialogActions,
  DialogContent,
  DialogTitle,
  Button,
  TextField
} from '@mui/material';

export default function CustomDialog({ open, onClose, onSubmit, titulo, label }) {
  const handleSubmit = (event) => {
    event.preventDefault();
    const formData = new FormData(event.currentTarget);
    const formJson = Object.fromEntries(formData.entries());
    onSubmit(formJson.nome); 
    onClose();
  };

  return (
    <Dialog
      open={open}
      onClose={onClose}
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
        {titulo}
      </DialogTitle>

      <DialogContent sx={{ paddingBottom: 0 }}>
        <form onSubmit={handleSubmit}>
          <TextField
            autoFocus
            required
            margin="dense"
            name="nome"
            label={label}
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
              onClick={onClose}
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
  );
}
