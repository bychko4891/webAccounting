$(function () {
    var resultDiv = $('#result');
    $('#form').submit(function (e) {
        e.preventDefault();
        var data = $(this).serialize();
        if ($('textarea[name="ukrText"]').val() && $('textarea[name="engText"]').val()) {
            // якщо всі поля заповнені, виконуємо запит на сервер
            $.ajax({
                type: "GET",
                url: "/englishADD",
                data: data,
                success: function (result) {
                    // $('#result').html(result);
                    $('input[name="ukrText"]').val('');
                    $('input[name="engText"]').val('');
                    // Отримуємо div-елемент, в який ми будемо поміщати повідомлення
                    resultDiv.text(result);
                    setTimeout(hideMessage, 5000);
                    // console.log(result);
                },
                error: function () {
                    let shel = {};
                    alert(Boolean(shel))
                    // Поміщаємо повідомлення про помилку в div-елемент
                    resultDiv.text('Помилка запиту на сервер');
                }
            });
        } else {
            // якщо не всі поля заповнені, не виконуємо запит на сервер і виводимо помилку
            alert('Будь ласка, заповніть поле вводу');
            return;
        }
    });

    function hideMessage() {
        resultDiv.text('');
    }
});
// Додаємо обробник події на кнопку відправки форми
$('form').submit(function (event) {
    event.preventDefault();
    sendMessage();
});
$(document).ready(function () {
    $('#reload').click(function () {
        $.get("/englishJSON", function (data) {
            console.log(data); // тут ви можете виконати потрібні дії зі змінною data, яка містить дані з сервера
            for (key in data) {
                if (data.hasOwnProperty(key)) {
                    if (key == "ukrText") {
                        var ukr = data[key];
                        $('#ukr-text').html(ukr);
                    }
                    if (key == "engText") {
                        var egl = data[key];
                        $('.content_block').hide();
                        $('#english-text').html(egl);
                        // $("#show_result").hide();
                    }
                }
            }
        });
    });
});
// Кнопка, щоб відкрити скритий текст
$(document).ready(function () {
    $('.content_toggle').click(function () {
        $('.content_block').slideToggle(600);
        return false;
    });
});
//авто висота вікна для вводу тексту
$(document).ready(function(){
    $('textarea').on('input', function(){
        this.style.height = 'auto';
        this.style.height = (this.scrollHeight) + 'px';
    });
});