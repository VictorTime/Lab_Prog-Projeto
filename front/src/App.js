
import React from 'react';


import NavBar from './views/navbar'
import SideBar from './views/sidebar'


import Rotas from './rotas'
/***/


class App extends React.Component {

    render() {
       return(
            <div className= "hold-transition sidebar-mini layout-fixed">
                <div className= "wrapper">
                   <NavBar href="#" label="Home" />
                   <SideBar/>
                   <Rotas/>
                </div>
            </div>
          
        )
    }
}


export default App;

