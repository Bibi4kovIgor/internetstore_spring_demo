<html>
    <head>
        <title>Products List</title>
        <link rel="stylesheet" href="../css/style.css">
    </head>
    <body>
        <div id = "header">
            <h2>
                Internet-store Products
            </h2>
        </div>

        <div id="content">

          <br/>
          <table class="datatable">
            <tr>
                <th>name</th>  <th>email</th> <th>phone</th>
            </tr>
            <#list model["productList"] as product>
                <tr>
                    <td>${product.name}</td> <td>${product.price}</td> <td>${product.description}</td>
                </tr>
            </#list>
          </table>

        </div>

        <div id="footer">

        </div>
    </body>
</html>