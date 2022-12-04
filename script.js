/*fetch('https://csc174-project.herokuapp.com/createCustomer',{
    method: 'POST',
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({
        name: 'fName'
    })
}).then(res => {
    return res.json()
})
    .then(data => console.log(data))
    .catch(error => console.log('ERROR'))
 */

/*
async function doRequest() {

    let url = 'https://csc174-project.herokuapp.com/createCustomer';
    let fName = document.getElementById('fname').value;
    let data = JSON.stringify({'fname': fName});

    let res = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(data),
    });

    if (res.ok) {

        let text = await res.text();
        return text;

        //let ret = await res.json();
        //return JSON.parse(ret.data);

    } else {
        return `HTTP error: ${res.status}`;
    }
}

doRequest().then(data => {
    console.log(data);
});
*/

let form=document.getElementById('myForm')

form.addEventListener('submit', function(e){
    e.preventDefault()

    let fName=document.getElementById('fname').value

    fetch('https://csc174-project.herokuapp.com/createCustomer', {
        method: 'POST',
        body: JSON.stringify({
            firstName:fName,

        }),
        headers: {
            'Content-type': 'application/json; charset=UTF-8',
        }
    })
        .then(function(response){
            return response.json()})
        .then(function(data)
        {console.log(data)}).catch(error => console.error('Error:', error));

    getData();
});

async function getData() {
    const response = await fetch('https://csc174-project.herokuapp.com/tableCustomer');
    console.log(response);
    const data = await response.json();

    console.log(data);
    length = data.length;
    console.log(data);
    let temp = "";
    for(i = 0; i < length; i++)
    {
        temp += "<tr>";
        temp += "<td>" + data[i].customerID + "</td>";
        //temp += "<td>" + data[i].firstName + "</td>";
    }

    document.getElementById("data").innerHTML=temp;
}