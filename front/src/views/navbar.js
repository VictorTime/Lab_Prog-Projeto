import { render } from 'ejs'
import React from 'react'

function NavBar(props) {
  

    return (
          <nav className="main-header navbar navbar-expand navbar-white navbar-light">
            <ul className="navbar-nav">
              <a class="button" href="#/logout" >
            <div class="logout">LOGOUT</div>
            </a>
            </ul>
          </nav>
      )
  }

export default NavBar