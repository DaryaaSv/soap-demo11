<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">

    <!-- Define the layout for the PDF -->
    <fo:layout-master-set>
        <fo:simple-page-master master-name="page" page-height="11in" page-width="10.5in"
                               margin-top="0.5in" margin-bottom="0.5in"
                               margin-left="0.5in" margin-right="0.5in">
            <fo:region-body/>
        </fo:simple-page-master>
    </fo:layout-master-set>

    <!-- Start defining the content of the PDF -->
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="A4"
                                       page-height="29.7cm"
                                       page-width="21cm"
                                       margin-top="2cm"
                                       margin-bottom="2cm"
                                       margin-left="2cm"
                                       margin-right="2cm">
                    <fo:region-body margin-top="3cm"/>
                </fo:simple-page-master>
            </fo:layout-master-set>
            <fo:page-sequence master-reference="A4">
                <fo:flow flow-name="xsl-region-body">
                    <!-- Insert your content generation here -->
                    <xsl:apply-templates select="Account"/>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>

    <!-- Template to match the Account element -->
    <xsl:template match="Account">
        <fo:block font-size="16pt" font-weight="bold" text-align="center" margin-bottom="20pt">
            Account Information
        </fo:block>
        <!-- Display user information -->
        <fo:block font-size="12pt" margin-bottom="20pt">
            <xsl:text>User ID: </xsl:text><xsl:value-of select="id"/>
            <xsl:text>&#10;Username: </xsl:text><xsl:value-of select="userName"/>
        </fo:block>

        <!-- Display favorite games -->
        <fo:block font-size="14pt" font-weight="bold" margin-top="20pt" margin-bottom="10pt">
            Favorite Games:
        </fo:block>
        <fo:block font-size="12pt" margin-bottom="20pt">
            <xsl:for-each select="favoriteGames">
                <xsl:variable name="gameId" select="game"/>
                <fo:block>
                    <xsl:text>&#8226; </xsl:text>
                    <xsl:value-of select="concat($gameId, ': ')"/>
                    <xsl:value-of select="//games[id=$gameId]/title"/>
                </fo:block>
            </xsl:for-each>
        </fo:block>

        <!-- Display wishlist -->
        <fo:block font-size="14pt" font-weight="bold" margin-top="20pt" margin-bottom="10pt">
            Wishlist:
        </fo:block>
        <fo:block font-size="12pt" margin-bottom="20pt">
            <xsl:for-each select="wishlist/games">
                <xsl:variable name="gameId" select="."/>
                <fo:block>
                    <xsl:text>&#8226; </xsl:text>
                    <xsl:value-of select="concat($gameId, ': ')"/>
                    <xsl:value-of select="//games[id=$gameId]/title"/>
                </fo:block>
            </xsl:for-each>
        </fo:block>

        <!-- Display reviews -->
        <fo:block font-size="14pt" font-weight="bold" margin-top="20pt" margin-bottom="10pt">
            Reviews:
        </fo:block>
        <fo:block font-size="12pt" margin-bottom="20pt">
            <xsl:for-each select="reviews">
                <fo:block font-size="12pt" margin-bottom="10pt">
                    <xsl:value-of select="reviewText"/><xsl:text>&#10;</xsl:text>
                    Rating: <xsl:value-of select="rating"/><xsl:text>&#10;</xsl:text>
                    <xsl:text>Game: </xsl:text><xsl:value-of select="//games[id=current()/game]/title"/>
                </fo:block>
            </xsl:for-each>
        </fo:block>

        <!-- Display game details -->
        <fo:block font-size="14pt" font-weight="bold" margin-top="20pt" margin-bottom="10pt">
            Game Details:
        </fo:block>
        <fo:block font-size="12pt" margin-bottom="20pt">
            <xsl:for-each select="games">
                <fo:block font-size="12pt" margin-bottom="10pt">
                    <xsl:text>Game ID: </xsl:text><xsl:value-of select="id"/><xsl:text>&#10;</xsl:text>
                    <xsl:text>Title: </xsl:text><xsl:value-of select="title"/><xsl:text>&#10;</xsl:text>
                    <xsl:text>Description: </xsl:text><xsl:value-of select="description"/><xsl:text>&#10;</xsl:text>
                    <xsl:text>Genre: </xsl:text><xsl:value-of select="genre"/>
                </fo:block>
            </xsl:for-each>
        </fo:block>
    </xsl:template>

</xsl:stylesheet>
