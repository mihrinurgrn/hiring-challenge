import React, { Component } from 'react'
import { Formik, Form, Field, ErrorMessage } from 'formik';
import AddressDataService from '../service/AddressDataService';

class NewAddressComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            city: '',
            district: ''
        }

        this.onSubmit = this.onSubmit.bind(this)
        this.validate = this.validate.bind(this)

    }



    validate(values) {
        let errors = {}
        if (!values.city || values.city.length<1) {
            errors.city = 'Enter a city'
            
        } 
        if (!values.district || values.district.length<1) {
            errors.district = 'Enter a district'
            
        }
        
        console.log(errors);
        return errors

    }

    onSubmit(values) {
        

        let address = {
            city: values.city,
            district: values.district
        }

        
        AddressDataService.createNewAddress(address)
            .then(() => this.props.history.push('/addresses'))
        

        console.log(values);
    }

    render() {

        let { city, district } = this.state

        return (
            <div>
                <h3>Add New Adress Form</h3>
                <div className="container">
                    <Formik
                        initialValues={{ city, district }}
                        onSubmit={this.onSubmit}
                        validateOnChange={false}
                        validateOnBlur={false}
                        validate={this.validate}
                        enableReinitialize={true}
                    >
                        {
                            (props) => (
                                <Form>


                                    <fieldset className="form-group">
                                        <label>City</label>
                                        <Field className="form-control" type="text" name="city" />
                                    </fieldset>
                                    <ErrorMessage name="city" component="div"
                                        className="alert alert-warning" />
                                    <fieldset className="form-group">
                                        <label>District</label>
                                        <Field className="form-control" type="text" name="district" />
                                    </fieldset>
                                    <ErrorMessage name="district" component="div"
                                    className="alert alert-warning" />
                                    <button className="btn btn-success" type="submit">Save</button>
                                </Form>
                            )
                        }
                    </Formik>

                </div>
            </div>
        )
    }
addAddressClicked() {
    this.props.history.push(`/addresses`)
}
}
export default NewAddressComponent