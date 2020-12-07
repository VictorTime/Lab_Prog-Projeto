import React from 'react'


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
                              <button type="button" class="btn btn-tool" data-card-widget="collapse" data-toggle="tooltip" title="Collapse">
                                <i class="fas fa-minus"></i></button>
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