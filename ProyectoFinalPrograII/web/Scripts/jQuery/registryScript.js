$(document).ready(function(){
    $('#myform').validate({
        
            rules:{
                name: "required",
                age:{
                    required:true,
                    min: 18
                    
                }
            },
        
            messages:{
                name:" name is required for this form",
                age: {
                    required: "age is required for this form",
                    min: "age must be greater than 18"
                }
            }
        });
        
        $('#meal').blur(function(){
            var option = $(this).val();
            calculatePrice(option);
           
           
        });
        
         $('#meal').click(function(){
            var option = $(this).val();
            calculatePrice(option);
           
           
        });
    
});

function calculatePrice(pOption){
     var price = 0.0;
           if(pOption ==='pasta'){
               price = 7.5;
            }
           
           else if (pOption ==='chicken'){
               price = 8;
           }
           
            else if(pOption ==='fish'){
              price = 10.5;
           }
           $('#price').html("<label>Price: $"+price+"</label>");
           $('#priceval').val(price); //mandar a llamar el price que nosotros mismos hemos puesto, para que se pueda enviar
    
}

