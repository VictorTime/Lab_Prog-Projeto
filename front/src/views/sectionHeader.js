import React from 'react'

function sectionHeader(props) {
    return (
        /*Content Header (Page header)*/
        <section className="content-header">
          <div className="container-fluid">
            <div className="row mb-2">
              <div className="col-sm-6">
                <h1>{props.title}</h1>
              </div>
            </div>
          </div>
        </section>
    )
}

export default sectionHeader