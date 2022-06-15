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

<?php

//reads the connection data from the my_db_credentials.php file in the same directory.
require_once 'my_db_credentials.php';

//Attempt to connect to the database.
$connection="host=".DB_SERVER." port=5432 dbname=".DB_BASE."
user=".DB_USER." password=".DB_PASS." options='--client_encoding=UTF8'";
$dbconn = pg_connect($connection);

//check if db connection is successful. If it isn't, then the program closes the connection by throwing a connection error.
if (!$dbconn) {
 die("Connection to the database has failed: " . pg_connect_error());
}

$fetchUserData = false;
$searchingForEmail = "";

if($_SERVER["REQUEST_METHOD"] == "POST"){
    //sql query that inserts a new user to the db schema
    $sql = "INSERT INTO users(fullname, address, country, postalcode, email, telephone, cardtype, cardno, expirationdate, cardsecuritycode, cardholdername) VALUES
    ('".$_POST['fullname']."','".$_POST['address']."','".$_POST['country']."','".$_POST['postalcode']."','".$_POST['email']."','".$_POST['telephone']."','".$_POST['cardType']."','".$_POST['cardNo']."','".$_POST['expirationDate']."','".$_POST['cardSecurityCode']."','".$_POST['cardHolderName']."') ";
} else {
    //sql query to get all users that have the email that matches the search input field
    $sql = "SELECT * FROM users WHERE email='".$_GET['search_email']."';";
    $fetchUserData = true;
    $searchingForEmail = $_GET['search_email'];
}


// this line prints the sql query in the browser tab.
// it is commented out because it is used for debugging purposes.
//echo $sql;

//execute query to the database
$result = pg_query($dbconn, $sql) ;

if($fetchUserData){
    //prints all user data to browser

    //pg_num_rows returns how many rows are there from an sql query
    $countResults = pg_num_rows($result);
    if($countResults > 0){
        echo '<div class="container" padding-left:50px; padding-right:50px;<br>
                <div id="departures_table">
                    <div>';

                        echo '<p class="description" style="text-align: center;">';
                        echo "<strong>Βρέθηκαν ".$countResults." χρήστες</strong> αποθηκευμένοι με e-mail ".$searchingForEmail."</p>";
                    echo ' </div>
                    <table style="width:100%; padding-top:32px; text-align: center;">
                        <tr>
                        <th>Ονοματεπώνυμο</th>
                        <th>Διεύθυνση</th>
                        <th>Χώρα</th>
                        <th>Ταχ.Κωδικας</th>
                        <th>E-mail</th>
                        <th>Τηλέφωνο</th>
                        <th>Τύπος Κάρτας</th>
                        <th>Αριθμός Κάρτας</th>
                        <th>Ημ. Λήξης</th>
                        <th>Όνομα Δικαιούχου</th></tr>';

    while($row = pg_fetch_array($result)){
        //echo json_encode($row);

        //masking cards and letting visible only the last 4 digits
        $maskedCardNo = '************' . substr($row['cardno'], - 4);

        // Creating timestamp from given date
        $timestamp = strtotime($row['expirationdate']);

        // Creating new date format from that timestamp
        $new_date = date("d-m-Y", $timestamp);
        

        echo("<tr>
        <td>".$row['fullname']."</td>
        <td>".$row['address']."</td>
        <td>".$row['country']."</td>
        <td>".$row['postalcode']."</td>
        <td>".$row['email']."</td>
        <td>".$row['telephone']."</td>
        <td>".$row['cardtype']."</td>
        <td>".$maskedCardNo."</td>
        <td>".$new_date."</td>
        <td>".$row['cardholdername']."</td></tr>");
    }
    echo('</table></div></div>');
    } else {
        echo '<div class="container" padding-left:50px; padding-right:50px;<br>';
        echo '<p class="description" style="text-align: center;">';
        echo "<strong>Δεν βρέθηκαν</strong> αποθηκευμένοι χρήστες με e-mail ".$searchingForEmail.". <strong>Δοκιμάστε ξανά!</strong></p>";
        echo('</div>');
    }

    
} else {
    //notifies if the insert sql query has been successful
    if ($result) {
        echo '<div class="container" padding-left:50px; padding-right:50px;<br>';

        echo '<p class="description" style="text-align: center;">';
        echo "Ο χρήστης έχει αποθηκευτεί επιτυχώς στη βάση δεδομένων.";
        echo('</div>');
    } else {
        echo '<div class="container" padding-left:50px; padding-right:50px;<br>';

        echo '<p class="description" style="text-align: center;">';
        echo "Υπήρξε κάποιο σφάλμα κατα την αποθήκευση των στοιχείων στη βάση δεδομένων. Δοκιμάστε ξανά";
        echo('</div>');
    }
}

//close database connection to avoid leaks
pg_close($dbconn);
?>

<!--Footer-->

<div class="footer">
            <p class="footer_text">Stathis Airlines και...<strong>Καλό σας Ταξίδι!</strong></p>

            <a href="#airlines_logo"><img class="footer_go_up_btn" src="img/icons/ic_go_to_top.png" alt="go_to_top_btn" style="width:42px;height:42px;"></a>

            <p class="developed_by">Developed by Stathis Karadimitriou as a part of the Web Development Course at University of Piraeus, 2022</p>
        </div>
    </body>
</html>