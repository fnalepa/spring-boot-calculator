var Calculator = (function(){
    var initSlider = function(id){
        $("#" + id + "-slider").slider();
        $("#" + id + "-slider").on("slide", function(ev){
            $("#" + id).val(ev.value);
        });
    };
    var updateLoanInfo = function(){
        var data = $("#loan-calculator-form").serialize();
        setTimeout(function(){
            if(data === $("#loan-calculator-form").serialize()){
                $("#loan-calculator-form").find(":submit").click();
            }
        }, 500);               
    };
    var onFormSubmit = function(e){
        e.preventDefault();
        var form = $("#loan-calculator-form");
        $.ajax(form.attr("action"), {
            data: form.serialize(),
            dataType: "json",
            error: function(){
                alert("Došlo k chybě.");
            },
            success: function(data){
                $(".monthly-payment").text(data.monthlyPayment);
                $(".interest-rate").text(data.interestRate);
                $(".apr").text(data.apr);
                $(".insurance").text(data.insurance);
                $(".total-amount").text(data.totalAmount);
            }
        });        
    };
    return {
        init: function(){
            initSlider("amount");
            initSlider("term");
            $("#loan-calculator-form").submit(onFormSubmit);
            $("#loan-calculator-form input").change(updateLoanInfo);            
        }
    };
})();