loadClientList();

// function loadClientList() {
//     let xhttp = new XMLHttpRequest();
//     xhttp.onreadystatechange = function () {
//         if (this.readyState == 4 && this.status == 200) {
//             let clientDataList = JSON.parse(this.responseText);
//             let clientList = ' <ul class="w3-ul w3-card-4"> ';
//
//             clientDataList.reverse();
//
//             for(let index = 0; index < clientDataList.length; index++) {
//                 clientList +=
//
//                     ' <li class="w3-bar"> ' +
//
//                     ' <button id= ' + clientDataList[index].id + ' onclick="editClient(this.id)" ' +
//                     ' class="w3-bar-item w3-button w3-small w3-right">Edit</button> ' +
//
//                     ' <button id=' + clientDataList[index].id + ' onclick="removeClient(this.id)" ' +
//                     ' class="w3-bar-item w3-button w3-small w3-right">Remove</button> ' +
//
//
//                     ' <img src="image/client.jpg" class="w3-bar-item w3-circle w3-hide-small" style="width:85px"> ' +
//                     ' <div class="w3-bar-item"> ' +
//                     ' <span class="w3-large"> firstname: ' +  clientDataList[index].firstname  + ' </span><br> ' +
//                     ' <span> lastname: ' +  clientDataList[index].lastname  + ' </span> <br>' +
//                     ' <span> address: ' +  clientDataList[index].address  + ' </span> <br>' +
//                     ' <span> number: ' +  clientDataList[index].number  + ' </span>' +
//                     ' </div> ';
//             }
//             clientList += "</ul>";
//             document.getElementById("clientData").innerHTML = clientList;
//         }
//     };
//     xhttp.open("GET", "/RetailShop/api/account/list", true);
//     xhttp.send();
// }


var selectedRow = null

function onFormSubmit(e) {
    // event.preventDefault();
    // var formData = getClient();
    if (selectedRow == null){
        addClient();
    }
    else{
        // updateClient(formData);
    }
    resetForm();
}

//Retrieve the data
function getClient(accId) {

    let client = { "id" : accId,
    "firstname" : document.getElementById("firstname").value,
    "lastname" : document.getElementById("lastname").value,
    "address" : document.getElementById("address").value,
    "number" : document.getElementById("number").value}
    // var formData = {};
    // formData["loginId"] = loginId;
    // formData["firstname"] = document.getElementById("firstname").value;
    // formData["lastname"] = document.getElementById("lastname").value;
    // formData["address"] = document.getElementById("address").value;
    // formData["number"] = document.getElementById("number").value;

    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (xhttp.readyState>3 && xhttp.status==200) {
            let foundClient = JSON.parse(this.responseText);

            document.getElementById("accId").value = foundClient.accId;
            document.getElementById("firstname").value = foundClient.firstname;
            document.getElementById("lastname").value = foundClient.lastname;
            document.getElementById("address").value = foundClient.address;
            document.getElementById("number").value = foundClient.number;

            document.getElementById("btnSaveClient").innerHTML = "Update Client";
        }
    };
    xhttp.open("POST", "/RetailShop/api/account/getClient", true);
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(JSON.stringify(client));

    // return formData;
};

function addClient() {

    let client = {
        "firstname" : document.getElementById("firstname").value,
        "lastname" : document.getElementById("lastname").value,
        "address" : document.getElementById("address").value,
        "number" : document.getElementById("number").value}
    console.log(client);

var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "/RetailShop/api/account/add", true);
    // xmlhttp.onreadystatechange = function() {
    //     if (xmlhttp.readyState > 3 && xmlhttp.status == 200) {
    //         loadClientList();
    //         resetForm();
    //     }
    // };
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify(client));
}


//Edit the data
function editClient(accId) {
    selectedRow = accId.parentElement;
    document.getElementById("firstname").value = selectedRow.cells[0].innerHTML;
    document.getElementById("lastname").value = selectedRow.cells[1].innerHTML;
    document.getElementById("address").value = selectedRow.cells[2].innerHTML;
    document.getElementById("number").value = selectedRow.cells[3].innerHTML;
}

function updateClient() {
    let client = {  "id" : null,
        "firstname" : document.getElementById("firstname").value,
        "lastname" : document.getElementById("lastname").value,
        "address" : document.getElementById("address").value,
        "number" : document.getElementById("number").value}

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("PUT", "/RetailShop/api/account/update", true);
    xmlhttp.onreadystatechange = function() {
        if(xmlhttp.readyState > 3 && xmlhttp.status == 200) {
            loadClientList();
            resetForm();
            document.getElementById("btnSaveClient").innerHTML = "Edit";
        }
    };
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify(client));
}

//Delete the data
function removeClient(id) {
    if (confirm('Do you want to delete this record?')) {
        row = id.parentElement;
        document.getElementById('clientData').deleteRow(id);
        resetForm();
    }

    var xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", "/RetailShop/api/account/remove", true);
    xhttp.onreadystatechange = function() {
        if(xhttp.readyState > 3 && xhttp == 200) {
            loadClientList();
        }
    };
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(JSON.stringify(client));
}

//Reset the data
function resetForm() {
    document.getElementById("firstname").value = '';
    document.getElementById("lastname").value = '';
    document.getElementById("address").value = '';
    document.getElementById("number").value = '';
    document.getElementById("btnSaveClient").innerHTML = "Add Client";
    selectedRow = null;
}

function saveClient() {

    if(validateForm()) {
        if(document.getElementById("btnSaveClient").innerHTML === ' Add Client ') {
            addClient();
        }
        else {
            updateClient();
        }
    }
}

function validateForm()
{
    let pass = true;
    let firstname = document.getElementById("firstname").value;
    let lastname = document.getElementById("lastname").value;
    let address = document.getElementById("address").value;
    let number = document.getElementById("number").value;

    if (firstname == null || firstname === "", lastname == null || lastname === "", address == null || address === "", number == null || number === "")
    {
        alert("Could you PLEASE fill in all the fields?");
        pass = false;
    }

    return pass;
}

function clearInputFields() {
    document.getElementById("    ").value = "";
    document.getElementById("firstname").value = "";
    document.getElementById("lastname").value = "";
    document.getElementById("address").value = "";
    document.getElementById("number").value = "";
    document.getElementById("btnSaveClient").innerHTML = " Add Client ";
}
