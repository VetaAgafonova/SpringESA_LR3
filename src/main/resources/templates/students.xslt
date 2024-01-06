<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:output method="html" omit-xml-declaration="yes"/>
    <xsl:template match="/">
        <html>
            <body>
                <h1>Students</h1>
                <table border="1">
                    <tr>
                        <th>Id</th>
                        <th>First name</th>
                        <th>Last name</th>
                        <th>Department id</th>
                    </tr>
                    <xsl:apply-templates/>
                </table>
            </body>
        </html>
    </xsl:template>
    <xsl:template match="student">
        <tr>
            <td><xsl:value-of select="@id"/></td>
            <td><xsl:value-of select="@firstName"/></td>
            <td><xsl:value-of select="@lastName"/></td>
            <td><xsl:value-of select="@department_id"/></td>
        </tr>
    </xsl:template>
</xsl:stylesheet>