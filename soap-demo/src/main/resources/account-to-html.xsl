<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <title>User Account Information</title>
                <style type="text/css">
                    body {
                    font-family: Arial, sans-serif;
                    background-color: #f4f4f4;
                    margin: 0;
                    padding: 0;
                    }
                    h1 {
                    text-align: center;
                    color: #333;
                    }
                    table {
                    width: 100%;
                    border-collapse: collapse;
                    margin-bottom: 20px;
                    }
                    th, td {
                    padding: 10px;
                    border: 1px solid #ddd;
                    text-align: left;
                    }
                    th {
                    background-color: #f2f2f2;
                    }
                    .review {
                    background-color: #e9f7fe;
                    }
                    .wishlist {
                    background-color: #fde9e9;
                    }
                    .favorite {
                    background-color: #e9ffe6;
                    }
                </style>
            </head>
            <body>
                <h1>User Account Information</h1>
                <xsl:apply-templates select="Account"/>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="Account">
        <h2>Account Details</h2>
        <table>
            <tr>
                <th>Field</th>
                <th>Value</th>
            </tr>
            <tr>
                <td>ID</td>
                <td><xsl:value-of select="id"/></td>
            </tr>
            <tr>
                <td>Username</td>
                <td><xsl:value-of select="userName"/></td>
            </tr>
            <tr>
                <td>Password</td>
                <td><xsl:value-of select="password"/></td>
            </tr>
        </table>

        <h2>Games</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Genre</th>
            </tr>
            <xsl:for-each select="games">
                <tr>
                    <td><xsl:value-of select="id"/></td>
                    <td><xsl:value-of select="title"/></td>
                    <td><xsl:value-of select="description"/></td>
                    <td><xsl:value-of select="genre"/></td>
                </tr>
            </xsl:for-each>
        </table>

        <h2>Reviews</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Game</th>
                <th>Review Text</th>
                <th>Rating</th>
            </tr>
            <xsl:for-each select="reviews">
                <tr class="review">
                    <td><xsl:value-of select="id"/></td>
                    <td>
                        <xsl:value-of select="//games[id=current()/game]/title"/>
                    </td>
                    <td><xsl:value-of select="reviewText"/></td>
                    <td><xsl:value-of select="rating"/></td>
                </tr>
            </xsl:for-each>
        </table>

        <h2>Wishlist</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Wishlist Name</th>
                <th>Games</th>
            </tr>
            <xsl:for-each select="wishlist">
                <tr class="wishlist">
                    <td><xsl:value-of select="id"/></td>
                    <td><xsl:value-of select="wishlistName"/></td>
                    <td>
                        <xsl:for-each select="games">
                            <xsl:value-of select="//games[id=current()]/title"/><br/>
                        </xsl:for-each>
                    </td>
                </tr>
            </xsl:for-each>
        </table>

        <h2>Favorite Games</h2>
        <table>
            <tr>
                <th>ID</th>
                <th>Game</th>
            </tr>
            <xsl:for-each select="favoriteGames">
                <tr class="favorite">
                    <td><xsl:value-of select="id"/></td>
                    <td>
                        <xsl:value-of select="//games[id=current()/game]/title"/>
                    </td>
                </tr>
            </xsl:for-each>
        </table>
    </xsl:template>
</xsl:stylesheet>
