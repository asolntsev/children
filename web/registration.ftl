<!DOCTYPE html>
<html>
<head>
  <title>kindergartens</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">
  <link href="css/kindergarten.css" rel="stylesheet" media="screen">

</head>
<body>
<div class="container">

  <form class="form-signin" method="post">
    <h2 class="form-signin-heading">Child person code</h2>
    <input name="child_code" type="text" class="input-block-level" placeholder="Person code" autofocus="">

    <#list [1, 2, 3] as priority>
      -- Choose the kindergarten #${priority} -- <br/>
    </#list>
    <button class="btn btn-large btn-primary" type="submit">Register</button>
  </form>

</div>

<script src="http://code.jquery.com/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
</body>
</html>