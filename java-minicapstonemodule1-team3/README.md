## Module 1 Capstone - Media Machine Application

You're developing an application for the newest Media Machine distributor,
Elevated Editions Emporium. EEE allows uses to purchase different types of media.

### Application requirements

1. The distributer allows you to purchase books, movies, albums, video games, or audio books.
   - Each item will have a name and a price.
2. A main menu must display when the software runs, presenting the following options:
    > ```
    > (1) Display Media Items
    > (2) Purchase
    > (3) Exit
    > ```
3. The software reads its inventory from an input file when the application
starts.
4. The vending machine is automatically restocked each time the application runs (the program stops and you run it again -- this is the only time to restock).
5. When the customer selects "(1) Display Media Items", they're presented with a submenu to filter by Books, Movies, Albums, Video Games, Audio Books, or everything:
    >```
    >(A) Books
    >(B) Movies
    >(C) Albums
    >(D) Video Games
    >(E) Audio Books
    >(F) Return all
    >```
      The submenu will display a list of all items 
with its quantity available:
    - Each product has an identifier and a purchase price.
    - A product that has run out must indicate that it's SOLD OUT.
    >```
    >ID     |Type          |Name                                        |Price     |Quantity
    >B001   | BOOK         | The Great Gatsby                           | 10.99    | 20  
    >B003   | BOOK         | 1984                                       | 9.75     | SOLD OUT
    >```  
1. When the customer selects "(2) Purchase", they're guided through the purchasing
process menu:
    ```
    Current Money Provided: $2.00
    
    (1) Feed Money
    (2) Select Product
    (3) Finish Transaction
    
    ```
7. The purchase process flow is as follows:
    1. Selecting "(1) Feed Money" allows the customer to repeatedly feed money into the
    machine in whole dollar amounts of 1, 5, 10, 20, or 50.  No other amounts of currency will be accepted.
        - The "Current Money Provided" indicates how much money the customer
        has fed into the machine.
    2. Selecting "(2) Select item" allows the customer to select an item to
    purchase.
        - Show the list of items available and allow the customer to enter
        a code to select an item.
        - If the code doesn't exist, the program informs the customer and returns them
        to the Purchase menu.
        - If an item is currently sold out, the software informs the customer and returns them to the
        Purchase menu.
        - If a customer selects an invalid item, you must display an error message and return them to the 
        Purchase menu.
        - Purchasing an item prints all the associated information for that media type. Dispensing also returns a message:
          - All books purchased should print: 
              <br>"Enjoy your literary adventure! We hope this story captivates your imagination."
          - All movies purchased should print:
              <br>"Enjoy your literary adventure! We hope this story captivates your imagination."
          - All albums purchased should print:
              <br>"Let the music play! We hope these tracks bring you joy and get your feet tapping."
          - All video games purchased should print:
              <br>"Get ready to level up! We hope you have a blast exploring and conquering in your new game."
          - All audio books purchased should print:
              <br>"Sit back, relax, and let the story unfold. Enjoy your new audiobook!"
<br>
        - After the purchase has been made, the machine must update its balance
        accordingly and return the customer to the Purchase menu.
    3. Selecting "(3) Finish Transaction" allows the customer to complete the
    transaction and receive any remaining change.
        - The machine returns the customer's money using nickels, dimes, quarters, and dollars
        (using the smallest amount of coins possible).
        - The machine's current balance updates to $0 remaining.
    4. After completing their purchase, the user returns to the "Main" menu ready for the next customer. <br><br>
Here is a sample of a movie purchase:

>```
>Enter Id: M001
>ID: M001
>Type: MOVIE
>Title: The Shawshank Redemption
>Release Year: 1994
>Genre: Drama
>Price: $14.99
>Total available: 4
>Director='Frank Darabont
>RuntimeMinutes=142
>Rating='R'
>Enjoy your literary adventure! We hope this story captivates your imagination.
>```


8. The Media Machine application needs to log all transactions to prevent theft.
   - Each purchase must generate a line in a file called `Log.txt`.
   - The lines must follow the format shown in the following example.
       - The first dollar amount is the amount deposited, spent, or given as change.
       - The second dollar amount is the new balance.
        ```
        01/01/2025 12:00:00 PM FEED MONEY: $5.00 $5.00 
        01/01/2025 12:00:15 PM FEED MONEY: $25.00 $30.00 
        01/01/2025 12:00:20 PM MOVIE The Shawshank Redemption M001 $14.99 $15.01 
        01/01/2025 12:00:15 PM FEED MONEY: $35.00 $50.01 
        01/01/2025 12:01:25 PM VIDEO GAME Red Dead Redemption 2 VG001 $44.99 $5.02 
        01/01/2025 12:01:35 PM GIVE CHANGE: $5.02 $0.00
        01/01/2025 12:30:00 PM FEED MONEY: $25.00 $25.00 
        01/01/2025 12:30:15 PM FEED MONEY: $20.00 $45.00 
        01/01/2025 12:30:20 PM AUDIO BOOK DUNE AD001 $29.99 $15.01
        01/01/2025 12:11:35 PM GIVE CHANGE: $15.01 $0.00
        ```
