
$(document).ready(function()
{
    $("#myform").validate({
        rules:{
            firstname: {
                required: true,
                min: 10
            },
            lastname: {
                required: true,
                min: 10
            },
            date: {
               required: true,
            }
        }
    });
}
    );

