<!DOCTYPE html>
<html>
<head>
  <title>Children's gardens</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">

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
    <#--
          <li class="active"><a href="#">Home</a></li>
          <li><a href="#">About</a></li>
    -->
      <li><a href="/registration">Register child</a></li>
      <li><a href="/logout">Log out</a></li>
    </ul>
    <h3 class="muted">Children's gardens</h3>
    <h4 class="muted parent">Parent: ${person_code}</h4>
  </div>

<#--
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
-->

  <hr>

  <#if childrenPositions?size=0><div class="no-children"> You have no children yet. Do something!</div></#if>
  <#list childrenPositions?keys as childCode>
    <div class="row-fluid marketing">
      <div class="span6 child_code">
        <h4>${childCode}</h4>
      </div>

      <div class="span6">
        <#assign childPositions = childrenPositions[childCode]>
        <#list childPositions as childPosition>
          <h4 class="garden">${childPosition.garden.name}</h4>
          <p class="place">Place: ${childPosition.place} / ${childPosition.queueSize}</p>
        </#list>
      </div>
    </div>
  </#list>

  <hr>

  <div class="footer">
    <p>&copy; Andrei Solntsev 2013</p>
  </div>

</div>

<script src="js/jquery-2.0.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>