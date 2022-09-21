<#import "../layouts/main.ftl" as layout>
<@layout.page>
    <fieldset>
        <legend>Add Customer</legend>
        <form name="LogIn" action="/login" method="post">
            First Name : <input type="text" name="firstName" />	<br/>
            Last Name : <input type="text" name="lastName" />	<br/>
            Email: <input type="text" name="email" />	<br/>
            Phone: <input type="text" name="phoneNumber" />	<br/>
            <input type="submit" value="   Save   " />
        </form>
    </fieldset>

    <br/>

    <#import "../partial/customers_list.ftl" as customersList>
    <@customersList.customers />
</@layout.page>