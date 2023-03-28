$(function () {
    $('#form').submit(function (e) {
        e.preventDefault();
        var data = $(this).serialize();
        $.ajax({
            type: "GET",
            url: "/englishJSON",
            // dataType: "json",
            data: data,
            success: function (result) {
                for (key in result) {
                    if (result.hasOwnProperty(key)) {
                        if (key == "ukrText") {var ukr = result[key];
                            $('#ukr-text').html(ukr); }
                        if (key == "engText") { var egl = result[key];
                            $('#english-text').html(egl); }
                    }
                }
                // console.log(str);
            }
        });
    });
});