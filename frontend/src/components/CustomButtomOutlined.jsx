import Button from '@mui/material/Button';
import PersonAddAlt1Icon from '@mui/icons-material/PersonAddAlt1';

export default function CustomButtomOutlined({variant, color, onClick, startIcon}) {
    return(
        <Button
            variant= {variant}
            color= {color}
            fullWidth
            startIcon= {startIcon}
            sx={{
                width: '45%',
                borderRadius: '12px',
                textTransform: 'none',
                fontWeight: '600',
                fontSize: '16px',
                padding: '10px 0',
                marginTop: '10px',
                '&:hover': {
                    backgroundColor: '#5C22A8'
                },
                color: '#8234E9',
                borderColor: '#8234E9',       
            }}
            onClick={onClick}
        >
            
            Sign Up
        </Button>
    );
}