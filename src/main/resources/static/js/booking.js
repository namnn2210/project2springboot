$(document).ready(function () {
    $(".quantity").val("0");
   $(".icon-plus-standard").click(function () {
       // tang gia o hoa don
       var price = $(".price").text();
       var price_float = parseFloat(price) + 65;
       $(".price").text(price_float+",000.00");
       // tang them 1 o text
       var quantity = $(".quantity").val();
       var quantity_int = parseInt(quantity);
       do {
           quantity_int++;
           $(".quantity-standard").val(quantity_int);
       }
       while(quantity_int > 4)
       console.log(quantity);
   });

    $(".icon-minus-standard").click(function () {
        var price = $(".price").text();
        var price_float = parseFloat(price) - 65;
        if(price_float < 0) {
            $(".price").text("0.00");
        }
        else {
            $(".price").text(price_float+",000.00");
        }
    })
});