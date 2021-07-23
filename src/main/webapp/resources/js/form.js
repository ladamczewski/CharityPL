const bagsQuant = document.querySelector('#quantity');
const institution = document.querySelector('#institution').children[document.querySelector('#institution').value].innerHTML;
const categories = document.querySelectorAll('.categories')
let catString = "";
const street = document.querySelector('#street');
const city = document.querySelector('#city');
const zipCode = document.querySelector('#zipCode');
const pickUpDate = document.querySelector('#pickUpDate');
const pickUpTime = document.querySelector('#pickUpTime');
const pickUpComment = document.querySelector('#pickUpComment');
const catSum = document.querySelector('#catSum');
const instSum = document.querySelector('#instSum');
const streetSum = document.querySelector('#streetSum');
const citySum = document.querySelector('#citySum');
const zipSum = document.querySelector('#zipSum');
const phoneSum = document.querySelector('#phoneSum');
const dateSum = document.querySelector('#dateSum');
const timeSum = document.querySelector('#timeSum');
const comSum = document.querySelector('#comSum');



document.addEventListener("DOMContentLoaded", function() {

    document.querySelector(".btnSum").addEventListener('click', ()=>{
      catString += "Oddajesz " + bagsQuant.value + " worków z kategorii: "
      categories.forEach(category=>{
        if(category.checked === true){
          catString += category.nextElementSibling.innerHTML + " "
        }
      })
      catSum.innerHTML = catString;
      instSum.innerHTML = institution;
      streetSum.innerHTML = street.value;
      citySum.innerHTML = city.value;
      zipSum.innerHTML=zipCode.value;
      dateSum.innerHTML=pickUpDate.value;
      timeSum.innerHTML=pickUpTime.value;
      comSum.innerHTML=pickUpComment.value;
    })
})