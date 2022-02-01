

function addRow() {
          
          
    var LicenceEx = document.getElementById("licEx");
    var dateBirth = document.getElementById("dob");
    var Quantity = document.getElementById("qan");          
    var LicenceNo = document.getElementById("lic");          
    var table = document.getElementById("myTableData");
    var myName = document.getElementById("FullName");
    var email = document.getElementById("email");
    var phone = document.getElementById("phone");
         
          
       
          var rowCount = table.rows.length;
          var row = table.insertRow(rowCount);
       
             
          
          var patternName = /^[A-Z][a-z]+\s[A-Z'\-a-z]+$/;          
          if (!patternName.test(myName.value)) {
            alert('Please provide a valid First name &Last name!');
            myName.focus;
            return false;
        }
          
                   
            var patternEmail = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;            
            if (!patternEmail.test(email.value)) {
                alert('Please provide a valid email address');
                email.focus;
                return false;          
        }

          var patternTele = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;       
        if (!patternTele.test(phone.value)) {
            alert('Please provide a valid Telephone format');
            phone.focus;
            return false;         

    }

        // var patternDOB = /^(?:(0[1-9]|1[012])[\- \/.](0[1-9]|[12][0-9]|3[01])[\- \/.](19|20)[0-9]{2})$/;
        // var dateBirth = document.getElementById("dob");
        //     if (!patternDOB.test(dateBirth.value)) {
        //         alert('Please provide a valid Date of Birth format: mm/dd/yyy');
        //         dateBirth.focus;
        //         return false;         

        // }

        // var patternLicenseEx = /^(\d{1,2})(\/|-)(\d{1,2})(\/|-)(\d{4})$/;;
        //  var LicenceEx = document.getElementById("licEx");
        //     if (!patternLicenseEx.test(LicenceEx.value)) {
        //         alert('Please provide a valid Date for Licence expiration format: mm/dd/yyy');
        //         LicenceEx.focus;
        //         return false;         

        // }

       

      



        if(patternEmail.test(email.value)==false || patternName.test(myName.value) ==false  || patternTele.test(phone.value)==false) {
            alert('Please provide a valid form');
        } else{
            row.insertCell(0).innerHTML= '<input type="button" value = "Delete" onClick="Javacsript:deleteRow(this)">';
            row.insertCell(1).innerHTML= myName.value;
            row.insertCell(2).innerHTML= email.value;
            row.insertCell(3).innerHTML= phone.value;
            row.insertCell(4).innerHTML= dateBirth.value;
            row.insertCell(5).innerHTML= LicenceNo.value;
            row.insertCell(6).innerHTML= LicenceEx.value;
            row.insertCell(7).innerHTML= Quantity.value;
            
            
            


        }


       
         
       
      }
       
      function deleteRow(obj) {
            
          var index = obj.parentNode.parentNode.rowIndex;
          var table = document.getElementById("myTableData");
          table.deleteRow(index);
          
      }
       
      function addTable() {
            
          var myTableDiv = document.getElementById("myDynamicTable");
            
          var table = document.createElement('TABLE');
          table.border='1';
          
          var tableBody = document.createElement('TBODY');
          table.appendChild(tableBody);
            
          for (var i=0; i<3; i++){
             var tr = document.createElement('TR');
             tableBody.appendChild(tr);
             
             for (var j=0; j<4; j++){
                 var td = document.createElement('TD');
                 td.width='75';
                 td.appendChild(document.createTextNode("Cell " + i + "," + j));
                 tr.appendChild(td);
             }
          }
          myTableDiv.appendChild(table);

          
      }
       
      function load() {
          
          console.log("Page load finished");
       
      }

      function months(){

        var arr = ["January", " Fbruary", "March", "April"]

        for (let i = 0; i < arr.length; i++) {
            console.log(" Arry values"+arr[i])
          }
      }
      
    