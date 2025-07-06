import { createTheme } from '@mui/material/styles';

const theme = createTheme({
  palette: {
    primary: {
      main: '#8234E9',
      contrastText: '#fff',
    },
    background: {
      default: '#1E1E1E',
      paper: '#252525',
    },
  },
  typography: {
    fontFamily: 'Ubuntu, sans-serif',
  },
  shape: {
    borderRadius: 12,
  },
});

export default theme;
