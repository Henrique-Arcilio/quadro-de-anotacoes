import React from 'react';
import { Autocomplete, Chip, TextField } from '@mui/material';

export default function CustomMultiInputTags({ value, onChange }) {
  return (
    <Autocomplete
      multiple
      freeSolo
      id="tags-filled"
      options={[]} // Sem sugestões fixas
      value={value}
      onChange={(event, newValue) => {
        onChange(newValue); // Atualiza o estado no pai
      }}
      renderTags={(value, getTagProps) =>
        value.map((option, index) => (
          <Chip
            variant="outlined"
            label={option}
            key={index}
            {...getTagProps({ index })}
            sx={{ backgroundColor: '#8234E9', color: '#fff' }}
          />
        ))
      }
      renderInput={(params) => (
        <TextField
          {...params}
          variant="outlined"
          label="Tags"
          placeholder="Digite e pressione Enter"
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
      )}
    />
  );
}
