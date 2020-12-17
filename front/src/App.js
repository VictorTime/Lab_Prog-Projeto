
import React from 'react';
import 'admin-lte/dist/css/adminlte.min.css'
import 'admin-lte/plugins/fontawesome-free/css/all.min.css'

import NavBar from './views/navbar'
import SideBar from './views/sidebar'


import Rotas from './rotas'
import Sidebar from './views/sidebar';
/***/


class App extends React.Component {

    render() {
       return(
            <div className= "hold-transition sidebar-mini layout-fixed">
                <div className= "wrapper">
                   <Rotas/>
                   
             
                </div>
            </div>
          
        )
    }
}


export default App;

