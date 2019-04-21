
$(document).ready(function()
{
    $("#myform").validate({
        rules:{
            firstname: {
                required: true
            },
            lastname: {
                required: true
            },
            date: {
               required: true
            }
        }
    });
}
    );

