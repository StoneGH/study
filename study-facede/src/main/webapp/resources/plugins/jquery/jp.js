(function ($) {
    $.fn.extend({
        "bold": function () {
            ///<summary>
            /// 加粗字体
            ///</summary>
            return this.css({fontWeight: "bold"});
        }
    });
})(jQuery);