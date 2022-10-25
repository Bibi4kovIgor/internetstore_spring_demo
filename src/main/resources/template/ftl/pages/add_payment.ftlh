<#import "../layouts/main.ftl" as layout>
<@layout.page>
    <fieldset>
        <legend>Add Payment</legend>
        <form name="AddPayment" action="/add_payment" method="post">
            First Name : <input type="text" name="firstName" />	<br/>
            Last Name : <input type="text" name="lastName" />	<br/>
            Email: <input type="text" name="email" />	<br/>
            Phone: <input type="text" name="phoneNumber" />	<br/>
            <input type="submit" value="   Save   " />
        </form>
    </fieldset>
    <table class="datatable">
        <tr>
            <th>Id</th>  <th>Payment Account</th> <th>phone</th>
        </tr>
        <#list model["paymentList"] as payment>
            <tr>
                <td>${payment.id}</td> <td>${payment.account}</td>
            </tr>
        </#list>
    </table>
</@layout.page>