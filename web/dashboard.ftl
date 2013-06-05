<!DOCTYPE html>
<html>
<head>
  <title>kindergartens</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
  <link href="css/kindergarten.css" rel="stylesheet" media="screen">

  <style type="text/css">
    body {
      padding-top: 20px;
      padding-bottom: 40px;
    }

      /* Custom container */
    .container-narrow {
      margin: 0 auto;
      max-width: 700px;
    }

    .container-narrow > hr {
      margin: 30px 0;
    }

      /* Main marketing message and sign up button */
    .jumbotron {
      margin: 60px 0;
      text-align: center;
    }

    .jumbotron h1 {
      font-size: 72px;
      line-height: 1;
    }

    .jumbotron .btn {
      font-size: 21px;
      padding: 14px 24px;
    }

      /* Supporting marketing content */
    .marketing {
      margin: 60px 0;
    }

    .marketing p + h4 {
      margin-top: 28px;
    }
  </style>
</head>

<body>

<div class="container-narrow">

  <div class="masthead">
    <ul class="nav nav-pills pull-right">
      <li><a href="/registration">Register child</a></li>
      <li><a href="/logout">Log out</a></li>
    </ul>
    <h3 class="muted">Kindergartens</h3>
    <h4 class="muted parent">Parent: ${person_code}</h4>
  </div>

  <div class="row-fluid marketing">
    <div class="span6">
      <h4>Tallinna Lindakivi Lasteaed</h4>
      <p>Place: 112 / 126</p>

      <h4>Tallinna Arbu Lasteaed</h4>
      <p>Place: 89 / 100</p>

      <h4>Tallinna Lasteaed Kirsike</h4>
      <p>Place: 70 / 100</p>
    </div>
  </div>

  <hr>

  <div class="footer">
    <#--<p>&copy; Andrei Solntsev 2013</p>-->
    <img src="img/kindergarten.gif" width="300px"/>
  </div>

</div>

<script src="js/jquery-2.0.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>