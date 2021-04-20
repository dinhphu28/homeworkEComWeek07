$(document).ready(function() {
    $.ajax({
        type: "GET",
        url: "https://ec18a002.herokuapp.com/rest/image/quantity",
        success: function(datas) {
            var quantity = datas
            for(let i = 0; i < quantity; i++) {
                $('.container').append(
                    `<div class="myslider fade">
                        <img class="animation-img" src="https://ec18a002.herokuapp.com/rest/image/${i}" style="width: 100%; height: 100%;" />
                    </div>`
                )
                $('.dotsbox').append(
                    `<span class="dot" onclick="currentSlide(${2+i})"></span>`
                )
            }
        }
    });
});

const myslide = document.getElementsByClassName('myslider');
const dot = document.getElementsByClassName('dot');

let counter = 1;
slidefun(counter);

let timer = setInterval("autoslide()", 8000);

function autoslide() {
    console.log("auto slide");
    counter += 1;
    slidefun(counter);
}

function plusSlide(n) {
    counter += n;
    slidefun(counter);
    resetTimer();
}

function currentSlide(n) {
    counter = n;
    slidefun(counter);
    resetTimer();
}

function resetTimer() {
    clearInterval(timer);
    timer = setInterval("autoslide()", 8000);
}

function slidefun(n) {
    let i;

    for(i = 0; i < myslide.length; i++){
        myslide[i].style.display = "none";
    }

    for(i = 0; i < dot.length; i++){
        dot[i].classList.remove('active');
    }

    if(n > myslide.length){
        counter = 1;
    }

    if(n < 1){
        counter = myslide.length;
    }

    myslide[counter - 1].style.display = "block";
    dot[counter - 1].classList.add('active');
}