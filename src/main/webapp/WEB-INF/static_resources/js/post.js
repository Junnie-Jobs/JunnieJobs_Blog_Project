var POST = (function(window) {


  function init() {

     $(".write").on("click", writeForm);

  }

  function writeform(){
    
  }

  return {
      "init" : init
    }


})(window);

$(document).ready(function() {
  POST.init();
}); 


 