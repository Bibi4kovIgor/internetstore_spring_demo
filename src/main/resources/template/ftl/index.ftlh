<html>
    <head>
        <title>Freemarker simple</title>
        <link rel="stylesheet" href="../css/style.css">
    </head>
    <body>
        <div id = "header">
            <h2>
                Internet-store demo
            </h2>
        </div>

        <div id="content">

          <fieldset>
            <legend>Add Person</legend>
          <form name="LogIn" action="add" method="post">
            Name : <input type="text" name="name" />	<br/>
            Email: <input type="text" name="email" />	<br/>
            Phone: <input type="text" name="phone" />	<br/>
            <input type="submit" value="   Save   " />
          </form>
          </fieldset>

          <br/>
          <table class="datatable">
            <tr>
                <th>name</th>  <th>email</th> <th>phone</th>
            </tr>
            <#list model["personList"] as person>
                <tr>
                    <td>${person.name}</td> <td>${person.email}</td> <td>${person.phoneNumber}</td>
                </tr>
            </#list>
          </table>

        </div>

        <div id="footer">

        </div>
    </body>
</html>