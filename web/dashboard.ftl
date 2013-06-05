<!DOCTYPE html>
<html>
<head>
  <title>kindergartens</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
  <link href="css/kindergarten.css" rel="stylesheet" media="screen">
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

  <#list childrenStates as childState>
    <hr/>
    <h5 class="muted child">Child: ${childState.childCode}</h5>
    <#list childState.queues as queue>
      <div class="row-fluid">
        <div class="span6 kindergarten">
          <p>${queue.kindergarten.name}</p>
        </div>
        <div class="span3 position" style="text-align: right; vertical-align: text-bottom;">
          <p>Place: ${queue.position}</p>
        </div>
      </div>
    </#list>
  </#list>

  <hr>

  <div class="footer">
    <img src="img/kindergarten.gif" width="300px"/>
  </div>

</div>

<script src="js/jquery-2.0.2.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>