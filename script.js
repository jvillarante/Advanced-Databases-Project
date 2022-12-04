const request = XMLHttpRequest();

request.addEventListener('readystatechange', () => {
    //console.log(request, request.readyState)
    if(request.readyState === 4) {
        console.log(request.responseText)
    }
});

let fName = document.getElementById('fname').value;

let submitButton = document.getElementById("submitButton");
submitButton.addEventListener("click", (fName)=>{
    request.open('GET', 'https://csc174-project.herokuapp.com/selectCustomer?customerID=' + fName);
    request.send();
});


request.open('POST', ' https://csc174-project.herokuapp.com/createCustomer');
request.send();

