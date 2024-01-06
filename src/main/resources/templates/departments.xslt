<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" omit-xml-declaration="yes"/>
    <xsl:template match="/">
        <html>
            <body>
                <h1>Departments</h1>
                <table border="1">
                    <tr>
                        <th>Id</th>
                        <th>Title</th>
                        <th>Leader</th>
                    </tr>
                    <xsl:apply-templates/>
                </table>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="department">
        <tr>
            <td><xsl:value-of select="@id"/></td>
            <td><xsl:value-of select="@title"/></td>
            <td><xsl:value-of select="@leader"/></td>
        </tr>
    </xsl:template>
</xsl:stylesheet>