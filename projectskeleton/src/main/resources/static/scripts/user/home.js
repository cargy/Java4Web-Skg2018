function logout() {
    localStorage.clear();
    window.location.replace(ROOT_PATH + "/index.html")
}

function populateDataTable(books) {
    jQuery.each(books, function(i,book) {
        $("#books").append("<tr><td>" + book.id + "</td><td>" + book.title + "</td></tr>");
     });

     $("#books tr").click(function() {
        loadBook($(this).children("td").html());
     });
}

function loadBook(id) {
    $.ajax({
        url: ROOT_PATH + "/books/" + id
    }).then(function(book) {
       $("input[name=id]").val(book.id);
       $("input[name=title]").val(book.title);
       $("input[name=isbn]").val(book.isbn);
    });
};

$(document).ready(function() {
    $.ajax({
        url: ROOT_PATH + "/books"
    }).then(function(books) {
        populateDataTable(books);
    });

    $("#saveButton").on('click', function(event){
        event.preventDefault();
        alert("To be done...");
    });

    $("#deleteButton").on('click', function(event){
        event.preventDefault();
        $.ajax({
            url: ROOT_PATH + "/books/" + $("input[name=id]").val(),
            type : "DELETE",
            dataType : 'json',
            contentType: 'application/json',
                success : function(result) {
                    console.log("book deleted!");
                },
                error: function(xhr, resp, text) {
                    console.log(xhr, resp, text);
                    alert("Could not delete book!");
                 }
         })

    });
});
