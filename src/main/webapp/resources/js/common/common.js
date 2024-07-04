function chkValueChange() {
	$('input[type="checkbox"]').change(function(){
		this.value = this.checked ? 1 : 0;
	});
}

function datepicker(){
	
	$.datepicker.setDefaults({
		dateFormat : "yy-mm-dd",
		prevText : '이전 달',
		nextText : '다음 달',
		monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
				'9월', '10월', '11월', '12월' ],
		monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월',
				'9월', '10월', '11월', '12월' ],
		dayNames : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
		dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
		showMonthAfterYear : true,
		yearSuffix : '년',
		changeMonth : true,
		changeYear : true,
		closeText : '닫기'
	});
	$(".datepicker").datepicker({
		showOn : "both",
		buttonImage : "../resources/images/ic_calendar.png",
		buttonImageOnly : true,
		regional : "ko"
	});

}

const onInputHandlerFrom = (date) => {
    let val = date.value.replace(/\D/g, "");
    let leng = val.length;
    let result = '';

    if (leng < 6) {
        result = val;
    } else if (leng < 8) {
        result += val.substring(0, 4);
        result += "-";
        result += val.substring(4);
    } else {
        result += val.substring(0, 4);
        result += "-";
        result += val.substring(4, 6);
        result += "-";
        result += val.substring(6);

        if (!checkValidDate(result)) {
            alert("잘못된 날짜 형식입니다.");
            date.value = '';
            return false;
        }
    }

    date.value = result;
};

const checkValidDate = (value) => {
    let result = true;
    try {
        let date = value.split("-");
        let y = parseInt(date[0], 10),
            m = parseInt(date[1], 10),
            d = parseInt(date[2], 10);

        let dateRegex = /^(?=\d)(?:(?:31(?!.(?:0?[2469]|11))|(?:30|29)(?!.0?2)|29(?=.0?2.(?:(?:(?:1[6-9]|[2-9]\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00)))(?:\x20|$))|(?:2[0-8]|1\d|0?[1-9]))([-.\/])(?:1[012]|0?[1-9])\1(?:1[6-9]|[2-9]\d)?\d\d(?:(?=\x20\d)\x20|$))?(((0?[1-9]|1[012])(:[0-5]\d){0,2}(\x20[AP]M))|([01]\d|2[0-3])(:[0-5]\d){1,2})?$/;
        result = dateRegex.test(d + '-' + m + '-' + y);
    } catch (err) {
        result = false;
    }
    return result;
};


function checkFileSize(input){
	 var file = input.files[0];
	  var maxSize = 100 * 1024 * 1024; // 100MB

	  if (file && file.size > maxSize) {
	    alert("파일 크기는 100MB 이하여야 합니다.");
	    // 파일 입력 필드 초기화
	    input.value = '';
	  }
	}







