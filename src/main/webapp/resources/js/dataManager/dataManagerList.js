$(function() {
  commonsBtn();
});


function commonsBtn() {
	
	var saveStatus;
	datepicker();
	chkValueChange();
	userDetailInfo()
	
	$('#check_all').on('click', function(){
		
		if($('#check_all').is(":checked")) {
			
			$("input[name=chk_]").prop("checked", true);
			$("input[name=chk_]").val(1);
			chkValueChange();
			
		} else {
			
			$("input[name=chk_]").prop("checked", false);
			$("input[name=chk_]").val(0);
			chkValueChange();
		}
		 
	});
	
	$('input[type="file"]').change(function() {
		alert("dd");
	});
	
	//사원 전체 검색
	$('#selectAllUserList').on('click', function() {
		
		selectUserStatusList($(this).val())
	})
	
	//재직자 검색
	$('#selectUserStatusY').on('click', function() {
		
		selectUserStatusList($(this).val())
	})
	
	//퇴사자 검색
	$('#selectUserStatusN').on('click', function() {
		
		selectUserStatusList($(this).val())
	})
	
	
	
	
function selectUserStatusList(statusYn){
		
		var param ={
				
			'empStatus' :statusYn	
		}
		
		$.ajax({
			url : "../data/selectUserInfoList.do",
			type : "post",
			dataType : "json",
			data: param,
			success : function(result){
				drawUserStatusList(result); //draw 유저 재직상태 리스트
	        },
	        error : function(e) {

	        }
	    });
	}	
	
function drawUserStatusList(result){
	debugger;
	var html ='';
	var userInfoTable =$('#userList').find('tbody');
	userInfoTable.children().remove();
	
	if(result !=null && result !=''){
		result.forEach(function(e,i){
		var j = i+1
		html += '<tr>'
		html += '<td>'+j+'</td>'     											//0
		html += '<td>'+e.user_id+ '</td>'	 									//1  아이디
		html += '<td>'+e.user_nm+'</td>'	 									//2  이름
		html += '<td>'+e.dept_nm+ '</td>'	 									//3  부서
		html += '<td>'+e.dept_position+ '</td>' 								//4  직급
		html += '<td>'+e.hp+ '</td>' 											//5 전화번호
		html += '<td>'+e.email+ '</td>' 										//6  전화번호
		html += '<td>' + (e.emp_status =='Y' ? '재직중' : '퇴사') + '</td>'; 		//7 재직여부
		html += '<td>' + (e.auth_yn =='Y' ? '예' : '아니오') + '</td>'; 			//8 관리자여부
		html += '</tr>';
		
		})
	}
	
	userInfoTable.append(html);
	userDetailInfo()
}

$('#addnewUser').on("click",function(){
	
	var param ={ 'newYn':'Y',
				  'saveStatus':$(this).val()
	}
	
	drawUserDetailInfo(param);
})



function userDetailInfo(){

$('#userList>tbody >tr').on("click",function(){
	debugger;
	var tr = $(this);
	var td = tr.children();
	var userId =td.eq(1).text();
	var userNm =td.eq(2).text();
	var deptNm =td.eq(3).text();
	var deptPosition =td.eq(4).text();
	var hp =td.eq(5).text();
	var email =td.eq(6).text();
	var empStatus =td.eq(7).text();
	var authYn =td.eq(8).text();
	
	var param ={
			'userId'      :userId,
			'userNm'      :userNm,
			'deptNm'      :deptNm,
			'deptPosition':deptPosition,
			'hp' 		  :hp,
			'email'		  :email,
			'empStatus'   :empStatus,
			'authYn' 	  :authYn,
			'saveStatus'  :"U"
	}
	
	
	drawUserDetailInfo(param)
})
}

/*사용자 상세정보 draw function*/
function drawUserDetailInfo(param){
	debugger;
	$('#userDetailInfo').remove()
	$('#topDiv').remove()
	$('#midDiv').remove()
	$('#title').remove()
	
	var html ="";
	
	html +='<div class="cm-table-bx style2 mt15" id ="userDetailInfo">'
	html +=	'<div class="table-wrap restrictions" >'
	html +='<table>'
	html +='<colgroup>'
	html += '<col style="width: 8%">'
	html += '<col style="width: 20%">'
	html += '<col style="width: 8%">'
	html += '<col style="width: 20%">'
	html += '<col style="width: 8%">'
	html += '<col style="width: auto">'
	html +='</colgroup>'
	html +='<tbody>'
	html +='<tr>'
	html += '<th>아이디</th>'
	html += '<td>'
	html += '<input type="text" class="cm-input per100" id ="userId" value="' + param.userId + '" maxlength="20">'
	html +=  '</td>'
	html += '<th>비밀번호</th>'
	html += '<td>'
	html += '<input type="password" class="cm-input per100" id ="userPw" value="' + param.userPw + '" maxlength="20">'
	html +=	 '</td>'	
	html += '<th>이름</th>'
	html += '<td>'
	html += '<input type="text" class="cm-input per100" id ="userNm" value ='+param.userNm+'>'
	html +=  '</td>'
	html += '<th>부서</th>'
	html += '<td>'
	html += '<input type="text" class="cm-input per100" id ="deptNm" value ='+param.deptNm+'>'
	html +=  '</td>'

	html +=  '</tr>'
		
	html +='<tr>'
	html += '<th>핸드폰번호</th>'
	html += '<td>'
	html += '<input type="text" class="cm-input per100"  id ="hp" value ='+param.hp+'>'
	html +=  '</td>'
	html += '<th>이메일</th>'
	html += '<td>'
	html += '<input type="text" class="cm-input per100" id ="email" value ='+param.email+'>'
	html += '<th>직급</th>'
	html += '<td>'
	html += '<input type="text" class="cm-input per100" id ="deptPosition" value ='+param.deptPosition+'>'
	html +=  '</td>'
	html += '<th>재직여부</th>'
	html += '<td>'
	html +='<div class="cm-select style5">'	
	html +=	'<select name ="empStatus" style="width: 210px;" id ="empStatus">'
	html += '<option value="Y"'
		if (param.empStatus === '재직중') {
		    html += ' selected'
		}
	html += '>재직중</option>'
		html += '<option value="N"'
		if (param.empStatus === '퇴사') {
		    html += ' selected'
		}
	html += '>퇴사</option>'	
	html +=	'</select>'	
	html += '</div>'	
	html +=  '</td>'
	html += '</tr>'     
    html +='</tbody>'
    html +='</table>'
    html +='</div>'
    html +='</div>'
    html +=	 '<div class="cm-btn-bx clearfix">'
    html += '<div class="fl-r">'
    html += '<div class="cm-btn style3"><button id ="saveUserInfoBtn">저장</button></div>'
    if(param.newYn !='Y'){	
    html += '<div class="cm-btn style5"><button id ="deleteUserInfoBtn">삭제</button></div>'
	}
	html += '<div class="cm-btn style7"><button id ="backBtn" onclick="window.location.href=\'../data/dataManagePage.do\'">목록</button></div>';
    html += ' </div>'
    html += ' </div> '	
			
	$('#userDetailInfoDiv').append(html)
	if(param.newYn =='Y'){
		$("input[type=text]").val("");
		$("input[type=password]").val("");
	}
    
    saveStatus =param.saveStatus;
    saveUserInfoFnc()
    deleteUserInfoFnc()
}



//사용자 정보 I/U function 
function saveUserInfoFnc(){
$('#saveUserInfoBtn').on('click', function() {
	
	var userId =$('#userId').val()				//아이디
	var userNm =$('#userNm').val()				//사용자 이름
	var deptNm =$('#deptNm').val()  			//부서
	var deptPosition =$('#deptPosition').val()  //직급
	var hp =$('#hp').val()						//핸드폰 번호
	var email =$('#email').val()				//이메일
	var empStatus =$('#empStatus').val()		//재직상태
	var authYn =$('#authYn').val()				//관리자 여부
	var userPw =$('#userPw').val()				//비밀번호
	var param ={
			'userId'      :userId,
			'userNm'      :userNm,
			'deptNm'      :deptNm,
			'deptPosition':deptPosition,
			'hp' 		  :hp,
			'email'		  :email,
			'empStatus'   :empStatus,
			'authYn' 	  :authYn,
			'saveStatus'  :saveStatus,
			'userPw'	  :userPw
	}
	
	
	$.ajax({
		url : "../data/saveUserInfo.do",
		type : "post",
		dataType : "json",
		data: param,
		success : function(result){
			alert(result.message)
			$('#backBtn').click()
        },
        error : function(e) {

        }
    });
	
})
}

function deleteUserInfoFnc(){
	$('#deleteUserInfoBtn').on('click', function() {
		
		
		var userId =$('#userId').val()				//아이디
		
		
		var param ={ 'saveStatus':"D",
					  'userId':userId}
		
		
		$.ajax({
			url : "../data/saveUserInfo.do",
			type : "post",
			dataType : "json",
			data: param,
			success : function(result){
				alert(result.message)
				$('#backBtn').click()
	        },
	        error : function(e) {

	        }
	    });
		
		
	})
	
	
}
















	//자료관리데이터 조회
	$('#selectDataManageList').on('click', function() {
		
		$("#v_user_id").val('');
		$("#v_user_nm").val('');
		
		let checkedCount = $("input:checkbox[name=chk]:checked").length;
	    if (checkedCount === 0) {
	      alert("사용자가 선택되지 않았습니다.");
	      return false;
	    } else if (checkedCount > 1) {
	      alert("데이터조회는 사용자별 단건으로 조회가능합니다.");
	      return false;
	    } else {	    	
	    	for(let i = 0 ; i < $('#member > tbody tr').length; i ++){
	    		if($("#chk" + i).val() == 1){
	    			let userParam = {
	    					user_id: $('#user_id'+i).text().trim(),
	    					user_nm: $('#user_nm'+i).text().trim(),
	    					rgsde_startdt : $("#rgsde_startdt").val().replace(/-/g, ""),
	    					rgsde_enddt : $("#rgsde_enddt").val().replace(/-/g, ""),
	    					gubun : $("#gubun").val(),
	    					search_type : $("#search_type").val(),
	    					search_value : $("#search_value").val()		
	    			};
	    			
	    			$("#v_user_id").val(userParam.user_id);
	    			$("#v_user_nm").val(userParam.user_nm);
	    			selectDataManageList(userParam);
	    		}
	    	}    	
	    }
	  });
	

	//자료관리데이터 신규
	$('#newDataManage').on('click', function() {
		let checkedCount = $("input:checkbox[name=chk]:checked").length;
	    if (checkedCount === 0) {
	      alert("사용자가 선택되지 않았습니다.");
	      return false;
	    }
	    
	    if($("#v_user_id").val() == '' || $("#v_user_id").val() == null) {
	    	alert("등록자료를 먼저 조회해 주세요");
	    	return false;
	    }
	    
	    let rowCnt = $('#data > tbody tr').length;

	    let row = `<tr>
	        <td>
	            <label for="chk_${rowCnt}" class="cm-check style2">
	                <input type="checkbox" name="chk_" id="chk_${rowCnt}" value="1" checked/>
	                <span></span>
	            </label>
	        </td>
	        <td></td>
	        <td style="display:none;"></td>
	        <td><div class="cm-select style3">
				  <select name ="gubun${rowCnt}" id ="gubun${rowCnt}">
						<option value="1" "selected">계획보고</option>
						<option value="2">착수보고</option>
						<option value="3">자료제출요구 및 현장조사</option>
						<option value="4">결과보고</option>
						<option value="5">사전통지 및 시정조치</option>
						<option value="6">안건</option>
						<option value="7">시정조치 통보</option>
						<option value="8">이행결과 보고</option>
						<option value="9">이행실태 점검</option>
						<option value="10">이의제기 및 법원제출 통보</option>
			   		</select>
				  </div>
			</td>
	        <td><input class="cm-inputb0 per90" type="text" id="title${rowCnt}" name="title${rowCnt}" value=''/></td>
	        <td><input class="cm-inputb0 per90" type="text" id="content${rowCnt}" name="content${rowCnt}" value=''/></td>
	        <td></td>
	        <td><input name="file" type="file" id="uploadFile${rowCnt}" name ="uploadFile${rowCnt}" accept=".zip" style="display:block" oninput="checkFileSize(this)"></td>
	        <td></td>
	    </tr>`;
   
	    $('#data > tbody:last').append(row);
	    chkValueChange();
	});
	

	//자료관리데이터 삭제
	$('#deleteDataManage').on('click', function(){	
		if(!confirm("체크된 데이터가 삭제 됩니다")){
			alert("취소 되었습니다.");
			return false;
		}else{	
			if($("input:checkbox[name=chk_]:checked").length == 0 ) {
				alert("삭제할 데이터가 선택되지 않았습니다.");
				return false;
			}else{
				let deleteParam = {dataManageParam : []};
				
			      $('#data > tbody tr').each(function(index, row) {
			          let checkbox = $(row).find("input:checkbox[name=chk_]:checked");
			          if (checkbox.length > 0) {
			            let bno = $("#bno" + index).val();
			            deleteParam.dataManageParam.push({
			            	bno: bno
			            });
			          }
			        });
				//자료관리 데이터 삭제
			    deleteDataManage(deleteParam);
			}		
		}				
	});
	
	//자료관리데이터 저장
	$('#saveDataManage').on('click', function(){	
		var trCnt =$('#data >tbody').find('tr').length
		
		if(!confirm("선택된 항목만 수정/저장 됩니다")){	
			alert("취소 되었습니다.");
			return false;
		}else{
			if($("input:checkbox[name=chk_]:checked").length != 0){
				 var emptyChk = false;
				 $("input:checkbox[name=chk_]:checked").each(function() {
					 var index = $(this).closest("tr").index();
					 if ($('#title' + index).val() == '' || $('#content' + index).val() == '') {
				          emptyChk = true;
				          return false;
			}
		})
		  if(emptyChk){
			  alert("자료관리 등록 시 제목/내용은 필수적으로 입력하셔야 합니다.");
		        return false;	
		  }
		}else{
			alert("자료관리 데이터가 선택되지 않았습니다.");
		      return false;
		}
				let mergeParam = {dataManageParam : []};
				let fileList = {file : []};
			      $('#data > tbody tr').each(function(index, row) {
			          let checkbox = $(row).find("input:checkbox[name=chk_]:checked");
			          if (checkbox.length > 0) {
			            let bno = $("#bno" + index).val();         
			            let title = $("#title" + index).val();
	                    let content = $("#content" + index).val();
			            let writer = $("#v_user_id").val();
			            let writer_nm = $("#v_user_nm").val();
			            let gubun = $("#gubun" + index).val();  
			            let file = $("#uploadFile" + index)[0].files[0];
			            
			            mergeParam.dataManageParam.push({
			            	bno: bno ,
			            	title : title,
			            	content : content,
			            	writer : writer ,
			            	writer_nm : writer_nm ,
			            	gubun : gubun
			            });
			            
			            fileList.file.push({
			            	gubun : gubun,
			            	file : file
			            });
			            
			          }
			        });
			      
			      
		        	for(let i = 0 ; i < fileList.file.length;i++ ){
		        		if(fileList.file[i].file ==null){
		        			alert("자료관리 등록 시 파일을 필수적으로 입력하셔야 합니다.");
		        			return false;
		        		}
		        	}
					//자료관리 데이터 저장
			      	mergeDataManage(mergeParam,fileList);
				}
		});
	}


