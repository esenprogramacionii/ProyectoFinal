
$(document).ready(function()
{
    $("#myform").validate({
        rules:{
            name: {
                required: true
            },
            brand: {
                required: true
            },
            description: {
               required: true
            },
            year: {
                required: true,
                min: 4
            },
            price: {
                required: true,
                min: 1
                
            }
        }
    });
}
    );