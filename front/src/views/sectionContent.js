import React from 'react'
import { Link } from 'react-router-dom'


function SectionContent(props){
        return (
            <section className="content">
            <div className="container-fluid">
                <div className="row">
                <div className="col-12">
                    <div className="card">
                        <div className="card-header">
                            <h3 className="card-title"></h3>
                        <div class="card-tools">
                            <Link to="/cadastroatividade">
                                <button type="button" class="btn btn-tool" data-card-widget="plus" data-toggle="tooltip" title="plus">
                                    <i><svg stroke="currentColor" fill="currentColor" stroke-width="0" viewBox="0 0 1024 1024" height="1em" width="1em" 
                                    xmlns="http://www.w3.org/2000/svg">
                                    <path d="M880 112H144c-17.7 0-32 14.3-32 32v736c0 17.7 14.3 32 32 32h736c17.7 0 32-14.3 32-32V144c0-17.7-14.3-32-32-32zM704 536c0 4.4-3.6 8-8 8H544v152c0 4.4-3.6 8-8 8h-48c-4.4 0-8-3.6-8-8V544H328c-4.4 0-8-3.6-8-8v-48c0-4.4 3.6-8 8-8h152V328c0-4.4 3.6-8 8-8h48c4.4 0 8 3.6 8 8v152h152c4.4 0 8 3.6 8 8v48z"></path></svg>
                                    </i>
                                </button>
                            </Link>
                              <button type="button" class="btn btn-tool" data-card-widget="remove" data-toggle="tooltip" title="Remove">
                                <i class="fas fa-times"></i></button>
                        </div>
                       </div>
                    </div>
                </div>      
                </div> 
            </div> 
            </section>
        )
}
export default SectionContent