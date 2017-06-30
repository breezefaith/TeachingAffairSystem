function updateInputValue(obj){
	var newValue=($(obj)).val();
	($(obj)).attr("value",newValue);
}
/*教师表格按钮*/
function clickTeacherButtonUpdate(obj){
	var id=String(obj.id);
	var parts=id.split("-");
	//获取按钮所在的<tr>元素
	var tr=$(obj).parent().parent();
	var td=$(tr).find("td");
	if($(obj).text()=="修改"&&parts.length==4){
		// alert(1);
		for (var i = td.length - 2; i >= 0; i--) {
			var origin=td[i].textContent;
			td[i].innerHTML="<input type='text' value='"+origin+"' style='width:98%;' onchange='updateInputValue(this)'/>";
		}
		$(obj).html("确定");
	}else if($(obj).text()=="确定"&&parts.length==4){
		// alert(2);
		var postData='{'
					+'teacherNo:"'+$(td[0]).text()+'",'
					+'teacherName:"'+$(td[1].innerHTML).val()+'",'
					+'sex:"'+$(td[2].innerHTML).val()+'",'
					+'teacherAcademy:"'+$(td[3].innerHTML).val()+'",'
					+'teacherTitle:"'+$(td[4].innerHTML).val()+'",'
					+'teacherEmail:"'+$(td[5].innerHTML).val()+'",'
					+'password:"'+$(td[6].innerHTML).val()+'"'
					+'}';
		for (var i = td.length - 2; i >= 0; i--) {
			var origin=$(td[i].innerHTML).val();
			$(td[i]).html(origin);
		}
		$(obj).html("修改");
	}else if($(obj).text()=="修改"&&parts.length!=4){
		// alert(3);
	}else if($(obj).text()=="确定"&&parts.length!=4){
		// alert(4);
		var id=$(tr).find("input:first").attr("value");
		$(tr).attr("id","table-teacher-information-tr-"+id);
		$(obj).attr("id","button-teacher-update-"+id);
		for (var i = td.length - 2; i >= 0; i--) {
			var origin=$(td[i].innerHTML).val();
			td[i].innerHTML=origin;
		}
		$(obj).html("修改");
	}
}
function clickTeacherButtonDelete(obj){
	var id=String(obj.id);
	var parts=id.split("-");
	var teacherNo=parts[parts.length-1];
	if(confirm("确定要删除这条信息吗？")==true){
		alert("删除"+(parts[parts.length-1]));
		//数据库进行删除
			//deleteFromSQL()
		//删除节点
		$(obj).parent().parent().remove();
	}else{
		alert("取消")
	}
}
function clickTeacherButtonInsert(obj){
	var newTrHTML="<tr>";
	var id="";
	for(var i=0;i<7;i++){
		newTrHTML=newTrHTML+"<td><input type='text' style='width:98%;' value='' onchange='updateInputValue(this)'/></td>";
	}
	newTrHTML=newTrHTML+"<td><button id='button-teacher-update' class='button-teacher-update'>确定</button> <button id='button-teacher-delete' class='button-teacher-delete'>删除</button></td></tr>";
	$("#table-teacher-information tbody tr:last").after(newTrHTML);
	//给新生成的按钮添加事件处理
	($("td:has(button:contains('确定')):last")).on("click",".button-teacher-update",function(){
		clickTeacherButtonUpdate(this);
	});
	($("td:has(button:contains('删除')):last")).on("click",".button-teacher-delete",function(){
		clickTeacherButtonDelete(this);
	});
	/*($("td:has(button):last")).on("click",".button-teacher-insert",function(){
		clickTeacherButtonInsert(this);
	});*/
}
/*学生表格按钮*/
function clickStudentButtonUpdate(obj) {
	var id=String(obj.id);
	var parts=id.split("-");
	var tr=$(obj).parent().parent();
	var td=$(tr).find("td");
	if($(obj).text()=="修改"&&parts.length==4){
		// alert(1);
		for (var i = td.length - 2; i >= 0; i--) {
			var origin=td[i].textContent;
			td[i].innerHTML="<input type='text' value='"+origin+"' style='width:98%;' onchange='updateInputValue(this)'/>";
		}
		$(obj).html("确定");
	}else if($(obj).text()=="确定"&&parts.length==4){
		// alert(2);
		for (var i = td.length - 2; i >= 0; i--) {
			var origin=$(td[i].innerHTML).val();
			$(td[i]).html(origin);
		}
		$(obj).html("修改");
	}else if($(obj).text()=="修改"&&parts.length!=4){
		// alert(3);
	}else if($(obj).text()=="确定"&&parts.length!=4){
		// alert(4);
		var id=$(tr).find("input:first").attr("value");
		$(tr).attr("id","table-student-information-tr-"+id);
		$(obj).attr("id","button-student-update-"+id);
		for (var i = td.length - 2; i >= 0; i--) {
			var origin=$(td[i].innerHTML).val();
			td[i].innerHTML=origin;
		}
		$(obj).html("修改");
	}
}	
function clickStudentButtonDelete(obj) {
	var id=String(obj.id);
	var parts=id.split("-");
	var studentNo=parts[parts.length-1];
	if(confirm("确定要删除这条信息吗？")==true){
		alert("删除"+(parts[parts.length-1]));
		//数据库进行删除
			//deleteFromSQL()
		//删除节点
		$(obj).parent().parent().remove();
	}else{
		alert("取消")
	}
}
function clickStudentButtonInsert(obj) {
	var newTrHTML="<tr>";
	var id="";
	for(var i=0;i<7;i++){
		newTrHTML=newTrHTML+"<td><input type='text' style='width:98%;' value='' onchange='updateInputValue(this)'/></td>";
	}
	newTrHTML=newTrHTML+"<td><button id='button-student-update' class='button-student-update'>确定</button> <button id='button-student-delete' class='button-student-delete'>删除</button></td></tr>";
	$("#table-student-information tbody tr:last").after(newTrHTML);
	//给新生成的按钮添加事件处理
	($("td:has(button:contains('确定')):last")).on("click",".button-student-update",function(){
		clickStudentButtonUpdate(this);
	});
	($("td:has(button:contains('删除')):last")).on("click",".button-student-delete",function(){
		clickStudentButtonDelete(this);
	});
}
/*管理员表格按钮*/
function clickManagerButtonUpdate(obj) {
	var id=String(obj.id);
	var parts=id.split("-");
	var tr=$(obj).parent().parent();
	var td=$(tr).find("td");
	if($(obj).text()=="修改"&&parts.length==4){
		// alert(1);
		for (var i = td.length - 2; i >= 0; i--) {
			var origin=td[i].textContent;
			td[i].innerHTML="<input type='text' value='"+origin+"' style='width:98%;' onchange='updateInputValue(this)'/>";
		}
		$(obj).html("确定");

	}else if($(obj).text()=="确定"&&parts.length==4){
		// alert(2);
		var td=$(tr).find("td");
		for (var i = td.length - 2; i >= 0; i--) {
			var origin=$(td[i].innerHTML).val();
			$(td[i]).html(origin);
		}
		$(obj).html("修改");
	}else if($(obj).text()=="修改"&&parts.length!=4){
		// alert(3);
	}else if($(obj).text()=="确定"&&parts.length!=4){
		// alert(4);
		var id=$(tr).find("input:first").attr("value");
		$(tr).attr("id","table-manager-information-tr-"+id);
		$(obj).attr("id","button-manager-update-"+id);
		for (var i = td.length - 2; i >= 0; i--) {
			var origin=$(td[i].innerHTML).val();
			td[i].innerHTML=origin;
		}
		$(obj).html("修改");
	}
}	
function clickManagerButtonDelete(obj) {
	var id=String(obj.id);
	var parts=id.split("-");
	var managerNo=parts[parts.length-1];
	if(confirm("确定要删除这条信息吗？")==true){
		alert("删除"+(parts[parts.length-1]));
		//数据库进行删除
			//deleteFromSQL()
		//删除节点
		$(obj).parent().parent().remove();
	}else{
		alert("取消")
	}
}
function clickManagerButtonInsert(obj) {
	var newTrHTML="<tr>";
	var id="";
	for(var i=0;i<3;i++){
		newTrHTML=newTrHTML+"<td><input type='text' style='width:98%;' value='' onchange='updateInputValue(this)'/></td>";
	}
	newTrHTML=newTrHTML+"<td><button id='button-manager-update' class='button-manager-update'>确定</button> <button id='button-manager-delete' class='button-manager-delete'>删除</button></td></tr>";
	$("#table-manager-information tbody tr:last").after(newTrHTML);
	//给新生成的按钮添加事件处理
	($("td:has(button:contains('确定')):last")).on("click",".button-manager-update",function(){
		clickManagerButtonUpdate(this);
	});
	($("td:has(button:contains('删除')):last")).on("click",".button-manager-delete",function(){
		clickManagerButtonDelete(this);
	});
}
/*课程表格按钮*/
function clickCourseButtonUpdate(obj) {
	var id=String(obj.id);
	var parts=id.split("-");
	var tr=$(obj).parent().parent();
	var td=$(tr).find("td");
	if($(obj).text()=="修改"&&parts.length==4){
		// alert(1);
		for (var i = td.length - 2; i >= 0; i--) {
			var origin=td[i].textContent;
			td[i].innerHTML="<input type='text' value='"+origin+"' style='width:98%;' onchange='updateInputValue(this)'/>";
		}
		$(obj).html("确定");

	}else if($(obj).text()=="确定"&&parts.length==4){
		// alert(2);
		var td=$(tr).find("td");
		for (var i = td.length - 2; i >= 0; i--) {
			var origin=$(td[i].innerHTML).val();
			$(td[i]).html(origin);
		}
		$(obj).html("修改");
	}else if($(obj).text()=="修改"&&parts.length!=4){
		// alert(3);
	}else if($(obj).text()=="确定"&&parts.length!=4){
		// alert(4);
		var id=$(tr).find("input:first").attr("value");
		$(tr).attr("id","table-course-information-tr-"+id);
		$(obj).attr("id","button-course-update-"+id);
		for (var i = td.length - 2; i >= 0; i--) {
			var origin=$(td[i].innerHTML).val();
			td[i].innerHTML=origin;
		}
		$(obj).html("修改");
	}
}
function clickCourseButtonDelete(obj) {
	var id=String(obj.id);
	var parts=id.split("-");
	var managerNo=parts[parts.length-1];
	if(confirm("确定要删除这条信息吗？")==true){
		alert("删除"+(parts[parts.length-1]));
		//数据库进行删除
			//deleteFromSQL()
		//删除节点
		$(obj).parent().parent().remove();
	}else{
		alert("取消")
	}
}
function clickCourseButtonInsert(obj) {
	var newTrHTML="<tr>";
	var id="";
	var prevTr=$(obj).parent().parent().parent().prev().find("tr:last");
	var tdNum=$(prevTr).find("td").length;
	for(var i=0;i<tdNum-1;i++){
		newTrHTML=newTrHTML+"<td><input type='text' style='width:98%;' value='' onchange='updateInputValue(this)'/></td>";
	}
	newTrHTML=newTrHTML+"<td><button id='button-course-update' class='button-course-update'>确定</button> <button id='button-course-delete' class='button-course-delete'>删除</button></td></tr>";
	$("#table-course-information tbody tr:last").after(newTrHTML);
	//给新生成的按钮添加事件处理
	($("td:has(button:contains('确定')):last")).on("click",".button-course-update",function(){
		clickManagerButtonUpdate(this);
	});
	($("td:has(button:contains('删除')):last")).on("click",".button-course-delete",function(){
		clickManagerButtonDelete(this);
	});
}
/*学期表格按钮*/
function clickSemesterButtonUpdate(obj) {
	var id=String(obj.id);
	var parts=id.split("-");
	var tr=$(obj).parent().parent();
	var label=$(tr).find('label.label-semester-info');
	//alert(parts);
	if($(obj).text()=="修改"&&parts.length==4){
		//alert(1);
		for (var i = label.length; i >= 0; i--) {
			var origin=$(label[i]).text();
			console.log(origin);
			$(label[i]).html('<input type="text" value="'+origin+'" onchange="updateInputValue(this)" readonly>');
			if(i!=0){
				var input=$(label[i]).find("input");
				$(input).attr("class","input-semester-date");
				if(i==1){
					$(input).attr("id","input-semester-start-"+parts[3]);
				}else if(i==2){
					$(input).attr("id","input-semester-end-"+parts[3]);
				}
				$(".input-semester-date").datepicker({
					"dateFormat":"yy-mm-dd",
					'changeMonth': true,
					'changeYear': true,
					'monthNamesShort': ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一','十二'],
					'onClose': function(selectDate,currentDate) {
						
					}
				});
				$("#input-semester-start-"+parts[3]).on("change",function(){
					$("#input-semester-end-"+parts[3]).datepicker("option","minDate",$(this).val());
				});
				$("#input-semester-end-"+parts[3]).on("change",function(){
					$("#input-semester-start-"+parts[3]).datepicker("option","maxDate",$(this).val());
				});
			}else{
				var input=$(label[i]).find("input");
				$(input).attr("class","input-semester-name");
				$(input).removeAttr('readonly');
			}
		}
		$(obj).html("确定");
	}else if($(obj).text()=="确定"&&parts.length==4){
		// alert(2);
		var td=$(tr).find("td");
		var label=$(tr).find('label.label-semester-info');
		for (var i = label.length-1; i >= 0; i--) {
			var origin=$(label[i]).find("input").val();
			$(label[i]).html(origin);
		}
		$(obj).html("修改");
	}else if($(obj).text()=="修改"&&parts.length!=4){
		alert(3);
	}else if($(obj).text()=="确定"&&parts.length!=4){
		alert(4);
		// var id=$(tr).find("input:first").attr("value");
		// $(tr).attr("id","table-course-information-tr-"+id);
		// $(obj).attr("id","button-course-update-"+id);
		// for (var i = td.length - 2; i >= 0; i--) {
		// 	var origin=$(td[i].innerHTML).val();
		// 	td[i].innerHTML=origin;
		// }
		$(obj).html("修改");
	}
}
function clickSemesterButtonDelete(obj) {
	var id=String(obj.id);
	var parts=id.split("-");
	var managerNo=parts[parts.length-1];
	if(confirm("确定要删除这条信息吗？")==true){
		alert("删除"+(parts[parts.length-1]));
		//数据库进行删除
			//deleteFromSQL()
		//删除节点
		$(obj).parent().parent().parent().parent().parent().parent().remove();
	}else{
		alert("取消")
	}
}
function clickSemesterButtonInsert(obj) {
	var newTrHTML="<tr>";
	var id="";
	var trHasTable=$(obj).parent().parent().parent().prev().find("tr:has(table):last");
	var lastSemesterTableId=String($(trHasTable).find('table').attr('id'));
	var lastSemesterTableIdParts=lastSemesterTableId.split('-');
	var newSemesterNo=String(parseInt(lastSemesterTableIdParts[lastSemesterTableIdParts.length-1])+1);
	var newSemesterCourseTableHtml='<table id="table-semester-information-tr-table-'+newSemesterNo+'" style="border: 1px solid pink;">'
							+'<thead><tr>'
							+'<th colspan="7" style="border:0;">'
							+'<label style="float: left" class="label-semester-name label-semester-info">'
							+"<input type='text' class='input-semester-name' onchange='updateInputValue(this)'>"
							+'</label>'
							// +'('+semesterObj[i]['semesterStartTime']+'~'+semesterObj[i]['semesterEndTime']+')'
							+"<label style='float: left'>(</label>"
							// +"&nbsp;"
							+'<label style="float: left" class="label-semester-date label-semester-start label-semester-info">'
							+"<input type='text' class='input-semester-date input-semester-start' onchange='updateInputValue(this)' readonly>"
							+'</label>'
							+"<label style='float: left'>~</label>"
							+'<label style="float: left" class="label-semester-date label-semester-end label-semester-info">'
							+"<input type='text' class='input-semester-date input-semester-end' onchange='updateInputValue(this)' readonly>"
							+'</label>'
							+"<label style='float: left'>)</label>"
							+'</th><td colspan="2"><button id="button-semester-setCurrent-'+newSemesterNo+'" class="button-semester-setCurrent">设为当前学期</button></td>'
							+'<td colspan="1">'
							+'<button id="button-semester-update-'+newSemesterNo+'" class="button-semester-update">确定</button>'
							+' <button id="button-semester-delete-'+newSemesterNo+'" class="button-semester-delete">删除</button>'
							+'</td></tr></thead>'
							+'<tbody><tr>'
							+'<th style="width: 5em;">课程号</th>'
							+'<th style="width: 10em;">课程名</th>'
							+'<th style="width: 10em;">开课学院</th>'
							+'<th style="width: 7em;">分类</th>'
							+'<th style="width: 5em;">教师号</th>'
							+'<th style="width: 10em;">教师名</th>'
							+'<th style="width: 3em;">开课周</th>'
							+'<th style="width: 4em;">预期人数</th>'
							+'<th style="width: 4em;">实际人数</th>'
							+'<th style="width: 7em;">操作</th>'
							+'</tr></tbody>'
							+'<tfoot><tr>'
							+'<td colspan="10" align="right" style="border: 0;">'
							+'<button id="button-semester-course-insert-'+newSemesterNo+'" class="button-semester-course-insert">添加课程</button>'
							+'</td></tr></tfoot>';
	$(trHasTable).after("<tr><td>"+newSemesterCourseTableHtml+"</td></tr>");
	$(trHasTable).next().attr('id',"table-semester-information-tr-"+newSemesterNo);
	$(".input-semester-date").datepicker({
		"dateFormat":"yy-mm-dd",
		'changeMonth': true,
		'changeYear': true,
		'monthNamesShort': ['一月','二月','三月','四月','五月','六月','七月','八月','九月','十月','十一','十二'],
		'onClose': function(selectDate,currentDate) {	
		}
	});
	$(".input-semester-start").on("change",function(){
		$(".input-semester-end").datepicker("option","minDate",$(this).val());
	});
	$(".input-semester-end").on("change",function(){
		$(".input-semester-start").datepicker("option","maxDate",$(this).val());
	});
	//给新生成的按钮添加事件处理
	$("#table-semester-information-tr-"+newSemesterNo+" .button-semester-setCurrent").click(function() {
		clickSemesterButtonSetCurrent(this);
	});
	$("#table-semester-information-tr-"+newSemesterNo+" .button-semester-update").click(function() {
		clickSemesterButtonUpdate(this);
	});
	$("#table-semester-information-tr-"+newSemesterNo+" .button-semester-delete").click(function() {
		clickSemesterButtonDelete(this);
	});
	$('#button-semester-course-insert-'+newSemesterNo).click(function() {
		clickSemesterCourseButtonInsert(this);
	});
	
}
function clickSemesterButtonSetCurrent(obj){
	var id=$(obj).attr("id");
	var parts=id.split("-");
	var semesterNo=parts[parts.length-1];
	alert("设置当前学期为："+semesterNo+"、"+$(obj).parent().parent().find("th label:first").text());
	//设置当前学期
}
function clickSemesterCourseButtonUpdate(obj) {
	// alert('clickSemesterCourseButtonUpdate');
	var id=String(obj.id);
	var parts=id.split("-");
	var tr=$(obj).parent().parent();
	var td=$(tr).find("td");
	if($(obj).text()=="修改"&&parts.length==5){
		// alert(1);
		$(td[4]).html("<select id='semester-course-teacher' class='semester-course-teacher'></select>");
		//初始化选项
		getTeacherOption($(td[4]).find("select.semester-course-teacher"));
		$(td[6]).html("<input type='text' style='width:90%;' value='"+$(td[6]).text()+"' onchange='updateInputValue(this)'>");
		$(td[7]).html("<input type='text' style='width:90%;' value='"+$(td[7]).text()+"' onchange='updateInputValue(this)'>");
		$(obj).html("确定");

	}else if($(obj).text()=="确定"&&parts.length==5){
		// alert(2);
		var selectedTeacherObj=JSON.parse($(td[4]).find("select option:selected").val());
		$(td[4]).html(selectedTeacherObj['teacherNo']);
		$(td[5]).html(selectedTeacherObj['teacherName']);
		$(td[6]).html($(td[6]).find("input").val());
		$(td[7]).html($(td[7]).find("input").val());
		$(obj).html("修改");
	}else if($(obj).text()=="修改"&&parts.length!=5){
		alert(3);
	}else if($(obj).text()=="确定"&&parts.length!=5){
		// alert(4);
		var selectedCourseObj=JSON.parse($(td[0]).find("select option:selected").val());
		$(td[0]).html(selectedCourseObj['courseNo']);
		$(td[1]).html(selectedCourseObj['courseName']);
		$(td[2]).html(selectedCourseObj['courseAcademy']);
		$(td[3]).html(selectedCourseObj['courseCategory']);

		var selectedTeacherObj=JSON.parse($(td[4]).find("select option:selected").val());
		$(td[4]).html(selectedTeacherObj['teacherNo']);
		$(td[5]).html(selectedTeacherObj['teacherName']);
		
		$(td[6]).html($(td[6]).find("input").val());
		$(td[7]).html($(td[7]).find("input").val());
		
		$(obj).attr("id",$(obj).attr("id")+"-"+selectedCourseObj['courseNo']);
		$(obj).next().attr("id",$(obj).next().attr("id")+"-"+selectedCourseObj['courseNo']);
		$(obj).html("修改");
	}
}
function clickSemesterCourseButtonDelete(obj) {
	var id=String(obj.id);
	var parts=id.split("-");
	var managerNo=parts[parts.length-1];
	if(confirm("确定要删除这条信息吗？")==true){
		alert("删除"+(parts[parts.length-1]));
		//数据库进行删除
			//deleteFromSQL()
		//删除节点
		$(obj).parent().parent().remove();
	}else{
		alert("取消")
	}
}
function clickSemesterCourseButtonInsert(obj) {
	// alert('clickSemesterCourseButtonInsert');
	var newTrHTML="<tr>";
	var id="";
	var prevTr=$(obj).parent().parent().parent().prev().find("tr:last");
	var tdNum=$(prevTr).find("td,th").length;
	for(var i=0;i<tdNum-1;i++){
		newTrHTML=newTrHTML+"<td></td>";
	}
	newTrHTML=newTrHTML+"<td><button id='button-semester-course-update' class='button-semester-course-update'>确定</button> <button id='button-semester-course-delete' class='button-semester-course-delete'>删除</button></td></tr>";
	$(prevTr).after(newTrHTML);
	//给新生成的按钮添加事件处理
	$(prevTr.next()).on("click",".button-semester-course-update",function(){
		clickSemesterCourseButtonUpdate(this);
	});
	($(prevTr.next())).on("click",".button-semester-course-delete",function(){
		// alert('clickSemesterCourseButtonDelete');
		clickSemesterCourseButtonDelete(this);
	});
	var newTr=$(prevTr).next();
	var td=$(newTr).find('td');
	$(td[0]).html("<select id='semester-course-course' class='semester-course-course'></select>");
	getCourseOption($(td[0]).find("select"));

	$(td[4]).html("<select id='semester-course-teacher' class='semester-course-teacher'></select>");
	getTeacherOption($(td[4]).find("select"));
	$(td[6]).html("<input type='text' style='width:90%;' value='"+$(td[6]).text()+"' onchange='updateInputValue(this)'>");
	$(td[7]).html("<input type='text' style='width:90%;' value='"+$(td[7]).text()+"' onchange='updateInputValue(this)'>");
	//$(obj).html("确定");

}
$(document).ready(function(){
	//默认为教师信息
	// getTeacherInformation();
	getSemesterInformation();
	($(".button-teacher-update")).click(function(){
		clickTeacherButtonUpdate(this);
	});
	($(".button-teacher-delete")).click(function(){
		clickTeacherButtonDelete(this);
	});
	($(".button-teacher-insert")).click(function(){
		clickTeacherButtonInsert(this);
	});

	($("#teacherInformation")).click(function(){
		getTeacherInformation();
	});

	($("#studentInformation")).click(function(){
		getStudentInformation();
	});

	($("#courseInformation")).click(function(){
		getCourseInformation();
	});

	($("#semesterInformation")).click(function(){
		getSemesterInformation();
	});
	($("#managerInformation")).click(function(){
		getManagerInformation();
	});
});
function getStudentInformation() {
	$.ajax({
		url:'http://localhost:8080/TeachingAffairSystem/ManagerAction!getStudent',
		type:'get',
		dataType:'html',
		timeout:1000,
		error:function(){
			alert("错误");
		},
		success:function(studentInfo){
			var studentObj=JSON.parse(studentInfo);
			var studentHtml='<div id="div-student"><table id="table-student-information" cellspacing="0"><thead><tr><th colspan="8" style="border:0;font-size: 1.2em;font-weight: bold;"><span style="float: left;">学生信息</span></th></tr></thead><tbody><tr><th style="width: 5em;">学号</th><th style="width: 8em;">姓名</th><th style="width: 3em;">性别</th><th style="width: 10em;">学院</th><th style="width: 5em;">专业</th><th style="width: 2em;">班级</th><th style="width: 16em;">密码</th><th style="width: 7em;">操作</th></tr>';
			var trHtml="";
			for(var i=0;i<studentObj.length;i++){
				trHtml=trHtml+"<tr id='table-student-information-tr-"+studentObj[i].studentNo+"'>";
				trHtml=trHtml+"<td>"+studentObj[i].studentNo+"</td>";
				trHtml=trHtml+"<td>"+studentObj[i].studentName+"</td>";
				trHtml=trHtml+"<td>"+studentObj[i].sex+"</td>";
				trHtml=trHtml+"<td>"+studentObj[i].studentAcademy+"</td>";
				trHtml=trHtml+"<td>"+studentObj[i].studentMajor+"</td>";
				trHtml=trHtml+"<td>"+studentObj[i].studentClass+"</td>";
				trHtml=trHtml+"<td>"+studentObj[i].password+"</td>";
				trHtml=trHtml+"<td><button id='button-student-update-"+studentObj[i].studentNo+"' class='button-student-update'>修改</button> <button id='button-student-delete-"+studentObj[i].studentNo+"' class='button-student-delete'>删除</button></td>"+"</tr>";
			}
			studentHtml=studentHtml+trHtml+'</tbody><tfoot><tr><td colspan="8" align="right" style="border: 0;"><button id="button-student-insert" class="button-student-insert">添加学生</button></td></tr></tfoot></table></div>';
			$("#div-main-right").html(studentHtml);
			//给新生成的按钮添加事件处理
			($("td:has(button:contains('修改'))")).on("click",".button-student-update",function(){
				clickStudentButtonUpdate(this);
			});
			($("td:has(button:contains('删除'))")).on("click",".button-student-delete",function(){
				clickStudentButtonDelete(this);
			});
			($("tfoot td")).on("click",".button-student-insert",function(){
				clickStudentButtonInsert(this);
			});
		}
	});
}
function getTeacherInformation() {
	$.ajax({
		url:'http://localhost:8080/TeachingAffairSystem/ManagerAction!getTeacher',
		type:'get',
		dataType:'html',
		timeout:1000,
		error:function(){
			alert("错误");
		},
		success:function(teacherInfo){
			//alert(teacherInfo);
			var teacherHtml='<div id="div-teacher"><table id="table-teacher-information" cellspacing="0"><thead><tr><th colspan="8" style="border:0;font-size: 1.2em;font-weight: bold;"><span style="float: left;">教师信息</span></th></tr></thead><tbody><tr><th style="width: 5em;">教师号</th><th style="width: 8em;">姓名</th><th style="width: 3em;">性别</th><th style="width: 10em;">学院</th><th style="width: 4em;">职称</th><th style="width: 10em;">邮箱</th><th style="width: 16em;">密码</th><th style="width: 7em;">操作</th></tr>';
			var teacherObj = JSON.parse(teacherInfo);
			var trHtml="";
			for(var i=0;i<teacherObj.length;i++){
				trHtml=trHtml+"<tr id='table-teacher-information-tr-"+teacherObj[i].teacherNo+"'>";
				trHtml=trHtml+"<td>"+teacherObj[i].teacherNo+"</td>";
				trHtml=trHtml+"<td>"+teacherObj[i].teacherName+"</td>";
				trHtml=trHtml+"<td>"+teacherObj[i].sex+"</td>";
				trHtml=trHtml+"<td>"+teacherObj[i].teacherAcademy+"</td>";
				trHtml=trHtml+"<td>"+teacherObj[i].teacherTitle+"</td>";
				trHtml=trHtml+"<td>"+teacherObj[i].teacherEmail+"</td>";
				trHtml=trHtml+"<td>"+teacherObj[i].password+"</td>";
				trHtml=trHtml+"<td><button id='button-teacher-update-"+teacherObj[i].teacherNo+"' class='button-teacher-update'>修改</button> <button id='button-teacher-delete-"+teacherObj[i].teacherNo+"' class='button-teacher-delete'>删除</button></td>"+"</tr>";
			}
			teacherHtml=teacherHtml+trHtml+'</tbody><tfoot><tr><td colspan="8" align="right" style="border: 0;"><button id="button-teacher-insert" class="button-teacher-insert">添加教师</button></td></tr></tfoot></table></div>';
			$("#div-main-right").html(teacherHtml);
			//给新生成的按钮添加事件处理
			($("td:has(button:contains('修改'))")).on("click",".button-teacher-update",function(){
				clickTeacherButtonUpdate(this);
			});
			($("td:has(button:contains('删除'))")).on("click",".button-teacher-delete",function(){
				clickTeacherButtonDelete(this);
			});
			($("tfoot td")).on("click",".button-teacher-insert",function(){
				clickTeacherButtonInsert(this);
			});
		}
	});
}
function getCourseInformation() {
	$.ajax({
		url:'http://localhost:8080/TeachingAffairSystem/ManagerAction!getCourse',
		type:'get',
		dataType:'html',
		timeout:1000,
		error:function(){
			alert("错误");
		},
		success:function(courseInfo){
			var courseObj=JSON.parse(courseInfo);
			var courseHtml='<div id="div-course"><table id="table-course-information" cellspacing="0"><thead><tr><th colspan="5" style="border: 0;font-size: 1.2em;font-weight: bold;"><span style="float: left;">课程信息</span></th></tr></thead><tbody><tr><th style="width: 5em;">课程号</th><th style="width: 8em;">课程名</th><th style="width: 10em;">开课学院</th><th style="width: 7em;">分类</th><th style="width: 7em;">操作</th></tr>';
			var trHtml="";
			for(var i=0;i<courseObj.length;i++){
				trHtml=trHtml+"<tr id='table-course-information-tr-"+courseObj[i].courseNo+"'>";
				trHtml=trHtml+"<td>"+courseObj[i].courseNo+"</td>";
				trHtml=trHtml+"<td>"+courseObj[i].courseName+"</td>";
				trHtml=trHtml+"<td>"+courseObj[i].courseAcademy+"</td>";
				trHtml=trHtml+"<td>"+courseObj[i].courseCategory+"</td>";
				trHtml=trHtml+"<td><button id='button-course-update-"+courseObj[i].courseNo+"' class='button-course-update'>修改</button> <button id='button-course-delete-"+courseObj[i].courseNo+"' class='button-course-delete'>删除</button></td>"+"</tr>";
			}
			courseHtml=courseHtml+trHtml+'</tbody><tfoot><tr><td colspan="5" align="right" style="border: 0;"><button id="button-course-insert" class="button-course-insert">添加课程</button></td></tr></tfoot></table></div>';
			$("#div-main-right").html(courseHtml);
			//给新生成的按钮添加事件处理
			($("td:has(button:contains('修改'))")).on("click",".button-course-update",function(){
				clickCourseButtonUpdate(this);
			});
			($("td:has(button:contains('删除'))")).on("click",".button-course-delete",function(){
				clickCourseButtonDelete(this);
			});
			($("tfoot tr td")).on("click",".button-course-insert",function(){
				clickCourseButtonInsert(this);
			});
		}
	});
}
function getSemesterInformation() {
	$.ajax({
		url:'http://localhost:8080/TeachingAffairSystem/ManagerAction!getSemester',
		type:'get',
		dataType:'html',
		timeout:10000,
		error:function(){
			alert("错误");
		},
		success:function(semesterInfo){
			var semesterObj=JSON.parse(semesterInfo);
			var semesterHtml='<div id="div-semester">'
				+'<table id="table-semester-information" cellspacing="0">'
				+'<thead><tr><th colspan="1" style="border: 0;font-size: 1.2em;font-weight: bold;"><span style="float: left;">学期信息</span></th></tr></thead>'
				+'<tbody></tbody>'
				+'<tfoot><tr><td colspan="1" align="right" style="border: 0;"><button id="button-semester-insert" class="button-semester-insert">添加学期</button></td></tr></tfoot>'
				+'</table></div>';
			
			$("#div-main-right").html(semesterHtml);
			var tbody=$("#div-main-right table tbody:first");
			for(var i=0;i<semesterObj.length;i++){
				var semesterNo=semesterObj[i]['semesterNo'];
				if($('#table-semester-information-tr-table-'+String(semesterNo)).length===0){
					$(tbody).append("<tr id='table-semester-information-tr-"+semesterNo+"'><td></td></tr>");
					var newSemesterCourseTableHtml='<table id="table-semester-information-tr-table-'+semesterNo+'" style="border: 1px solid pink;">'
							+'<thead><tr>'
							+'<th colspan="7" style="border:0;">'
							+'<label style="float: left" class="label-semester-name label-semester-info">'+semesterObj[i]['semesterName']+'</label>'
							// +'('+semesterObj[i]['semesterStartTime']+'~'+semesterObj[i]['semesterEndTime']+')'
							+"<label style='float: left'>(</label>"
							// +"&nbsp;"
							+'<label style="float: left" class="label-semester-date label-semester-start label-semester-info">'+semesterObj[i]['semesterStartTime']+'</label>'
							+"<label style='float: left'>~</label>"
							+'<label style="float: left" class="label-semester-date label-semester-end label-semester-info">'+semesterObj[i]['semesterEndTime']+'</label>'
							+"<label style='float: left'>)</label>"
							+'</th><td colspan="2"><button id="button-semester-setCurrent-'+semesterNo+'" class="button-semester-setCurrent">设为当前学期</button></td>'
							+'<td colspan="1">'
							+'<button id="button-semester-update-'+semesterNo+'" class="button-semester-update">修改</button>'
							+' <button id="button-semester-delete-'+semesterNo+'" class="button-semester-delete">删除</button>'
							+'</td></tr></thead>'
							+'<tbody><tr>'
							+'<th style="width: 5em;">课程号</th>'
							+'<th style="width: 10em;">课程名</th>'
							+'<th style="width: 10em;">开课学院</th>'
							+'<th style="width: 7em;">分类</th>'
							+'<th style="width: 5em;">教师号</th>'
							+'<th style="width: 10em;">教师名</th>'
							+'<th style="width: 3em;">开课周</th>'
							+'<th style="width: 4em;">预期人数</th>'
							+'<th style="width: 4em;">实际人数</th>'
							+'<th style="width: 7em;">操作</th>'
							+'</tr></tbody>'
							+'<tfoot><tr>'
							+'<td colspan="10" align="right" style="border: 0;">'
							+'<button id="button-semester-course-insert-'+semesterNo+'" class="button-semester-course-insert">添加课程</button>'
							+'</td></tr></tfoot>';
					$(tbody).find("tr:last td").append(newSemesterCourseTableHtml);
					$("#button-semester-course-insert-"+semesterNo).click(function(){
						clickSemesterCourseButtonInsert(this);
					});
				}
				var newTrHtml="<tr id='table-semester-course-information-tr-"+semesterObj[i]['courseNo']+"'>"
						+"<td>"+semesterObj[i]['courseNo']+"</td>"
						+"<td>"+semesterObj[i]['courseName']+"</td>"
						+"<td>"+semesterObj[i]['courseAcademy']+"</td>"
						+"<td>"+semesterObj[i]['courseCategory']+"</td>"
						+"<td>"+semesterObj[i]['teacherNo']+"</td>"
						+"<td>"+semesterObj[i]['teacherName']+"</td>"
						+"<td>"+semesterObj[i]['startWeek']+"-"+semesterObj[i]['endWeek']+"</td>"
						+"<td>"+semesterObj[i]['expectNum']+"</td>"
						+"<td>"+semesterObj[i]['actualNum']+"</td>"
						+"<td>"
						+'<button id="button-semester-course-update-'+semesterObj[i]['courseNo']+'" class="button-semester-course-update">修改</button>'
						+'<button id="button-semester-course-delete-'+semesterObj[i]['courseNo']+'" class="button-semester-course-delete">删除</button>'
						+"</td></tr>";
				$('#table-semester-information-tr-table-'+String(semesterNo)+' tbody').append(newTrHtml);
				$("#button-semester-course-update-"+semesterObj[i]['courseNo']).click(function(){
					clickSemesterCourseButtonUpdate(this);
				});
				$("#button-semester-course-delete-"+semesterObj[i]['courseNo']).click(function(){
					clickSemesterCourseButtonDelete(this);
				});
			}
			//为新生成的按钮添加事件处理
			$("td td:has(button:contains('修改').button-semester-update)").on("click",".button-semester-update",function(){
				clickSemesterButtonUpdate(this);
			});
			$("td td:has(button:contains('删除').button-semester-delete)").on("click",".button-semester-delete",function(){
				clickSemesterButtonDelete(this);
			});
			$("td td:has(button:contains('设为当前学期').button-semester-setCurrent)").on("click",".button-semester-setCurrent",function () {
				clickSemesterButtonSetCurrent(this);
			});
			$("td:has(button:contains('添加学期').button-semester-insert)").on("click",".button-semester-insert",function(){
				clickSemesterButtonInsert(this);
			});
			// ($("td:has(button:contains('修改'))")).on("click",".button-semester-update",function(){
			// 	clickCourseButtonUpdate(this);
			// });
			// ($("td:has(button:contains('删除'))")).on("click",".button-semester-delete",function(){
			// 	clickCourseButtonDelete(this);
			// });
			// ($("tfoot tr td")).on("click",".button-semester-insert",function(){
			// 	clickCourseButtonInsert(this);
			// });
		}
	});
}
function getManagerInformation() {
	$.ajax({
		url:'http://localhost:8080/TeachingAffairSystem/ManagerAction!getManager',
		type:'get',
		dataType:'html',
		timeout:1000,
		error:function(){
			alert("错误");
		},
		success:function(managerInfo){
			var managerObj=JSON.parse(managerInfo);
			var managerHtml='<div id="div-manager"><table id="table-manager-information" cellspacing="0"><thead><tr><th colspan="4" style="border: 0;font-size: 1.2em;font-weight: bold;"><span style="float: left;">管理员信息</span></th></tr></thead><tbody><tr><th style="width: 2em;">编号</th><th style="width: 10em;">用户名</th><th style="width: 16em;">密码</th><th style="width: 7em;">操作</th></tr>';
			var trHtml="";
			for(var i=0;i<managerObj.length;i++){
				trHtml=trHtml+"<tr id='table-manager-information-tr-"+managerObj[i].managerNo+"'>";
				trHtml=trHtml+"<td>"+managerObj[i].managerNo+"</td>";
				trHtml=trHtml+"<td>"+managerObj[i].username+"</td>";
				trHtml=trHtml+"<td>"+managerObj[i].password+"</td>";
				trHtml=trHtml+"<td><button id='button-manager-update-"+managerObj[i].managerNo+"' class='button-manager-update'>修改</button> <button id='button-manager-delete-"+managerObj[i].managerNo+"' class='button-manager-delete'>删除</button></td>"+"</tr>";
			}
			managerHtml=managerHtml+trHtml+'</tbody><tfoot><tr><td colspan="4" align="right" style="border: 0;"><button id="button-manager-insert" class="button-manager-insert">添加管理员</button></td></tr></tfoot></table></div>';
			$("#div-main-right").html(managerHtml);
			//给新生成的按钮添加事件处理
			($("td:has(button:contains('修改'))")).on("click",".button-manager-update",function(){
				clickManagerButtonUpdate(this);
			});
			($("td:has(button:contains('删除'))")).on("click",".button-manager-delete",function(){
				clickManagerButtonDelete(this);
			});
			($("tfoot td")).on("click",".button-manager-insert",function(){
				clickManagerButtonInsert(this);
			});
		}
	});
}

