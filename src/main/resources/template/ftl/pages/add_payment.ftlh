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
</@layout.page>