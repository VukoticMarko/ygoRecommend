import axios from 'axios';
const url = "http://localhost:8080/api/archetypes/recommend";

const RecommendService = {
    recommend: async function (areq){
        const headers = {};
        headers['Content-Type'] = 'application/json';
        return axios(url, {
            method: 'POST',
            headers: headers,
            data: JSON.stringify(areq)
        }).then(response =>{
            console.log("LALA " + response.data);
            return response.data;
        })
        .catch(error =>{
            console.log(error.response);
        });
    },
};
export default RecommendService;