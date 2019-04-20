$(document).ready(function(){
    $("#myform").validate({
        rules:{
                name: {
                required:true,
                min:10
            }
            
        }
    });
});


