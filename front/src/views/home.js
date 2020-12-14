import React from 'react'
import Navbar from '../views/navbar'
import Sidebar from '../views/sidebar'
import sectionContent from '../views/sectionContent'
import sectionHeader from '../views/sectionHeader'

import Usuario from './views/usuario'

class Home extends React.Component {
  render() {
        return (
            <div className="hold-transition sidebar-mini layout-fixed">
    
                <div className="wrapper">
                    <Navbar />
                    <Sidebar />
                    <div className="content-wrapper">
                        
                       <sectionHeader title="Investimentos"/>
                        <sectionContent>
                            <div className="card-body">
                            </div>    
                        </sectionContent>
                    </div>
                </div>
            </div>
        )
    }
}

export default Home