import { IconButton } from "@mui/material";
import axios from "axios";
import {useState} from "react";
import {useNavigate} from 'react-router-dom';

import ArrowBackIosNewRounded from "@mui/icons-material/ArrowBackIosRounded";
import SaveRoundedIcon from '@mui/icons-material/SaveRounded';
import DeleteRoundedIcon from "@mui/icons-material/DeleteRounded";

import * as React from 'react';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select from '@mui/material/Select';

const Anotacao = () => {
    return (
        <div style={{
            display: 'flex',
            justifyContent: 'center',
            alignItems: 'center',
            height: '100vh',
            width: '100vw',
            backgroundColor: 'primary',
            fontFamily: 'ubuntu'
        }}>
            <div
                style={{
                    position: 'fixed',
                    top: '24px',
                    alignSelf: 'center',
                    display:"flex"
                }}
            >
                <div>
                    <IconButton
                        sx={{
                        backgroundColor: '#8234E9',
                        width: '50px',
                        height: '50px',
                        '&:hover': {
                            backgroundColor: '#5C22A8'
                        },
                        color: '#fff',
                        borderRadius: '12px'
                        }}
                    >
                        <ArrowBackIosNewRounded />
                    </IconButton>
                </div>
                <div>
                    <h3
                    style={{
                        color: "#fff"

                    }}
                   >
                    Pagina Anotacoes</h3>
                </div>
                <div>
                    <IconButton
                        sx={{
                        backgroundColor: '#8234E9',
                        width: '50px',
                        height: '50px',
                        '&:hover': {
                            backgroundColor: '#5C22A8'
                        },
                        color: '#fff',
                        borderRadius: '12px'
                        }}
                    >
                        <SaveRoundedIcon />
                    </IconButton>

                    <IconButton
                        sx={{
                        backgroundColor: '#8234E9',
                        width: '50px',
                        height: '50px',
                        '&:hover': {
                            backgroundColor: '#5C22A8'
                        },
                        color: '#fff',
                        borderRadius: '12px'
                        }}
                    >
                        <DeleteRoundedIcon />
                    </IconButton>

                    <div>
                        <FormControl variant="filled" sx={{ m: 1, minWidth: 120,  color:'#fff'}}>
                            <InputLabel 
                            id="demo-simple-select-filled-label"
                                sx={{
                                    color:'#fff',
                                    '&.Mui-focused':{color: '#fff'}
                                }} 
                            >Age</InputLabel>
                            <Select
                                labelId="demo-simple-select-filled-label"
                                id="demo-simple-select-filled"
                                //value={age}
                                //onChange={handleChange}
                                sx= {{
                                    color: '#fff',
                                    background: '#8234E9',
                                    '&.Mui-Focused .MuiOutlineInpur-notchedOutline': {
                                        background: '#8234E960'
                                    }
                                }}
                            >
                            <MenuItem value=""
                                sx= {{
                                    color: '#fff'
                                }}
                            >
                                <em>None</em>
                            </MenuItem>
                            <MenuItem sx= {{color: '#fff'}}value={10}>Ten</MenuItem>
                            <MenuItem sx= {{color: '#fff'}}value={20}>Twenty</MenuItem>
                            <MenuItem sx= {{color: '#fff'}}value={30}>Thirty</MenuItem>
                            </Select>
                    </FormControl>
                    </div>
                </div>
            </div>

        </div>
    );
}

export default Anotacao;