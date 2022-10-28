<#import "../layouts/main.ftl" as layout>
<@layout.page>
    <h1>Hello, <#if first_name??>${first_name}</#if>, <#if last_name??>${last_name}</#if></h1>
</@layout.page>