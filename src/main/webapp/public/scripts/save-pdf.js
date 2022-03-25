var doc = new jsPDF();

function saveDiv(divID) {
    doc.fromHTML("" +
        "<head>\n" +
        "    <link rel=\"stylesheet\" href=\"<%=request.getContextPath()%>/public/css/styles.css\">\n" +
        "</head>" + document.getElementById(divID).innerHTML);
    doc.save();
}

function printDiv(divID) {
    let mywindow = window.open('', 'PRINT', 'height=650,width=900,top=100,left=150');

    mywindow.document.write('<html><head><title>Test</title></head>');
    mywindow.document.write('<body>');
    mywindow.document.write(document.getElementById(divID).innerHTML);
    mywindow.document.write('</body></html>');

    mywindow.document.close();
    mywindow.focus();

    mywindow.print();
    mywindow.close();

    return true;
}

function Popup(divID) {
    var mywindow = window.open('', 'new div', 'height=400,width=600');
    mywindow.document.write('<html><head><title></title>');
    mywindow.document.write('<link rel="stylesheet" href="<%=request.getContextPath()%>/public/css/styles.css" type="text/css"/>');
    mywindow.document.write('</head><body >');
    mywindow.document.write(document.getElementById(divID).innerHTML);
    mywindow.document.write('</body></html>');
    mywindow.document.close();
    mywindow.focus();
    setTimeout(function(){mywindow.print();},1000);
    //mywindow.close();

    return true;
}