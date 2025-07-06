import React from 'react';
import IconButton from '@mui/material/IconButton';
import AddIcon from '@mui/icons-material/Add';

export default function CustomAddButton({ onClick }) {
  return (
    <IconButton
      onClick={onClick}
      sx={{
        backgroundColor: '#8234E9',
        width: '60px',
        height: '60px',
        '&:hover': {
          backgroundColor: '#5C22A8'
        },
        color: '#fff',
        borderRadius: '12px'
      }}
    >
      <AddIcon fontSize="large" />
    </IconButton>
  );
}
