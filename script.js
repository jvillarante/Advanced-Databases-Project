const request = XMLHttpRequest();

request.addEventListener('readystatechange', () => {
    //console.log(request, request.readyState)
    if(request.readyState === 4) {
        console.log(request.responseText)
    }
});

request.open('GET', ' https://csc174-project.herokuapp.com/selectCustomer');
request.send();

request.open('POST', ' https://csc174-project.herokuapp.com/createCustomer');
request.send();
