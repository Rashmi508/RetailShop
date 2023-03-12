loadOrderList();

function loadOrderList() {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let orderDataList = JSON.parse(this.responseText);
            let orderList = ' <ul class="w3-ul w3-card-4"> ';

            orderDataList.reverse();

            for (let index = 0; index < orderDataList.lenght; index++) {
                orderList +=
                    ' <li class="w3-bar"> ' +

                    ' <button id= ' + orderDataList[index].id + ' onclick="editOrder(this.id)" ' +
                    ' class="w3-bar-item w3-button s3-small w3-right"> Edit </button> ' +

                    ' <button id=' + orderDataList[index].id + ' onclick="removeOrder(this.id)" ' +
                    ' class="w3-bar-item w3-button w3-small w3-right"> Remove </button> ' +

                    ' <img src="" class="w3-bar-item w3-circle w3-hide-small" style="width:85px"> ' +
                    ' <div class="w3-bar-item"> ' +
                    ' <span class="w3-large"> first Name: ' + orderDataList[index].firstname + ' </span> <br> ' +
                    ' <span> Last Name: ' + orderDataList[index].lastname + ' </span> <br>' +
                    ' <span> Address: ' + orderDataList[index].address + ' </span> <br>' +
                    ' <span> PhoneNumber: ' + orderDataList[index].number + ' </span> <br>' +
                    ' <div> ';
            }
            orderList += "</ul>";
            document.getElementById("orderData").innerHTML = orderList;
        }
    };
    xhttp.open("GET", "/foodDeliveryApp/api/order/list", true);
    xhttp.send();
}

function addOrder() {
    let order = {
        "id" : null,
        "firstName" : document.getElementById("firstname").value,
        "lastName" : document.getElementById("lastname").value,
        "address" : document.getElementById("address").value,
        "number" : document.getElementById("number").value
    }
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "/foodDeliveryApp/api/order/list/add", true);
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState > 3 && xmlhttp.status == 200) {
            loadOrderList();
            clearInputFields();
        }
    };
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify(order));
}

function updateOrder() {
    let order = {
        "id" : document.getElementById("orderId").value,
        "firstname" : document.getElementById("firstname").value,
        "lastname" : document.getElementById("lastname").value,
        "address" : document.getElementById("address").value,
        "number" : document.getElementById("number").value
    }
    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("PUT", "/foodDeliveryApp/api/order/list/update", true);
    xmlhttp.onreadystatechange = function() {
        if(xmlhttp.readyState > 3 && xmlhttp.status == 200) {
            loadOrderList();
            clearInputFields();
            document.getElementById("button").innerHTML = "Order Now";
        }
    };
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify(order));
}

function clearInputFields() {
    document.getElementById("orderId").value = "";
    document.getElementById("firstname").value = "";
    document.getElementById("lastname").value = "";
    document.getElementById("address").value = "";
    document.getElementById("number").value = "";
    document.getElementById("button").innerHTML = "Order Now";
}

function removeOrder(orderId) {
    if( confirm("Do you really want to delete this order?")) {
        deleteOrder(orderId);
    }
}

function deleteOrder(orderId) {
    let order = {
        "id" : orderId,
        "firstname" : document.getElementById("firstname").value,
        "lastname" : document.getElementById("lastname").value,
        "address" : document.getElementById("address").value,
        "number" : document.getElementById("number").value
    }
    var xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "/foodDeliveryApp/api/order/list/remove", true);
    xhttp.onreadystatechange = function() {
        if(xhttp.readyState > 3 && xhttp == 200) {
            loadOrderList();
        }
    };
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(JSON.stringify(order));
}

function getOrder(orderId) {
    let order = {
        "id" : orderId,
        "firstname" : document.getElementById("firstname").value,
        "lastname" : document.getElementById("lastname").value,
        "address" : document.getElementById("address").value,
        "number" : document.getElementById("number").value
    }

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState>3 && xhttp.status==200) {
            let foundOrder = JSON.parse(this.responseText);

            document.getElementById("orderId").value = foundOrder.id;
            document.getElementById("firstname").value = foundOrder.firstname;
            document.getElementById("lastname").value = foundOrder.lastname;
            document.getElementById("address").value = foundOrder.address;
            document.getElementById("number").value = foundOrder.number;

            document.getElementById("button").innerHTML = "Update Order";
        }
    };
    xhttp.open("POST", "/foodDeliveryApp/api/order/getOrder", true);
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(JSON.stringify(order));
}

function editOrder(orderId) {
    getOrder(orderId);
}

function saveOrder() {

    if(validateForm()) {
        if(document.getElementById("button").innerHTML == 'Order Now'){
            addOrder();
        }
        else{
            updateOrder();
        }

    }
}

function validateForm() {
    let pass = true;
    let firstName = document.getElementById("firstname").value;
    let lastName = document.getElementById("lastname").value;
    let address = document.getElementById("address").value;
    let number = document.getElementById("number").value;

    if (firstName == null || firstName == "",
    lastName == null || lastName == "",
    address == null || address == "",
    number == null || number == "") {
        alert("Please fill in all the fields.");
        pass = false;
    }

    return pass;

}













































// const form = document.getElementById('form');
// const firstname = document.getElementById('firstname');
// const lastname = document.getElementById('lastname');
// const address = document.getElementById('address');
// const PhoneNumber = document.getElementById('number');

// form.addEventListener('submit', e => {
//     e.preventDefault();

//     validateInputs();
// });

// const setError = (element, message) => {
//     const inputControl = element.parentElement;
//     const errorDisplay = inputControl.querySelector('.error');

//     errorDisplay.innerText = message;
//     inputControl.classList.add('error');
//     inputControl.classList.remove('success')
// }

// const setSuccess = element => {
//     const inputControl = element.parentElement;
//     const errorDisplay = inputControl.querySelector('.error');

//     errorDisplay.innerText = '';
//     inputControl.classList.add('success');
//     inputControl.classList.remove('error');
// };

// const isValidEmail = email => {
//     const re = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
//     return re.test(String(email).toLowerCase());
// }

// const validateInputs = () => {
//     const firstnameValue = firstname.value.trim();
//     const lastnameValue = lastname.value.trim();
//     const addressValue = address.value.trim();
//     const PhoneNumberValue = PhoneNumber.value.trim();

//     if(firstnameValue === '') {
//         setError(firstname, 'Firstname is required');
//     } else {
//         setSuccess(firstname);
//     }

//     if(lastnameValue === '') {
//         setError(lastname, 'Lastname is required');
//     } else {
//         setSuccess(lastname);
//     }

//     if(addressValue === '') {
//         setError(address, 'Address is required');
//     } else {
//         setSuccess(address);
//     }

//     if(PhoneNumberValue === '') {
//         setError(PhoneNumber, 'Phone Number is required');
//     } else {
//         setSuccess(PhoneNumber);
//     }

//     document.getElementById('button').addEventListener('click', clickButton)
// };

// function clickButton() {
//     alert('your order has been placed')

// }