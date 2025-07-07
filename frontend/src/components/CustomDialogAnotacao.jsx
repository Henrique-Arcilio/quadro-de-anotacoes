import { useState } from 'react';
import CustomDialog from '../components/CustomDialog';
import CustomTextField from '../components/CustomTextField';


import {
  Dialog,
  DialogActions,
  DialogContent,
  DialogTitle,
  Button,
  TextField
} from '@mui/material';


export default function CustomDialogAnotacao ({openNote, onCloseNote, onSubmitNote, tituloNote }){
    const handleSubmit = (event) => {
        event.preventDefault();
        const formData = new FormData(event.currentTarget);
        const formJson = Object.fromEntries(formData.entries());

        const anotacao = {
            titulo: formJson.titulo,
            texto: formJson.texto,
            tags: formJson.tags?.split(',').map(tag => tag.trim()) || [] 
        };

        onSubmitNote(anotacao); 
        onCloseNote();
    };


    return (
        <Dialog
              open={openNote}
              onClose={onCloseNote}
              PaperProps={{
                sx: {
                  backgroundColor: '#252525',
                  borderRadius: '16px',
                  color: '#fff',
                  fontFamily: 'Ubuntu', 
                  
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
                {tituloNote}
              </DialogTitle>
        
              <DialogContent>
                <form onSubmit={handleSubmit}>
                  <CustomTextField 
                  autoFocus
                    required
                    margin="dense"
                    name="titulo"
                    label= "Nova anotação"
                    type="text"
                    fullWidth
                    variant="outlined"/>

                    

                    <CustomTextField
                        name="tags"
                        label="Tags"
                    />

                    <CustomTextField
                        multiline
                        id="outlined-multiline-static"
                        name="texto"
                        label="Texto"
                        rows={4}
                        
                    />


                  <DialogActions sx={{ marginTop: 2 }}>
                    <Button
                      onClick={onCloseNote}
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