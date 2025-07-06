import Button from '@mui/material/Button';

export default function CustomButtomOutlined({variant, color, type, onchange, startIcon, texto}) {
    return(
        <Button
            variant= {variant}
            color= {color}
            type= {type}
            fullWidth
            startIcon= {startIcon}
            
            sx={{
                width: '45%',
                backgroundColor: '#8234E9',
                borderRadius: '12px',
                textTransform: 'none',
                fontWeight: '600',
                fontSize: '16px',
                padding: '10px 0',
                marginTop: '10px',
                '&:hover': {
                    backgroundColor: '#5C22A8'
                }
            }}
        >
            {texto}
        </Button>
    );
}