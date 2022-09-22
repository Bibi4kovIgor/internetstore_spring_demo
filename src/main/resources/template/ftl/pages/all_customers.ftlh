<#import "../layouts/main.ftl" as layout>
<@layout.page>
    <fieldset>
        <legend>Search Person</legend>
            <form name="searchPerson" action="/get_customer_by_name" method="post">
                First Name : <input type="text" name="firstName" />	<br/>
                <input type="submit" value="   Search   " />
            </form>
        </fieldset>
    <#import "../partial/customers_list.ftl" as customersPartial>
    <@customersPartial.customers />
</@layout.page>