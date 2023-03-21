let products = {
    data: [
        {
            productName: "Sectional Sofa",
            category: "Sofa",
            price: "3500",
            image: "image/sectional-sofa.jpg",
        },

        {
            productName: "Sofa Bed",
            category: "Sofa",
            price: "3500",
            image: "image/Sofa-bed.webp",
        },

        {
            productName: "Highback Sofa",
            category: "Sofa",
            price: "3500",
            image: "image/wooden-long-chair.jpg"

        },

        {
            productName: "2 & 3 Seat Fabric & Leather High Back Sofas",
            category: "Sofa",
            price: "3500",
            image: "image/highback.jpg",
        },

        {
            productName: "Haven high back sofas",
            category: "Sofa",
            price: "3500",
            image: "image/haven-high-back-sofas-07.jpg",
        },

        {
            productName: "Pompadour high back sofa casaleone",
            category: "Sofa",
            price: "3500",
            image: "image/pompadour-high-back-sofa-casaleone-amethyst1.jpg",
        },

        {
            productName: "Grey Sectional Sofa",
            category: "Sofa",
            price: "3500",
            image: "image/section.jpeg",
        },

        {
            productName: "Oversized sectional sofa with wide chaise reversible",
            category: "Sofa",
            price: "3500",
            image: "image/oversized sectional sofa.jpg",
        },

        {
            productName: "Modern convertible Sofa bed",
            category: "Sofa",
            price: "3500",
            image: "image/modern convertible sofa bed.jpg",
        },

    ],
};

for (let i of products.data) {
    //Create Card
    let card = document.createElement("div");
    //Card should have category and should stay hidden initially
    card.classList.add("card", i.category, "hide");
    //image div
    let imgContainer = document.createElement("div");
    imgContainer.classList.add("image-container");
    //img tag
    let image = document.createElement("img");
    image.setAttribute("src", i.image);
    imgContainer.appendChild(image);
    card.appendChild(imgContainer);
    //container
    let container = document.createElement("div");
    container.classList.add("container");
    //product name
    let name = document.createElement("h3");
    name.classList.add("product-name");
    name.innerText = i.productName.toUpperCase();
    container.appendChild(name);
    //price
    let price = document.createElement("h4");
    price.innerText = "SRD " + i.price;
    container.appendChild(price);

    card.appendChild(container);
    document.getElementById("products").appendChild(card);
}

//parameter passed from button (Parameter same as category)
function filterProduct(value) {
    //Button class code
    let buttons = document.querySelectorAll(".button-value");
    buttons.forEach((button) => {
        //check if value equals innerText
        if (value.toUpperCase() == button.innerText.toUpperCase()) {
            button.classList.add("active");
        } else {
            button.classList.remove("active");
        }
    });

    //select all cards
    let elements = document.querySelectorAll(".card");
    //loop through all cards
    elements.forEach((element) => {
        //display all cards on 'all' button click
        if (value == "all") {
            element.classList.remove("hide");
        } else {
            //Check if element contains category class
            if (element.classList.contains(value)) {
                //display element based on category
                element.classList.remove("hide");
            } else {
                //hide other elements
                element.classList.add("hide");
            }
        }
    });
}

//Search button click
document.getElementById("search").addEventListener("click", () => {
    //initializations
    let searchInput = document.getElementById("search-input").value;
    let elements = document.querySelectorAll(".product-name");
    let cards = document.querySelectorAll(".card");

    //loop through all elements
    elements.forEach((element, index) => {
        //check if text includes the search value
        if (element.innerText.includes(searchInput.toUpperCase())) {
            //display matching card
            cards[index].classList.remove("hide");
        } else {
            //hide others
            cards[index].classList.add("hide");
        }
    });
});

//Initially display all products
window.onload = () => {
    filterProduct("all");
};