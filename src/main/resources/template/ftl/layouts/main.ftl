<#macro page>
    <!doctype html>
    <html>
        <#import "/partial/header.ftl" as h>
        <@h.header />
        <body>
            <div id="container">
                <#nested>
            </div>
            <#import "/partial/footer.ftl" as f>
            <@f.footer />
        </body>
    </html>
</#macro>