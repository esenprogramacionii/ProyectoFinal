$(document).ready(function(){
    $("#myform").validate({
        rules:{
                supplier: {
                required:true,
                min:1
            }
            
        }
    });
});


