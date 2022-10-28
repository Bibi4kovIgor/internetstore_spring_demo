<#import "../layouts/main.ftl" as layout>
<@layout.page>
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
</@layout.page>