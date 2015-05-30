$(document).ready(function () {

    var url= "https://www.dropbox.com/home?preview=form-validation.json";
    var sn=$('#sn').val();
    var icons = {
        header: "ui-icon-circle-arrow-e",
        activeHeader: "ui-icon-circle-arrow-s"
    };
    $( ".accordion" ).accordion({
        icons: icons
    });



    $('.submit').click(function () {

        if(sn==""){
            $('.required').append(' (Please supply)');
            $('.sn').addClass('has-error');
        }else{
            $.ajax({
                dataType: "json",
                url: url,
                success: success
            });

        }


    });





});
