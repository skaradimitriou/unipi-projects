/**
 * This file is responsible for the three button click events.
 * 
 * First Btn alerts the data that his data has been saved successfully.
 * Second Btn clears all input fields from the Personal Details & Payment Method Forms
 * Third Btn prompts the user to print his data.
 */

function validateUserInput(){
    let fullName = document.getElementById("fullName").value;
    let address = document.getElementById("address").value;
    let country = document.getElementById("country").value;
    let postalCode = document.getElementById("postalCode").value;
    let email = document.getElementById("email").value;
    let telephone = document.getElementById("telephone").value;
    
    var paymentCardType = "";
    if(document.getElementById("payment_type_visa").checked == true){
        paymentCardType = "Visa";
    } else if (document.getElementById("payment_type_mastercard").checked == true){
        paymentCardType = "Mastercard";
    } else if(document.getElementById("payment_type_other").checked == true){
        paymentCardType = "Άλλο";
    }

    let cardNo = document.getElementById("card_no").value;
    let cardExpireDate = document.getElementById("card_expire_date").value;
    let cardSecurityCode = document.getElementById("card_security_code").value;
    let cardHolderName = document.getElementById("card_holder_name").value;

    let fullNameVerified = validateField(fullName,"fullName");
    let addressVerified = validateField(address,"address");
    let countryVerified = validateField(country, "country");
    let postalCodeVerified = validatePostalCode(postalCode);
    let emailValidated = validateEmail(email);
    let phoneValidated = validateTelephone(telephone);

    let paymentTypeVerified = validatePaymentType(paymentCardType);
    let cardNoVerified = validateField(cardNo, "card_no");
    let cardExpireDateVerified = validateField(cardExpireDate, "card_expire_date");
    let cardSecurityCodeVerified = validateField(cardSecurityCode, "card_security_code");
    let cardHolderNameVerified = validateField(cardHolderName, "card_holder_name");

    let allFieldsFilled = checkIfAllFieldsAreFilled();
    
    if(fullNameVerified && addressVerified && countryVerified && postalCodeVerified && emailValidated && phoneValidated && 
        paymentTypeVerified && cardNoVerified && cardExpireDateVerified && cardSecurityCodeVerified && cardHolderNameVerified && allFieldsFilled){
        saveUserData();
    } else {
        console.log("Error while saving data");   
    }
}

function saveUserData() {
    let fullName = document.getElementById("fullName").value;
    let address = document.getElementById("address").value;
    let country = document.getElementById("country").value;
    let postalCode = document.getElementById("postalCode").value;
    let email = document.getElementById("email").value;
    let telephone = document.getElementById("telephone").value;

    var paymentCardType = "";
    if(document.getElementById("payment_type_visa").checked == true){
        paymentCardType = "Visa";
    } else if (document.getElementById("payment_type_mastercard").checked == true){
        paymentCardType = "Mastercard";
    } 

    let cardNo = document.getElementById("card_no").value;
    let cardExpireDate = document.getElementById("card_expire_date").value;
    let cardSecurityCode = document.getElementById("card_security_code").value;
    let cardHolderName = document.getElementById("card_holder_name").value;

    alert("Τα στοιχεία σας αποθηκεύθηκαν επιτυχώς στο σύστημα.");
    logPersonalDetails(fullName, address, country, postalCode, email, telephone, paymentCardType, cardNo, cardExpireDate, cardSecurityCode, cardHolderName);
    clearFields();
}

function logPersonalDetails(fullname, address, country, postalCode, email, telephone, paymentCardType, cardNo, cardExpireDate, cardSecurityCode, cardHolderName){
    console.log("Personal Details:");
    console.log("Full Name:" + " " + fullname);
    console.log("Address:" + " " + address);
    console.log("Country:" + " " + country);
    console.log("Postal Code:" + " " + postalCode);
    console.log("Email:" + " " + email);
    console.log("Telephone:" + " " + telephone);
    
    console.log("Payment Details:")
    console.log("Card Type:" + " " + paymentCardType);
    console.log("Card Number:" + " " + cardNo);
    console.log("Card Expire Date:" + " " + cardExpireDate);
    console.log("Card Security Code:" + " " + cardSecurityCode);
    console.log("Card Holder Name:" + " " + cardHolderName);
}

function checkIfAllFieldsAreFilled(){
    let fullName = document.getElementById("fullName").value;
    let address = document.getElementById("address").value;
    let country = document.getElementById("country").value;
    let postalCode = document.getElementById("postalCode").value;
    let email = document.getElementById("email").value;
    let telephone = document.getElementById("telephone").value;

    var paymentCardType = "";
    if(document.getElementById("payment_type_visa").checked == true){
        paymentCardType = "Visa";
    } else if (document.getElementById("payment_type_mastercard").checked == true){
        paymentCardType = "Mastercard";
    } 

    let card_no = document.getElementById("card_no").value;
    let card_expire_date = document.getElementById("card_expire_date").value;
    let card_security_code = document.getElementById("card_security_code").value;
    let card_holder_name = document.getElementById("card_holder_name").value;

    if(isFilled(fullName) && isFilled(address) && isFilled(country) && isFilled(postalCode) && isFilled(email) && isFilled(telephone) &&
    isFilled(paymentCardType) && isFilled(card_no) && isFilled(card_expire_date) && isFilled(card_security_code) && isFilled(card_holder_name)){
         return true;
    } else {
        return false;
    }
}

