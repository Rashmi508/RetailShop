let searchForm = document.querySelector('.search-form');
// let cartIcon = document.querySelector('#cart-icon')

// cartIcon.onclick = () => {
//     cart.classList.add('active')
// };

document.querySelector('#search-btn').onclick = () =>{
    searchForm.classList.toggle('active');
    // shoppingCart.classList.remove('active');
    loginForm.classList.remove('active');
    navbar.classList.remove('active');
}

// let searchBar = document.getElementById('search-box')

// console.log(searchBar)
// searchBar.addEventListener('keyup', (e) => {
//     console.log(e.target.value)
// })

let loginForm = document.querySelector('.login-form');

document.querySelector('#login-btn').onclick = () =>{
    loginForm.classList.toggle('active');
    searchForm.classList.remove('active');
    // shoppingCart.classList.remove('active');
    navbar.classList.remove('active');
}

document.querySelector('#button').onclick = () => {
    alert("logged in");
}


let navbar = document.querySelector('.navbar');

document.querySelector('#menu-btn').onclick = () =>{
    navbar.classList.toggle('active');
    searchForm.classList.remove('active');
    // shoppingCart.classList.remove('active');
    loginForm.classList.remove('active');
}

window.onscroll = () =>{
    searchForm.classList.remove('active');
    // shoppingCart.classList.remove('active');
    loginForm.classList.remove('active');
    navbar.classList.remove('active');
}

// let cartIcon = document.querySelector('#cart-icon')
// let cart = document.querySelector('.cart')
// let closeCart = document.querySelector('#close-cart')

// cartIcon.onclick = () => {
//     cart.classList.add('active')
// };

// closeCart.onclick = () => {
//     cart.classList.remove('active')
// };

// if (document.readyState == 'loading') {
//     document.addEventListener('DOMContentLoaded', ready)
// } else {
//     ready()
// }


// function ready() {
//     var removeCartButtons = document.getElementsByClassName('cart-remove')
//     console.log(removeCartButtons)
//     for (var i = 0; i < removeCartButtons.length; i++) {
//         var button = removeCartButtons[i]
//         button.addEventListener('click', removeCartItem)
//     }

//     var quantityInputs = document.getElementsByClassName('cart-quantity')
//     for(var i = 0; i < quantityInputs.length; i++) {
//         var input = quantityInputs[i]
//         input.addEventListener('change', quantityChanged)
//     }

//     var addCart = document.getElementsByClassName('add-cart')
//     for(var i = 0; i < addCart.length; i++) {
//         var button = addCart[i]
//         button.addEventListener('click', addCartClicked)
//     }

//     document.getElementsByClassName('btn-buy')[0].addEventListener('click', buyButtonClicked)
// }

// function buyButtonClicked() {
//     alert('Your order is placed')
//     var cartContent = document.getElementsByClassName('cart-content')[0]
//     while(cartContent.hasChildNodes()) {
//         cartContent.removeChild(cartContent.firstChild)
//     }
//     updateTotal()
// }


// function removeCartItem(event) {
//     var buttonClicked = event.target
//     buttonClicked.parentElement.remove()
//     updateTotal()
// }

// function quantityChanged(event) {
//     var input = event.target
//     if (isNaN(input.value) || input.value <= 0) {
//         input.value = 1
//     }

//     updateTotal()

// }

// function addCartClicked(event) {
//     var button = event.target
//     var shopProducts = button.parentElement
//     var title = shopProducts.getElementsByClassName('product-title')[0].innerText
//     var price = shopProducts.getElementsByClassName('price')[0].innerText
//     var productImage = shopProducts.getElementsByClassName('product-image')[0].src
//     addProductToCart(title, price, productImage)
//     updateTotal()
// }

// function addProductToCart(title, price, productImage) {
//     var cartShopBox = document.createElement('div')
//     cartShopBox.classList.add('cart-box')
//     var cartItems = document.getElementsByClassName('cart-content')[0]
//     var cartItemsNames = cartItems.getElementsByClassName('cart-product-title')
//     for(var i = 0; i < cartItemsNames.length; i++) {
//         if(cartItemsNames[i].innerText == title) {
//              alert('You have already add this item to cart')
//              return
//         }
//     }


// var cartBoxContent = `
//                         <img src="${productImage}" alt="" class="cart-img">
//                             <div class="detail-box">
//                                 <div class="cart-product-title">${title}</div>
//                                     <div class="cart-price">${price}</div>
//                                         <input type="number" value="1" class="cart-quantity">
//                         </div>

//                         <i class='bx bxs-trash-alt cart-remove'></i> `

// cartShopBox.innerHTML = cartBoxContent
// cartItems.append(cartShopBox)
// cartShopBox.getElementsByClassName('cart-remove')[0].addEventListener('click', removeCartItem)
// cartShopBox.getElementsByClassName('cart-quantity')[0].addEventListener('change', quantityChanged)

// }

// function updateTotal() {
//     var cartContent = document.getElementsByClassName('cart-content')[0]
//     var cartBoxes = cartContent.getElementsByClassName('cart-box')
//     var total = 0;
//     for(var i = 0; i < cartBoxes.length; i++) {
//         var cartBox = cartBoxes[i]
//         var priceElement = cartBox.getElementsByClassName('cart-price')[0]
//         var quantityElement = cartBox.getElementsByClassName('cart-quantity')[0]
//         var price = parseFloat(priceElement.innerText.replace("SRD ", ""))
//         var quantity = quantityElement.value
//         total = total + (price * quantity)
//     }
//         total = Math.round(total * 100) / 100

//         document.getElementsByClassName('total-price')[0].innerText = "SRD " + total

// }


