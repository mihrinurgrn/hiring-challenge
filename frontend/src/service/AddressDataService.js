import axios from 'axios'

const APP_API_URL = 'http://localhost:8080'
const ADDRESS_API_URL = `${APP_API_URL}/address`

class AddressDataService {

    retrieveAllAddresses() {
        return axios.get(`${ADDRESS_API_URL}`);
    }

    createNewAddress(address) {
        console.log(address);
        return axios.post(`${ADDRESS_API_URL}`, {
            city: address.city,
            district: address.district,
            plakaCode:address.plakaCode
        });
    }
}

export default new AddressDataService()