function isFilled(field){
    return field.length != 0;
}

/*
 * This method clears all input fields from the Personal Details & Payment Method Forms.
 */

function clearFields(){
    document.getElementById("fullName").value = "";
    document.getElementById("address").value = "";
    document.getElementById("country").value = "Ελλάδα";
    document.getElementById("postalCode").value = "";
    document.getElementById("email").value = "";
    document.getElementById("telephone").value = "";

    document.getElementById("payment_type_visa").checked = false;
    document.getElementById("payment_type_mastercard").checked = false;
    document.getElementById("card_no").value = "";
    document.getElementById("card_expire_date").value = "";
    document.getElementById("card_security_code").value = "";
    document.getElementById("card_holder_name").value = "";
}

/* 
 * Opens the print dialog in the default browser
 */

function openPrintDialog(){
    console.log("user is prompted to print dialog");
    window.print();
}

/**
 * Other helper functions
 */

function containsOnlyLatinChars(fieldName){
    let field =  document.getElementById(fieldName).value;

    const reg = new RegExp('^[a-zA-Z]+$');
    if(field != ""){
        if(!(reg.test(field))){
            alert("Το πεδίο αυτό θα πρέπει να περιέχει μόνο Λατινικούς χαρακτήρες.");
            document.getElementById(fieldName).value = "";
            document.getElementById(fieldName).placeholder = "Το πεδίο θα πρέπει να περιέχει μόνο Λατινικούς χαρακτήρες.";
            document.getElementById(fieldName).style = "border:1px solid red;";
        } else {
            document.getElementById(fieldName).style = "border:none";
        }
    }
}

function validateField(inputTxt, fieldName){
    if(inputTxt.length != 0){
        document.getElementById(fieldName).style = "border:1px solid green;";
        return true;
    } else {
        alert("Το πεδίο" + " " + fieldName + " " + "είναι κενό");
        document.getElementById(fieldName).style = "border:1px solid red;";
        document.getElementById(fieldName).placeholder = "Το πεδίο δεν πρέπει να είναι άδειο";
        return false;
    }
}

function validatePaymentType(paymentCardType){
    if(paymentCardType == ""){
        alert("Επίλεξτε μια απο τις 3 επιλογές για τον τύπο της κάρτας σας");
        document.getElementById("payment_type_error").innerHTML = "Επίλεξτε μια απο τις 3 επιλογές για τον τύπο της κάρτας σας";
        document.getElementById("payment_type_error").style = "color: red; font-family: 'Roboto', sans-serif; font-size:12px;";
        return false;
    } else {
        document.getElementById("payment_type_error").innerHTML = "";
        return true;
    }
}

function validatePostalCode(postalCode){
    if(postalCode.length == 5){
        document.getElementById("postalCode").style = "border:1px solid green;";
        return true;
    } else {
        alert("Το πεδίο του ΤΚ δεν μπορεί να είναι κενό.");
        document.getElementById("postalCode").value = "";
        document.getElementById("postalCode").placeholder = "Ο ταχυδρομικός κώδικας πρεπει να αποτελειται απο 5 ψηφία";
        document.getElementById("postalCode").style = "border:1px solid red;";
        return false;
    }
}

function validateEmail(email){
    if(email != "" || email != undefined){
        if(email.includes('@')){
            document.getElementById("email").style = "border:1px solid green;";
            return true;
        } else {
            alert("Το email θα πρεπει να ειναι της μορφής name@domain.gr");
            document.getElementById("email").placeholder = "Το e-mail δεν πρέπει να είναι άδειο και θα πρέπει να περιέχει το '@'.";
            document.getElementById("email").style = "border:1px solid red;";
            return false;
        }
    }
}

function validateTelephone(telephone){
    let prefix = "+30210"
    if(telephone != "" || telephone != undefined){
        if(telephone.startsWith(prefix)){
            document.getElementById("telephone").style = "border:1px solid green;";
            return true;
        } else {
            alert("Το τηλέφωνο θα πρέπει να ξεκινάει με +30210 και να ακολουθούν τα ψηφία του σταθερού σας τηλεφώνου.");
            document.getElementById("telephone").style = "border:1px solid red;";
            document.getElementById("telephone").placeholder = "Το τηλέφωνο δεν πρέπει να είναι άδειο και θα πρέπει να ξεκινάει με '+30210'.";
            return false;
        }
    }
}

function validateCardNo(){
    let cardNo = document.getElementById("card_no").value;
    const reg = new RegExp('^[0-9]+$');

    if(cardNo != ""){
        if (!(reg.test(cardNo))){
            alert("Ο αριθμός της κάρτας σας θα πρέπει να αποτελείται απο αριθμούς (0-9).");
            document.getElementById("card_no").value = "";
        }
    }
}

function validateCVV(){
    let cvv = document.getElementById("card_security_code").value;
    const reg = new RegExp('^[0-9]+$');

    if(cvv != ""){
        if (!(reg.test(cvv))){
            alert("Ο κωδικός ασφαλείας θα πρέπει να αποτελείται απο αριθμούς (0-9).");
            document.getElementById("card_security_code").value = "";
        }
    }
}