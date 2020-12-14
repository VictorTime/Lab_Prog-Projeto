import React from 'react'

function Sidebar() {
    return (
        <aside className="main-sidebar sidebar-dark-primary elevation-4">
          <div className="sidebar">
            <nav className="mt-2">
              <ul className="nav nav-pills nav-sidebar flex-column" 
                  data-widget="treeview" 
                  role="menu" 
                  data-accordion="false">
                <li className="nav-item has-treeview">
                  <a href="#/Login" className="nav-link">
                    <i className="nav-icon fas fa-edit"></i>
                    <p>Login</p>
                  </a>
                </li>
                <li className="nav-item has-treeview">
                  <a href="#/curriculo" className="nav-link">
                    <i className="nav-icon fas fa-edit"></i>
                    <p>Curriculo</p>
                  </a>
                </li>
                <li className="nav-item has-treeview">
                  <a href="#/atividades" className="nav-link">
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