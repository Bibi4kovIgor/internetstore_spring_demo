<#import "../layouts/main.ftl" as layout>
<@layout.page>
    <fieldset>
        <legend>Add Customer</legend>
        <form name="LogIn" action="/registration" method="post">
            Login : <input type="text" name="userName" />	<br/>
            Password : <input type="password" name="password" />	<br/>
            <input type="submit" value="   Save   " />
            <input type="reset" value="   Clear   " />
        </form>
    </fieldset>
</@layout.page>