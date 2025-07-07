
import React from 'react';
import IconButton from '@mui/material/IconButton';
import EditRoundedIcon from '@mui/icons-material/EditRounded';

export default function CustomEditIcon({ onClick }) {
  return (
    <IconButton
      onClick={onClick}
      sx={{
        backgroundColor: '#8234E9',
        width: '35px',
        height: '35px',
        '&:hover': {
          backgroundColor: '#5C22A8'
        },
        color: '#fff',
        borderRadius: '12px'
      }}
    >
      <EditRoundedIcon />
    </IconButton>
  );
}
