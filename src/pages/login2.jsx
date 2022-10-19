import React,{ useState } from 'react'
import { useRouter } from 'next/router';
import { Button } from "@material-ui/core";
import { makeStyles } from "@material-ui/core/styles"

const useStyle=makeStyles(
    {
        botonp:{
            background: "linear-gradient(45deg, #FE6B8B 30%, #FF8E53 90%)",
            border: 0,
            borderRadius: 3,
            boxShadow: "0 3px 5px 2px rgba(255, 105, 135, .3)",
            color: "white",
            height: 48,
            padding: "0 30px",
        },
    }
    );
const Login = () => {
    const router = useRouter();
    const [miLogin,setMiLogin]= useState("false");
    const [usu,setUsu]= useState("");
    const [pas,setPass]= useState("");
    const classes=useStyle();
    function iniciarSesion(e){
        
        e.preventDefault();
        var txtusu= document.getElementById("txtusu").value;
        var txtpass= document.getElementById("txtpass").value;
        if(txtusu.length===0 || txtpass.length===0)
        {
            alert("Complete los datos Faltantes!!");
        }else{
            if(txtusu==="admin" && txtpass=== "123"){
                setMiLogin("true");
                document.getElementById("form_login").style.display="none";
                //router.push('/');
            }else{
                setMiLogin("false");
                alert("Error de contraseña o usuario!!");
                document.getElementById("txtusu").value="";
                document.getElementById("txtpass").value="";
                document.getElementById("txtusu").focus();
            }
        }
    }

  return (
    <div className='container' style={{background:"lightgrey",marginTop:20,padding:20, textaling:"center"}}>
        <form id='form_login'>
        <div>
            <h1 style={{color:"blue",textaling:"center"}}>Login</h1>
            <label htmlFor="txtusu"><strong>Username</strong> </label>

            <input type="text" id="txtusu" style={{textaling:"center"}} classname="form-control" onChange={(e)=>setUsu(e.target.value)} required />
        
        
        </div>      
        <div>
            <label htmlFor="txtpas"><strong>Password</strong> </label>
            <input type="password" id="txtpass" style={{textaling:"center"}} classname="form-control" onChange={(e)=>setPass(e.target.value)} required />
        </div><br/>
        <input type="submit"  className={classes.botonp} value="login" onClick={iniciarSesion} />
        </form>
        {miLogin==="true" && router.push('/') }
    </div>
  )
};
export default Login;