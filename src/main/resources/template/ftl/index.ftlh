<#import "layouts/main.ftl" as layout>
<@layout.page>
    <#assign all_customers = "all_customers">
    <#assign all_products = "all_products">
    <#assign add_payment = "add_payment">
    <#assign add_customer = "add_customer">

    <p>
        <a href="${all_customers}">All Customers</a>
    </p>
    <p>
        <a href="${all_products}">All Products</a>
    </p>
    <p>
        <a href="${add_payment}">Add Payment</a>
    </p>
    <p>
        <a href="${add_customer}">Add Customer</a>
    </p>

</@layout.page>

