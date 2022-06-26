import axios from 'axios';
const url = "http://localhost:8080/api/archetypes/recommend";

const RecommendService = {
    recommend: async function (client){
        const headers = {};
        headers['Content-Type'] = 'application/json';
        return axios(url, {
            method: 'POST',
            headers: headers,
            data: JSON.stringify(client)
        }).then(response =>{
            console.log(response.data)
            return response.data;
        })
        .catch(error =>{
            console.log(error.response);
        });
    },
};
export default RecommendService;