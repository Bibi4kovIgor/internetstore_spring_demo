<#import "../layouts/main.ftl" as layout>
<@layout.page>
    <#import "/partial/customers_list.ftl" as customersList>
    <@customersList.customers />
</@layout.page>