loadClientList();

function loadClientList() {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            let clientDataList = JSON.parse(this.responseText);
            let clientList = ' < ul class="w3-ul w3-card-4"> ';

            clientDataList.reverse();

            for(let index = 0; index < clientDataList.length; index++) {
                clientList +=

                    ' <li class="w3-bar"> ' +

                    ' <button id= ' + clientDataList[index].id + ' onclick="editClient(this.id)" ' +
                    ' class="w3-bar-item w3-button w3-small w3-right">Edit</button> ' +

                    ' <button id=' + clientDataList[index].id + ' onclick="removeClient(this.id)" ' +
                    ' class="w3-bar-item w3-button w3-small w3-right">Remove</button> ' +


                    ' <img src="Images/client.png" class="w3-bar-item w3-circle w3-hide-small" style="width:85px"> ' +
                    ' <div class="w3-bar-item"> ' +
                    ' <span class="w3-large"> firstname: ' +  clientDataList[index].firstname  + ' </span><br> ' +
                    ' <span> lastname: ' +  clientDataList[index].lastname  + ' </span> <br>' +
                    ' <span> address: ' +  clientDataList[index].address  + ' </span> <br>' +
                    ' <span> number: ' +  clientDataList[index].number  + ' </span>' +
                    ' </div> ';
            }
            clientList += "</ul>";
            document.getElementById("clientData").innerHTML = clientList;
        }
    };
    xhttp.open("GET", "/RetailShop/api/account/list", true);
    xhttp.send();
}


var selectedRow = null

function onFormSubmit(e) {
    event.preventDefault();
    var formData = getClient();
    if (selectedRow == null){
        addClient(formData);
    }
    else{
        updateClient(formData);
    }
    resetForm();
}

//Retrieve the data
function getClient(accId) {

    let client = { "accId" : accId,
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

            document.getElementById("button").innerHTML = "Update Client";
        }
    };
    xhttp.open("POST", "/RetailShop/api/account/getClient", true);
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(JSON.stringify(client));

    // return formData;
};




//Insert the data
function addClient(data) {
    var table = document.getElementById("clientList").getElementsByTagName('tbody')[0];
    var newRow = table.insertRow(table.length);
    cell1 = newRow.insertCell(0);
    cell1.innerHTML = data.firstname;
    cell2 = newRow.insertCell(1);
    cell2.innerHTML = data.lastname;
    cell3 = newRow.insertCell(2);
    cell3.innerHTML = data.address;
    cell4 = newRow.insertCell(3);
    cell4.innerHTML = data.number;
    cell4 = newRow.insertCell(4);
    cell4.innerHTML = `<button onClick="onEdit(this)">Edit</button> 
                            <button onClick="onDelete(this)">Delete</button>`;

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("POST", "/RetailShop/api/account/add", true);
    xmlhttp.onreadystatechange = function() {
        if (xmlhttp.readyState > 3 && xmlhttp.status == 200) {
            loadClientList();
            resetForm();
        }
    };
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify(client));
}

//Edit the data
function editClient(clientId) {
    selectedRow = clientId.parentElement.parentElement;
    document.getElementById("firstname").value = selectedRow.cells[0].innerHTML;
    document.getElementById("lastname").value = selectedRow.cells[1].innerHTML;
    document.getElementById("address").value = selectedRow.cells[2].innerHTML;
    document.getElementById("number").value = selectedRow.cells[3].innerHTML;
}

function updateClient(formData) {
    selectedRow.cells[0].innerHTML = formData.firstname;
    selectedRow.cells[1].innerHTML = formData.lastname;
    selectedRow.cells[2].innerHTML = formData.address;
    selectedRow.cells[3].innerHTML = formData.number;

    var xmlhttp = new XMLHttpRequest();
    xmlhttp.open("PUT", "/RetailShop/api/account/update", true);
    xmlhttp.onreadystatechange = function() {
        if(xmlhttp.readyState > 3 && xmlhttp.status == 200) {
            loadClientList();
            resetForm();
            document.getElementById("button").innerHTML = "Edit";
        }
    };
    xmlhttp.setRequestHeader("Content-Type", "application/json");
    xmlhttp.send(JSON.stringify(order));
}

//Delete the data
function deleteClient(td) {
    if (confirm('Do you want to delete this record?')) {
        row = td.parentElement.parentElement;
        document.getElementById('clientList').deleteRow(row.rowIndex);
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
    document.getElementById("button").innerHTML = "Order Now";
    selectedRow = null;
}