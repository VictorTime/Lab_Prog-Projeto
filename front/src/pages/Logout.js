import React, { Component } from 'react'

export default class Logout extends Component {
    
    componentDidMount(){
        var store = require('store')
        store.clearAll()
        window.document.location='#/login' 
    }
    
    render() {
        return (
            <div>
                
            </div>
        )
    }
}
