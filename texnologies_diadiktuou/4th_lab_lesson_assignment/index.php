<!DOCTYPE html>
<html>
    <meta charset="utf-8">
    <head>
        <link rel="stylesheet" href="styles.css">
        <script type="text/javascript" src="scripts.js"></script>

        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Roboto&display=swap" rel="stylesheet">

        <title>Home - Third HTML Assignment - S.Karadimitriou</title>
        <link rel="icon" type="image/x-icon" href="img/icons//stathis_airlines_logo_white.png">
    </head>

    <body>
        <!-- Home Banner -->

        <div class="airlines_promo_banner home_banner">
            <div id="airlines_logo" class="top_bar_bg">
                <div>
                    <a href="index.php">
                        <img class="stathis_airlines_logo" src="img/icons/stathis_airlines_logo_white.png" alt="stathis_airlines_logo_sm"/>
                    </a>
                </div>
            </div>

            <p class="promo_banner_title">Stathis Airlines</p>
            <p class="promo_banner_desc">Αναζήτησε τα στοιχεία σου</p>

            <!-- Search User data by user email -->
            <div id="search_by_mail">
                <form method="get" action="contact.php">
                    <input id="search_email" name="search_email" type="email" placeholder="Εισάγετε το e-mail σας για να δείτε τα δεδομένα σας..."><br>
               
                    <input class="promo_banner_btn btn_link" type="submit" value="Αναζήτηση">
                </form>

                
                <input class="promo_banner_btn_clean" type="button"  onclick="clearSearchBox()" value="Καθαρισμός">
            </div>
        </div>

        <div class="container" style="height:750px; padding-left:50px; padding-right:50px;">
                    <form method="post" action="contact.php">
                    
                        <!-- Left section of the Form -->
                        <div class="contact_form_inner" style="float:left; width:47%; margin-right:10px;">
                            <p class="header">Προσωπικές Πληροφορίες</p>
                            <hr class="divider">
                            <label>Ονοματεπώνυμο Επιβάτη</label><br>
                            <input id="fullname" name="fullname" type="text" oninput="containsOnlyLatinChars('fullname')" placeholder="Εισάγετε το ονοματεπώνυμο σας"><br>

                            <label>Διεύθυνση</label><br>
                            <input id="address" name="address" type="text" oninput="containsOnlyLatinChars('address')" placeholder="Εισάγετε τη διέθυνση σας"><br>
        
                            <label>Χώρα</label><br>
                            <select name="country" id="country">
                                <option value="Ελλάδα" name="country">Ελλάδα</option>
                                <option value="Αγγλία" name="country">Αγγλία</option>
                                <option value="Ισπανία" name="country">Ισπανία</option>
                                <option value="Ολλανδία" name="country">Ολλανδία</option>
                                <option value="Γερμανία" name="country">Γερμανία</option>
                                <option value="Γαλλία" name="country">Γαλλία</option>
                            </select>

                            <br>

                            <label>Ταχυδρομικός Κώδικας</label><br>
                            <input id="postalcode" name="postalcode" type="text" maxlength="5" placeholder="Εισάγετε τον ταχυδρομικό κώδικα σας"><br>

                            <label>E-mail Επικοινωνίας</label><br>
                            <input id="email" name="email" type="email" placeholder="Εισάγετε το e-mail σας.."><br>
        
                            <label>Τηλέφωνο Επικοινωνίας</label><br>
                            <input id="telephone" name="telephone" type="tel" maxlength="13" placeholder="Πληκτρολογήστε το τηλέφωνο σας..."><br>
                        </div>

                        <!-- Right section of the Form -->
                        <div class="contact_form_inner" style="float:right; width:47%;">
                            <p class="header">Στοιχεία Πληρωμής</p>
                            <hr class="divider">

                            <br>

                            <label>Επιλογή Τύπου Κάρτας</label><br>
                            <div style="margin-top: 8px; margin-bottom: 30px; ">
                                <input id="payment_type_visa" type="radio" id="visa" name="cardType" value="Visa">
                                <label for="visa">Visa</label>
                                <input id="payment_type_mastercard" style="margin-left: 50px;" type="radio" id="mastercard" name="cardType" value="MasterCard">
                                <label for="mastercard">MasterCard</label>
                                <input id="payment_type_other" style="margin-left: 50px;" type="radio" id="other" name="cardType" value="MasterCard">
                                <label for="mastercard">Άλλο</label><br>
                                <p id="payment_type_error"></p>
                            </div>

                            <label>Αριθμός Κάρτας</label><br>
                            <input id="cardNo" name="cardNo" type="text" maxlength="16" oninput="validateCardNo()" placeholder="Εισάγετε τον αριθμό της κάρτας σας"><br>
                        

                            <label>Ημερομηνία Λήξης</label><br>
                            <input id="expirationDate" name="expirationDate" type="date" maxlength="8" placeholder="Εισάγετε την ημερομηνία λήξης της κάρτας σας"><br>

                            <label>CVV</label><br>
                            <input id="cardSecurityCode" name="cardSecurityCode" type="text" maxlength="3" oninput="validateCVV()" placeholder="Εισάγετε τον κωδικό ασφαλείας της κάρτας σας"><br>

                            <label>Όνομα Δικαιούχου</label><br>
                            <input id="cardHolderName" name="cardHolderName" type="text" maxlength="30"placeholder="Εισάγετε το όνομα του Δικαιούχου"><br>

                            <input id="submit_btn" type="submit" class="form_btn_save" value="Αποθήκευση">
                            <input type="button" class="form_btn_clean" onclick="clearFields()" value="Καθαρισμός">
                            <input type="button" class="form_btn_print" onclick="openPrintDialog()" value="Εκτύπωση">
                        </div>
                    </form>
        </div>

        <!--Footer-->

        <div class="footer">
            <p class="footer_text">Stathis Airlines και...<strong>Καλό σας Ταξίδι!</strong></p>

            <a href="#airlines_logo"><img class="footer_go_up_btn" src="img/icons/ic_go_to_top.png" alt="go_to_top_btn" style="width:42px;height:42px;"></a>

            <p class="developed_by">Developed by Stathis Karadimitriou as a part of the Web Development Course at University of Piraeus, 2022</p>
        </div>
    </body>
</html>