import React from 'react'

function Sidebar() {
    return (
        <aside className="main-sidebar sidebar-dark-primary elevation-4">
          <a href="#" className="brand-link">
            <span 
              className="brand-text font-weight-light">
                  Usuario
            </span>
          </a>
          <div className="sidebar">
            <nav className="mt-2">
              <ul className="nav nav-pills nav-sidebar flex-column" 
                  data-widget="treeview" 
                  role="menu" 
                  data-accordion="false">
                <li className="nav-item has-treeview">
                  <a href="home.html" className="nav-link">
                    <i className="nav-icon fas fa-tachometer-alt"></i>
                    <p>Home</p>
                  </a>
                </li>
                <li className="nav-item has-treeview">
                  <a href="usuario.html" className="nav-link">
                    <i className="nav-icon fas fa-edit"></i>
                    <p>Usuarios</p>
                  </a>
                </li>
                <li className="nav-item has-treeview">
                  <a href="atividades.html" className="nav-link">
                    <i className="nav-icon fas fa-edit"></i>
                    <p>Atividades</p>
                  </a>
                </li>
              </ul>
            </nav>            
          </div>
        </aside>
    )
}
export default Sidebar