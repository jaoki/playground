(function(){
	var body = document.getElementsByTagName('body') [0];
	var divGray = document.createElement('div');
	var windowHeight = window.innerHeight;
	var windowWidth = window.innerWidth;
	divGray.setAttribute("style","background-color: gray; height:" + windowHeight + "px;width:" + windowWidth + "px;");

	body.appendChild(divGray);
	alert("aaab");
})()

