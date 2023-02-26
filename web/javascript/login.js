
function validate() {

    const form = document.getElementById('form').value;
    const PhoneNumber = document.getElementById('number').value;
    const password = document.getElementById('password').value;

    if(PhoneNumber == "8888997" && password == "admin"){

        alert("Login successful");
        window.location = "home.html";
    }

    else{
        alert("Login failed");
    }

}



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

// const validateInputs = () => {
//     const PhoneNumberValue = PhoneNumber.value.trim();
//     const passwordValue = password.value.trim();

//     if(PhoneNumberValue === '') {
//         setError(PhoneNumber, 'Phone Number is required');
//     } else {
//         setSuccess(PhoneNumber);
//     }

//     if(passwordValue === '') {
//         setError(password, 'Password is required');
//     } else {
//         setSuccess(password);
//     }

//     document.getElementById('button').addEventListener('click', clickButton)
// };

// function clickButton() {
//     alert('login succesful')

// }



