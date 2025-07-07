import React from 'react';
import TextField from '@mui/material/TextField';

export default function CustomTextField({ label, name, value, onChange, type, ...rest }) {
  return (
    <TextField
      label={label}
      name={name}
      value={value}
      onChange={onChange}
      type={type}
      variant="outlined"
      fullWidth
      
      sx={{
        marginBottom: '16px',
        '& .MuiOutlinedInput-root': {
          borderRadius: '12px',
          backgroundColor: '#1E1E1E',
          '& fieldset': {
            borderColor: '#1E1E1E',
          },
          '&:hover fieldset': {
            borderColor: '#8234E9',
          },
          '&.Mui-focused fieldset': {
            borderColor: '#8234E9',
          },
        },
        '& label': {
          color: '#6b7280',
        },
        '& label.Mui-focused': {
          color: '#FFF',
        },
        '& input, & textarea': {
          color: '#fff',
        },

      }}
      {...rest} 
    />
  );
}
