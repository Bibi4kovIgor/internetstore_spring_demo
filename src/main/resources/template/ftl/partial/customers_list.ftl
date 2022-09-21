<#macro customers>
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
</#macro>