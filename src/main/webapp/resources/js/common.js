$(function() {
  /* tab */
  $(".main-tab-bx > .tab-btn > ul > li > button").click(function() {
    var tabTarget1 = $(this).attr("data-index");

    $(this).parent().siblings("li").removeClass("active");
    $(this).parent().addClass("active");

    $(this).closest(".main-tab-bx").children(".tab-content").children(".tab-content-inner").removeClass("open");
    $(this).closest(".main-tab-bx").children(".tab-content").children(".tab-content-inner.tab-" + tabTarget1).addClass("open");

    if(tabTarget1 == 1){
      $(this).closest(".main-tab-bx").addClass("first");
    } else {
      $(this).closest(".main-tab-bx").removeClass("first");
    }
  });
});
