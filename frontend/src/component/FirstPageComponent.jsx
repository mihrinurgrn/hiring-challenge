import React, { Component } from 'react';
class FirstPageComponent extends Component {

    constructor(props) {
        super(props)
        this.addAddressClicked = this.addAddressClicked.bind(this)
    }

render() {
    return (
        <div className="container">
            <h3>My Hiring Project</h3>
            <div className="container">
                
                
            </div>
            <div className="row">
<button className="btn btn-success" onClick={this.addAddressClicked}>Add New Address</button>
</div>
        </div>
        
    )
}
addAddressClicked() {
    this.props.history.push(`/addresses`)
}
}
export default FirstPageComponent