import React, { Component } from 'react';
import ListAddressesComponent from './ListAddressesComponent';
import FirstPageComponent from './FirstPageComponent';
import NewAdressComponent from './NewAdressComponent';

import {
    BrowserRouter as Router,
    Switch,
    Route,
    Link
  } from "react-router-dom";

class AddressApp extends Component {
    render() {
        return (
            <Router>
                <>
                    <h2>Address Application</h2>
                    <Switch>
                        <Route path="/" exact component={FirstPageComponent} />
                        <Route path="/addresses" exact component={ListAddressesComponent} />
                        <Route path="/addresses/new" exact component={NewAdressComponent} />
                        
                    </Switch>
                </>
                
            </Router>

            
        )
    }
}

export default AddressApp