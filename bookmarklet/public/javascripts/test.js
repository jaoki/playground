(function(){
	var body = document.getElementsByTagName('body') [0];
	var divGray = document.createElement('div');
	var windowHeight = window.innerHeight;
	var windowWidth = window.innerWidth;
	divGray.setAttribute("style","background-color: gray; height:" + windowHeight + "px;width:" + windowWidth + "px;" + "position:absolute;top:0;left:0;opacity:0.5;z-index:999;");

	var vgiframe = document.createElement('iframe');
	vgiframe.setAttribute("id", "videogramit_iframe");
	vgiframe.setAttribute("name", "hs1346279057044");
	vgiframe.setAttribute("frameborder", "0");
	vgiframe.setAttribute("key", "0");
	vgiframe.setAttribute("style", "width: 400px; height: 547px;z-index:1000;");
	vgiframe.setAttribute("onload", "if (hs.expanders[0]) hs.expanders[0].contentLoaded()");
	vgiframe.setAttribute("src", "http://www.videogram.com/upload/");

// <iframe name="hs1346279057044" frameborder="0" key="0" style="width: 400px; height: 547px; " onload="if (hs.expanders[0]) hs.expanders[0].contentLoaded()" src="http://www.videogram.com/upload/"></iframe>

	divGray.appendChild(vgiframe);


	body.appendChild(divGray);
	var yturl = document.getElementById("videogramit_iframe").contentWindow.getElementById("yturl");
	yturl.value =window.location.href;

})()

