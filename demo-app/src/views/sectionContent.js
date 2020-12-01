import React from 'react'
class sectionContent extends React.Component {
    render () {
        return (
            <section className="content">
            <div className="container-fluid">
                <div className="row">
                <div className="col-12">
                    /* Default box */
                    <div className="card">
                        <div className="card-header">
                            <h3 className="card-title">{this.props.title}</h3>
                        </div> 
                        {this.props.children}
                    </div>
                </div>
                </div>      
            </div>  
            </section>
        )
    }
}
export default sectionContent