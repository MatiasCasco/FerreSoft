import Head from 'next/head';
import { DashboardLayout } from '../components/dashboard-layout';
import 'bootstrap/dist/css/bootstrap.min.css';
import DataTable from 'react-data-table-component';
import { products } from '../__mocks__/products';
import {
  Box,
  Button,
  Card,
  CardContent,
  TextField,
  InputAdornment,
  SvgIcon,
  Typography
} from '@mui/material';
import { Search as SearchIcon } from '../icons/search';
import { Component } from 'react';

const columnas=[
  {
    name:"id",
    selector:"id",
    sortable: true
  },
  {
    name:"createdAt",
    selector:"createdAt",
    sortable: true
  },
  {
    name:"description",
    selector:"description",
    sortable: true
  },
  {
    name:"title",
    selector:"title",
    sortable: true
  },
  {
    name:"total",
    selector:" totalDownloads",
    sortable: true
    
  }


];



const paginacionOpciones={
  rowsPerPageText:'Filas por pagina',
  rowsPerPageLength:3,
  rangeSeparatorText:'de',
  selectAllRowsItem:true,
  selectAllRowsItemText:'Todos'
  

}
class Productsdt extends Component{
  state={
      busqueda:'',
      productos:[]
  }
  onChange=async e=>{
    e.persist();
    await this.setState({busqueda: e.target.value});
    console.log(this.state.busqueda);
    this.filtrarElementos();
  }

  filtrarElementos=()=>{
    var search=products.filter(item=>{
      if(item.createdAt.toString().includes(this.state.busqueda)
      || item.title.toLowerCase().normalize('NFD').replace(/[\u0300-\u036f]/g,"").includes(this.state.busqueda.toLowerCase() )
      ){
        return item;
      }
    });
    this.setState({productos: search});
  }

  componentDidMount(){
    this.setState({productos: products });
  }


  render(){
    return(
      <>
        <Head>
          <title>
            Products | Material Kit
          </title>
        </Head>
        <div className='table-responsive'>
          <div className='barraBusqueda'>
            <input
              type="text"
              placeholder='Buscar'
              className='textfield'
              name='busqueda'
              value={this.state.busqueda}
              onChange={this.onChange}
            />
            <button type="button" className="btnBuscar"/*onclic={onClear}*/ >
              {" "}
              <SvgIcon fontSize="small" color="action">
                <SearchIcon />
              </SvgIcon>
            </button>
          </div>
          <DataTable
          columns={columnas}
          data={this.state.productos}
          title="tabla de productos"
          pagination
          paginationComponentOptions={paginacionOpciones}
          fixedHeader
          fixedHeaderScrollHeight='600px'
          noDataComponent={<span>No se encontro ningún elemento </span>  }

          />
        </div>
    
      </> 
    );
  }

}



Productsdt.getLayout = (page) => (
  <DashboardLayout>
    {page}
  </DashboardLayout>
);

export default Productsdt;
