import React, { Component } from 'react';
import AddressDataService from '../service/AddressDataService';

class ListAddressesComponent extends Component {

    constructor(props) {
        super(props)
        this.state = {
            addresses: [],
            message: null
        }
    }

    componentDidMount() {
        console.log("abc");
        this.refreshAddresses();
    }

    refreshAddresses = () => {
        AddressDataService.retrieveAllAddresses()
            .then(
                response => {
                    console.log(response);
                    this.setState({ addresses: response.data })
                }
            )
    }

    render() {
        return (
            <div className="container">
                <h3>All Addresses</h3>
                <div className="container">
                    <table className="table">
                        <thead>
                            <tr>
                                <th>City</th>
                                <th>District</th>
                                <th>PlakaCode</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.addresses.map(
                                    address =>
                                        <tr key={address.addressId}>
                                            <td>{address.city}</td>
                                            <td>{address.district}</td>
                                            <td>{address.plakaCode}</td>
                                        </tr>
                                )
                            }
                        </tbody>
                    </table>
                    
                </div>
                <div className="row">
    <button className="btn btn-success" onClick={this.toAddAddressClicked}>Add</button>
</div>
            </div>
            
        )
    }
    toAddAddressClicked = () => {
        this.props.history.push(`/addresses/new`)
    }
}

export default ListAddressesComponent