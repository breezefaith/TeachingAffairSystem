$(document).ready(function(){
	getTeacherCourse();
	$("#teacherCourse").click(function () {
		getTeacherCourse();
	});

	$("#personInformation").click(function () {
		getTeacherPerson();
	});
});
function getTeacherCourse() {
	$.ajax({
		url:'http://localhost:8080/TeachingAffairSystem/TeacherAction!getTeacherCourse',
		type:"post",
		data:{
			teacherNo:"t1"	
		},
		dataType:'html',
		timeout:10000,
		error:function(){
			alert("错误");
		},
		success:function(teacherCourseInfo) {
			$("#div-main-right").html("");
			var teacherCourseObj=JSON.parse(teacherCourseInfo);
			for(var i=0;i<teacherCourseObj.length;i++){
				if($("#div-semester-"+teacherCourseObj[i]['semesterNo']).length==0){
					$("#div-main-right").append("<div id='div-semester-"+teacherCourseObj[i]['semesterNo']+"' class='div-semester'></div>");
				}
				if($("#div-semester-name-"+teacherCourseObj[i]['semesterNo']).length==0){
					$("#div-semester-"+teacherCourseObj[i]['semesterNo']).append('<div id="div-semester-name-'+teacherCourseObj[i]['semesterNo']+'" class="div-semester-name"><h3>'+teacherCourseObj[i]['semesterName']+'</h3></div>');
				}
				if($("#div-semester-"+teacherCourseObj[i]['semesterNo']+" #div-semester-course-"+teacherCourseObj[i]['courseNo']).length==0){
					var newSemesterCourseDiv="<div id='div-semester-course-"+teacherCourseObj[i]['courseNo']+"' class='div-semester-course'>"
											+"<table><tr><th style='width:5em;'>课程号</th><th style='width:8em;'>课程名</th><th style='width:7em;'>开课学院</th><th style='width:5em;'>类别</th></tr>"
											+"<tr>"
											+"<td>"+teacherCourseObj[i]['courseNo']+"</td>"
											+"<td>"+teacherCourseObj[i]['courseName']+"</td>"
											+"<td>"+teacherCourseObj[i]['courseAcademy']+"</td>"
											+"<td>"+teacherCourseObj[i]['courseCategory']+"</td>"
											+"</tr>"
											+"</div>";
					$("#div-semester-"+teacherCourseObj[i]['semesterNo']).append(newSemesterCourseDiv);
				}
				if($("#div-semester-"+teacherCourseObj[i]['semesterNo']+" #div-semester-course-"+teacherCourseObj[i]['courseNo']+" #table-semester-course-student-"+teacherCourseObj[i]['courseNo']).length==0){
					var newSemesterCourseStudentTable="<table id='table-semester-course-student-"+teacherCourseObj[i]['courseNo']+"' class='table-semester-course-student'>"
													+"<tr><th style='width:5em;'>学号</th><th style='width:10em;'>姓名</th><th style='width:7em;'>学院</th><th style='width:7em;'>专业</th><th style='width:3em;'>成绩</th></tr>"
													+"</table>";
					$("#div-semester-"+teacherCourseObj[i]['semesterNo']+" #div-semester-course-"+teacherCourseObj[i]['courseNo']).append(newSemesterCourseStudentTable);
				}
				if($("#div-semester-"+teacherCourseObj[i]['semesterNo']+" #div-semester-course-"+teacherCourseObj[i]['courseNo']+" #table-semester-course-student-"+teacherCourseObj[i]['courseNo']+" td:contains('"+teacherCourseObj[i]['studentNo']+"')").length==0){
					var newSemesterCourseStudentTr="<tr>"
											+"<td>"+teacherCourseObj[i]['studentNo']+"</td>"
											+"<td>"+teacherCourseObj[i]['studentName']+"</td>"
											+"<td>"+teacherCourseObj[i]['studentAcademy']+"</td>"
											+"<td>"+teacherCourseObj[i]['studentMajor']+"</td>"
											+"<td>"+teacherCourseObj[i]['score']+"</td>"
											+"</tr>";
					$("#div-semester-"+teacherCourseObj[i]['semesterNo']+" #div-semester-course-"+teacherCourseObj[i]['courseNo']+" #table-semester-course-student-"+teacherCourseObj[i]['courseNo']).append(newSemesterCourseStudentTr);
					$("#div-semester-"+teacherCourseObj[i]['semesterNo']+" #div-semester-course-"+teacherCourseObj[i]['courseNo']+" #table-semester-course-student-"+teacherCourseObj[i]['courseNo']+" tr:last td:last").dblclick(function () {
						clickScoreTd(this);
					});
				}
			}
		}
	});
}
function getTeacherPerson() {
	$.ajax({
		url:"http://localhost:8080/TeachingAffairSystem/TeacherAction!getTeacherPerson",
		type:"post",
		data:{
			teacherNo:$.cookie("username")
		},
		timeout:10000,
		error:function() {
			alert("error");
		},
		success:function(teacherPersonInfo) {
			var teacherPersonObj=JSON.parse(teacherPersonInfo);
			var newTeacherPersonTable="<table id='table-teacher-person-'"+teacherPersonObj['teacherNo']+" class='table-teacher-person'>"
									+"<tr><th style='width:5em;'>教师号</th><th style='width:10em;'>姓名</th><th style='width:3em;'>性别</th><th style='width:7em;'>学院</th><th style='width:4em;'>职称</th><th style='width:10em;'>邮箱</th><th style='width:16em;'>密码</th><th style='width:3em;'>操作</th></tr>"
									+"<td>"+teacherPersonObj['teacherNo']+"</td>"
									+"<td>"+teacherPersonObj['teacherName']+"</td>"
									+"<td>"+teacherPersonObj['sex']+"</td>"
									+"<td>"+teacherPersonObj['teacherAcademy']+"</td>"
									+"<td>"+teacherPersonObj['teacherTitle']+"</td>"
									+"<td>"+teacherPersonObj['email']+"</td>"
									+"<td>"+teacherPersonObj['password']+"</td>"
									+"<td>"+"<button>修改</button>"+"</td>"
									+"</table>";
			$("#div-main-right").html(newTeacherPersonTable);
			$(".table-teacher-person button").click(function() {
				clickTeacherPersonButtonUpdate(this);
			});						
		}
	});
}
function clickTeacherPersonButtonUpdate(obj) {
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
				teacherNo:$(td[0]).html(),
				teacherName:$(td[1]).find("input").val(),
				sex:$(td[2]).find("input").val(),
				teacherAcademy:$(td[3]).find("input").val(),
				teacherTitle:$(td[4]).find("input").val(),
				email:$(td[5]).find("input").val(),
				password:$(td[6]).find("input").val()
		};
		$.ajax({
			url:"http://localhost:8080/TeachingAffairSystem/TeacherAction!updateTeacherPerson",
			type:"post",
			data:postData,
			dataType:"html",
			timeout:5000,
			error:function(err){
				$("#div-main-right").html(JSON.stringify(err));
			},
			success:function(studentInfo){
				getTeacherPerson();
			}
		});
	}
	
}
function clickScoreTd(obj) {
	var origin=$(obj).text();
	$(obj).html("<input type='text' style='width:40%' value='' onchange='updateInputValue(this)' onkeyup=\"this.value=this.value.replace(/[^0-9]/g,'')\" onafterpaste=\"this.value=this.value.replace(/[^0-9]/g,'')\" > <button>确定</button>");
	$(obj).find("button").click(function () {
		var score=$(obj).find("input").val();
		var tableSemesterCourse=$(obj).parent().parent().parent().parent();
		var tableSemester=$(tableSemesterCourse).parent();
		var partsTableSemesterId=$(tableSemester).attr("id").split("-");
		var partsTableSemesterCourseId=$(tableSemesterCourse).attr("id").split("-");
		var semesterNo=partsTableSemesterId[partsTableSemesterId.length-1];
		var courseNo=partsTableSemesterCourseId[partsTableSemesterCourseId.length-1];
		var studentNo=$(obj).parent().find("td:first").html();
		var postData={
				semesterNo:semesterNo,
				courseNo:courseNo,
				studentNo:studentNo,
				score:score
		};
		$.ajax({
			url:"http://localhost:8080/TeachingAffairSystem/TeacherAction!updateScore",
			type:"post",
			data:postData,
			timeout:5000
		});
		$(obj).html($(obj).find("input").val());
	});
}
function updateInputValue(obj){
	var newValue=($(obj)).val();
	($(obj)).attr("value",newValue);
}