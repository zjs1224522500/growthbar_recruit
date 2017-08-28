$(document).on('click', '#userQQ', function() {
    $(this).removeClass('growthbar_div_transmit');
});
$(document).on('click', '#userTel', function() {
    $(this).removeClass('growthbar_div_transmit');
});
$(document).on('click', '#userDesc', function() {
    $(this).removeClass('growthbar_div_transmit');
});
$(document).on('click', '#userName', function() {
    $(this).removeClass('growthbar_div_transmit');
});
$(document).on('click', '#userGender', function() {
    $(this).removeClass('growthbar_div_transmit');
});
$(document).on('click', '#userEmail', function() {
    $(this).removeClass('growthbar_div_transmit');
});
$(document).on('click', '#studentId', function() {
    $(this).removeClass('growthbar_div_transmit');
});
$(document).on('click', '#fromSubmit', function() {
    var dataInf = $("#formVal").serialize();
    if ($("#userName").val() == '' || $("#studentId").val() == '' || $("#userTel").val() == '' || $("#userEmail").val() == '' || $("#userDesc").val() == '' || $("#userQQ").val() == '') {
        alert("请检查是否填写完全。");
    } else {
        $.ajax({
            url: 'recruit_growthbar/recruit/save',
            type: 'POST',
            dataType: 'json',
            data: dataInf,
            success: function(data) {
                if (data.status == true) {
                    alert("提交成功。");
                    window.location.href = "../home.html";
                } else {
                    alert("提交失败，请重新填写。" + data.errorData);
                }
            },
            error: function(XMLHttpRequest, textStatus, errorThrown) {
                alert(XMLHttpRequest.responseText);
                alert(XMLHttpRequest.readyState);
                alert(textStatus);
            },
        });
    }
});