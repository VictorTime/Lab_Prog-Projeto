
import React from 'react';
import 'admin-lte/dist/css/adminlte.min.css'
import 'admin-lte/plugins/fontawesome-free/css/all.min.css'

import Atividades from './views/atividades'


class App extends React.Component {

    render() {
       return(
            <div className= "hold-transition sidebar-mini layout-fixed">
                <div className= "wrapper">
                   <Atividades />
                </div>
            </div>
          
        )
    }
}


export default App;