//자료관리데이터 조회
function selectDataManageList(userParam){
    $.ajax({
        url: "/data/selectDataManageList.do",
        type: "post",
        dataType: "json",
        data: userParam,
        success: function(data) { 
        	let rows = [];
        	if (data.length > 0) {
              $.each(data, function(i) {
                let row = `<tr>
                  <td><label for="chk_${i}" class="cm-check style2">
                    <input type="checkbox" name="chk_" id="chk_${i}"/>
                    <span></span>
                  </label></td>
                  <td style="display:none;"><input class="cm-inputb0 per90" type ="text" id ="bno${i}" name ="bno${i}" value ='${(data[i].bno || '')}'/></td>
                  <td>${parseInt(i) + 1}</td>
				  <td><div class="cm-select style3">
				  <select name ="gubun${i}" id ="gubun${i}">
						<option value="1" ${(data[i].gubun == "1"? "selected" : "")}>계획보고</option>
						<option value="2" ${(data[i].gubun == "2"? "selected" : "")}>착수보고</option>
						<option value="3" ${(data[i].gubun == "3"? "selected" : "")}>자료제출요구 및 현장조사</option>
						<option value="4" ${(data[i].gubun == "4"? "selected" : "")}>결과보고</option>
						<option value="5" ${(data[i].gubun == "5"? "selected" : "")}>사전통지 및 시정조치</option>
						<option value="6" ${(data[i].gubun == "6"? "selected" : "")}>안건</option>
						<option value="7" ${(data[i].gubun == "7"? "selected" : "")}>시정조치 통보</option>
						<option value="8" ${(data[i].gubun == "8"? "selected" : "")}>이행결과 보고</option>
						<option value="9" ${(data[i].gubun == "9"? "selected" : "")}>이행실태 점검</option>
						<option value="10" ${(data[i].gubun == "10"? "selected" : "")}>이의제기 및 법원제출 통보</option>
				  </select>
				  </div>
				  </td>
                  <td><input class="cm-inputb0 per90" type ="text" id ="title${i}" name ="title${i}" value ='${(data[i].title || '')}'/></td>
                  <td><input class="cm-inputb0 per90" type ="text" id ="content${i}" name ="content${i}" value ='${(data[i].content || '')}'/></td>
                  <td>${(data[i].atch_original_name || '')}</td>
                  <td><input name="file" type="file" id="uploadFile${i}" name ="uploadFile${i}" accept=".zip" style="display:block" oninput="checkFileSize(this)"></td>
                  <td>${(data[i].rgsde || '')}</td>
                </tr>`;                
                rows.push(row);
              });

              $('#data > tbody').html(rows.join(''));
            }else{
            	$('#data > tbody').empty();
            } 
        	
            chkValueChange();
        },
        error: function(jqXHR, textStatus, errorThrown) {
          console.log("Request failed with error:", textStatus, errorThrown);
        }
      });
	}


