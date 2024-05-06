<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:fo="http://www.w3.org/1999/XSL/Format">
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="A4"
                                       page-height="40cm"
                                       page-width="20cm"
                                       margin-top="0cm"
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
        <!-- Account Information -->
        <fo:block font-size="18pt" font-weight="bold" text-align="center" margin-bottom="5pt">
            Account Information
        </fo:block>

        <!-- User Information -->
        <fo:block font-size="14pt" font-weight="bold" margin-bottom="10pt">
            User Information:
        </fo:block>
        <fo:block font-size="12pt" margin-bottom="20pt">
            <fo:table table-layout="fixed" width="100%">
                <fo:table-column column-width="40%"/>
                <fo:table-column column-width="60%"/>
                <fo:table-body>
                    <fo:table-row>
                        <fo:table-cell padding="2mm">
                            <fo:block font-weight="bold">User ID:</fo:block>
                        </fo:table-cell>
                        <fo:table-cell padding="2mm">
                            <fo:block><xsl:value-of select="id"/></fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                    <fo:table-row>
                        <fo:table-cell padding="2mm">
                            <fo:block font-weight="bold">Username:</fo:block>
                        </fo:table-cell>
                        <fo:table-cell padding="2mm">
                            <fo:block><xsl:value-of select="userName"/></fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                </fo:table-body>
            </fo:table>
        </fo:block>
        <fo:block margin-bottom="20pt"/>

        <!-- Favorite Games -->
        <fo:block font-size="14pt" font-weight="bold" margin-bottom="10pt">
            Favorite Games:
        </fo:block>
        <fo:block font-size="12pt" margin-bottom="20pt">
            <xsl:for-each select="favoriteGames">
                <fo:block>
                    <fo:inline font-weight="bold">&#8226;</fo:inline>
                    <xsl:value-of select="//games[id=current()/game]/title"/>
                </fo:block>
            </xsl:for-each>
        </fo:block>
        <fo:block margin-bottom="20pt"/>

        <!-- Wishlist -->
        <fo:block font-size="14pt" font-weight="bold" margin-bottom="10pt">
            Wishlist:
        </fo:block>
        <fo:block font-size="12pt" margin-bottom="20pt">
            <xsl:for-each select="wishlist/games">
                <fo:block>
                    <fo:inline font-weight="bold">&#8226;</fo:inline>
                    <xsl:value-of select="//games[id=current()]/title"/>
                </fo:block>
            </xsl:for-each>
        </fo:block>
        <fo:block margin-bottom="20pt"/>

        <!-- Games -->
        <fo:block font-size="14pt" font-weight="bold" margin-bottom="10pt">
            Games:
        </fo:block>
        <fo:block font-size="12pt" margin-bottom="20pt">
            <fo:table table-layout="fixed" width="100%">
                <fo:table-column column-width="10%"/>
                <fo:table-column column-width="30%"/>
                <fo:table-column column-width="60%"/>
                <fo:table-header>
                    <fo:table-row>
                        <fo:table-cell padding="2mm" font-weight="bold" border="1pt solid black">
                            <fo:block>ID</fo:block>
                        </fo:table-cell>
                        <fo:table-cell padding="2mm" font-weight="bold" border="1pt solid black">
                            <fo:block>Title</fo:block>
                        </fo:table-cell>
                        <fo:table-cell padding="2mm" font-weight="bold" border="1pt solid black">
                            <fo:block>Description</fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                </fo:table-header>
                <fo:table-body>
                    <xsl:for-each select="games">
                        <fo:table-row>
                            <fo:table-cell padding="2mm" border="1pt solid black">
                                <fo:block><xsl:value-of select="id"/></fo:block>
                            </fo:table-cell>
                            <fo:table-cell padding="2mm" border="1pt solid black">
                                <fo:block><xsl:value-of select="title"/></fo:block>
                            </fo:table-cell>
                            <fo:table-cell padding="2mm" border="1pt solid black">
                                <fo:block><xsl:value-of select="description"/></fo:block>
                            </fo:table-cell>
                        </fo:table-row>
                    </xsl:for-each>
                </fo:table-body>
            </fo:table>
        </fo:block>
        <fo:block margin-bottom="20pt"/>

        <!-- Reviews -->
        <fo:block font-size="14pt" font-weight="bold" margin-bottom="10pt">
            Reviews:
        </fo:block>
        <fo:block font-size="12pt" margin-bottom="20pt">
            <fo:table table-layout="fixed" width="100%">
                <fo:table-column column-width="20%"/>
                <fo:table-column column-width="50%"/>
                <fo:table-column column-width="30%"/>
                <fo:table-header>
                    <fo:table-row>
                        <fo:table-cell padding="2mm" font-weight="bold" border="1pt solid black">
                            <fo:block>Rating</fo:block>
                        </fo:table-cell>
                        <fo:table-cell padding="2mm" font-weight="bold" border="1pt solid black">
                            <fo:block>Review Text</fo:block>
                        </fo:table-cell>
                        <fo:table-cell padding="2mm" font-weight="bold" border="1pt solid black">
                            <fo:block>Game Name</fo:block>
                        </fo:table-cell>
                    </fo:table-row>
                </fo:table-header>
                <fo:table-body>
                    <xsl:for-each select="reviews">
                        <fo:table-row>
                            <fo:table-cell padding="2mm" border="1pt solid black">
                                <fo:block><xsl:value-of select="rating"/></fo:block>
                            </fo:table-cell>
                            <fo:table-cell padding="2mm" border="1pt solid black">
                                <fo:block><xsl:value-of select="reviewText"/></fo:block>
                            </fo:table-cell>
                            <fo:table-cell padding="2mm" border="1pt solid black">
                                <fo:block><xsl:value-of select="//games[id=current()/game]/title"/></fo:block>
                            </fo:table-cell>
                        </fo:table-row>
                    </xsl:for-each>
                </fo:table-body>
            </fo:table>
        </fo:block>
        <fo:block margin-bottom="20pt"/>

    </xsl:template>

</xsl:stylesheet>
