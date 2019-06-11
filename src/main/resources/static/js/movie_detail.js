$(document).ready(function() {
    $(".iframe-trailer").hide();
    $(".choose-show-time-time").hide();

    $(".btn-showtrailer").click(function() {
        $(".iframe-trailer").show();
    });

    $(".show-times-picker").datepicker();

    $(".submit-choose-date").click(function (event) {
        if($(".show-times-picker").val() == "") {
            alert("Hãy chọn ngày để tìm suất chiếu phù hợp với bạn !")
        }
        var find_data = {
            date :$(".show-times-picker").val(),
            id : $(".movie-id").val()
        }
        event.preventDefault();
        $.ajax({
            type:"POST",
            contentType:"application/json",
            url:"/showtime/getShowtimes",
            data: JSON.stringify(find_data),
            cache: false,
            timeout: 600000,
            dataType: 'json',
            success:function (resp) {
                if(resp.length == 0 || resp == null) {
                    alert("Không có suất chiếu theo ngày bạn đã chọn !");
                }
                else {
                    $(".choose-show-time-time").show();
                    var text = "";
                    for(var i = 0 ;i<resp.length;i++) {
                        text += '<option class="show-time-time" >';
                        text += resp[i].time;
                        text += '</option>';
                    }
                    $(".select-show-time").html(text);
                }
            },
            error:function () {
                console.log("Lỗi");
            }
        })
    });
});