//자료데이터 머지
function mergeDataManage(mergeParam,fileList){	  
    $.ajax({
        url: "/data/mergeDataManage.do",
        type: "post",
        dataType: "JSON",
		data: JSON.stringify(mergeParam),
	    traditional : true,  
	    contentType: "application/json; charset=utf-8", //헤더의 Content-Type을 설정   
        success: function(data) {         
       
        	var formData = new FormData();
        	for(let i = 0 ; i < fileList.file.length;i++ ){
        		formData.append('files', fileList.file[i].file);
        		formData.append('gubun', fileList.file[i].gubun);
        		formData.append('bno', data.bnoList[i]);
        	}
        	fileUpload(formData,data.message);
        	        	
        },
        error: function(jqXHR, textStatus, errorThrown) {
          console.log("Request failed with error:", textStatus, errorThrown);
        }
      });
}


function fileUpload(formData , message) {
    $.ajax({
        url: "/data/uploadDataManage.do",
        type: "post",
		data: formData,
	    processData: false,
	    contentType: false,
        success: function(data) { 
        	alert(message);
        	$('#selectDataManageList').click();
        },
        error: function(jqXHR, textStatus, errorThrown) {
          console.log("Request failed with error:", textStatus, errorThrown);
        }
      });
}






//자료관리데이터 삭제deleteDataManage
function deleteDataManage(deleteParam) {
	
    $.ajax({
        url: "/data/deleteDataManage.do",
        type: "post",
        dataType: "JSON",
		data: JSON.stringify(deleteParam),
	    traditional : true,  
	    contentType: "application/json; charset=utf-8", //헤더의 Content-Type을 설정   
        success: function(data) { 
        	alert(data.message);
        	//재조회
        	$('#selectDataManageList').click();
        },
        error: function(jqXHR, textStatus, errorThrown) {
          console.log("Request failed with error:", textStatus, errorThrown);
        }
      });
	}

