
<?php 
  session_start(); 
  $currentArgID = intval($_GET["arg"]); 
  $_SESSION['returnToArg']= $currentArgID; /*TODO This session variable won't pass for some reason*/
?>

<!DOCTYPE html>
<html>
<head>
  <title>Collective Dialectic Database</title>
  <meta charset="utf-8"/>
  <meta name="keywords" content="arguments, dialectic, formalize, anti-troll, discussion, debate"/>
  <meta name="copyright" content="Copyright 2015 Craig Danz Seattle, WA USA">  
  <meta name="robots" content="follow"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!-- This meta viewport tag 
                        right here is gonna save you a future headache. It's the thing that "convinces your 
                        phone that it's a phone". Without it, this page would appear desktop when loaded on 
                        your phone browser. This fixes it. -->
  <link rel="stylesheet" href="http://localhost:8888/style_CDDb.css">
  <script src="jquery-3.3.1.min.js"></script>
</head>
                      <!-- End Header -->
<body>
<div class="row-1">
  <div class="header">
    <section 
      style=" 
        color: white;
        font-size: 1rem;
        position: absolute;
        bottom: .2rem;
        text-align: right;
      ">
      <a href="login.php?arg=<?php echo $_SESSION['returnToArg'];?>">Login</a> 
    </section> <!--TODO link floats down when window narrows - fix -->
  </div>
  
  <div class="because">
    <section 
      style=" 
        font-size: 120%;
        color: white;
        background-color:var(--cddbBlue);
        padding-left: .5rem;   
        padding-bottom: .5rem;    
      ">
      <table border='0' width='100%'><tr><td>
      <strong>Because...</strong>
    </td><td style="width:10%; min-width:100px;">
        <?php if($_SESSION['opinion'] > 0){ ?> 
            <form action='functions.php' method="POST">
              <button type="submit" class="button weighBecause" name="buttonClicked" value="weighBecause">Weigh In</button> 
            </form>
    <?php } ?>
    </td></tr>
    </table>
    </section>
    <section 
      style="padding-left: .5rem;">
    <?php 
      $endorseType = 'Because';
      $baseURL = "http://localhost:8888/CDDb_working.php";
      include('display_associated.php');
    ?>
  </section>
  </div>

</div>

<!-- You can add multiple classes to a div. Just separate them by a space. -->
<!-- Just like this here ▼ -->
<div class="container1 argu-butt">

  <div class="argument">
    <section 
      style=" 
        font-size: 120%;
        color: white;
        background-color:var(--cddbBlack);
        padding-left: .5rem;   
        padding-bottom: .5rem;    
      ">
      <table border='0' width='100%'> <tr><td><strong><?php echo "Argument: " . intval($_GET["arg"])?>      <?php if($_SESSION['opinion'] > 0){ ?>
        <span style="color: #10a020; font-size: 1.5rem;">&#x2714;</span>
      <?php } ?>
      <?php if($_SESSION['opinion'] < 0){ ?>
        <span style="color: #af1a17; font-size: 1.5rem;">&#x2718;</span>
      <?php } ?></br></strong>
    
    <!--Green check or Red X-->


    </td>

    <td style="width:20%; min-width:160px;">

    <!-- Learning to add a responsive button -->

    <?php if($_SESSION['opinion'] == 0){ ?>
      <div class="btn-group">
            <form action='functions.php' method="POST">
              <button type="submit" class="button acAvail" name="buttonClicked" value="accept">Accept</button> 
            </form>
            <form action='functions.php' method="POST">
              <button type="submit" class="button reAvail" name="buttonClicked" value="reject">Reject</button> 
            </form>
      </div>
    <?php } ?>



    <?php if($_SESSION['opinion'] > 0){ ?>
      <div class="btn-group">
            <button type="submit" class="button acSet" name="buttonClicked" value="accept">Accepted</button> 
            <form action='functions.php' method="POST">
              <button type="submit" class="button reAvail" name="buttonClicked" value="reject">Reject</button> 
            </form>
      </div>
    <?php } ?>

    <?php if($_SESSION['opinion'] < 0){ ?>
      <div class="btn-group">
            <form action='functions.php' method="POST">
              <button type="submit" class="button acAvail" name="buttonClicked" value="accept">Accept</button> 
            </form>

        <button type="submit" class="button reSet" name="buttonClicked" value="reject">Rejected</button> 
      </div>
    <?php } ?>
    </td></tr></table>
    </section>
    <section 
      style="padding-left: .5rem;">


