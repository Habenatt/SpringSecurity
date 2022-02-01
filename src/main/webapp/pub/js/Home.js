function addRow() {
          
          
    var userName = document.getElementById("userName");
    var Pass = document.getElementById("Pass");
    var Quantity = document.getElementById("qan");          
    var LicenceNo = document.getElementById("lic");    

    if(userName.value=="" || Pass.value==""){
        alert('Please provide a valid User Name & Password!');
        myName.focus;
        return false;
    } 
    else{
        alert ("Login successfully");
         window.location.replace("file:///D:/haben%20Documents/PER%20SCHOLAS/CLASSES/week11/SBA/WEB_SBA/views/Drivers.html"); // Redirecting to other page.
     

    }
    

   
   
    
}

var textWrapper = document.getElementById('.ml2');
textWrapper.innerHTML = textWrapper.textContent.replace(/\S/g, "<span class='letter'>$&</span>");

anime.timeline({loop: true})
  .add({
    targets: '.ml2 .letter',
    scale: [4,1],
    opacity: [0,1],
    translateZ: 0,
    easing: "easeOutExpo",
    duration: 950,
    delay: (el, i) => 70*i
  }).add({
    targets: '.ml2',
    opacity: 0,
    duration: 1000,
    easing: "easeOutExpo",
    delay: 1000
  });
// Wrap every letter in a span
var textWrapper = document.querySelector('.ml3');
textWrapper.innerHTML = textWrapper.textContent.replace(/\S/g, "<span class='letter'>$&</span>");

anime.timeline({loop: true})
  .add({
    targets: '.ml3 .letter',
    opacity: [0,1],
    easing: "easeInOutQuad",
    duration: 2250,
    delay: (el, i) => 150 * (i+1)
  }).add({
    targets: '.ml3',
    opacity: 0,
    duration: 1000,
    easing: "easeOutExpo",
    delay: 1000
  });

  
