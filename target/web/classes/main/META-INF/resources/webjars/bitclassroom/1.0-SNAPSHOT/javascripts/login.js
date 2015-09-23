function checkEmail(email){
	if(email !== undefined){	
	   var atposition = email.indexOf("@");
	   var dotposition = email.lastIndexOf(".");	
	}
	
	if(atposition < 1 || dotposition < atposition + 2 || dotposition + 2 >= email.length){

			return false;

		}
	return true;
}

function popitup(url) {
	newwindow=window.open(url,'name','height=200,width=150');

	if (window.focus) {
		newwindow.focus()
	}

	return false;
}


