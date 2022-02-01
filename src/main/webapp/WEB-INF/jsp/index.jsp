<html>
    <head>
        <title>
             success
        </title>
    </head>

    <body style="background-color: lightgray;">

    <h2 style = "margin-left: 200px; color:  rgb(131, 6, 247);"> Registration Page</h2>

 <form  method="get"  action="indexSubmit" style="background-color: dimgrey; margin-left: 200px; width: 700px; height: 500px; border-radius: 10px;">
            <br>
            <label for="FullName" style="width: 30%; display: inline-block; padding-left: 9px;">Full Name:</label>
            <input id="FullName" type="text" name="name" size="20" required style="border-color: rgb(131, 6, 247);  border-width: 4px;" placeholder="Sam Tom"/><br><br>

            <label for="email" style="width: 30%; display: inline-block; padding-left: 9px;">Email:</label>
            <input id="email" type="email" name="email" size="20" style="border-color: rgb(131, 6, 247);  border-width: 4px;" placeholder="*@*.*" /><br><br>



            <label for="phone" style="width: 30%; display: inline-block; padding-left: 9px;">Telephone:</label>
            <input id="phone" type="tel" name="phone" size="20" style="border-color: rgb(131, 6, 247);  border-width: 4px;" pattern="[0-9]{3}-[0-9]{3}-[0-9]{4}" /> <small>Format: 123-4567-6789</small><br><br>


            <label for="dob" style="width: 30%; display: inline-block; padding-left: 9px;">DOB:  </label>
            <input id="dob" type="date" min="1970-11-30" max="2008-11-30" name="dateOfBirth" size="20" style="border-color: rgb(131, 6, 247);  border-width: 4px;" /> <small>Format: mm/dd/yyy!</small><br><br>





            <label for="lic" style="width: 30%; display: inline-block; padding-left: 9px;">License No:</label>
            <input id="lic" type="number" name="lic" size="20"  pattern="[0-9]{3}" required style="border-color: rgb(131, 6, 247);  border-width: 4px;" /> <small>Format: 345 </small><br><br>

            <label for="licEx" style="width: 30%; display: inline-block; padding-left: 9px;">License Expiration date:  </label>
           <input id="licEx" type="date" min="2022-1-21" name="date1" size="20" required style="border-color: rgb(131, 6, 247);  border-width: 4px;" /><br><br>

           <label for="qan" style="width: 30%; display: inline-block; padding-left: 9px;"><b> Experience(in Years):</b></label>
           <input id="qan" type="number" name="quantity" value="0" min="1" max="6" size="20" required style="border-color: rgb(131, 6, 247);  border-width: 4px;" /><small>from 1 to 6!</small><br><br>


            <input id="add" type="submit" name="submit"  value="Submit" style=" margin-left:20px; border-color: darkslateblue; background-color: dimgray; padding-left: 20px; padding-right: 20px; align-content: center;  "  onclick="Javascript:addRow()"/><br>

        </form><br><br><br>

    </body>
    </html>