function update(btn){
	//$(btn).parent().parent().find("td");
	//修改按钮的父元素td
	var btn_td = $(btn).parent();
	var upass_td = btn_td.prev();
	var uname_td = upass_td.prev();
	//获取帐号密码 对应td的内容
	var username = uname_td.html();
	var password = upass_td.html();
	//修改帐号密码td的子元素为输入框
	uname_td.html("<input type='text' value='"+username+"'>");
	upass_td.html("<input type='text' value='"+password+"'>");
	//删除JS的点击事件
	$(btn).removeAttr("onclick");
	$(btn).html("保存");
	$(btn).click(save);
	//字符串的定义格式 
	//"<input type='text' value='"+username+"'>"
	//字符串的表现格式
	//<input type='text' value='qiaofeng'>
}
/**
 * 
 * @returns
 */
function save(){
	//根据点击的保存按钮, 寻找到父元素td
	var btn_td = $(this).parent();
	//寻找按钮父元素的前一个兄弟, 找到密码父元素td
	var upass_td = btn_td.prev();
	//根据密码父元素的前一个兄弟 ,找到帐号父元素td
	var uname_td = upass_td.prev();
	//根据帐号父元素td , 寻找前一个兄弟元素ID的父元素
	var id_td = uname_td.prev();
	
	//得到id数据
	var xid = id_td.html();
	//得到用户新输入的帐号内容
	var xusername = uname_td.find("input").val();
	//得到用户新输入的密码内容
	var xpassword = upass_td.find("input").val();
	
	//更改浏览器地址 , 用来提交服务器
	window.location.href="update.do?id="+xid+"&username="+xusername+"&password="+xpassword;
	
}