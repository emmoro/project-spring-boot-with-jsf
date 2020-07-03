// add event handler realization
var addEvent = (function () {
  if (document.addEventListener) {
    return function (el, type, fn) {
      if (el && el.nodeName || el === window) {
        el.addEventListener(type, fn, false);
      } else if (el && el.length) {
        for (var i = 0; i < el.length; i++) {
          addEvent(el[i], type, fn);
        }
      }
    };
  } else {
    return function (el, type, fn) {
      if (el && el.nodeName || el === window) {
        el.attachEvent('on' + type, function () { return fn.call(el, window.event); });
      } else if (el && el.length) {
        for (var i = 0; i < el.length; i++) {
          addEvent(el[i], type, fn);
        }
      }
    };
  }
})();

// variables
var aLoops = []; // sound loops

// initialization
addEvent(window, 'load', function (event) {

    // load music files
    aLoops[0] = new Audio('media/background.ogg');
    aLoops[0].volume = 0.3;
    aLoops[1] = new Audio('media/button.ogg');
    aLoops[1].volume = 1.0;
    aLoops[2] = new Audio('media/button_click.ogg');
    aLoops[2].volume = 1.0;

    aLoops[0].addEventListener('ended', function() { // loop background sound
        this.currentTime = 0;
        this.play();
    }, false);
    aLoops[0].play();
});

// all the buttons
var aBtns = document.querySelectorAll('#nav li');

// onmouseover event handler
addEvent(aBtns, 'mouseover', function (event) {
    aLoops[1].currentTime = 0;
    aLoops[1].play(); // play click sound
});

// onmouseout event handler
addEvent(aBtns, 'mouseout', function (event) {
    aLoops[1].currentTime = 0;
    aLoops[1].pause(); // play click sound
});

// onclick event handler
addEvent(aBtns, 'click', function (event) {
    aLoops[2].currentTime = 0;
    aLoops[2].play(); // play click sound
});

function PositionFooter() {
    var $footer = $("#footer"), footerHeight = $footer.height(),
    footerTop = ($(window).scrollTop() + $(window).height() - footerHeight) + "px";

    if (($(document.body).height() + footerHeight) < $(window).height()) {
        $footer.css({ position: "absolute", top: footerTop }); } 
    else { $footer.css({ position: "static" }); }

    $footer.fadeTo(1000, 1);
}

function GerenciarFooter() {
    $(window).resize(PositionFooter)
    PositionFooter();
}

$(document).ready(function () {
    GerenciarFooter();

    // Se descomentar quebra o Modal
    //Garante que a função será executada após um postback AJAX 
    //prm = Sys.WebForms.PageRequestManager.getInstance();
   // prm.add_endRequest(PositionFooter);
});