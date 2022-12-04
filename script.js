fetch('https://csc174-project.herokuapp.com/createCustomer',{
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

        // let text = await res.text();
        // return text;

        let ret = await res.json();
        return JSON.parse(ret.data);

    } else {
        return `HTTP error: ${res.status}`;
    }
}

doRequest().then(data => {
    console.log(data);
});