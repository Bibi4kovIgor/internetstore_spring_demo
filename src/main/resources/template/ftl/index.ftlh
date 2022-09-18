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
                <th>first_name</th> <th>last_name</th>  <th>email</th> <th>phone</th>
            </tr>
            <#list model["customerList"] as customer>
                <tr>
                    <td>${customer.firstName}</td> <td>${customer.lastName}</td> <td>${customer.email}</td> <td>${customer.phoneNumber}</td>
                </tr>
            </#list>
          </table>

        </div>

        <div id="footer">

        </div>
    </body>
</html>