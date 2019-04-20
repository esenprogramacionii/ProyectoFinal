/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function()
{
    $("#myform").validate({
        rules:{
            firstname: {
                required: true,
                max: 10
            },
            lastname: {
                required: true,
                min: 10
            },
            date: {
               required: true,
               min: 10
            }
        }
    });
}
    );