9. Create as many of your classes as possible to be "testable" classes. Limit console
input and output to as few classes as possible.
10. Sales Report
    - Provide a "Hidden" menu option on the main menu ("4") that writes to a sales
    report that shows the total sales by category. The name of the
    file must include the date and time so each sales report is uniquely named.
    - An example of the output format appears at the end of this file.
11. Provide unit tests demonstrating that your code works correctly.
___
### Media data file
The input file that stocks the item products is a comma `,` delimited file. Each line is a separate product in the file and follows this format:

| Column Name   | Description |
----------------|------------|
| Type          | The media type of the product                                      |
| Title         | Title of the media item                                            |
| Release Year  | The year the media item was released                               |
| Genre         |                                                                    |
| Unique ID     | The code to be used for purchasing the item                        |
| Price         | The purchase price for the item                                    |
| Specific Att1 | Depending on the media item, this will be an attribute             |
| Specific Att2 | Depending on the media item, this will be an attribute             |
| Specific Att3 | Depending on the media item, this will be an attribute             |
| Number of Copies | How many copies are available                                   |

Specific Attributes:
- For Books: SpecificAttribute1 is Author, SpecificAttribute2 is ISBN, SpecificAttribute3 is PageCount.
- For Movies: SpecificAttribute1 is Director, SpecificAttribute2 is RuntimeMinutes, SpecificAttribute3 is Rating.
- For Albums: SpecificAttribute1 is Artist, SpecificAttribute2 is NumberOfTracks, SpecificAttribute3 is RecordLabel.
- For Video Games: 
    <br>SpecificAttribute1 is platform (String): e.g., "PC", "PlayStation 5", "Xbox Series X", "Nintendo Switch", 
    <br>SpecificAttribute2 is developer (String): e.g., "Nintendo", "Rockstar Games", "CD Projekt Red", <br>SpecificAttribute3 is esrbRating (String): e.g., "E for Everyone", "T for Teen", "M for Mature"
- For Audio Books: 
     <br>SpecificAttribute1 is narrator, 
     <br>SpecificAttribute2 is durationMinutes, 
     <br>SpecificAttribute3 is author


For example:

```
BOOK,The Great Gatsby,1925,Classic,B001,10.99,F. Scott Fitzgerald,9780743273565,180,5
BOOK,To Kill a Mockingbird,1960,Classic,B002,12.50,Harper Lee,9780061120084,324,10
MOVIE,The Shawshank Redemption,1994,Drama,M001,14.99,Frank Darabont,142,R,30
MOVIE,The Godfather,1972,Crime,M002,13.50,Francis Ford Coppola,175,R,40
ALBUM,Thriller,1982,Pop,A001,10.99,Michael Jackson,9,Epic,2
ALBUM,The Dark Side of the Moon,1973,Progressive Rock,A002,12.50,Pink Floyd,10,Harvest,10
VIDEOGAME,The Witcher 3: Wild Hunt,2015,RPG,VG001,39.99,PC,CD Projekt Red,M for Mature,4
VIDEOGAME,Red Dead Redemption 2,2018,Action-Adventure,VG002,49.99,PlayStation 4,Rockstar Games,M for Mature,6
AUDIOBOOK,Dune,2019,Sci-Fi,AB001,29.99,Scott Brick,1260,Frank Herbert,10
AUDIOBOOK,The Martian,2014,Sci-Fi,AB002,22.50,R.C. Bray,652,Andy Weir,15
```

**An input file is in your repository: `mediaInput.csv`.**

 ---
### Sales report
The output sales report file is pipe-delimited. Each line is a separate category with the number of sales for the applicable product and the total dollar amount of the sales. At the end of the report is a blank line followed by the **TOTAL SALES** dollar amount indicating the gross sales from the vending machine.

For example:

>```
>BOOKS      |  12| $144.42
>MOVIES     |   2| $ 23.98
>ALBUMS     |   0|
>VIDEOGAMES |   6| $248.00
>AUDIOBOOKS |   1| $ 12.99
>
>**TOTAL SALES** $429.39
>```


