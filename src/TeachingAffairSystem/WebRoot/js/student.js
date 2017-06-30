$(document).ready(function(){
	getStudentCourse();
	$("#score").click(function() {
		getStudentCourse();
	});
	$("#selectCourse").click(function () {
		getSelectedCourse();
	});
	$("#personInformation").click(function() {
		getStudentPerson();
	});
});
function getStudentCourse() {
	$.ajax({
		url:"http://localhost:8080/TeachingAffairSystem/StudentAction!getStudentCourse",
		type:"post",
		data:{
			"studentNo":"s1",
		},
		timeout:10000,
		dataType:'html',
		error:function(error) {
			$("#div-main-right").html(error);
		},
		success:function(studentCourseInfo) {
			$("#div-main-right").html("");
			var studentCourseObj=JSON.parse(studentCourseInfo);
			//alert(studentCourseObj.length);
			for(var i=0;i<studentCourseObj.length;i++){
				//alert(JSON.stringify(studentCourseObj[i]));
				if($("#div-semester-"+studentCourseObj[i]['semesterNo']).length==0){
					var newSemesterDiv="<div class='div-semester' id='div-semester-"+studentCourseObj[i]['semesterNo']+"'>"
									+"<div class='div-semester-name' id='div-semester-name-"+studentCourseObj[i]['semesterNo']+"'><h3>"+studentCourseObj[i]['semesterName']+"</h3></div>"
									+"<table class='table-semester-course' id='table-semester-course-"+studentCourseObj[i]['semesterNo']+"'>"
									+'<tr><th style="width: 5em;">课程号</th><th style="width: 8em;">课程名</th><th style="width: 7em;">开课学院</th><th style="width: 4em;">类别</th><th style="width: 10em;">教师</th><th style="width: 10em;">邮箱</th><th style="width: 2em;">成绩</th><th style="width: 4em;">操作</th></tr>'
									+"</table>"
									+"</div>";
					$("#div-main-right").append(newSemesterDiv);
				}
				var newStudentCourseTr="<tr>"
								+"<td>"+studentCourseObj[i]['courseNo']+"</td>"
								+"<td>"+studentCourseObj[i]['courseName']+"</td>"
								+"<td>"+studentCourseObj[i]['courseAcademy']+"</td>"
								+"<td>"+studentCourseObj[i]['courseCategory']+"</td>"
								+"<td>"+studentCourseObj[i]['teacherName']+"</td>"
								+"<td>"+studentCourseObj[i]['email']+"</td>"
								+"<td>"+studentCourseObj[i]['score']+"</td>"
								+"<td><button>退选</button></td>"
								+"</tr>";
				$("#div-semester-"+studentCourseObj[i]['semesterNo']+" table").append(newStudentCourseTr);
				$("#div-semester-"+studentCourseObj[i]['semesterNo']+" table tr:contains('"+studentCourseObj[i]['courseNo']+"') button").click(function () {
					clickStudentCourseButtonRemove(this);
				});
				// alert($("#div-semester-"+studentCourseObj[i]['semesterNo']+" table tr:contains('"+studentCourseObj[i]['courseNo']+"') td:last").prev().html()!=null);
				if($("#div-semester-"+studentCourseObj[i]['semesterNo']+" table tr:contains('"+studentCourseObj[i]['courseNo']+"') td:last").prev().html()!=""){
					$("#div-semester-"+studentCourseObj[i]['semesterNo']+" table tr:contains('"+studentCourseObj[i]['courseNo']+"') td:last button").attr("disabled","");
				}
				
			}
		}
	});
}
function clickStudentCourseButtonRemove(obj){
	var tr=$(obj).parent().parent();
	var scoreTd=$(obj).parent().prev();
	var parts=$(tr).parent().parent().attr("id").split("-");
	var semesterNo=parts[parts.length-1];
	var courseNo=$(tr).find("td:first").html();
	var studentNo=$.cookie("username");
	if(confirm("确定要退选这门课吗？")==true){
		$.ajax({
			url:"http://localhost:8080/TeachingAffairSystem/StudentAction!removeCourse",
			type:"post",
			data:{
				semesterNo:semesterNo,
				courseNo:courseNo,
				studentNo:studentNo
			},
			timeout:5000
		});
		getSelectedCourse();
	}else{
//		alert("取消")
	}
}
function getSelectedCourse() {
	$("#div-main-right").html("");
	$.ajax({
		url:"http://localhost:8080/TeachingAffairSystem/StudentAction!getSelectedCourse",
		type:"post",
		data:{
			"studentNo":"s1"
		},
		timeout:10000,
		dataType:'html',
		error:function() {
			alert("错误");
		},
		success:function(selectedCourseInfo) {
			$("#div-main-right").html("");
			var selectedCourseObj=JSON.parse(selectedCourseInfo);
			//alert(studentCourseObj.length);
			for(var i=0;i<selectedCourseObj.length;i++){
				//alert(JSON.stringify(studentCourseObj[i]));
				if($("#div-semester-"+selectedCourseObj[i]['semesterNo']).length==0){
					var newSemesterDiv="<div class='div-semester' id='div-semester-"+selectedCourseObj[i]['semesterNo']+"'>"
									+"<div class='div-semester-name' id='div-semester-name-"+selectedCourseObj[i]['semesterNo']+"'><h3>"+selectedCourseObj[i]['semesterName']+"</h3></div>"
									+"<table class='table-semester-course' id='table-semester-course-"+selectedCourseObj[i]['semesterNo']+"'>"
									+'<tr><th style="width: 5em;">课程号</th><th style="width: 8em;">课程名</th><th style="width: 7em;">开课学院</th><th style="width: 4em;">类别</th><th style="width: 10em;">教师</th><th style="width: 10em;">邮箱</th><th style="width: 4em;">操作</th></tr>'
									+"<tr><td colspan='7'><button style='float:right'>提交</button></td></tr>"
									+"</table>"
									+"</div>";
					$("#div-main-right").append(newSemesterDiv);
					$("#div-semester-"+selectedCourseObj[i]['semesterNo']+" table tr:last button:contains('提交')").click(function () {
						clickButtonConfirmSelected(this);
					});
				}
				var newSelectedCourseTr="<tr>"
								+"<td>"+selectedCourseObj[i]['courseNo']+"</td>"
								+"<td>"+selectedCourseObj[i]['courseName']+"</td>"
								+"<td>"+selectedCourseObj[i]['courseAcademy']+"</td>"
								+"<td>"+selectedCourseObj[i]['courseCategory']+"</td>"
								+"<td>"+selectedCourseObj[i]['teacherName']+"</td>"
								+"<td>"+selectedCourseObj[i]['email']+"</td>"
								+"<td><input type='checkbox'></td>"
								+"</tr>";
				$("#div-semester-"+selectedCourseObj[i]['semesterNo']+" table tr:last").before(newSelectedCourseTr);
			}
		}
	});
}
function clickButtonConfirmSelected(obj) {
	var tr=$(obj).parent().parent().parent().find("tr:has(input[type='checkbox']:checked)");
	var table=$(obj).parent().parent().parent().parent();
	var tableId=$(table).attr("id");
	var parts=tableId.split("-");
	var semesterNo=parts[parts.length-1];
	for(var i=0;i<tr.length;i++){
		var postData={
				semesterNo:semesterNo,
				studentNo:$.cookie("username"),
				courseNo:$(tr[i]).find("td:first").html()
		};
		$.ajax({
			url:"http://localhost:8080/TeachingAffairSystem/StudentAction!selectCourse",
			type:"post",
			data:postData,
			timeout:5000
		});
	}
	getSelectedCourse();
}
function getStudentPerson() {
	$.ajax({
		url:"http://localhost:8080/TeachingAffairSystem/StudentAction!getStudentPerson",
		type:"post",
		data:{
			studentNo:$.cookie("username")
		},
		timeout:10000,
		dataType:'html',
		error:function() {
			alert("错误");
		},
		success:function(studentCourseInfo) {
			var studentCourseObj=JSON.parse(studentCourseInfo);
			var newStudentPersonTable="<table id='table-teacher-person-'"+studentCourseObj['studentNo']+" class='table-student-person'>"
									+"<tr><th style='width:5em;'>学号</th><th style='width:10em;'>姓名</th><th style='width:3em;'>性别</th><th style='width:7em;'>学院</th><th style='width:7em;'>专业</th><th style='width:10em;'>班级</th><th style='width:16em;'>密码</th><th style='width:3em;'>操作</th></tr>"
									+"<td>"+studentCourseObj['studentNo']+"</td>"
									+"<td>"+studentCourseObj['studentName']+"</td>"
									+"<td>"+studentCourseObj['sex']+"</td>"
									+"<td>"+studentCourseObj['studentAcademy']+"</td>"
									+"<td>"+studentCourseObj['studentMajor']+"</td>"
									+"<td>"+studentCourseObj['studentClass']+"</td>"
									+"<td>"+studentCourseObj['password']+"</td>"
									+"<td>"+"<button>修改</button>"+"</td>"
									+"</table>";
			$("#div-main-right").html(newStudentPersonTable);
			$(".table-student-person button").click(function() {
				clickstudentPersonButtonUpdate(this);
			});						
		}
	});
}
function clickstudentPersonButtonUpdate(obj) {
	var tr=$(obj).parent().parent();
	var td=$(tr).find("td");
	if($(obj).text()=="修改"){
		for(var i=1;i<td.length-1;i++){
			var origin=$(td[i]).text();
			$(td[i]).html("<input type='text' style='width:90%;' value='"+origin+"'>");
		}
		$(obj).html("确定");
	}else if($(obj).text()=="确定"){
		var postData={
				studentNo:$(td[0]).html(),
				studentName:$(td[1]).find("input").val(),
				sex:$(td[2]).find("input").val(),
				studentAcademy:$(td[3]).find("input").val(),
				studentMajor:$(td[4]).find("input").val(),
				studentClass:$(td[5]).find("input").val(),
				password:$(td[6]).find("input").val()
		};
		$.ajax({
			url:"http://localhost:8080/TeachingAffairSystem/StudentAction!updateStudentPerson",
			type:"post",
			data:postData,
			dataType:"html",
			timeout:5000,
			error:function(err){
				$("#div-main-right").html(JSON.stringify(err));
			},
			success:function(studentInfo){
				getStudentPerson();
			}
		});
	}
}