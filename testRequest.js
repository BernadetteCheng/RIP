detect()


async function detect() {
    
  const vision = require('@google-cloud/vision');
  const axios = require('axios');

  // Creates a client
  const client = new vision.ImageAnnotatorClient();


  // Performs text detection on the image file
  const [result] = await client.textDetection("./receipt3.jpg");
  const detections = result.textAnnotations;

  const IGNORE_PRICES = ["subtotal", "tax", "total", "tend", "due"]
  var pricesToIgnore = 0;

  var counter = 0;            // counts how many individual products were purchased
  var productCounter = 0;     // counts how many types of products were purchased
  var skipNext = true;       // skips the first description string, which is the entire string
  var productPrices = [];
  var productCategories = [];
  var breakdownArray = [];

  detections.forEach(text => {
    var content = text.description;
    if (!skipNext) {

      // if the reader detects a UPC code
      if (content.length == 12 && !isNaN(content.length)) {
        var upc = content;
        productCounter++;

        // Walmart only allows 5 API requests per second, so must stagger calls 0.200 seconds apart to avoid overloading the server
        setTimeout(function() {
          axios.get(`http://api.walmartlabs.com/v1/items?apiKey=kdbqt665b38j32mfjsgekzmz&upc=${upc}`)
          .then((response) => {
            // outputs the top level category of the product purchased, eg. "Personal Care" or "Cell Phone"
            var productCategory = response.data["items"][0].categoryPath.substring(0, response.data["items"][0].categoryPath.indexOf("/"));
            productCategories.push(productCategory)

            if (productCategories.length == productPrices.length) {
              breakdownArray = arrayMerger(productCategories, productPrices)
              console.log(breakdownArray)
              console.log("Products purchased: " + productCategories.length)
              console.log("Total Cost: " + totalCost.toFixed(2))

              // Done!
            }
          })
          .catch((error) => {
            productCategories.push("Miscellaneous")

            if (productCategories.length == productPrices.length) {
              breakdownArray = arrayMerger(productCategories, productPrices)
              console.log(breakdownArray)
              console.log("Products purchased: " + productCategories.length)
              console.log("Total Cost: $" + totalCost.toFixed(2))

              // Done!
            }
          })
        }, 200*productCounter);
      }

      // if the reader detects a price that should be avoided, eg. total, tax, subtotal, change
      else if (
        content.toLowerCase() == IGNORE_PRICES[0] ||
        content.toLowerCase() == IGNORE_PRICES[1] || 
        content.toLowerCase() == IGNORE_PRICES[2] || 
        content.toLowerCase() == IGNORE_PRICES[3] ||
        content.toLowerCase() == IGNORE_PRICES[4] 
        ) {
          console.log(content)
        pricesToIgnore++;
      }

      // if the reader detects a price (xx.xx or $xx.xx format)
      else {
        for (var i = 0; i < content.length; i++) {
          if (isNaN(content[i]) && content[i] != '.' && content[i] != '$') {
            break
          }
          if ((content[0] === '$' || !isNaN(content[0])) && content[i] === '.' && !isNaN(content[i + 1]) && !isNaN(content[i + 2]) && !content[i + 3]) {
            // console.log(content)
            var price = content;
            productPrices.push(Number(price.replace(/[^0-9.]/g, '')));
            counter++
          }
        }
      }

    } else {
      skipNext = false;
    }
  });

  // remove a number of prices equal to the number of irrelevant keywords found (total, subtotal, etc)
  for (var i = 0; i < pricesToIgnore; i++) {
    productPrices.pop();
  }

  var totalCost = 0;

  // sum the costs of items
  for (var i = 0; i < productPrices.length; i++) {
    totalCost += productPrices[i]
  }

  // add 13% HST
  totalCost = totalCost * 1.13

  console.log(productPrices)
  console.log("Total Cost: " + totalCost.toFixed(2))
  
}

function arrayMerger(categoryArray, priceArray) {
  var mergedArray = [];
  for (var i = 0; i < categoryArray.length; i++) {
    mergedArray.push([categoryArray[i], priceArray[i]])
  }
  return mergedArray;
}