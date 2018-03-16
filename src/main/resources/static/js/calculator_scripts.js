var Calculator = (function(){
    var previousSubmitData = null;
    var initSlider = function(id){
        var slider = $("#" + id + "-slider").slider();
        $("#" + id + "-slider").on("slide", function(ev){
            $("#" + id).val(ev.value);
        });
        $("#" + id).change(function(){
            slider.slider("setValue", $(this).val());
        });
    };
    var updateLoanInfo = function(){
        var data = $("#loan-calculator-form").serialize();
        if(previousSubmitData !== data){
            setTimeout(function(){
                if(data === $("#loan-calculator-form").serialize()){
                    $("#loan-calculator-form").find(":submit").click();
                }
            }, 200);               
        }
    };
    var onTermChange = function(){
        $(".term-years").text(parseFloat($("#term").val()/12).toLocaleString());
    };
    var onFormSubmit = function(e){
        e.preventDefault();
        var form = $("#loan-calculator-form");
        var data = form.serialize();
        $.ajax(form.attr("action"), {
            data: data,
            dataType: "json",
            error: function(){
                alert("Došlo k chybě.");
            },
            success: function(data){
                if(typeof data.monthlyPayment == "undefined" || typeof data.interestRate == "undefined" || typeof data.apr == "undefined" || typeof data.insurance == "undefined" || typeof data.totalAmount == "undefined"){
                    alert("Nepodařilo se nám zjistit údaje úvěru dle zadaných parametrů.");
                    return;
                }
                $(".monthly-payment").text(data.monthlyPayment.toLocaleString());
                $(".interest-rate").text(data.interestRate.toLocaleString());
                $(".apr").text(data.apr.toLocaleString());
                $(".insurance").text(data.insurance.toLocaleString());
                $(".total-amount").text(data.totalAmount.toLocaleString());
                previousSubmitData = data;
            }
        });        
    };
    return {
        init: function(){
            initSlider("amount");
            initSlider("term");
            $("#loan-calculator-form").submit(onFormSubmit);
            $("#loan-calculator-form input").change(updateLoanInfo); 
            $("#loan-calculator-form input[type='number']").click(updateLoanInfo);
            $("#term, #term-slider").change(onTermChange);
            updateLoanInfo();
        }
    };
})();