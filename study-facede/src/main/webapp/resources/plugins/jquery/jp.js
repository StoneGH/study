(function ($) {
    $.fn.alert = function(){
        alert(2);
        return $(this);
    };
})(jQuery);