function getCourseOption(obj) {
	$.ajax({
		url:'http://localhost:8080/TeachingAffairSystem/ManagerAction!getCourseOption',
		type:'get',
		dataType:'html',
		timeout:10000,
		error:function(){
			alert("错误");
		},
		success:function(courseInfo) {
			var courseObj=JSON.parse(courseInfo);
			$(obj).parent().next().html("");
			for(var i=0;i<courseObj.length;i++){
				// alert(String(JSON.stringify(courseObj[i])));
				$(obj).append('<option value=\''+String(JSON.stringify(courseObj[i]))+'\'>'+courseObj[i]['courseNo']+'-'+courseObj[i]['courseName']+"</option>");
				$(obj).find("option:last").click(function () {
					// alert($(this).val());
					var selectedCourseObj=JSON.parse($(this).val());
					var td=$(obj).parent().parent().find("td");
					$(td[1]).html(selectedCourseObj['courseName']);
					$(td[2]).html(selectedCourseObj['courseAcademy']);
					$(td[3]).html(selectedCourseObj['courseCategory']);
				});
			}
		}
	});
}
function getTeacherOption(obj) {
	$.ajax({
		url:'http://localhost:8080/TeachingAffairSystem/ManagerAction!getTeacherOption',
		type:'get',
		dataType:'html',
		timeout:10000,
		error:function(){
			alert("错误");
		},
		success:function(teacherInfo) {
			var teacherObj=JSON.parse(teacherInfo);
			$(obj).parent().next().html("");
			for(var i=0;i<teacherObj.length;i++){
				$(obj).append('<option value=\''+JSON.stringify(teacherObj[i])+'\'>'+teacherObj[i]['teacherNo']+'-'+teacherObj[i]['teacherName']+"</option>");
				$(obj).find("option:last").click(function () {
					var selectedTeacherObj=JSON.parse($(this).val());
					$(this).parent().parent().next().html(selectedTeacherObj['teacherName']);
				});
			}
		}
	});
}
//JSON数据查找
function searchInJson(key,val,obj) {
	for(var i=0;i<obj.length;i++){
		if(val==obj[i][key]){
			return i;
			break;
		}
	}
	return -1;
}