<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:output method="html" indent="yes"/>

    <xsl:template match="/">

        <html>
            <head>
                <title>Account Information</title>
                <style>
                    body {
                    font-family: Arial, sans-serif;
                    background-color: #f2f2f2;
                    padding: 20px;
                    }
                    .account {
                    border: 1px solid #ccc;
                    border-radius: 5px;
                    background-color: #fff;
                    padding: 20px;
                    margin-bottom: 20px;
                    }
                    h2 {
                    color: #333;
                    }
                    h3 {
                    color: #555;
                    }
                    table {
                    width: 100%;
                    border-collapse: collapse;
                    margin-top: 10px;
                    }
                    th, td {
                    border: 1px solid #ddd;
                    padding: 8px;
                    text-align: left;
                    }
                    th {
                    background-color: #f2f2f2;
                    font-weight: bold;
                    }
                </style>
            </head>
            <body>

                <xsl:apply-templates select="accounts/account"/>

            </body>
        </html>

    </xsl:template>

    <xsl:template match="account">
        <div class="account">
            <h2>Account Information</h2>
            <table>
                <tr>
                    <th>ID</th>
                    <td><xsl:value-of select="id"/></td>
                </tr>
                <tr>
                    <th>Username</th>
                    <td><xsl:value-of select="userName"/></td>
                </tr>
                <tr>
                    <th>Password</th>
                    <td><xsl:value-of select="password"/></td>
                </tr>
            </table>

            <h3>Games</h3>
            <table>
                <tr>
                    <th>Title</th>
                    <th>Description</th>
                    <th>Genre</th>
                </tr>
                <xsl:apply-templates select="games/game"/>
            </table>

            <h3>Reviews</h3>
            <table>
                <tr>
                    <th>Game Title</th>
                    <th>Review Text</th>
                    <th>Rating</th>
                </tr>
                <xsl:apply-templates select="reviews/review"/>
            </table>

            <h3>Wishlist</h3>
            <table>
                <tr>
                    <th>Wishlist Name</th>
                </tr>
                <tr>
                    <td><xsl:value-of select="wishlist/wishlistName"/></td>
                </tr>
            </table>

            <h3>Favorite Games</h3>
            <table>
                <tr>
                    <th>Game Title</th>
                </tr>
                <xsl:apply-templates select="favoriteGames/favoriteGame"/>
            </table>

        </div>
    </xsl:template>

    <xsl:template match="game">
        <tr>
            <td><xsl:value-of select="title"/></td>
            <td><xsl:value-of select="description"/></td>
            <td><xsl:value-of select="genre"/></td>
        </tr>
    </xsl:template>

    <xsl:template match="review">
        <tr>
            <td><xsl:value-of select="game/title"/></td>
            <td><xsl:value-of select="reviewText"/></td>
            <td><xsl:value-of select="rating"/></td>
        </tr>
    </xsl:template>

    <xsl:template match="favoriteGame">
        <tr>
            <td><xsl:value-of select="game/title"/></td>
        </tr>
    </xsl:template>

</xsl:stylesheet>
