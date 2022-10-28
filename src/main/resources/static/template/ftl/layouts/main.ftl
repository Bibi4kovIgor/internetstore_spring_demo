<#macro page>
    <!doctype html>
    <html>
        <#import "/partial/header.ftl" as h>
        <@h.header />
        <body>
            <main>
                <div id="container">
                    <#nested>
                </div>
            </main>
            <#import "/partial/footer.ftl" as f>
            <@f.footer />
        </body>
    </html>
</#macro>