<!-- End of button test -->
    <div class="argRow1">
      <div class="argContain1">
        <?php echo "$rate"; ?>%
      </div>
      <div class="argContain2">
        <?php
    print_r($_SESSION);
        ?>
      </div>
    </div>
    <div class="argRow2">
      <div class="argContain3">
        <?php
          require_once('argument_at_hand.php');
           echo $rate;//changed from include()
        ?>
      </div>
    </div>
    <div class="argRow3">
      <div class="argContain4">
        D
      </div>
      <div class="argContain5">
        <br>
        <br>
        <br>
        <br>
            <?php if($_SESSION['opinion'] > 0 && isset($_SESSION['profile'])){ ?>
            <form action='functions.php' method="POST">
              <button type="submit" class="button alter" name="buttonClicked" value="improve">Improve</button> 
            </form>
    <?php } ?>
      </div>
    </div>

    </section>
    <!--  Ball test  -->
    <table>
      <tr>
        <td>

        </td>
      </tr>
    </table>

  </div>

  <div class="rebuttal">
    <section 
      style=" 
        font-size: 120%;
        color: white;
        background-color:var(--cddbRed);
        padding-left: .5rem;   
        padding-bottom: .5rem;    
      ">
     <table border='0' width='100%'><tr><td>
      <strong>Rebuttal</strong>
    </td><td style="width:10%; min-width:100px;">
        <?php if($_SESSION['opinion'] < 0){ ?> 
            <form action='functions.php' method="POST">
              <button type="submit" class="button weighRebuttal" name="buttonClicked" value="weighRebuttal">Weigh In</button> 
            </form>
    <?php } ?>
    </td></tr>
    </table>
    </section>
 
    <section 
      style="padding-left: .5rem; background-color:white;">
    <?php
      $endorseType = 'Rebuttal';
      $baseURL = "http://localhost:8888/CDDb_working.php";
      include('display_associated.php');
    ?>
    </section>
  </div>
  
  
</div> <!-- End Main Div -->

<!--Row 3 -->

<div class="container2 so-tags">
  <div class="so">

    <section 
      style=" 
        font-size: 120%;
        color: white;
        background-color:var(--cddbGreen);
        padding-left: .5rem;   
        padding-bottom: .5rem;    
      ">
      <table border='0' width='100%'><tr><td>
      <strong>Therefore...</strong>
    </td><td style="width:10%; min-width:100px;">
        <?php if($_SESSION['opinion'] > 0){ ?> 
            <form action='functions.php' method="POST">
              <button type="submit" class="button weighSo" name="buttonClicked" value="weighSo">Weigh In</button> 
            </form>
    <?php } ?>
    </td></tr>
    </table>
    </section>
    <section 
      style="padding-left: .5rem;">
    <?php
       $endorseType = 'Therefore';
      $baseURL = "http://localhost:8888/CDDb_working.php";
      include('display_associated.php');
    ?>
  </div>



    <div class="tags">    
      <section 
      style=" 
        font-size: 120%;
        color: white;
        background-color:#0e0e0e;
        padding-left: .5rem;   
        padding-bottom: .5rem;    
      ">
      <strong>Filters</strong>
    </section>
    <section 
      style="padding-left: .5rem;">
    <table>
      <tr><td><strong>Groups</strong></td><td>Affiliations, organizing bodies.</td></tr>
      <tr><td><strong>Topics</strong></td><td>Exposition tagged for specificity.</td></tr>
      <tr><td><strong>Positions</strong></td><td>Cross-reference other opinons.</td></tr>
    </table>
    </section>
  </div>
</div>
</div>

</body>
</html>
