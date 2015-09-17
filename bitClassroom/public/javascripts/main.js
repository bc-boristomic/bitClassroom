/**
 * Created by NN on 14.9.2015.
 */


function checkEmail() {
    var email = document.getElementById("inputEmail").value;
    var filter = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i;


    if (!filter.test(email)) {
        document.getElementById("emailError").innerHTML = "Invalid E-mail.";
    } else {
        document.getElementById("emailError").innerHTML = "";
    }
}


function checkNameInput() {


    var firstName = document.getElementById("inputName").value;
    var filter = /^[a-zA-Z]+$/;


    if (firstName.length == 0) {
        document.getElementById("nameError").innerHTML = "This field is required";
    } else {


        if (!filter.test(firstName)) {
            document.getElementById("nameError").innerHTML = "Only letters allowed.";
        } else  if (firstName.length < 3){
            document.getElementById("nameError").innerHTML = "Nick name is short";
        }else{

            document.getElementById("nameError").innerHTML = "";
        }
    }
}

function checkLastNameInput() {


    var firstName = document.getElementById("inputLName").value;
    var filter = /^[a-zA-Z]+$/;


    if (firstName.length == 0) {
        document.getElementById("lastNameError").innerHTML = "This field is required";
    } else {


        if (!filter.test(firstName)) {
            document.getElementById("lastNameError").innerHTML = "Only letters allowed.";
        } else  if (firstName.length < 3){
            document.getElementById("lastNameError").innerHTML = "Nick name is short";
        }else{

            document.getElementById("lastNameError").innerHTML = "";
        }
    }
}



function checkPassword() {
        var password = document.getElementById("inputPassword1").value;


         if (password.length == 0) {
                 document.getElementById("passError").innerHTML = "This field is required";
             } else {




                 if (password.length < 6) {
                         document.getElementById("passError").innerHTML = "Password must have at least 6 characters.";
                     } else if (password.search(/\d/) == -1) {
                         document.getElementById("passError").innerHTML = "Password must have at least one number.";
                     } else if (password.search(/[a-zA-Z]/)) {
                         document.getElementById("passError").innerHTML = "Password must have at least one letter.";
                     } else if (password.length > 6 && !password.search(/[a-zA-Z]/) && password.search(/\d/) != -1) {
                         document.getElementById("passError").innerHTML = "";
                     }
             }
}


function checkPasswords() {
          var password = document.getElementById("inputPassword1").value;
          var repassword = document.getElementById("inputPassword").value;

              if (password != repassword) {
                 document.getElementById("repassError").innerHTML = "Password must be same.";
             } else {
                 document.getElementById("repassError").innerHTML = "";
              }
}

function checkPhone(){


        var phone = document.getElementById("home-phone").value;
        var filter = /^[a-zA-Z]+$/;

        if ( phone.length <10 || phone.length > 15){
            document.getElementById("phoneCheck").innerHTML = "Enter correct form of phone number[ +387******** ]";
        }else if (filter.test(phone)){
            document.getElementById("phoneCheck").innerHTML = "Enter only numbers";

        }else if(phone.length >=10 && phone.length<=15 && !filter.test(phone)){

            document.getElementById("phoneCheck").innerHTML = "";
        }

}

function checkMobilePhone(){


    var phone = document.getElementById("home-phone").value;
    var filter = /^[a-zA-Z]+$/;


    if ( phone.length <10 || phone.length > 15){
        document.getElementById("phoneCheck").innerHTML = "Enter correct form of phone number[ +387******** ]";
    }else if (filter.test(phone)){
        document.getElementById("mobilePhoneCheck").innerHTML = "Enter only numbers";

    }else if(phone.length >=10 && phone.length<=15 && !filter.test(phone)){

        document.getElementById("mobilePhoneCheck").innerHTML = "";
    }

}

function checkSkypeName(){

    var skypeName = document.getElementById("skype").value;
    var filter = /^[a-zA-Z]+$/;

    if ( skypeName.length < 3){

        document.getElementById("skypeCheck").innerHTML = "Too short";

    }else if (skypeName >= 3 ||  filter.test(skypeName)){
        document.getElementById("skypeCheck").innerHTML =  "";
    }

}

function checkFacebook(){

    var facebook = document.getElementById("facebook").value;

    if ( facebook == null){

        facebook.val("http://www.facebook.com/");
    }else if ( facebook.length < 28){

        document.getElementById("facebookCheck").innerHTML = " Wrong URL, please enter valid URL";
    }else if ( facebook.length >= 28) {

        document.getElementById("facebookCheck").innerHTML = "";
    }



}



