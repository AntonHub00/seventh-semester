$(document).ready(function(){

    $('.btn-1').click(function(){
        // $(this).addClass('red');
        if(this.innerHTML == 'Hide')this.innerHTML = 'Show';
        else this.innerHTML = 'Hide';

        $(this).toggleClass('red');
        $('.parrafo').toggle();
        // $('.parrafo').toggleClass('red');
    });

});