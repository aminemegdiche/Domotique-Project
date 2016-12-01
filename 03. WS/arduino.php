<?php
   

 
// array for JSON response
$response = array();


// include db connect class
require_once __DIR__ . '/db_connect.php';


// connecting to db
$db = new DB_CONNECT();

 @$id=$_GET['id_chmbre'];
   $temp=$_GET['temp'];
    $humi=$_GET['humi'];  

mysql_query("UPDATE `rooms` SET `temp_rm`=".$temp.",`himu_rm`=".$humi." where `id_rm`=".$id);



 $result = mysql_query("select * from  lampe where id_rm=".$id) or die(mysql_error());

 
if (mysql_num_rows($result) > 0)
 {
      
     $row = mysql_fetch_array($result) ;
      
        echo "<equip>".$row["etat_lampe"]."</equip>";
            echo "<pin>".$row["pin_lampe"]."</pin>";
            echo"";

		}

    $result = mysql_query("select * from  climatiseur where id_rm=".$id) or die(mysql_error());

 
if (mysql_num_rows($result) > 0)
 {
      
     $row = mysql_fetch_array($result) ;
      
        echo "<equip>".$row["etat_clima"]."</equip>";
            echo "<pin>".$row["pin_clima"]."</pin>";
            echo"";

    }
        $result = mysql_query("select * from  shutter where id_rm=".$id) or die(mysql_error());

 
if (mysql_num_rows($result) > 0)
 {
      
     $row = mysql_fetch_array($result) ;
      
        echo "<equip>".$row["etat"]."</equip>";
            echo "<pin>".$row["pin_shutter"]."</pin>";
            echo"";

    }

    
   
 
 
 
?>
