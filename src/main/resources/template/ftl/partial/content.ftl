<#macro content url>
    <div id = "header">
        <h2>
            Internet-store demo
        </h2>
    </div>
    <div id="container">
        <#import "/partial/${url}" as c>
        <@c.content />
    </div>
</#content>